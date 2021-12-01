package cn.kungreat.basedemo;

import cn.kungreat.basedemo.annotation.ConditionalOnTest;
import org.springframework.context.annotation.Configuration;


@Configuration(proxyBeanMethods = false,value = "conditionTestBean")
@ConditionalOnTest(type = "prod",beaname="conditionTestBean")
public class ConditionTestBean {

    private String sayCondition="-condition";

    public String getSayCondition() {
        return sayCondition;
    }

    public void setSayCondition(String sayCondition) {
        this.sayCondition = sayCondition;
    }
}
