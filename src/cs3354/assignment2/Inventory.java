package cs3354.assignment2;

import java.io.Serializable;
import java.util.*;
import java.text.NumberFormat;

/*******************************************************************************
@author Alexander Maxwell
Date: 02/07/2017
@version 1.0
<p> The Inventory class defines an object of type Arraylist which is of type
Product and serves as the the primary storage interface for the inventory. It
provides the public methods: addItem, removeItem, displayItem,
displayInventoryBySku, displayInventoryByTitle, processSale, and private method
searchInventory. These methods are discussed in detail below.
</p>
 @see ArrayList
*******************************************************************************/
public class Inventory implements Serializable{

    /***************************************************************************
     * VARIABLE DEFINITIONS
     **************************************************************************/

    // Define a new Arraylist of type Product
    private ArrayList <Product> currentInventory = new ArrayList<Product>();

    /***************************************************************************
     * CONSTRUCTORS
     **************************************************************************/
    // Define Inventory class default constructor.
    public Inventory(){}

    /***************************************************************************
     * PUBLIC MEMBER METHODS
     **************************************************************************/

     /*
        Method: addItem
        Type: Boolean
        Description: Adds a new Product object to the current Inventory object's
        inventory list.
        Param: @param ItemDVD class object, which is a unique DVD to add to
        inventory.
        Return: @return Adds passed object to Inventory object's array list.
        Returns <CODE>True</CODE> if the item was added successfully, and
        returns <CODE>False</CODE> if the item was added unsuccessfully.
     */

    public boolean addItem (Product newProduct) {

        /*
            Check current inventory to see if SKU of new product matches the SKU
            of a product already in the inventory. If it does then display and
            error to the user, otherwise add the product to the inventory.
        */

        Product currentProduct = searchInventory(newProduct.getSku());

        if (currentProduct != null) {
            System.out.println("ERROR! The SKU '" + newProduct.getSku() +
                    "' is already in use. Please select a different " +
                        "SKU and try again.");
            return false;
        }

        /*
            Validate the format of the price. If it's "0" then display an error,
            otherwise check to see if decimal portion of the price  has more
            than two places, if it does then display an error. Furthermore,
            validate the quantity and determine if it's less than or equal to
            "0", if it is then display an error.
        */

        // Convert price from double to string to check decimal portion.
        String currentPrice = Double.toString(newProduct.getPrice());
        int locationDecimal = currentPrice.indexOf('.');
        String decimalPortion = currentPrice.substring(locationDecimal + 1);

        if (newProduct.getPrice() <= 0){
            System.out.println();
            System.out.println("ERROR! Price cannot be $0.00. Minimum price" +
                        "$0.01");
            return false;
        } else if (decimalPortion.length() > 2 || decimalPortion.length() < 1){
            System.out.println();
            System.out.println("ERROR! Invalid price. Price must be formatted "
                        + "in the form #.##");
            return false;
        } else if (newProduct.getQuantity() < 0){
            System.out.println();
            System.out.println("ERROR! Invalid quantity. Quantity must be " +
                    "greater than 0.");
            return false;
        } else {
                return currentInventory.add(newProduct);
        } // End if/else if
    } // End addItem

    /*
    Method: removeItem
    Type: Boolean
    Description: Removes a Product object from the current inventory if it
    exists in the inventory otherwise it outputs an error.
    Param: @param (int) Unique SKU of item to be removed.
    Return: @return Returns <CODE>True</CODE> if an item was successfully
    removed, and returns <CODE>False</CODE> if the item was not found in the
    inventory.
    */
    public boolean removeItem (int givenSku){

        Product currentProduct = searchInventory(givenSku);

        if(currentProduct == null){
            System.out.println("ERROR! The SKU '" + givenSku +
                    "' could not be found in the inventory. Please select a " +
                    "different SKU and try again.");
            return false;
        } else {
            currentInventory.remove(currentProduct);
            System.out.println( "The item with SKU '" + givenSku +
                    "' has been removed from the inventory.");
            return true;
        }

    } // End removeItem
    /*
    Method: displayItem
    Type: void
    Description: Displays a Product object from the current inventory if it
    exists in the inventory otherwise it outputs an error.
    Param: @param (int) Unique SKU of item to be displayed.
    Return: N/A
    */
    public void displayItem(int givenSku){
        Product currentProduct = searchInventory(givenSku);

        if(currentProduct == null){
            System.out.println("ERROR! The SKU '" + givenSku +
                    "' could not be found in the inventory. Please select a " +
                    "different SKU and try again.");
        } else {
            currentProduct.display(); // Call type specific Product.display()
        }
    }

    /*
    Method: displayInventoryBySku
    Type: void
    Description: Displays the current inventory sorted by SKU.
    Param: N/A
    Return: N/A
    */
    public void displayInventoryBySku(){

        // Method specific variable definitions.
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter =
                NumberFormat.getCurrencyInstance(locale);

        if (currentInventory.size() <= 0){
            System.out.println("ERROR! There's no inventory to display.");
        } else {
            // Create a new comparator and sort inventory by SKU.
            Comparator<Product> comp = new SortBySku();
            Collections.sort(currentInventory,comp);

            System.out.format("%1$-15s %2$-15s %3$-15s %4$-15s %5$-15s %n",
                    "Category", "SKU", "Quantity", "Price", "Title");
            System.out.println();
            for (Product currentProduct : currentInventory){

                System.out.format("%1$-15s %2$-15s %3$-15s %4$-15s %5$-15s %n",
                        currentProduct.getType(),currentProduct.getSku(),
                        currentProduct.getQuantity(),
                        currencyFormatter.format(currentProduct.getPrice()),
                        currentProduct.getTitle());
            }
        }

    } // End displayInventoryBySku

