package mySpring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Jeka on 08/09/2016.
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfigImpl();
    private Reflections scanner = new Reflections();
    private List<ObjectConfigurer> objectConfigurers = new ArrayList<>();
    private List<ProxyConfigurer> proxyConfigurers = new ArrayList<>();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurer>> classes = scanner.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> c : classes) {
            objectConfigurers.add(c.newInstance());
        }
        Set<Class<? extends ProxyConfigurer>> set = scanner.getSubTypesOf(ProxyConfigurer.class);
        for (Class<? extends ProxyConfigurer> aClass : set) {
            proxyConfigurers.add(aClass.newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        type = resolveImpl(type);
        T t = type.newInstance();
        configure(t);
        invokeInitMethods(type, t);
        t = configureProxyIfNeed(type, t);
        return t;

    }






    private <T> T configureProxyIfNeed(Class<T> type, T t) {
        for (ProxyConfigurer proxyConfigurer : proxyConfigurers) {
            t = proxyConfigurer.configureProxy(t,type);
        }
        return t;
    }

    private <T> void invokeInitMethods(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }


    private <T> void configure(T t) {
        objectConfigurers.forEach(configurer->configurer.configure(t));
    }


    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            Class<T> impl = config.getImpl(type);
            if (impl == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new RuntimeException("you have zero or more than one impl of " + type + " please bind needed impl your config");
                }
                type = (Class<T>) classes.iterator().next();
            }else {
                type = impl;
            }
        }
        return type;
    }


}
