package my.training.tradingquantitycalc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import my.training.tradingquantitycalc.model.Stock;
import my.training.tradingquantitycalc.orchestration.ApiCallStockPriceRead;

@RestController
@RequestMapping("/stockqntycalc")
public class StockQntyCalcController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	WebClient webClient;
	
	@Autowired
	ApiCallStockPriceRead apiCallStockPriceRead;

	@RequestMapping("/{stockName}")
	public int getStockQnty(@PathVariable("stockName") String stockName) {
		
		
		//Stock stock1= restTemplate.getForObject("http://stock-price-service/stockprice/"+ stockName, Stock.class);
		
		Stock stock= apiCallStockPriceRead.getStockLtp(stockName);
		
		
		double profit =stock.getLtp()* .03;
		double qunty = 100.00 / profit;
		int quanty = (int) qunty;
		return quanty;
	}

}
