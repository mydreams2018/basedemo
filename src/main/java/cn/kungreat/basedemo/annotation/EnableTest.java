package cn.kungreat.basedemo.annotation;

import cn.kungreat.basedemo.AnnoTestBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.annotation.Annotation;
import java.util.Iterator;


public class EnableTest implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //封装过的方式  注解并不直接存在此类上 AnnotationMetadata
        String beanName = null;
        MergedAnnotations annotations = importingClassMetadata.getAnnotations();
        Iterator<MergedAnnotation<Annotation>> iterator = annotations.iterator();
        while(iterator.hasNext()){
            MergedAnnotation<Annotation> next = iterator.next();
            if(next.getType().equals(EnablePermission.class)){
                beanName = next.getString("name");
            }
        }

        if (registry.containsBeanDefinition("BEANTSTS")) {
            BeanDefinition beanDefinition = registry.getBeanDefinition("BEANTSTS");
        }
        if(beanName != null){
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(AnnoTestBean.class);
            //设置方式依靠 get set
            builder.addPropertyValue("say", "hello-enable");
            registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
        }


     /*   原始反射获取注解值
        Annotation[] annotations = BasedemoApplication.class.getDeclaredAnnotations();
        for(int x=0;x<annotations.length;x++){
            if(annotations[x] instanceof  EnablePermission){
                EnablePermission enablePermission =(EnablePermission) annotations[x];
                System.out.println(enablePermission.name());
            }
        }*/

    }
}
