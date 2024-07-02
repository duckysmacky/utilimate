import org.junit.jupiter.api.Test;

import static io.github.duckysmacky.utilimate.math.NumberUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberUtilsTest {

    @Test
    public void maxTest() {
        assertEquals(10, max(1, 5, 10).intValue());
    }

    @Test
    public void minTest() {
        assertEquals(1, min(1, 5, 10).intValue());
    }
}
