package mySpring;

/**
 * Created by Jeka on 11/09/2016.
 */
public interface ProxyConfigurer {
    <T> T configureProxy(T t, Class<T> type);
}
