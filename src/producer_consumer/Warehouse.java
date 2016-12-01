/* 
 * File: Warehouse.java
 * Author: Piero Dalle Pezze
 * Licence: MIT
 * Date: 14/05/2006
 * Version: 1.0
 */
package producer_consumer;

import java.util.*;

/** 
 * This class is a generic warehouse that can contains some purchases. Producers
 * and Consumers access in mutual exclusive mode.
 *
 * @author Piero Dalle Pezze
 * @version 1.0
 */
public class Warehouse {

    /**
     * The capacity of the warehouse.
     */
    private int capacity;

    /**
     * The data structure to contains the purchases in the warehouse.
     */
    private LinkedList<Purchase> store = new LinkedList<Purchase>();
    
    /**
     * Default constructor. It creates a warehouse of capacity 10.
     */
    public Warehouse() { 
	this(10); 
    }

    /**
     * It creates a warehouse of a certain capacity.
     *
     * @param capacity The capacity of the warehouse.
     */
    public Warehouse(int capacity) {  
	this.capacity = capacity;
    }

    /**
     * It returns a purchase, if exists, from the warehouse.
     * If this is empty, it puts the caller in a wait
     * status until the warehouse have at least a purchase.
     *
     * @return Purchase A Purchase.
     */
    public synchronized Purchase getPurchase() { 
	while(store.size() == 0) {
	    System.out.println("\n                            ***** The warehouse is empty! *****\n");
	    try {
		wait();
	    } catch(InterruptedException e) { }
	}
	Purchase value = store.removeFirst();
	notifyAll();
	return value;
    }

    /**
     * Return the capacity of the warehouse.
     *
     * @return The capacity of the warehouse.
     */
    public int getCapacity() {
	return capacity;
    }

    /**
     * Return a copy of the repository of the warehouse.
     *
     * @return The list of the purchase actually in the warehouse.
     */
    public synchronized LinkedList<Purchase> getRepository() {
	LinkedList<Purchase> l = new LinkedList<Purchase>();
	for(int i = 0; i < store.size(); i++) {
	    l.add(store.get(i));
	}
	return l;
    }

    /**
     * It inserts a new purchase in the warehouse. If this is full,
     * it put the caller in a wait status until the warehouse can
     * accept a new purchase.
     *
     * @param value The purchase inserted in the warehouse.
     */
    public synchronized void putPurchase(Purchase value) { 
	while(store.size() == capacity) {
	    System.out.println("\n                            ***** The warehouse is full! *****\n");
	    try {
		wait();
	    } catch(InterruptedException e) { }
	}
        store.addLast(value);
	notifyAll();
    }

}  // end class Warehouse
