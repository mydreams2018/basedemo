package cn.kungreat.basedemo.annotation;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnTestConditional.class)
public @interface ConditionalOnTest {

    String type() default "";

    String beaname() default "";
}
