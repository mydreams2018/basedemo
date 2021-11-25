package cn.kungreat.basedemo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class BasedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasedemoApplication.class, args);
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
