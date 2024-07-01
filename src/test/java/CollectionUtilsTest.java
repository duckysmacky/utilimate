import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.duckysmacky.utilimate.collections.CollectionUtils.*;
import static org.junit.jupiter.api.Assertions.*;

public class CollectionUtilsTest {
    private static List<Integer> numberList;
    private static List<Boolean> booleanMixedList;
    private static List<Boolean> booleanAllList;
    private static List<Boolean> booleanNoneList;
    private static List<Integer> booleanNumbersList;

    @BeforeAll
    public static void initialize() {
        numberList = Arrays.asList(-1, 5, -56, 5, 263, 163, -3, 7, 5, -1);
        booleanMixedList = Arrays.asList(true, false, false, true, true, false);
        booleanAllList = Arrays.asList(true, true, true, true, true, true);
        booleanNoneList = Arrays.asList(false, false, false, false, false, false);
        booleanNumbersList = Arrays.asList(1, 0, 0, 1, 1, 0);
    }

    @Test
    public void maxTest() {
        assertEquals(max(numberList).intValue(), 263);
    }

    @Test
    public void minTest() {
        assertEquals(min(numberList).intValue(), -56);
    }

    @Test
    public void sumTest() {
        assertEquals(sum(numberList).intValue(), 387);
    }

    @Test
    public void allTest() {
        // True
        assertTrue(all(booleanAllList));

        // False
        assertFalse(all(booleanMixedList));
        assertFalse(all(booleanNoneList));
        assertFalse(all(booleanNumbersList));
    }

    @Test
    public void anyTest() {
        // True
        assertTrue(any(booleanAllList));
        assertTrue(any(booleanMixedList));
        assertTrue(any(booleanNumbersList));

        // False
        assertFalse(any(booleanNoneList));
    }
}
