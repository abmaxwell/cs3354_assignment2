package cs3354.assignment2;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;
/*******************************************************************************
 @author Alexander Maxwell
 Date: 02/07/2017
 @version 2.0
 @since 1.0
 Class Name: Main
 Description: <p> The Main class defines the driver for a store inventory
 program. It loops a menu, reads in items from a file and writes items
 to a file after the program quits. It allows users to add items to the
 inventory, remove items from the inventory, view the inventory sorted,
 and processes selling inventory items.
 </p>
 ******************************************************************************/
public class Main {

    public static void main(String[] args) {

        // Define Main class member variables.
        boolean loopMenu = true;
        boolean operationFlag = true;
        int skuFind;
        int menuChoice;
        int itemSku;
        int itemQuantity;
        int itemIsbn;
        int itemUpc;
        double itemPrice;
        double itemWeight;
        String itemTitle;
        String itemAuthor;
        final String STORE_NAME = "BlueBOX (v2.0) Store Inventory Menu";
        final String FILE_NAME = "inventoryRecord.txt";
        Inventory storeInventory = new Inventory();

        // Create input scanner.
        Scanner input = new Scanner(System.in);


        /*
            Create a new input file instance, a new input object instance,
            and attempt to read in an object from the file. If it fails simply
            create a new "Inventory" object to store items to.
        */

        try {
            FileInputStream fileIN = new FileInputStream(FILE_NAME);
            ObjectInputStream objectIN= new ObjectInputStream(fileIN);
            storeInventory = (Inventory) objectIN.readObject();
            fileIN.close();
            System.out.println("Loading inventory from file '"
                    + FILE_NAME + "'..." );
        } catch (FileNotFoundException e) {
            System.out.println("ERROR! There is no file named '"
                    + FILE_NAME + "'.");
        } catch (IOException e) {
            System.out.println("ERROR! There is a problem with file input " +
                    "from '"+ FILE_NAME + "'.");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR! Class not found on input from file " +
                    "named '" + FILE_NAME + "'.");
        }


