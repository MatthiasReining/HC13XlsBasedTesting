/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.herbstcampus.hcxlsbasedtesting;

import com.jexunit.core.GevoTestCase;
import com.jexunit.core.GevoTester;
import com.jexunit.core.commands.TestCommand;
import com.jexunit.core.junit.Parameterized;
import org.junit.Assert;
import org.junit.runner.RunWith;

/**
 *
 * @author Matthias
 */
@RunWith(GevoTester.class)
public class JexAppTest {
    
    @Parameterized.ExcelFile
    static String excelFile = "src/test/resources/jexunit-testcases.xlsx";
    
    @TestCommand(value="MULTI")
    public static void runMultiCommand(GevoTestCase testCase, TestInputData data) {
        
        double actual = new App().multiply(  data.getParam1(), data.getParam2());
        Assert.assertEquals(data.getResult(), actual, 0.0);
        
    }
    
    @TestCommand(value="COMPLEX")
    public static void runComplexCommand(GevoTestCase testCase, TestInputData data) {
        
        double actual = new App().complex(data.getParam1(), data.getParam2(), data.getParam3());
        Assert.assertEquals(data.getResult(), actual, 0.0);
        
    }
    
}
