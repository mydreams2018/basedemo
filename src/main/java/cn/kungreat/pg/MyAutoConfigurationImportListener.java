package cn.kungreat.pg;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfigurationImportEvent;
import org.springframework.boot.autoconfigure.AutoConfigurationImportListener;
import org.springframework.boot.autoconfigure.condition.ConditionEvaluationReport;

/*
*  抄的 ConditionEvaluationReportAutoConfigurationImportListener  下有很多标准的 spring.factories 演示
*  org.springframework.boot.autoconfigure.EnableAutoConfiguration 的所有类
*  参考实现类
*  org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration
*
*/
public class MyAutoConfigurationImportListener implements AutoConfigurationImportListener,BeanFactoryAware{
    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void onAutoConfigurationImportEvent(AutoConfigurationImportEvent event) {
        if (this.beanFactory != null) {
            ConditionEvaluationReport report = ConditionEvaluationReport.get(this.beanFactory);
            report.recordEvaluationCandidates(event.getCandidateConfigurations());
            report.recordExclusions(event.getExclusions());
        }
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (beanFactory instanceof ConfigurableListableBeanFactory)
                ? (ConfigurableListableBeanFactory) beanFactory : null;
    }
}
