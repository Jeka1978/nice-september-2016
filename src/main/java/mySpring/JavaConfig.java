package mySpring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeka on 08/09/2016.
 */
public abstract class JavaConfig implements Config {
    private Map<Class, Class> map = new HashMap<>();

    public JavaConfig() {
        configure();
    }

    protected abstract void configure();

    protected void addBinding(Class ifc, Class c) {
        map.put(ifc, c);
    }

    @Override
    public <T> Class<T> getImpl(Class<T> type) {

        return map.get(type);
    }
}
