package mySpring;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by Jeka on 11/09/2016.
 */
public class BencmarkProxyConfigurer implements ProxyConfigurer {
    @Override
    public <T> T configureProxy(final T t,Class<T> type) {

        boolean benchmarkMethodExists = Arrays.stream(type.getMethods()).anyMatch(m -> m.isAnnotationPresent(Benchmark.class));

        if (type.isAnnotationPresent(Benchmark.class)||benchmarkMethodExists) {
            if (type.getInterfaces().length == 0) {
                return (T) Enhancer.create(type, new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                        return  invokeOfIH(t,type, method, args);
                    }
                });
            }
            return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), (proxy, method, args) -> invokeOfIH(t, type, method, args));
        }
        return t;
    }

    private <T> Object invokeOfIH(T t, Class<T> type, Method method, Object[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method classMethod = type.getMethod(method.getName(), method.getParameterTypes());
        if (classMethod.isAnnotationPresent(Benchmark.class)||type.isAnnotationPresent(Benchmark.class)) {
            System.out.println("*************BENCHMARK START*********");
            long start = System.nanoTime();
            Object retVal = method.invoke(t, args);
            long end = System.nanoTime();
            System.out.println("method "+method.getName()+" was working for "+(end-start));
            System.out.println("*************BENCHMARK END*********");
            return retVal;
        }else {
            return method.invoke(t, args);
        }
    }
}
