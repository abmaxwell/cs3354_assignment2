package cs3354.assignment2;

import java.io.Serializable;
import java.util.Comparator;

/*******************************************************************************
 @author Alexander Maxwell
 Date: 02/07/2017
 @version 1.0
 ******************************************************************************/
public class SortByTitle implements Serializable, Comparator<Product>{

    /*
        Takes two objects of type Product and compares them by Title.
        @param (Product) lhs item and rhs item to compare to each other.
        @return Returns .
     */
    public int compare(Product lhs, Product rhs) {
        return lhs.getTitle().compareTo(rhs.getTitle());
    }
}
