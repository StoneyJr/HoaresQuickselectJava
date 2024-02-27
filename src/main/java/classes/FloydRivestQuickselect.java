package classes;

import java.util.List;

/**
 * This class represents a different implementation of the Quickselect Algorithm.
 * The code was copied from https://www.geeksforgeeks.org/floyd-rivest-algorithm/ and adapted in order to accept
 * lists instead of arrays. Comments inside methods are also copied. Functionally it is equivalent to Hoare's
 * quickselect but runs faster on average. For lists under n=600 the quickselect algorithm is used, but for all others
 * two pivots are used. The list is then partitioned into three lists. One containing all elements smaller than the
 * small pivot, one containing all elements greater than the great pivot and one containing all in between. This will
 * be repeated until the kth-smallest element is found.
 *
 * This algorithm only works with integers as elements!
 *
 * @author copied from https://www.geeksforgeeks.org/floyd-rivest-algorithm/ (adjusted by Jorma Steiner)
 */
public class FloydRivestQuickselect implements SelectAlgorithm<Integer> {

    /**
     * Returns the sign of a double.
     * If a number is negative -1 is returned and if it is positive 1 is returned. For zero, it returns 0.
     * This method replaces the comparators from the quickselect algorithm of this project.
     *
     * @param x number to be evaluated
     * @return  -1, 1 or 0 depending on the sign of the number
     */
      private int sign(double x){
            if (x < 0)
                return -1;
            if (x > 0)
                return 1;
            return 0;
        }


    /**
     * This method swaps two numbers in a given list.
     * the two integer paramters represent the two indices for the to-be swapped elements.
     *
     * @param list a given list within the two numbers are located
     * @param i index of the first to-be swapped element
     * @param j index of the second to-be swapped element
     */
    private void swap(List<Integer> list, int i, int j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }

    public Integer select(List<Integer> list, int k){

        return select(list, 0, list.size() - 1, k-1);
    }

    /**
     * This method returns the kth smallest element of a given element.
     * Further details can be found here: https://www.geeksforgeeks.org/floyd-rivest-algorithm/
     *
     * @param list given list which is expected to be unsorted
     * @param left left limit of list
     * @param right left limit of list
     * @param k integer representing k-th place in sorted list
     * @return k-th element in given list
     */
    private Integer select(List<Integer> list, int left, int right, int k){
            while (right > left) {
                if (right - left > 600) {
                    // Choosing a small sublist S based on sampling. 600, 0.5 and 0.5 are arbitrary constants
                    int n = right - left + 1;
                    int i = k - left + 1;
                    double z = Math.log(n);
                    double s = 0.5 * Math.exp(2 * z / 3);

                    double sd = 0.5 * Math.sqrt(z * s * (n - s) / n)
                            * sign(i - n / 2);

                    int newLeft = Math.max(left,
                            (int)(k - i * s / n
                                    + sd));

                    int newRight = Math.min(right,
                            (int)(k + (n - i) * s / n
                                    + sd));

                    select(list, newLeft, newRight, k);
                }

                // Partition the sublist S[left..right] with arr[k] as pivot
                int t = list.get(k);
                int i = left;
                int j = right;
                swap(list, left, k);
                if (list.get(right) > t) {
                    swap(list, left, right);
                }

                while (i < j) {
                    swap(list, i, j);
                    i++;
                    j--;

                    while (list.get(i) < t)
                        i++;
                    while (list.get(j) > t)
                        j--;
                }

                if (list.get(left) == t)
                    swap(list, left, j);
                else {
                    j++;
                    swap(list, right, j);
                }

                // Adjust the left and right pointers to select the sublist having k
                if (j <= k)
                    left = j + 1;
                if (k <= j)
                    right = j - 1;
            }
            return list.get(k);
    }
}
