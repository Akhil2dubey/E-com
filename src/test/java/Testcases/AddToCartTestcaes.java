package Testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.AddToCart;

public class AddToCartTestcaes extends BasetestCases {

	AddToCart atc;
	

	@BeforeClass
	public void normalsetup() throws IOException {
		setup();
		atc = new AddToCart(driver);
	}

	@Test(priority = 1)
	public void ComponetsTABOpen() {
		atc.componentsTAB();
	}

	@Test(priority = 2)
	public void Openitem() {
		atc.OpenProduct();
	}

	@Test(priority = 3)
	public void checkthebox() {
		atc.checkboxCHECK();
	}
	
	@Test(priority = 4)
	public void EntrText() {
		atc.TextFill();
	}
	@Test(priority = 5)
	public void  selectthecolor() {
		atc.SelectColor();
	}

	@Test(priority = 6)
	public void textAea() {
		atc.Textarea();
	}
	@Test(priority = 7)
	public void UploadTheFile() throws AWTException {
		String filePath= "C:\\Users\\akhil dwivedi\\Desktop\\2 (1).jpg";
		atc.FileUpLoad(filePath );
	}
	@Test(priority =8)
	public void calenderupdate() {
		atc.Clndr();
	}
	@Test(priority=9)
	public void timeselect() {
		atc.TimeInput();
	}
	@Test(priority=10)
	public void filldatetime() {
		atc.DateTimeInput();
	}
	@Test(priority=11)
	public void selectQTY() {
		atc.enterQTY();
	}
	@Test(priority=12)
	public void AddToProduct() {
		atc.AddClick();
	}
//	@DataProvider(name="imageData")
//	public Object[] data() {
//		return new Object[] {"C:\\Users\\akhil dwivedi\\Desktop"};
//		
//	}
}

