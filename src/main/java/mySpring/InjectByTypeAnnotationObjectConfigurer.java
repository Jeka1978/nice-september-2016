package mySpring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Jeka on 11/09/2016.
 */
public class InjectByTypeAnnotationObjectConfigurer implements ObjectConfigurer {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                Object object = ObjectFactory.getInstance().createObject(field.getType());
                field.setAccessible(true);
                field.set(t, object);
            }
        }
        Method[] methods = t.getClass().getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(InjectByType.class) && method.getName().startsWith("set")) {
                Class<?> type = method.getParameterTypes()[0];
                Object object = ObjectFactory.getInstance().createObject(type);
                method.invoke(t, object);
            }
        }
    }
}




