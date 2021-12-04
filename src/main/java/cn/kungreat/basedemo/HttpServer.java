package cn.kungreat.basedemo;

import cn.kungreat.pg.AnnoTestBeanPackage;
import cn.kungreat.pg.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpServer {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    private AnnoTestBean annoTestBean;
    @Autowired
    private AnnoTestBeanPackage annoTestBeanPackage;
    @Autowired
    private ConditionTestBean conditionTestBean;

    @RequestMapping(value = "/base")
    public String hello(){
        //在事件监听那可以获得到事件通知
        applicationEventPublisher.publishEvent(new MyEvent("自已的事件"));
        return annoTestBean.getSay()+annoTestBeanPackage.getSayPg()+conditionTestBean.getSayCondition();
    }
}
