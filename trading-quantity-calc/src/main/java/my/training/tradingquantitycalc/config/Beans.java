package my.training.tradingquantitycalc.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Beans {

	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@LoadBalanced
	@Bean
	public WebClient  getWebClient() {
		
		/*
		 * HttpClient httpClient = HttpClient.create()
		 * .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
		 * .responseTimeout(Duration.ofMillis(5000)) .doOnConnected(conn ->
		 * conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
		 * .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));
		 */
		
		WebClient client = WebClient.builder()
				 // .baseUrl("http://localhost:8080")
				  .defaultCookie("cookieKey", "cookieValue")
				  .defaultHeader(org.springframework.http.HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
				 // .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))
				  //.clientConnector(new ReactorClientHttpConnector(httpClient))
				  .build();
		return client;
				
		
	}

	
}
