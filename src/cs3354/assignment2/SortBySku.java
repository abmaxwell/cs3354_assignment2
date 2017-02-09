package cs3354.assignment2;

import java.io.Serializable;
import java.util.Comparator;

/*******************************************************************************
 @author Alexander Maxwell
 Date: 02/07/2017
 @version 1.0
 ******************************************************************************/
public class SortBySku implements Serializable, Comparator<Product>{

    /*
        Takes two objects of type Product and compares them by SKU.
        @param (Product) lhs item and rhs item to compare to each other.
        @return Returns -1 if lhs SKU is less than rhs SKU. Returns 0 if
        lhs SKU equals rhs SKU. Returns 1 if lhs SKU is greater than rhs SKU.
    */
    public int compare(Product lhs, Product rhs){
        int lhsSku = lhs.getSku();
        int rhsSku = rhs.getSku();

        if (lhsSku < rhsSku){
            return -1;
        } else if (lhsSku == rhsSku){
            return 0;
        } else {
            return 1;
        }
    }
}
