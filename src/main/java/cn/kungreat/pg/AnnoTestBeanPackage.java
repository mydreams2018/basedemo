package cn.kungreat.pg;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoTestBeanPackage {

    private String sayPg="-Package";

    public String getSayPg() {
        return sayPg;
    }

    public void setSayPg(String sayPg) {
        this.sayPg = sayPg;
    }
}
