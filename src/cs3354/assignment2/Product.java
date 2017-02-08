package cs3354.assignment2;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

/*******************************************************************************
 @author Alexander Maxwell
 Date: 02/07/2017
 @version 1.0
 @since 1.0

 ******************************************************************************/
public class Product implements Serializable {

    /***************************************************************************
     * VARIABLE DEFINITIONS
     **************************************************************************/

    // Define private member variables.
    private int sku;        // Holds item's unique SKU.
    private int quantity;   // Holds item's available quantity (>= 0).
    private double price;   // Holds item's price (> $0.00).
    private String title;   // Holds item's title.


    /***************************************************************************
     * CONSTRUCTORS
     **************************************************************************/
    /*
      Default Constructor (Initialize to "0").
    */
    public Product(){
        sku = 0;
        quantity = 0;
        price = 0.00;
        title = "";
    }
    /*
      Overloaded Constructor (Initialize to user specified values)
      @param sku the item's unique SKU.
      @param quantity the item's available quantity (>= 0).
      @param price the item's price (> 0.00).
      @param title the item's title.
    */
    public Product(int sku, String title, double price, int quantity){
        this.sku = sku;
        this.quantity = quantity;
        this.price = price;
        this.title = title;
    }

    /***************************************************************************
     * PUBLIC MEMBER METHODS
     **************************************************************************/
    /*
    Method: displayProduct
    Type: void
    Description: Displays products attributes.
     */
    public void display() {
        System.out.println("SKU: " + sku);
        System.out.println("Title: " + title);
        System.out.println("Price: $" + formatPrice(price));
        System.out.println("Quantity: " + quantity);
    }

    /*************************************
     * Getters
    **************************************/
    /*
        @return the item's unique SKU.
    */
    public int getSku() {
        return sku;
    }
    /*
        @return the item's title.
    */
    public String getTitle() {
        return title;
    }
    /*
        @return the item's price (> 0.00).
    */
    public double getPrice() {
        return price;
    }
    /*
        @return the item's price formatted to ($0.00).
    */
    public String getFormattedPrice(){
        return formatPrice(price);
    }
    /*
        @return the item's available quantity (>= 0).
    */
    public int getQuantity() {
        return quantity;
    }

    /***************************************************************************
     * PRIVATE MEMBER METHODS
     **************************************************************************/

    /*
    Method: formatPrice
    Type: String
    Description: Takes double and formats it to $0.00 and returns as string.
    @param price the item's price (> 0.00) to be formatted.
    @return a string with the price formatted to $0.00.
     */
    private String formatPrice(double price){
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter =
                NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(price);
    }

}
