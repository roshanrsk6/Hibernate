package my.training.tradingquantitycalc.model;


public class Stock {

	
	private String stockName;
	
	private int ltp;

	public Stock(String stockName, int ltp) {
		super();
		this.stockName = stockName;
		this.ltp = ltp;
	}

	public Stock() {
	
	}

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
