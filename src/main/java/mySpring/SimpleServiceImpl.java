package mySpring;

import lombok.SneakyThrows;

/**
 * Created by Jeka on 11/09/2016.
 */
public class SimpleServiceImpl implements SimpleService {
    @Override
    @Benchmark
    public void a() {
        System.out.println("Aaaaa");
    }

    @Override
    @SneakyThrows
    @Benchmark
    public void b() {
        Thread.sleep(1000);
        System.out.println("Bbbbbbbb");
    }

    @Override
    public void c() {
        System.out.println("ccccccccccc");
    }
}
