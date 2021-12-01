package cn.kungreat.basedemo.annotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;


@Order(Ordered.HIGHEST_PRECEDENCE)
public class OnTestConditional implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try {
            MergedAnnotations annotations = metadata.getAnnotations();
            MergedAnnotation<ConditionalOnTest> conditionalOnTestMergedAnnotation = annotations.get(ConditionalOnTest.class);
            String beaname = conditionalOnTestMergedAnnotation.getString("beaname");
            //可能会进来多次 只有不存在时才去处理  多次也不影响会自动的处理只注入一个对象
            boolean exist = context.getBeanFactory().containsBean(beaname);
            if(!exist){
                Environment environment = context.getEnvironment();
                String property = environment.getProperty("mytest.type");
                String type = conditionalOnTestMergedAnnotation.getString("type");
                System.out.println(property+":"+type);
                //条件处理
                return type.equals(property);
            }
        } catch (Exception ex) {
            throw new IllegalStateException("Error processing condition on " + ex.getMessage());
        }
        return false;
    }
}
