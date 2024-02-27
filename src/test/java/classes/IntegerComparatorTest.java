package classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class IntegerComparatorTest {

	private IntegerComparator ic = new IntegerComparator();

	@Test
	public void sameIntegerTest() {
		assertEquals(0, ic.compare(1, 1));
		assertEquals(0, ic.compare(0, 0));
		assertEquals(0, ic.compare(-1, -1));
		assertNotEquals(0, ic.compare(1, 2));
		assertNotEquals(0, ic.compare(2, 1));
	}

	@Test
	public void differentIntegerTest() {
		assertEquals(1, ic.compare(2, 1));
		assertEquals(-1, ic.compare(1, 2));
		assertNotEquals(1, ic.compare(1, 1));
		assertNotEquals(-1, ic.compare(1, 1));
	}

	@Test
	public void negativeIntegerTest() {
		assertEquals(-1, ic.compare(-1, 2));
		assertEquals(-1, ic.compare(-1, 1));
		assertEquals(1, ic.compare(1, -1));
	}
}
