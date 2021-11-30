package cn.kungreat.basedemo.annotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

public class EnablePermissionPaakage implements ImportSelector {

    //返回需要扫描的类名称
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"cn.kungreat.pg.AnnoTestBeanPackage"};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return null;
    }
}
