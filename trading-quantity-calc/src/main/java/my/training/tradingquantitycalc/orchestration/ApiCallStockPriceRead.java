package my.training.tradingquantitycalc.orchestration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import my.training.tradingquantitycalc.model.Stock;
import reactor.core.publisher.Mono;

@Service
public class ApiCallStockPriceRead {
	
	@Autowired
	WebClient webClient;
	
	
	@HystrixCommand(fallbackMethod = "getFallbackgetStockLtp",
			commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "500"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "100000")
			}
			)

	public Stock getStockLtp(String stckName) {
		
		Mono<Stock> mono=	 webClient.get().uri("http://stock-price-service/stockprice/"+ stckName)
				.retrieve()
				.bodyToMono(Stock.class);
				
		mono.subscribe();		
			    
		return new Stock("stock readr call success", 103);
	}

	public Stock getFallbackgetStockLtp(String stckName) {
		return new Stock("cb fail default", 12);
		
	}
	
}
