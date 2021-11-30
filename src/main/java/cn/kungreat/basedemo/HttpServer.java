package cn.kungreat.basedemo;

import cn.kungreat.pg.AnnoTestBeanPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpServer {

    @Autowired
    private AnnoTestBean annoTestBean;
    @Autowired
    private AnnoTestBeanPackage annoTestBeanPackage;

    @RequestMapping(value = "/base")
    public String hello(){
         return annoTestBean.getSay()+annoTestBeanPackage.getSayPg();
    }
}
