/* 
 * File: ProducerConsumer.java
 * Author: Piero Dalle Pezze
 * Licence: MIT
 * Date: 14/05/2006
 * Version: 1.0
 */
package producer_consumer;

import java.util.*;


/** 
 * The producer-consumer model. This class simulates the behaviour of an abstract
 * producer-consumer situation. This model is at the base of some computers problems
 * like the processes scheduling per example. Cause the nature of Java programming
 * language, I must remember that the notify() of threads is casual both after a sleep()
 * call and after a wait() call. So Producer and Consumer object, which extends the same
 * class Thread, have a behaviour not predicible. In a process scheduling, this is not
 * a good thing!
 *
 * @author Piero Dalle Pezze
 * @version 1.0
 */
public class ProducerConsumer {

    /**
     * It generates and actives some instances of Producer and Consumer objects and a
     * shared resource.
     */
    public static void main(String[] args) {
	/* It instances objects. */ 
	Warehouse w = new Warehouse(2);
	ArrayList<Thread> people = new ArrayList<Thread>();
        people.add(new Producer(w, "James Gosling", 0));
	people.add(new Producer(w, "Linus Torvald", 0));
	people.add(new Consumer(w, "Donald Duck", 0));
	people.add(new Consumer(w, "Mickey Mouse", 0));
	people.add(new Consumer(w, "Rockerduck", 0));

	/* It prints initial data. */
	System.out.println("\n *** The Producer - Consumer model ***\n");
	for(int i = 0; i < people.size(); i++) {
	    if(people.get(i) instanceof Producer) {
		System.out.print("- Producer name: ");
	    } else {
		System.out.print("- Consumer name: ");
	    }
	    System.out.println(people.get(i).getName());
	}

	System.out.println("\nStarting activity...\n");

	/* It actives Producers and Consumers. */
	for(int i = 0; i < people.size(); i++) {
	    people.get(i).start();
	}
    }

} //end class ProducerConsumer
