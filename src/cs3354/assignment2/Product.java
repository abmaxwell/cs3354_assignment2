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
    private double BASE_SHIP_CREDIT = 0.00; // Null value to denote default.
    private double COMMISSION_RATE = 0.00; // Null value to denote default.
    private String title;   // Holds item's title.
    private String type = "Not Defined";    // Holds item's category type.


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
        System.out.println();
        System.out.println("Quantity: " + quantity);
        System.out.println();
        System.out.println("Price: " + formatPrice(price));
        System.out.println();
        System.out.println("Title: " + title);
        System.out.println();
    }

    /*
    Method: totalPrice
    Type: double
    Description: Calculates the total price from processing the sale of an item.
    (total price = product price x quantity sold)
    Param: @param The (int) given quantity.
    Return: @return Returns the (double) total price of processing a sale based
    on quality sold.
     */
    public double totalPrice(int givenQuantity){
        return (price * givenQuantity);
    }
    /*
    Method: totalShippingCredit
    Type: double
    Description: Calculates the total shipping credit given to seller
    from processing the sale of an item.
    (total shipping credit = item specific shipping credit x quantity sold)
    Param: @param The (int) given quantity.
    Return: @return Returns the (double) total shipping credit of processing a
    sale based on quality sold.
     */
    public double totalShippingCredit(int givenQuantity){
        return (getBaseShipCredit() * givenQuantity);
    }
    /*
    Method: totalCommission
    Type: double
    Description: Calculates the total commission from processing the sale of
    an item.(commission = [price * COMMISSION] * given quantity)
    Param: @param The (int) given quantity.
    Return: @return Returns the (double) total commission of processing a sale
    based on quality sold.
     */
    public double totalCommission(int givenQuantity){
        return (((price * getCommissionRate()) * givenQuantity));
    }
    /*
    Method: totalProfit
    Type: double
    Description: Calculates the total profit from processing the sale of
    an item.
    (profit = [total price + total shipping credit] - [total commission +
    shipping cost])
    Param: N/A
    Return: @return Returns the (double) total profit of processing a sale based
    on quality sold.
     */
    public double totalProfit(int givenQuantity, double givenShippingCost){
       return ((totalPrice(givenQuantity) + totalShippingCredit(givenQuantity))
               - (totalCommission(givenQuantity) + givenShippingCost));
    }

    /*************************************
     * Getters
    **************************************/
    /*
        @return Returns the item's unique SKU.
    */
    public int getSku() {
        return sku;
    }
    /*
        @return Returns the item's title.
    */
    public String getTitle() {
        return title;
    }
    /*
        @return Returns the item's price (> 0.00).
    */
    public double getPrice() {
        return price;
    }
    /*
        @return Returns the item's price formatted to ($0.00).
    */
    public String getFormattedPrice(){
        return formatPrice(price);
    }
    /*
        @return Returns the item's available quantity (>= 0).
    */
    public int getQuantity() {
        return quantity;
    }
    /*
        @return Returns the item's category type (Movie, Book, or Toy).
    */
    public String getType() {
        return type;
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
    /*************************************
     * Setters
     **************************************/
    /*
        @param Set's the item's available quantity (>= 0).
    */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
