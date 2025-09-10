package net.letscode.nau.annoted;

import java.lang.annotation.*;

/**
 * Methods annotated with @DoNotUse are not intended for regular invocation and should be avoided in typical usage scenarios.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PACKAGE})
public @interface DoNotUse {
    String reason() default "Methods annotated with @DoNotUse are not intended for regular invocation and should be avoided in typical usage scenarios"; // You can provide a reason why this should not be used
    boolean forRemoval() default false;
}
