package classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StringComparatorTest {
    private StringComparator sc = new StringComparator();

    @Test
    public void sameStringTest(){
        assertEquals(0, this.sc.compare("a", "a"));
        assertEquals(0, this.sc.compare("Ab", "Ab"));
        assertEquals(0, this.sc.compare("1A", "1A"));
        assertNotEquals(0, this.sc.compare("1A","A1"));
        assertNotEquals(0, this.sc.compare("a","A"));
    }

    @Test
    public void differentStringTest(){
        assertEquals(1, this.sc.compare("ana","Ana"));
        assertEquals(-1, this.sc.compare("Bab","aba"));
        assertNotEquals(1, this.sc.compare("AA","AA"));
        assertNotEquals(-1, this.sc.compare("AA","AA"));
    }

}
