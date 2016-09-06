package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Jeka on 06/09/2016.
 */
public class ListUtil {
    public static <T> void forEachWithDelay(int delay, List<T> list, Consumer<T> consumer) throws InterruptedException {
        for (T t1 : list) {
            consumer.accept(t1);
            Thread.sleep(delay);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        List<String> strings = Arrays.asList("java", "scala", "groovy", "c#");
        ListUtil.forEachWithDelay(1500,strings,o -> System.out.println(o));
    }











}
