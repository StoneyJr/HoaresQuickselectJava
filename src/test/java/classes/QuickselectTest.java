package classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import exceptions.DifferentGenericsException;

public class QuickselectTest {

	@Test
	public void smallestElementUnorderedListTest() {
		Quickselect<Integer> qs = new Quickselect<>(new IntegerComparator());

		List<Integer> list = Arrays.asList(2, 4, 6, 3, 1, 9, 7);

		assertEquals(1, qs.select(list, 1));
	}

	@Test
	public void allElementsUnorderedListTest() {
		Quickselect<Integer> qs = new Quickselect<>(new IntegerComparator());

		List<Integer> list = Arrays.asList(2, 8, 4, 6, 3, 1, 9, 5, 7);

		assertEquals(1, qs.select(list, 1));
		assertEquals(2, qs.select(list, 2));
		assertEquals(3, qs.select(list, 3));
		assertEquals(4, qs.select(list, 4));
		assertEquals(5, qs.select(list, 5));
		assertEquals(6, qs.select(list, 6));
		assertEquals(7, qs.select(list, 7));
		assertEquals(8, qs.select(list, 8));
		assertEquals(9, qs.select(list, 9));
	}

	@Test
	public void stringUnorderedListTest() {
		Quickselect<String> qs = new Quickselect<>(new StringComparator());

		List<String> list = Arrays.asList("ab", "ba", "CD", "AA");

		assertEquals("AA", qs.select(list, 1));
		assertEquals("CD", qs.select(list, 2));
		assertEquals("ab", qs.select(list, 3));
		assertEquals("ba", qs.select(list, 4));
	}

	@Test
	public void integerSortedListTest() {
		Quickselect<Integer> qs = new Quickselect<>(new IntegerComparator());

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		assertEquals(1, qs.select(list, 1));
		assertEquals(9, qs.select(list, 9));
	}

	@Test
	public void integerReverseSortedTest() {
		Quickselect<Integer> qs = new Quickselect<>(new IntegerComparator());

		List<Integer> list = Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1);

		assertEquals(1, qs.select(list, 1));
		assertEquals(9, qs.select(list, 9));
	}

	@Test
	public void negativeIntegerTest() {
		Quickselect<Integer> qs = new Quickselect<>(new IntegerComparator());

		List<Integer> list = Arrays.asList(-2, 5, -1, -10, 3, 2);

		assertEquals(-10, qs.select(list, 1));
		assertEquals(2, qs.select(list, 4));
	}

	@Test
	public void duplicatesTest() {
		Quickselect<Integer> qs = new Quickselect<>(new IntegerComparator());

		List<Integer> list = Arrays.asList(1, 3, 2, 2, 6, 5, 1);

		assertEquals(1, qs.select(list, 1));
		assertEquals(1, qs.select(list, 2));
		assertEquals(2, qs.select(list, 3));
		assertEquals(2, qs.select(list, 4));
		assertEquals(3, qs.select(list, 5));
		assertEquals(5, qs.select(list, 6));
		assertEquals(6, qs.select(list, 7));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" }) // for testing different types for list and Quickselect
	@Test
	public void differentTypesTest() {
		Quickselect qs = new Quickselect<>(new StringComparator());

		List<Integer> list = Arrays.asList(-2, 5, -1, -10, 3, 2);

		assertThrows(DifferentGenericsException.class, () -> qs.select(list, 1));
	}

	@Test
	public void illegalParameterKTest() {
		Quickselect<Integer> qs = new Quickselect<>(new IntegerComparator());

		List<Integer> list = Arrays.asList(-2, 5, -1, -10, 3, 2);

		assertThrows(IllegalArgumentException.class, () -> qs.select(list, 0));
		assertThrows(IllegalArgumentException.class, () -> qs.select(list, -1));
		assertThrows(IllegalArgumentException.class, () -> qs.select(list, 10));
	}
}
