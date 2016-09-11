package mySpring;

/**
 * Created by Jeka on 11/09/2016.
 */
public class BenchmarkPowerCleaner implements Cleaner {
    @InjectByType
    private PowerCleaner cleaner;

    @Override
    public void clean() {
        long before = System.nanoTime();
        cleaner.clean();
        long after = System.nanoTime();
        System.out.println(after-before);
    }
}
