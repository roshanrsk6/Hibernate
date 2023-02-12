package my.training.stockpricereaderservice.model;

import java.io.Serializable;

public class Stock implements Serializable{

	
	private String stockName;
	
	private int ltp;

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getLtp() {
		return ltp;
	}

	public void setLtp(int ltp) {
		this.ltp = ltp;
	}
	
	
}
