import org.junit.Test;
import java.util.*;

import static io.github.duckysmacky.NumberManipulator.*;
import static junit.framework.TestCase.assertEquals;

public class NumberManipulatorTest {
    final List<Integer> NUMBERS = Arrays.asList(-1, 5, -56, 5, 263, 163 , -3, 7, 5, -1);
    final List<Boolean> BOOLS_MIXED = Arrays.asList(true, false, false, true, true, false);
    final List<Boolean> BOOLS_ALL = Arrays.asList(true, true, true, true, true, true);
    final List<Boolean> BOOLS_NONE = Arrays.asList(false, false, false, false, false, false);
    final List<Integer> BOOLS_NUMBERS = Arrays.asList(1, 0, 0, 1, 1, 0);

    @Test
    public void maxTest() {
        assertEquals(max(NUMBERS), 263f);
        assertEquals(max(10, 3), 10f);
    }

    @Test
    public void minTest() {
        assertEquals(min(NUMBERS), -56f);
        assertEquals(min(10, 3), 3f);
    }

    @Test
    public void sumTest() {
        assertEquals(sum(NUMBERS), 387f);
        assertEquals(sum(10, 3), 13f);
    }

    @Test
    public void allTest() {
        assertEquals(all(BOOLS_ALL), true);
        assertEquals(all(BOOLS_MIXED), false);
        assertEquals(all(BOOLS_NONE), false);
        assertEquals(all(BOOLS_NUMBERS), false);
    }

    @Test
    public void anyTest() {
        assertEquals(all(BOOLS_ALL), true);
        assertEquals(all(BOOLS_MIXED), true);
        assertEquals(all(BOOLS_NONE), false);
        assertEquals(all(BOOLS_NUMBERS), true);
    }
}