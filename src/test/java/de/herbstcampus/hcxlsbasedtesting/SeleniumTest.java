/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.herbstcampus.hcxlsbasedtesting;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Matthias
 */
public class SeleniumTest {

    @Test
    public void testCase1() throws InterruptedException {

        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/HCWebApp/faces/index.xhtml");

        final Double input1 = 5.0;
        final Double input2 = 2.0;
        Double expected = 10.0;

        driver.findElement(By.id("in1")).sendKeys(String.valueOf(input1));
        driver.findElement(By.id("in2")).sendKeys(String.valueOf(input2));
        driver.findElement(By.id("buttonCalc")).click();


        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return (d.findElement(By.id("resultGroup")).getText().trim().length() > 5);
            }
        });

        Double actual = Double.valueOf(driver.findElement(By.id("result")).getText());
        Assert.assertEquals(expected, actual);
    }
}