    /*
    Method: displayInventoryByTitle
    Type: void
    Description: Displays the current inventory sorted by SKU.
    Param: N/A
    Return: N/A
    */
    public void displayInventoryByTitle(){

        // Method specific variable definitions.
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter =
                NumberFormat.getCurrencyInstance(locale);

        if (currentInventory.size() <= 0){
            System.out.println("ERROR! There's no inventory to display.");
        } else {
            // Create a new comparator and sort inventory by SKU.
            Comparator<Product> comp = new SortByTitle();
            Collections.sort(currentInventory,comp);

            System.out.format("%1$-15s %2$-15s %3$-15s %4$-15s %5$-15s %n",
                    "Category", "SKU", "Quantity", "Price", "Title");
            System.out.println();
            for (Product currentProduct : currentInventory){

                System.out.format("%1$-15s %2$-15s %3$-15s %4$-15s %5$-15s %n",
                        currentProduct.getType(),currentProduct.getSku(),
                        currentProduct.getQuantity(),
                        currencyFormatter.format(currentProduct.getPrice()),
                        currentProduct.getTitle());
            }
        }

    } // End displayInventoryBySku

    /*
    Method: processSale
    Type: boolean
    Description: Processes the sale of an item in the inventory. User must
    provide the SKU of the item, quantity of item to sell
    Param:
    @param (int) Unique SKU of item to processes a sale on.
    @param (int) Given quantity of product to sell.
    @param (double) Shipping cost paid by shipping company.
    Return:  Returns <CODE>True</CODE> if a sale was successfully processed, and
    returns <CODE>False</CODE> if the sale failed.
    */
    public boolean processSale (int givenSku, int givenQuantity,
                                double givenShippingCost){

        // Method specific variables
        double totalPrice;
        double totalShippingCredit;
        double totalCommission;
        double totalProfit;

        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter =
                NumberFormat.getCurrencyInstance(locale);

        // Search for product in inventory based on given SKU.
        Product currentProduct = searchInventory(givenSku);

        if(currentProduct == null){
            System.out.println("ERROR! The SKU '" + givenSku +
                    "' could not be found in the inventory. Please select a " +
                    "different SKU and try again.");
            return false;
        } else {
            if(currentProduct.getQuantity() < givenQuantity){

                // Print error to user to change quantity.
                System.out.println("ERROR! The SKU '" + givenSku +
                        "' does not have enough inventory to process sale.");
                System.out.println("Given quantity was " + givenQuantity +
                        ". Available quantity of SKU #" + givenSku + " is " +
                        currentProduct.getQuantity() + ".");
                return false;
            } else{
                // Set quantity of item to reflect the new available quantity.
                // (new quantity = current quantity - given quantity)
                currentProduct.setQuantity((currentProduct.getQuantity()
                        - givenQuantity));

                // Calculate the total price of the items sold.
                totalPrice = currentProduct.totalPrice(givenQuantity);

                // Calculate the total shipping credit of the items sold.
                totalShippingCredit =
                        currentProduct.totalShippingCredit(givenQuantity);

                // Calculate the total commission on the items sold.
                totalCommission = currentProduct.totalCommission(givenQuantity);

                // Calculate the total profit on the items sold.
                totalProfit = currentProduct.totalProfit(givenQuantity,
                        givenShippingCost);

                /*
                // DEBUG
                System.out.println("DEBUG: TotalPrice: " + totalPrice);
                // DEBUG
                System.out.println("DEBUG: TotalShippingCredit: " +
                totalShippingCredit);
                // DEBUG
                System.out.println("DEBUG: TotalCommission: " +
                totalCommission);
                // DEBUG
                System.out.println("DEBUG: TotalProfit: " + totalProfit);

                */
                // Print out calculations from processing a sale to the user.
                System.out.printf("%-10s %20s \n", "Total Price:",
                        currencyFormatter.format(totalPrice));

                System.out.printf("%-10s %10s \n", "Total Shipping Credit:",
                        currencyFormatter.format(totalShippingCredit));

                System.out.printf("%-10s %14s \n", "Total Commission: ",
                currencyFormatter.format(totalCommission));
                // System.out.println("DEBUG: " + totalProfit);
                System.out.printf("%-10s %22s \n" ,"Profit: ",
                currencyFormatter.format(totalProfit));
                return true;
            }
        }

    }
    /***************************************************************************
    * PRIVATE MEMBER METHODS
    ***************************************************************************/
    /*
        Method: searchInventory
        Type: Product
        Description: Searches inventory (Arraylist) for item matching given SKU.
        If it's found it returns the item. Otherwise it returns NULL.
        @param (int) SKU of item to search for.
        @return (Product) Item searched for if found otherwise NULL.

     */
    private Product searchInventory(int searchSku){

        for ( Product currentProduct : currentInventory ){
            if (currentProduct.getSku() == searchSku)
                return currentProduct;
        }
        return null;
    }
}
