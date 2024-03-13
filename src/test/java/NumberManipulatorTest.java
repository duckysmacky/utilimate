import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static io.github.duckysmacky.NumberManipulator.*;
import static junit.framework.TestCase.assertEquals;

public class NumberManipulatorTest {
    static List<Integer> numbers;
    static List<Boolean> boolsMixed;
    static List<Boolean> boolsAll;
    static List<Boolean> boolsNone;
    static List<Integer> boolsNumbers;

    @Before
    public void setDefaults() {
        numbers = Arrays.asList(-1, 5, -56, 5, 263, 163 , -3, 7, 5, -1);
        boolsMixed = Arrays.asList(true, false, false, true, true, false);
        boolsAll = Arrays.asList(true, true, true, true, true, true);
        boolsNone = Arrays.asList(false, false, false, false, false, false);
        boolsNumbers = Arrays.asList(1, 0, 0, 1, 1, 0);
    }

    @Test
    public void maxTest() {
        assertEquals(max(numbers), 263f);
        assertEquals(max(10, 3), 10f);
    }

    @Test
    public void minTest() {
        assertEquals(min(numbers), -56f);
        assertEquals(min(10, 3), 3f);
    }

    @Test
    public void sumTest() {
        assertEquals(sum(numbers), 387f);
        assertEquals(sum(10, 3), 13f);
    }

    @Test
    public void allTest() {
        assertEquals(all(boolsAll), true);
        assertEquals(all(boolsMixed), false);
        assertEquals(all(boolsNone), false);
        assertEquals(all(boolsNumbers), false);
    }

    @Test
    public void anyTest() {
        assertEquals(all(boolsAll), true);
        assertEquals(all(boolsMixed), true);
        assertEquals(all(boolsNone), false);
        assertEquals(all(boolsNumbers), true);
    }
}