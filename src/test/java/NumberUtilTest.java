import org.junit.jupiter.api.Test;

import static io.github.duckysmacky.utilimate.math.NumberUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberUtilTest {

    @Test
    public void maxTest() {
        assertEquals(max(1, 5, 10).intValue(), 10);
    }

    @Test
    public void minTest() {
        assertEquals(min(1, 5, 10).intValue(), 1);
    }
}
