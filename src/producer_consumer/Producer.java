/* 
 * File: Producer.java
 * Author: Piero Dalle Pezze
 * Mail: piero.dallepezze@gmail.com
 * Country: Italy
 * Licence: Open Source
 * Date: 14/05/2006
 * Version: 1.0
 */
package producer_consumer;

import java.util.*;


/** 
 * The producer of the producer-consumer model. This class represents the object
 * which produces or sells a resource to the consumer. Resouces 
 * are mutually exclusive.
 *
 * @author Piero Dalle Pezze
 * @version 1.0
 */
public class Producer extends Thread {

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
     * The number of purchases that a producer produces. It is a default value.
     */
    private int nSales = 15;

    /**
     * It creates a producer named "Producer" which supplies purchases to the warehouse at least
     * every 50 ms.
     *
     * @param warehouse The warehouse to get purchases.
     */
    public Producer(Warehouse warehouse) {
	this(warehouse, "Producer");
    }

    /**
     * It creates a producer with a name, which supplies purchase to the warehouse at least every
     * 50 ms.
     *
     * @param warehouse The warehouse to put a new purchase.
     * @param name The name of the producer.
     */
    public Producer(Warehouse warehouse, String name) {
	this(warehouse, name, 50);
    }

    /** 
     * It creates a producer with a name which supplies purchases to the warehouse at a frequece
     * decided by user. If frequece is 0, then it means it is random.
     *
     * @param warehouse The warehouse to put a new purchase.
     * @param name The name of the producer.
     * @param frequence The frequence of request.
     */
    public Producer(Warehouse warehouse, String name, int frequence) {
	super(name);
	this.warehouse = warehouse;
	if(frequence < 0) {
	    System.out.println("Error: frequence is negative. Default frequence: 50");
	    this.frequence = 50;
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
     * Return the number of sales that the producer supplies.
     *
     * @return The number of sales.
     */
    public int numberOfSales() {
	return nSales;
    }

    /** 
     * This method active a producer object to supplies some purchases.
     */
    public void run() {
	Purchase value = null;
	Random rand = new Random();
	int rand_freq = 0;
	for(int i = 0; i < nSales; i++) {
	    value = new Purchase();
	    /* Producer put a goods in the warehouse. */
	    warehouse.putPurchase(value);
	    System.out.println("Producer " + getName() + " puts the purchase n." + value.getSerialNumber());
	    /* Setting for the next supply. */
	    if(frequence == 0) {
		rand_freq = (rand.nextInt() % 500) + 1;
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
	    System.out.println("Error: frequence is negative. Default frequence: 50");
	    this.frequence = 50;
	} else {
	    this.frequence = frequence;
	}
    }

} // end class Producer