package java8;

import lombok.Setter;

/**
 * Created by Jeka on 06/09/2016.
 */
@Setter
public class TaxCalculator {
    private MaamSuplier maamSuplier;

    public double withMaam(double price) {
        return price * maamSuplier.getMaam()+price;
    }


}
