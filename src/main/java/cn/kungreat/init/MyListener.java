package cn.kungreat.init;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

public class MyListener implements ApplicationListener<ApplicationEvent> , Ordered {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("event:"+event.getClass());
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
