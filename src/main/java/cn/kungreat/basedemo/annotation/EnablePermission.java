package cn.kungreat.basedemo.annotation;

import org.springframework.context.annotation.Import;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({EnableTest.class,EnablePermissionPaakage.class})
public @interface EnablePermission {

    String name() default "";
}
