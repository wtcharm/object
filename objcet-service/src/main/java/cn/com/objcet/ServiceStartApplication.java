package cn.com.objcet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * 服务端访问
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class ServiceStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceStartApplication.class, args); 
	}
}
