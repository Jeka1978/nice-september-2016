package mySpring;

/**
 * Created by Jeka on 08/09/2016.
 */
public interface Config {
    <T> Class<T> getImpl(Class<T> type);
}
