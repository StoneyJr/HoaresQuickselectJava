package classes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import exceptions.DifferentGenericsException;

/**
 * This class represents the Quickselect Algorithm. For the Constructor a
 * Comparator must be provided. This Comparator is needed for comparing the
 * elements of the given unsorted list.
 *
 * @author Jorma Steiner
 * @param <T> Generic Type of element to be selected from
 */
public class Quickselect<T> implements SelectAlgorithm<T>{

	private List<T> list;
	private final Comparator<T> comparator;

	/**
	 * Creates the Quickselect object setting the generic type T.
	 *
	 * @param comparator object of Comparator class providing logic of comparing
	 *                   elements
	 */
	public Quickselect(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	/**
	 * Returns the k-th element of a given list. The method verifies if both list
	 * and comparator use the same generic type. If not DifferentGenericsException
	 * is thrown. Also verified is given k, it should be between 0 and the size of
	 * the list. Else the algorithm can't function. After verification the recursive
	 * method recSelect is called with first index (0) as left index and last index
	 * (list.size()) as right index.
	 *
	 * @param unsortedList given list which is expected to be unsorted
	 * @param k            integer representing the k-th place in sorted list
	 * @return k-th element in given list
	 */
	public T select(List<T> unsortedList, int k) throws IllegalArgumentException {
		if (k <= 0 || k > unsortedList.size()) {
			throw new IllegalArgumentException("(" + k + ")-element is not possible");
		}
		try {
			this.list = unsortedList;
			return recSelect(0, list.size() - 1, k);
		} catch (ClassCastException e) {
			throw new DifferentGenericsException("Generic Types of List and Comparator doesn't match.");
		}
	}

	/**
	 * Searches recursively the k-th element in the list instance variable. The
	 * method uses a random integer between the two given indices as a pivot-index.
	 * The element at the pivot-index functions as a pivot. "smaller" elements ar
	 * left and "bigger" elements are right of the pivot. For comparing and
	 * rearranging the elements between 'leftIndex' and 'rightIndex' the method
	 * partition is called with both limits and the pivot-index. After the elements
	 * are rearranged with integer k it is decided which side of the pivot-element
	 * is further searched for the k-th element by calling same method again with
	 * new limits. If the pivot-Index equals k or the sublist is only one element
	 * big the element at this index is returned.
	 *
	 * @param leftIndex  left limit of (sub)list
	 * @param rightIndex right limit of (sub)list
	 * @param k          integer representing the k-th place in sorted list
	 * @return k-th element in given list
	 */
	private T recSelect(int leftIndex, int rightIndex, int k) {

		// sublist is only one element big
		if (leftIndex == rightIndex) {
			return this.list.get(leftIndex);
		}

		// random index between leftIndex and rightIndex
		int pivotIndex = leftIndex + (int) (Math.random() * ((rightIndex - leftIndex) + 1));

		pivotIndex = partition(leftIndex, rightIndex, pivotIndex);

		// deciding which side of pivot-element to be further searched
		if (pivotIndex + 1 == k) {
			return this.list.get(pivotIndex);
		} else if (pivotIndex + 1 < k) {
			return recSelect(pivotIndex + 1, rightIndex, k);
		} else {
			return recSelect(leftIndex, pivotIndex - 1, k);
		}
	}

	/**
	 * Rearranges elements in the instance variable list according to pivot-value.
	 * First the pivot-element is swapped to the end of the (sub)list. Then two
	 * pointers move from the left and the right. The left one searches for bigger
	 * elements than the pivot-element and the right pointer searches for smaller
	 * ones. If both pointers have found one those two are swapped. This rearranging
	 * continues until both pointer meet each other. Lastly the pivot-element is
	 * moved between the smaller and bigger ones.
	 *
	 * @param leftIndex  left limit of (sub)list
	 * @param rightIndex right limit of (sub)list
	 * @param pivotIndex index its element will be used as pivot
	 * @return index of pivot after rearranging elements
	 */
	private int partition(int leftIndex, int rightIndex, int pivotIndex) {

		int l = leftIndex - 1; // left pointer
		int r = rightIndex; // right pointer
		T pivotValue = this.list.get(pivotIndex);

		swapElementsAt(pivotIndex, rightIndex);

		while (true) {
			do {
				l++;
			} while (this.comparator.compare(pivotValue, list.get(l)) > 0 && l < rightIndex);
			do {
				r--;
			} while (this.comparator.compare(pivotValue, list.get(r)) < 0 && r > leftIndex);

			// pointers have met each other
			if (r <= l) {
				swapElementsAt(l, rightIndex); // move pivot-element between smaller and bigger elements
				return l;
			}

			swapElementsAt(l, r);
		}

	}

	/**
	 * Swaps elements at the given two indices of the instance variable 'list'.
	 *
	 * @param firstIndex  index of the first to-be-swapped element
	 * @param secondIndex index of the second to-be-swapped element
	 */
	private void swapElementsAt(int firstIndex, int secondIndex) {

		Collections.swap(this.list, firstIndex, secondIndex);
	}

	/**
	 * returns the list assigned to the instance variable 'list'
	 *
	 * @return list assigned to instance variable
	 */
	public List<T> getList() {

		return this.list;
	}

}
