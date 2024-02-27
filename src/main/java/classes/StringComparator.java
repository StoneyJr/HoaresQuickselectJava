package classes;

import java.util.Comparator;

/**
 * This class represents a comparator for Strings.
 * The Comparator has only one compare method. It compares two given Strings and returns 0, 1 or -1.
 *
 * @author Jorma Steiner
 */
public class StringComparator implements Comparator<String> {

    /**
     * Compares two Strings with each other.
     * The method returns 0 if both Strings are the same, 1 if the first one is alphabetical before and -1 if the first
     * one is alphabetical after the second one. It uses the method compareTo of the String class.
     * Uppercase Letters are before smaller ones.
     * For Example: A is before a, a is before b, B is before a
     *
     * @param o1 first given String
     * @param o2 second given String
     * @return 0 if same String, -1 if first is alphabetical before, 1 if first is alphabetical after
     */
    @Override
    public int compare(String o1, String o2) {
        int dif = o1.compareTo(o2);

        if (dif == 0){
            return 0;
        }

        if (dif < 0){
            dif = -1;
        } else{
            dif = 1;
        }
        return dif;
    }
}
