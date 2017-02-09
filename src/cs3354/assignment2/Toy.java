package cs3354.assignment2;

import java.io.Serializable;

/*******************************************************************************
 @author Alexander Maxwell
 Date: 02/07/2017
 @version 1.0
 @since 1.0

 ******************************************************************************/
public class Toy extends Product implements Serializable{

    /***************************************************************************
     * VARIABLE DEFINITIONS
     **************************************************************************/

    // Define private member variables.
    private double weight;     // Holds item's unique weight in ounces (oz).

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
}
