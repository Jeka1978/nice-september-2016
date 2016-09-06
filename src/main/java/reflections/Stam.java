package reflections;

/**
 * Created by Jeka on 06/09/2016.
 */
public class Stam {

    @RunThisMethod
    public void doWork() {
        System.out.println("work");
    }

    @RunThisMethod(3)
    public void drinkBeer() {
        System.out.println("Leff is the best");
    }
}
