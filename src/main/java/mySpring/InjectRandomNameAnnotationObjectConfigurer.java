package mySpring;

import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Jeka on 08/09/2016.
 */
public class InjectRandomNameAnnotationObjectConfigurer implements ObjectConfigurer {

    private DataFactory dataFactory = new DataFactory();
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> type = t.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomName.class)) {
                InjectRandomName annotation = field.getAnnotation(InjectRandomName.class);
                String value = dataFactory.getName();
                field.setAccessible(true);
                field.set(t,value);
            }
        }
    }
}
