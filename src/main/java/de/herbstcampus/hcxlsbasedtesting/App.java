package de.herbstcampus.hcxlsbasedtesting;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Hello world!
 *
 */
public class App 
{
    public Double multiply(Double in1, Double in2) {
        return new BigDecimal( in1*in2 ).setScale(0, RoundingMode.UP).doubleValue();
    }
}
