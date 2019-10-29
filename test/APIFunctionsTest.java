import api.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class APIFunctionsTest {
    @Test
    public void testTopKFrequent() {
        List<String> result = StringUtils.topKFrequent("i love... i love coding", 2);
        List<String> expected = Arrays.asList("coding", "love");
        assertTrue(result.containsAll(expected) && result.size() == expected.size());

        result = StringUtils.topKFrequent("coding", 2);
        assertEquals(Arrays.asList("coding"), result);

        result = StringUtils.topKFrequent("", 2);
        assertEquals(Arrays.asList(), result);
    }

    @Test(expected = RuntimeException.class)
    public void testTopKFrequentExceptionNullText() {
        StringUtils.topKFrequent(null, 2);
    }

    @Test(expected = RuntimeException.class)
    public void testTopKFrequentExceptionInvalidK() {
        StringUtils.topKFrequent("i love... i love coding", -1);
    }

}
