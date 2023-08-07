package org.example.annotations;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD,ElementType.TYPE})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface DBField {
    String name();
}
