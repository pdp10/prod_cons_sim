/* 
 * File: Consumer.java
 * Author: Piero Dalle Pezze
 * Licence: MIT
 * Date: 14/05/2006
 * Version: 1.0
 */
package producer_consumer;

import java.util.*;


/** 
 * The consumer of the producer-consumer model. This class represents the object
 * which consumes or buy or uses a resource supplied by the producer. Resouces 
 * are mutually exclusive.
 *
 * @author Piero Dalle Pezze
 * @version 1.0
 */
public class Consumer extends Thread {

    /**
     * The warehouse which contains resources to consume. It may be also empty or full.
     */
    private Warehouse warehouse;

    /**
     * The frequence of request for a resource. It must be non negative. If it is 0,
     * then the frequence is generated in random mode.
     */	
    private int frequence;

    /**
     * The number of purchases that a consumer consumes. It is a default value.
     */
    private int nPurchases = 10;

    /**
     * It creates a consumer named "Consumer" which requests goods from the warehouse at least
     * every 250 ms.
     *
     * @param warehouse The warehouse to get a new purchase.
     */
    public Consumer(Warehouse warehouse) {
	this(warehouse, "Consumer");
    }

    /**
     * It creates a consumer with a name, which requests purchases from the warehouse at least every
     * 250 ms.
     *
     * @param warehouse The warehouse to get a new purchase.
     * @param name The name of the consumer.
     */
    public Consumer(Warehouse warehouse, String name) {
	this(warehouse, name, 250);
    }

    /** 
     * It creates a consumer with a name which requests goods from the warehouse at a frequence
     * decided by user. If frequece is 0, then it means it is random.
     *
     * @param warehouse The warehouse to get a new purchase.
     * @param name The name of the consumer.
     * @param frequence The frequence of request.
     */
    public Consumer(Warehouse warehouse, String name, int frequence) {
	super(name);
	this.warehouse = warehouse;
	if(frequence < 0) {
	    System.out.println("Error: frequence is negative. Default frequence: 50");
	    this.frequence = 250;
	} else {
	    this.frequence = frequence;
	}
    } 

    /**
     * Return the frequence of request.
     *
     * @return The frequence of request.
     */
    public int getFrequence() {
	return frequence;
    }

    /**
     * Return the warehouse shared between the producer and the consumer.
     *
     * @return The warehouse.
     */
    public Warehouse getWarehouse() {
	return warehouse;
    }

    /**
     * Return the number of purchases that the consumer wants.
     *
     * @return The number of purchases.
     */
    public int numberOfPurchases() {
	return nPurchases;
    }

    /** 
     * This method active a consumer object to request some purchases.
     */
    public void run() {
	Purchase value = null;
	Random rand = new Random();
	int rand_freq = 0;
	for(int i = 0; i < nPurchases; i++) {
	    /* The consumer request a purchases. */
	    value = warehouse.getPurchase();
	    System.out.println("                                                Consumer " + getName() 
			       + " gets the purchase n." + value.getSerialNumber());
	    /* Setting for the next request. */
	    if(frequence == 0) {
		rand_freq = (rand.nextInt() % 1000);
		if(rand_freq < 0) {
		    rand_freq = -rand_freq;
		}
		rand_freq++;
	    }
	    try { sleep(rand_freq); }
	    catch(InterruptedException e) { }
	}
    }

    /**
     * Set a new frequece of request.
     * 
     * @param frequence The frequece of request.
     */ 
    public void setFrequence(int frequence) {
	if(frequence < 0) {
	    System.out.println("Error: frequence is negative. Default frequence: 250");
	    this.frequence = 250;
	} else {
	    this.frequence = frequence;
	}
    }

} // end class Consumer