        // Loop menu with inventory control options.
        do {
            /*
             @throws InputMismatchException
             */
            try {
                System.out.println();
                System.out.println(STORE_NAME);
                System.out.println();
                System.out.println("1. Add Product");
                System.out.println("2. Remove Product");
                System.out.println("3. Find Product by SKU");
                System.out.println("4. Display Current Inventory (Sorted by SKU)");
                System.out.println("5. Display Current Inventory " +
                        "(Sorted by Title)");
                System.out.println("6. Process A Sale");
                System.out.println("7. Quit Program");
                System.out.println();
                System.out.print("Enter choice: ");
                Scanner inputMenu = new Scanner(System.in);
                menuChoice = inputMenu.nextInt();

                switch (menuChoice) {
                    case 1:
                        // Read in category option from user.
                        System.out.println();
                        System.out.println("Select Product Type");
                        System.out.print("Enter M for movie, B for Book, or T " +
                                "for Toy: ");
                        char categoryChoice =
                                Character.toUpperCase(input.next().charAt(0));
                        switch (categoryChoice) {
                            case 'M':
                                // Prompt for new movie from user.
                                System.out.println();
                                System.out.println("-----------------------");
                                System.out.println("--  Add A New Movie  --");
                                System.out.println("-----------------------");
                                System.out.println();

                                System.out.print("Enter SKU: ");
                                itemSku = input.nextInt();
                                System.out.println();

                                System.out.print("Enter Title: ");
                                input.nextLine();  // Consume newline after SKU
                                itemTitle = input.nextLine();
                                System.out.println();

                                System.out.print("Enter Price: $");
                                itemPrice = input.nextDouble();
                                System.out.println();

                                System.out.print("Enter Quantity: ");
                                itemQuantity = input.nextInt();
                                System.out.println();

                                System.out.print("Enter UPC: ");
                                itemUpc = input.nextInt();
                                System.out.println();

                                // Add new movie to inventory.
                                Movie newMovie = new Movie(itemSku, itemTitle,
                                        itemPrice, itemQuantity, itemUpc);
                                operationFlag = storeInventory.addItem(newMovie);
                                if (operationFlag) {
                                    System.out.println("The movie '" + itemTitle +
                                            "' with SKU #" + itemSku + " was " +
                                            "successfully added.");
                                }
                                break;
                            case 'B':
                                // Prompt for new book from user.
                                System.out.println();
                                System.out.println("----------------------");
                                System.out.println("--  Add A New Book  --");
                                System.out.println("----------------------");
                                System.out.println();

                                System.out.print("Enter SKU: ");
                                itemSku = input.nextInt();
                                System.out.println();

                                System.out.print("Enter Title: ");
                                input.nextLine();  // Consume newline after SKU
                                itemTitle = input.nextLine();
                                System.out.println();

                                System.out.print("Enter Price: $");
                                itemPrice = input.nextDouble();
                                System.out.println();

                                System.out.print("Enter Quantity: ");
                                itemQuantity = input.nextInt();
                                System.out.println();

                                System.out.print("Enter ISBN: ");
                                itemIsbn = input.nextInt();
                                System.out.println();

                                System.out.print("Enter Author: ");
                                input.nextLine();  // Consume newline after SKU
                                itemAuthor = input.nextLine();
                                System.out.println();

                                // Add new book to inventory.
                                Book newBook = new Book(itemSku, itemTitle,
                                        itemPrice, itemQuantity, itemIsbn,
                                        itemAuthor);
                                operationFlag = storeInventory.addItem(newBook);
                                if (operationFlag) {
                                    System.out.println("The book '" + itemTitle + "'" +
                                            " with SKU #" + itemSku + " was " +
                                            "successfully added.");
                                }
                                break;
                            case 'T':
                                // Prompt for new toy from user.
                                System.out.println();
                                System.out.println("---------------------");
                                System.out.println("--  Add A New Toy  --");
                                System.out.println("---------------------");
                                System.out.println();

                                System.out.print("Enter SKU: ");
                                itemSku = input.nextInt();
                                System.out.println();

                                System.out.print("Enter Title: ");
                                input.nextLine();  // Consume newline after SKU
                                itemTitle = input.nextLine();
                                System.out.println();

                                System.out.print("Enter Price: $");
                                itemPrice = input.nextDouble();
                                System.out.println();

                                System.out.print("Enter Quantity: ");
                                itemQuantity = input.nextInt();
                                System.out.println();

                                System.out.print("Enter Weight (in ounces): ");
                                itemWeight = input.nextDouble();
                                System.out.println();

                                // Add new toy to inventory.
                                Toy newToy = new Toy(itemSku, itemTitle,
                                        itemPrice, itemQuantity, itemWeight);
                                operationFlag = storeInventory.addItem(newToy);
                                if (operationFlag) {
                                    System.out.println("The toy '" + itemTitle + "'" +
                                            " with SKU #" + itemSku + " " +
                                            "was successfully added...");
                                }
                                break;
                            default:
                                System.out.println();
                                System.out.println("Invalid Option! " +
                                        "Please choose M, B, or T.");

                        }
                        break;

                    case 2:

                        // Prompt for SKU of item to remove from user.
                        System.out.println();
                        System.out.println("----------------------");
                        System.out.println("--  Remove Product  --");
                        System.out.println("----------------------");
                        System.out.println();

                        System.out.print("Enter SKU: ");
                        itemSku = input.nextInt();
                        System.out.println();

                        // Attempt to remove item from inventory.
                        storeInventory.removeItem(itemSku);

                        break;

                    case 3:

                        // Prompt for SKU of item to display from user.
                        System.out.println();
                        System.out.println("-----------------------");
                        System.out.println("--  Display Product  --");
                        System.out.println("-----------------------");
                        System.out.println();

                        System.out.print("Enter SKU: ");
                        itemSku = input.nextInt();
                        System.out.println();

                        // Display item from inventory.
                        storeInventory.displayItem(itemSku);
                        break;

                    case 4:

                        System.out.println();
                        storeInventory.displayInventoryBySku();
                        break;

                    case 5:

                        System.out.println();
                        storeInventory.displayInventoryByTitle();
                        break;

                    case 6:

                        // OPTION 6
                        System.out.println("OPTION 6");

                        // Prompt user for SKU, quantity, shipping cost paid.
                        System.out.println();
                        System.out.println("----------------------");
                        System.out.println("--  Process A Sale  --");
                        System.out.println("----------------------");
                        System.out.println();

                        System.out.print("Enter SKU of product sold: ");
                        int givenSku = input.nextInt();
                        System.out.println();
                        System.out.print("Enter quantity of product sold: ");
                        int givenQuantity = input.nextInt();
                        System.out.println();
                        System.out.print("Enter shipping cost of product sold: $");
                        double givenShippingCost = input.nextDouble();
                        System.out.println();


                        operationFlag = storeInventory.processSale(givenSku,
                                givenQuantity, givenShippingCost);

                        if (operationFlag) {
                            System.out.println();
                            System.out.println("The sale of " + givenQuantity +
                                    " units with SKU #" + givenSku + " was " +
                                    "successfully processed.");
                        }
                        break;

                    case 7:

                        System.out.println();
                        System.out.println("Thanks for the inventory! Have a " +
                                "great day!");
                        loopMenu = false;
                        break;
                    default:
                        System.out.println();
                        System.out.println("ERROR! Invalid Option! " +
                                "Please choose 1. 2. 3. 4. 5. 6. or 7. " +
                                "from the menu options.");
                }

            } catch (InputMismatchException e){
                System.out.println();
                System.out.println("ERROR! Invalid input type. " +
                        "Please try again.");
                input.next();
            }
        } while(loopMenu);

        /*
            Create a new output file instance, a new output object instance,
            and attempt to write an object to the file. If it fails simply
            create a new "Inventory" object to store items to.
        */

        try {
            FileOutputStream fileOUT = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOUT = new ObjectOutputStream(fileOUT);
            objectOUT.writeObject(storeInventory);
            fileOUT.close();
        } catch (IOException e) {
            System.out.println("ERROR! There is a problem writing to "
                    + FILE_NAME + ".");;
        }
    }
}
