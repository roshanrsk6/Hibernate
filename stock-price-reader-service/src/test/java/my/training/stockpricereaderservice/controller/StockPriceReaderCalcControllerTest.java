package my.training.stockpricereaderservice.controller;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;

import my.training.stockpricereaderservice.model.Stock;

@TestInstance(Lifecycle.PER_CLASS)
class StockPriceReaderCalcControllerTest {
	
	StockPriceReaderCalcController calcController=null;
	TestInfo testInfo=null;
	TestReporter testReporter=null;
	
	@BeforeAll
	static void  beforeAll() {
		
		
	}
	
	@BeforeEach
	void init(TestInfo testInfo,TestReporter testReporter) {
		calcController=new StockPriceReaderCalcController();
		this.testInfo=testInfo;
		this.testReporter=testReporter;
		testReporter.publishEntry(testInfo.getDisplayName()+"/"+testInfo.getTestClass()+"."+testInfo.getTestMethod());
		
		
	}
	@AfterEach
	 void cleanup() {
		 System.out.println("clean up....");
		 
	 }
	
	@Test
	@DisplayName("testing stock price")
	@Tag("stock")
	void test() {
		
		Stock stock= calcController.getStockPrice("test");
		assertEquals(stock.getLtp(), 120,"worng ltip");
		
	}
	
	@Test
	@DisplayName("testing Division")
	@Tag("math")
	void testDividsion() {
		
		
		assertAll(
				()->assertEquals(120, 240/2),
				()->assertEquals(124, 120+4),
				()->assertEquals(120, 124-4)
				
				);
		
		
	
		
		//assertThrows(ArithmeticException.class,()->calcController.divide(1, 0));
		
	}
	
	@Nested
	@Tag("math")
	 class Testdivision {
			
		@Test
		@DisplayName("Testing the positive vlue here")
		void testdivionPositive() {
			assertEquals(120, 240/2,()->"dicion resuklt is wring");
		}
		
		@Test
		@DisplayName("Testing the negraitve vlue here")
		void testdivionNegetive() {
			assertEquals(-120, -240/2,"division resuklt is wring");
			
		}
		
			
	}
		
	

}
