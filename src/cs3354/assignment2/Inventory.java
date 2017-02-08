package cs3354.assignment2;

import java.io.Serializable;
import java.util.ArrayList;

/*******************************************************************************
@author Alexander Maxwell
Date: 02/07/2017
@version 1.0

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
        Returns <CODE>True</CODE> if the item was added successfully, and returns
        <CODE>False</CODE> if the item was added unsuccessfully.
     */

    public boolean addItem (Product newProduct) {

        /*
            Check current inventory to see if SKU of new product matches the SKU
            of a product already in the inventory. If it does then display and
            error to the user, otherwise add the product to the inventory.
        */

        Product currentProduct = searchInventory(newProduct.getSku());

        if (currentProduct != null) {
            System.out.println();
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
        } else if (decimalPortion.length() > 2 || decimalPortion.length() < 2){
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
