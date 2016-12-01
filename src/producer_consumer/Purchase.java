/* 
 * File: Purchase.java
 * Author: Piero Dalle Pezze
 * Licence: MIT
 * Date: 14/05/2006
 * Version: 1.0
 */
package producer_consumer;


/** 
 * A generic purchase. It is supplied by a producer and used by a consumer.
 *
 * @author Piero Dalle Pezze
 * @version 1.0
 */
public class Purchase {
    
    /**
     * The counter to generate unique serialNumber.
     */
    private static long count = 1;

    /**
     * The serialNumber of the goods. It is unique.
     */
    private long serialNumber;

    /**
     * Default constructor. It creates a purchase with a unique serial number.
     */
    public Purchase() {
	serialNumber = count;
	/* Sets the next serial number. */
	count++;
    }

    /**
     * Return the serial number of the purchase.
     *
     * @return The serial number.
     */
    public long getSerialNumber() {
	return serialNumber;
    }

}  //end class Purchase
