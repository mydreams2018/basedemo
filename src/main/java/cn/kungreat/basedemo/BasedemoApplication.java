package cn.kungreat.basedemo;

import cn.kungreat.basedemo.annotation.EnablePermission;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@MapperScan(basePackages = "cn.kungreat.basedemo.mapper")
@EnablePermission(name = "kungreat")
public class BasedemoApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(BasedemoApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
		System.out.println("main-finish");
	}

	@Bean
	public ApplicationRunner runner(WebServerApplicationContext wb){
		System.out.println(wb.getWebServer());
		//spring 启动之后回调
		return new ApplicationRunner() {
			@Override
			public void run(ApplicationArguments args) throws Exception {
				System.out.println("run-finish");
			}
		};
	}

	@EventListener(WebServerInitializedEvent.class)
	public void onWebServerRead(WebServerInitializedEvent webServerInitializedEvent){
		System.out.println(webServerInitializedEvent.getWebServer());
	}

}
