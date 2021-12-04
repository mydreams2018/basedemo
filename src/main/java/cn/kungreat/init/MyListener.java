package cn.kungreat.init;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

public class MyListener implements ApplicationListener<ApplicationEvent> , Ordered {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        //事件触发.可根据自已的业务完成 事件通知处理.
        System.out.println("event:"+event);
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
