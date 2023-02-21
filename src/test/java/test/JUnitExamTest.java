package test;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



import pages.JUnitExamPage;
import util.BrowserFactory;

public class JUnitExamTest {
	

	WebDriver driver ;
	
		
	
	
//	@Test
	public void toggleAllCheckboxTest () {
		
		driver = BrowserFactory.init();
		
		JUnitExamPage page = PageFactory.initElements(driver, JUnitExamPage.class);
		
		page.clickOnToggleAllCheckBox();
		page.checkBoxVerification();
		BrowserFactory.teardown();
	}
	
	@Test 
	public void removeCheckBoxTest() {
		
			driver = BrowserFactory.init();
		
		JUnitExamPage page = PageFactory.initElements(driver, JUnitExamPage.class);
		
		page.SelectCheckBox(4);
		page.clickOnRemoveButton();
		page.verifyThatCheckBoxIsRemoved(4);
		BrowserFactory.teardown();
	}

//	@Test
	public void toggleAllAndDeleteTest() {

		driver = BrowserFactory.init();
	
	JUnitExamPage page = PageFactory.initElements(driver, JUnitExamPage.class);
	
	page.clickOnToggleAllCheckBox();
	page.clickOnRemoveButton();
	page.verifyNoCheckboxisDisplayed();
	BrowserFactory.teardown();
	
	}
	
	
}


