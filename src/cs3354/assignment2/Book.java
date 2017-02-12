package cs3354.assignment2;

import java.io.Serializable;

/*******************************************************************************
 @author Alexander Maxwell
 Date: 02/07/2017
 @version 1.0
 @since 1.0

 ******************************************************************************/
public class Book extends Product implements Serializable {

    /***************************************************************************
     * VARIABLE DEFINITIONS
     **************************************************************************/

    // Define private member variables.
    private int isbn;      // Holds item's unique ISBN.
    private String author; // Holds item's specific author.
    private double BASE_SHIP_CREDIT = 3.99; // Holds unique shipping credit.
    private double COMMISSION_RATE = 0.15; // Holds unique commission %.

    /***************************************************************************
     * CONSTRUCTORS
     **************************************************************************/
    /*
      Default Constructor (Initialize to "0" or "").
    */
    public Book(){
        super();
        isbn = 0;
        author = "";
    }
    /*
      Overloaded Constructor (Initialize to user specified values)
      @param sku the item's unique SKU.
      @param quantity the item's available quantity (>= 0).
      @param price the item's price (> 0.00).
      @param title the item's title.
      @param isbn the item's unique ISBN.
      @param author the item's specific author.
    */
    public Book(int sku, String title, double price, int quantity, int isbn,
                 String author){
        super(sku, title, price, quantity);
        this.isbn = isbn;
        this.author = author;
    }

    /***************************************************************************
     * PUBLIC MEMBER METHODS
     **************************************************************************/
    public void display() {
        // Display's universal attributes in addition to
        // Book specific attributes.
        super.display();
        System.out.println("ISBN: " + isbn);
        System.out.println();
        System.out.println("Author: " + author);
    }
    /*************************************
     * Getters
     **************************************/
    /*
        @return Returns the book's unique ISBN.
    */
    public int getIsbn() {
        return isbn;
    }
    /*
        @return Returns the book's author.
    */
    public String getAuthor() {
        return author;
    }
    /*
      @return Returns the item's category type as "Book".
  */
    public String getType() {
        return "Book";
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
