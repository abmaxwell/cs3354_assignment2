package cs3354.assignment2;

import java.io.Serializable;
import java.lang.Math;

/*******************************************************************************
 @author Alexander Maxwell
 Date: 02/07/2017
 @version 1.0
 @since 1.0
 <p> The Toy class is a subclass of the superclass Product. It extends the
 available fields representing a Product by including an item's weight. It also
 defines it's own private member variables Base_Ship_Rate and Commission_Rate.
 </p>
 @see Product
 ******************************************************************************/
public class Toy extends Product implements Serializable{

    /***************************************************************************
     * VARIABLE DEFINITIONS
     **************************************************************************/

    // Define private member variables.
    private double weight;     // Holds item's unique weight in ounces (oz).
    private double BASE_SHIP_CREDIT = 4.49; // Holds unique shipping credit.
    private double COMMISSION_RATE = 0.15; // Holds unique commission %.
    private double WEIGHT_SHIP_CREDIT = 0.50;// Holds per pound shipping credit.
    private int WEIGHT_UNIT = 16; // 8oz = 0.5 lbs 16oz = 1 lbs 24oz = 1.5 lbs

    /***************************************************************************
     * CONSTRUCTORS
     **************************************************************************/
    /*
      Default Constructor (Initialize to "0" or "").
    */
    public Toy() {
        super();
        weight = 0.0;
    }

    /*
      Overloaded Constructor (Initialize to user specified values)
      @param sku the item's unique SKU.
      @param quantity the item's available quantity (>= 0).
      @param price the item's price (> 0.00).
      @param title the item's title.
      @param weight the item's weight in ounces (oz).
    */
    public Toy(int sku, String title, double price, int quantity,
               double weight) {
        super(sku, title, price, quantity);
        this.weight = weight;
    }

    /***************************************************************************
     * PUBLIC MEMBER METHODS
     **************************************************************************/
    public void display() {
        // Display's universal attributes in addition to
        // Toy specific attributes.
        super.display();
        System.out.println("Weight: " + weight + " oz");

    }
    /*
    Method: totalShippingCredit
    Type: double
    Description: Calculates the total shipping credit given to seller
    from processing the sale of an item.
    (total shipping credit = item specific shipping credit x quantity sold)
    Param: @param The (int) given quantity.
    Return: @return Returns the (double) total shipping credit of processing a
    sale based on quality sold and weight of toy.
    */
    public double totalShippingCredit(int givenQuantity){

        // Calculate the total number of lbs.
        // #lbs = (weight of item) / (16oz/lbs)
        int numPounds = (int)(Math.ceil(weight/WEIGHT_UNIT));

        // Calculate the total shipping credit.
        // shipping credit = base shipping credit + weight based shipping
        // credit * #lbs)
        double shipCredit = BASE_SHIP_CREDIT + (WEIGHT_SHIP_CREDIT * numPounds);

        return (shipCredit * givenQuantity);
    }

    /*************************************
     * Getters
     **************************************/
    /*
        @return Returns the toy's unique weight in total ounces.
    */
    public double getWeight() {
        return weight;
    }
    /*
      @return Returns the item's category type as "Toy".
    */
    public String getType() {
        return "Toy";
    }
    /*
        @return Returns the unique base shipping credit.
    */
    public double getBaseShipCredit(){
        return BASE_SHIP_CREDIT;
    }
    /*
        @return Returns the unique commission rate.
    */
    public double getCommissionRate(){
        return COMMISSION_RATE;
    }
}
