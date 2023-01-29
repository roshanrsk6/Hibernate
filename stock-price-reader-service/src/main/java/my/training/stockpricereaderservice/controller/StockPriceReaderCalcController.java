package my.training.stockpricereaderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import my.training.stockpricereaderservice.model.Stock;

@RestController
@RequestMapping("/stockprice")
public class StockPriceReaderCalcController {

	@Autowired
	WebClient.Builder webClientBuilder;
	

	

	@RequestMapping("/{stockName}")
	public Stock getStockPrice(@PathVariable("stockName") String stockName) {
		Stock stock=new Stock();
		stock.setLtp(120);
		stock.setStockName(stockName);
		return stock;
		

		
	}

	
}
