package my.training.tradingquantitycalc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import my.training.tradingquantitycalc.model.Database;
import my.training.tradingquantitycalc.model.Stock;
import my.training.tradingquantitycalc.orchestration.ApiCallStockPriceRead;

@RestController
@RequestMapping("/stockqntycalc")
@RefreshScope
public class StockQntyCalcController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	WebClient webClient;
	
	@Autowired
	ApiCallStockPriceRead apiCallStockPriceRead;
	
	
	
	@Value("${stock.value:199}")
	private String defValue;
	
	@Value("${my.values}")
	private List<String> myVlaues;
	
	@Autowired
	private Database database;
	
	
	@Autowired
	Environment env;

	@RequestMapping("/{stockName}")
	public int getStockQnty(@PathVariable("stockName") String stockName) {
		
		
		//Stock stock1= restTemplate.getForObject("http://stock-price-service/stockprice/"+ stockName, Stock.class);
		
		Stock stock= apiCallStockPriceRead.getStockLtp(stockName);
		System.out.println(database.getUrl());
		
		double profit =stock.getLtp()* .03;
		double qunty = 100.00 / profit;
		int quanty = (int) qunty;
		return quanty;
	}
	
	@GetMapping("/envdetails")
	public  String getenvDet() {
	 return env.toString();

	}

}
