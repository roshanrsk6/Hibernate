package my.training.stockpricereaderservice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class Beans {

	
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
				  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
				 // .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))
				  //.clientConnector(new ReactorClientHttpConnector(httpClient))
				  .build();
		return client;
		
	}
}
