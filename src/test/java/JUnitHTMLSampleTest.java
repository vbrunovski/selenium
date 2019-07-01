import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JUnitHTMLSampleTest extends JUnitHTMLReporter {

    @Test
    public void htmlsampleTest0() {
        assertTrue(1 < 2);
    }

    @Test
    public void htmlsampleTest1() {
        assertTrue(1 > 2);
    }

    @Test
    public void htmlsampleTest2() {
        assertTrue(1 < 2);
    }

    @Test
    public void htmlsampleTest4() {
        assertTrue(1 > 2);
    }
}