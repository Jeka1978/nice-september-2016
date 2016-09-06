package java8;

/**
 * Created by Jeka on 06/09/2016.
 */
@FunctionalInterface
public interface Algorithm<T> {
    void doSomething(T t);
}
