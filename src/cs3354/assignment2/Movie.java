package cs3354.assignment2;

import java.io.Serializable;

/*******************************************************************************
 @author Alexander Maxwell
 Date: 02/07/2017
 @version 1.0
 @since 1.0

 ******************************************************************************/
public class Movie extends Product implements Serializable {

    /***************************************************************************
     * VARIABLE DEFINITIONS
     **************************************************************************/

    // Define private member variables.
    private int upc;    // Holds item's unique UPC.

    /***************************************************************************
     * CONSTRUCTORS
     **************************************************************************/
    /*
      Default Constructor (Initialize to "0").
    */
    public Movie(){
        super();
        upc = 0;
    }
    /*
      Overloaded Constructor (Initialize to user specified values)
      @param sku the item's unique SKU.
      @param quantity the item's available quantity (>= 0).
      @param price the item's price (> 0.00).
      @param title the item's title.
      @param upc the item's unique UPC.
    */
    public Movie(int sku, String title, double price, int quantity, int upc){
        super(sku, title, price, quantity);
        this.upc = upc;
    }

    /***************************************************************************
     * PUBLIC MEMBER METHODS
     **************************************************************************/
    public void display() {

        // Display's universal attributes in addition to
        // Movie specific attributes.
        super.display();
        System.out.println("UPC: " + upc);
    }
}
