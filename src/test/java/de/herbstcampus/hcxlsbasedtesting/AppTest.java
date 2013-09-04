package de.herbstcampus.hcxlsbasedtesting;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
    @Test
    public void testMultiply() {
        Double actual = new App().multiply(2.0, 2.0);
        
        Assert.assertEquals(new Double(4.0), actual);
    }
    
}
