package reflections;

import lombok.SneakyThrows;

import java.lang.reflect.Method;

/**
 * Created by Jeka on 06/09/2016.
 */
public class ObjectCreator {
    @SneakyThrows
    public static <T> T create(Class<T> type) {
        T t = type.newInstance();

        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(RunThisMethod.class)) {
                RunThisMethod annotation = method.getAnnotation(RunThisMethod.class);
                int value = annotation.value();
                for (int i = 0; i < value; i++) {
                    method.invoke(t);
                }
            }
        }

        return t;
    }
}
