package classes;

import java.util.Comparator;

/**
 * This class represents a Comparator for Integers.
 * The Comparator has only one compare method. It compares two given Integer and returns 0, 1 or -1.
 *
 * @author Jorma Steiner
 */
public class IntegerComparator implements Comparator<Integer> {

    /**
     * Compares two Integer with each other.
     * The method returns 0 if both Integer are the same, 1 if the first one is bigger and -1 if the first one is
     * smaller.
     *
     * @param o1 first given Integer
     * @param o2 second given Integer
     * @return 0 if smae Integer, -1 if first is smaller, 1 if first is bigger
     */
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1.equals(o2)){
            return 0;
        }
        if (o1 < o2){
            return -1;
        }
        else{
            return 1;
        }
    }
}
