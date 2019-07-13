package cn.com.objcet.api.service.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
//	public static final String AUTH = "mldn:java" ; // 认证信息
//	@Bean
//	public HttpHeaders getHeaders() {	// 进行头部信息定义
//		HttpHeaders headers = new HttpHeaders() ;	// 定义头部信息
//		// 对给出的认证信息进行Base64的编码处理操作
//		byte[] encodingAuth = Base64.getEncoder().encode(AUTH.getBytes(Charset.forName("US-ASCII")));
//		String authHeader = "Basic " + new String(encodingAuth) ; // 认证头信息
//		headers.set("Authorization", authHeader); // 追加认证头信息
//		return headers ; 
//	}
	
	@Bean 
	public RestTemplate getRestTemplate() {
		return new RestTemplate() ;
	}
}
