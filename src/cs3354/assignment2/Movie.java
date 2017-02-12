package cs3354.assignment2;

import java.io.Serializable;

/*******************************************************************************
 @author Alexander Maxwell
 Date: 02/07/2017
 @version 1.0
 @since 1.0
 <p> The Movie class is a subclass of the superclass Product. It extends the
 available fields representing a Product by including a UPC. It also defines
 it's own private member variables Base_Ship_Rate and Commission_Rate.
 </p>
 @see Product
 ******************************************************************************/
public class Movie extends Product implements Serializable {

    /***************************************************************************
     * VARIABLE DEFINITIONS
     **************************************************************************/

    // Define private member variables.
    private int upc;    // Holds item's unique UPC.
    private double BASE_SHIP_CREDIT = 2.98; // Holds unique shipping credit.
    private double COMMISSION_RATE = 0.12; // Holds unique commission %.

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

    /*************************************
     * Getters
     **************************************/
    /*
        @return Returns the movie's unique UPC.
    */
    public int getUpc() {
        return upc;
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
    /*
       @return Returns the item's category type as "Movie".
   */
    public String getType() {
        return "Movie";
    }
}

