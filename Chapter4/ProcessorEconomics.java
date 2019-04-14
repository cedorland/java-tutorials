package Chapter4;

public class ProcessorEconomics {

	/*
		In this section, we're going to take a look at processor economics,
		which is what I call the methodology behind harnessing parallel processing,
		task ordering, queueing, etc., to maximize the efficiency of a program
		which has to handle multiple processing tasks at once, or needs to handle a pause
		between two disparate tasks without eating up your CPU.
	 */
	
	/**		SECTION 1: THREADS		**/
	
	/*
		Threading is the process of creating a separate, runnable process in your code
		which is distinct from the main code sequence you're running.
		
		When you call a method, the computer has to run through all of the code in that method
		and wait for it to return a value before it can move on to the next line of code.
		
		When you run a process in a thread, instead of waiting for it to finish before moving on, 
		the computer will run the thread in parallel.
		
		Let's take a look at the basic Thread syntax:
		
		Thread myThread = new Thread(){
			public synchronized void run(){
                Do things here.
        	}
		};
		
		A thread is sort of like its own main() method - it's a runnable, unlike a standard method
		or generic object type. 
		
		When working with threads, you have to be careful to avoid access issues - 
		say you're depending on a certain variable to have a certain value at some point in your
		main method, and you also change the value in the thread.
		
		Since the two are running in parallel, you can't be sure exactly *when* your thread
		will change the value of the shared variable - each individual process will move forward
		based on what the processor can handle at the time - so you have to use synchronization.
		
		Synchronization is used to keep track of what happens when and where, and it's also used to
		help keep your program running smoothly without eating up too much CPU.
		
		Maybe you've made the mistake of using this kind of loop in your code
		while waiting for something to happen:
		
		>	while(true){ look for thing to change }
		
		Do you see any issues with that?
		
		Since the while-loop keeps running, it will CONSTANTLY be eating up
		processing power to check whether your variable has changed every chance it gets.
		This can mean eating up 80-90% of your CPU, checking every nanosecond,
		which not only slows down your computer, but can even make it so that
		whatever program might have changed the value of that variable 
		is also slowed down, which makes the process take even longer.
		
		Instead, you can tell the main thread to stop using resources until it is notified to continue
		using either the wait() method or the sleep() method.
		
		The Thread.sleep() method allows you to input an integer number of milliseconds
		for it to sleep for, freeing all resources until the specified amount of time has passed.
		This is useful if you want to check something every five seconds:
		
		while(true) {
			Check if variable has changed;
			Thread.sleep(5000);
		}
		
		But what if you want to just wait until the variable has changed?
		That's where the wait() method comes in handy.
		You *can* use wait() the same way you use sleep,
		but its real power comes from pairing it with the Thread.notify() method.
		
		When you use the wait() method on a specific object, and that object is synchronized,
		you can call the notify() or notifyAll() methods on that same object FROM ANY THREAD,
		and whatever was waiting on that object will be notified.
		
		Say we made an object called variableChangeSynchronizer, and we wanted to wait for
		the value of our variable to change.
		We could do something like this in place of those while-loops:
		
		variableChangeSynchronizer.wait();
		
		Then, in a separate thread, when the value of the variable changed:
		
		variable = newValue;
		variableChangeSynchronizer.notify();
		
		That call to notify() on the synchronizer object will wake the first
		thread which was waiting on the object, and tell it to continue!
		
		It's important to note that THESE HAVE TO BE CALLED ON THE EXACT SAME OBJECT.
		Calling these methods on two different instances of the object won't work,
		because the .notify() method will only wake threads which were waiting on the same
		specific instance of the object.
		This means that the object you wait on has to be static.
		Here's the code I use to handle my synchronizations:
		
		>	public class Synchronizer {
		>
		>		public Synchronizer(){}
		>
		>		public void waitOn() throws InterruptedException{
		>			synchronized (this){
        >				wait();
        >			}
		>		}
		>
		>		public void notifyOn() throws InterruptedException{
		>			synchronized (this){
    	>				notify();
    	>			}
		>		}
		>
		>		public void notifyAllOn() throws InterruptedException{
		>			synchronized (this){
    	>				notifyAll();
    	>			}
		>		}
		>	}
		
		Let's break that down.
		
		
		
		>	public class Synchronizer {
		
		Here, we're just making our class declaration, telling the computer that what follows
		is the definition of an object called Synchronizer.
		
		
		
		>	public Synchronizer(){}
		
		This is an empty constructor. We don't need to save any variables here - instead, we just want an object
		which takes up as little memory as possible on which we can synchronize actions.
		
		
		
		>	public void waitOn() throws InterruptedException{
		
		This is the declaration of our extension of the wait() functionality of threads.
		It throws an InterruptedException if the thread's wait() function gets interrupted.
		
		
		
		>	synchronized (this){
        >		wait();
        >	}
        
        Here's the meat of the operation. Here, we're making a 'synchronized' code block,
        and telling the computer that it will be synchronized on 'this' (meaning the instance of a Synchronizer object
        which calls this method).
        
        Then, we're calling the Thread.wait() method. This means that when you call this method on a
        Synchronizer object from within a thread, you're telling the thread to sleep indefinitely until
        that exact same object gets notified to continue!
        
        By itself, that doesn't help a whole lot. Let's keep moving:
		
		
		
		>	public void notifyOn() throws InterruptedException{
		>		synchronized (this){
    	>			notify();
    	>		}
    	>	}
    	
    	This method is almost identical, but this one uses the notify() function!
    	This method is also synchronized to the object which calls it,
    	which means that if a specific instance of Synchronizer was used to
    	force a few threads to wait, this method will wake the thread that called
    	the waitOn() method first.
    	
    	This is useful for queueing actions, but if you want to just notify every
    	thread that was waiting on this object, you can use the next method:
    	
    	
		>		public void notifyAllOn() throws InterruptedException{
		>			synchronized (this){
    	>				notifyAll();
    	>			}
		>		}
		
		And there you have it. This one notifies ALL threads which are waiting on this instance of
		Synchronizer, instead of just the one which started waiting first.
		
		Let's look at an example of how you could use this.
		
		Say you were fishing and you wanted to cast your line into the water, then wait for a fish to
		bite before doing anything else. We'll roughly simulate this with code.
		
		Let's make a synchronizer object first. It needs to be static so that there's only a single
		instance of it.
		
		>	static Synchronizer fishSynchronizer = new Synchronizer();
		
		Next, we'll do some work. Take a quick look at this, then we'll break it down after.
		
		>	public void main(String[] args){
		>		
		>		Thread goFishing = new Thread(){
		>			public synchronized void run(){
		>				sleep(10000);
        >        		while(true){
       	>					if( Math.random() < 0.2 ){
       	>						break;
       	>					}
       	>					sleep(5000);
        >				}
        >				fishSynchronizer.notifyOn();
        >			}
		>		};
		>		
		>		System.out.println("You cast your line into the water...");
		>
		>		goFishing.start();
		>
		>		fishSynchronizer.waitOn();
		>
		>		System.out.println("There's something on the line!");
		>
		>	}
		
		This is a pretty basic use of Threading and task-ordering, but it shows the concepts in action.
		There's a better way to execute this specific task, but I wanted to sort of illustrate
		how everything works in context.
		
		First off, that whole snippet is run from within a main() method.
		
		The first thing we do inside that method is to create a new thread named goFishing,
		and write up its 'run' method. The 'run' method in a Thread is equivalent to the main() method -
		when you start a Thread using the Thread.start() method, you're telling the computer to
		run the Thread's run() method in parallel.
		
		Next, inside the thread's run() method, we sleep for 10 seconds. After that, we enter a while loop
		that runs continuously (which is normally bad practice), but here we'll be using another sleep()
		so it's sort of okay.
		Inside the loop, we check if a random number is less than 0.2, and if it is, we break the loop.
		If it isn't, we sleep for 5 seconds and keep looping.
		
		After the loop has been broken, the thread's run() method calls fishSynchronizer.notifyOn(),
		which tells any thread that was waiting on it to continue. Then the thread dies.
		
		All of that was just the Thread's initialization. We haven't actually started the thread yet.
		
		After we initialize it, we print a statement, then start the thread.
		
		While the thread is in its first sleep() statement, before the loop starts, we call 
		fishSynchronizer.waitOn() and the main() method pauses while it waits for a call to
		fishSynchronizer.notifyOn(). Our thread, 'goFishing', keeps running here while the
		main() method's thread is asleep.
		
		Once the goFishing thread makes a call to fishSynchronizer.notifyOn(), the main method will continue,
		and the statement "There's somethign on the line!" will be printed to the console.
		
		If we wanted to do this without using our Synchronizer object, that's totally possible as well.
		Let's take a look at that:
		
		>	public void main(String[] args){
		>		
		>		Thread goFishing = new Thread(){
		>			public synchronized void run(){
		>				sleep(10000);
        >        		while(true){
       	>					if( Math.random() < 0.2 ){
       	>						break;
       	>					}
       	>					sleep(5000);
        >				}
        >			}
		>		};
		>		
		>		System.out.println("You cast your line into the water...");
		>
		>		goFishing.start();
		>		goFishing.join();
		>
		>		System.out.println("There's something on the line!");
		>
		>	}
		
		All we did there was remove both of the calls to our fishSynchronizer object and replace
		the waitOn() call with a call to goFishing.join().
		
		The Thread.join() method is equivalent to saying "wait for this thread to die before continuing".
		It tells the computer to pause execution on the current thread, let the other thread finish executing,
		and then continue.
		
		Here, when we called goFishing.join(), we told the computer "pause the main() method's thread
		until the goFishing thread dies".
		
		That's pretty much it for Threading, synchronization, and processor economics for now.
		As always, any requests should be posted to the GitHub page.
		
		
	*/
	
}
