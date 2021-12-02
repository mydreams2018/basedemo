package cn.kungreat.init;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
/*
* 开始spring 初始化事件
*/
public class MyInit implements ApplicationContextInitializer<ConfigurableApplicationContext> , Ordered {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("initialize");
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
