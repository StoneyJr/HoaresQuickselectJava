package classes;

import exceptions.DifferentGenericsException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FloydRivestTest {

    @Test
    public void smallestElementUnorderedListTest(){
        FloydRivestQuickselect fr = new FloydRivestQuickselect();

        List<Integer> list = Arrays.asList(2,4,6,3,1,9,7);

        assertEquals(1, fr.select(list, 1));
    }

    @Test
    public void allElementsUnorderedListTest(){
        FloydRivestQuickselect fr = new FloydRivestQuickselect();

        List<Integer> list = Arrays.asList(2,8,4,6,3,1,9,5,7);

        assertEquals(1, fr.select(list, 1));
        assertEquals(2, fr.select(list, 2));
        assertEquals(3, fr.select(list, 3));
        assertEquals(4, fr.select(list, 4));
        assertEquals(5, fr.select(list, 5));
        assertEquals(6, fr.select(list, 6));
        assertEquals(7, fr.select(list, 7));
        assertEquals(8, fr.select(list, 8));
        assertEquals(9, fr.select(list, 9));
    }

    @Test
    public void integerSortedListTest(){
        FloydRivestQuickselect fr = new FloydRivestQuickselect();

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        assertEquals(1, fr.select(list, 1));
        assertEquals(9, fr.select(list, 9));
    }

    @Test
    public void integerReverseSortedTest(){
        FloydRivestQuickselect fr = new FloydRivestQuickselect();

        List<Integer> list = Arrays.asList(9,8,7,6,5,4,3,2,1);

        assertEquals(1, fr.select(list, 1));
        assertEquals(9, fr.select(list, 9));
    }

    @Test
    public void negativeIntegerTest(){
        FloydRivestQuickselect fr = new FloydRivestQuickselect();

        List<Integer> list = Arrays.asList(-2, 5, -1, -10, 3, 2);

        assertEquals(-10, fr.select(list, 1));
        assertEquals(2, fr.select(list, 4));
    }

    @Test
    public void duplicatesTest(){
        FloydRivestQuickselect fr = new FloydRivestQuickselect();

        List<Integer> list = Arrays.asList(1,3,2,2,6,5,1);

        assertEquals(1, fr.select(list, 1));
        assertEquals(1, fr.select(list, 2));
        assertEquals(2, fr.select(list, 3));
        assertEquals(2, fr.select(list, 4));
        assertEquals(3, fr.select(list, 5));
        assertEquals(5, fr.select(list, 6));
        assertEquals(6, fr.select(list, 7));
    }
}
