package java8;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Jeka on 06/09/2016.
 */
public class TaxCalculatorTest {
    @Test
    public void withMaam() throws Exception {
        TaxCalculator taxCalculator = new TaxCalculator();
        MaamSuplier mock = mock(MaamSuplier.class);
        when(mock.getMaam()).thenReturn(0.1);
        System.out.println(mock.getClass());
        taxCalculator.setMaamSuplier(mock);
        Assert.assertEquals(110,taxCalculator.withMaam(100),0.001);

    }

}



