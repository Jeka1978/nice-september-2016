package eli;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Jeka on 06/09/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Calls {
    Call[] value();
}
