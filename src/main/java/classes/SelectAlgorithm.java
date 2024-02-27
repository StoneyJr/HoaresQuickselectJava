package classes;

import java.util.List;

/**
 * Interface for Select Algorithm. It provides a method header for select. This
 * method need two parameters. A list with elements of type T and an int
 * representing the k-th element to be searched.
 *
 * @param <T> generic type of elements inside the given list.
 */
public interface SelectAlgorithm<T> {

	T select(List<T> list, int k);
}
