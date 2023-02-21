package pages;

import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;




public class JUnitExamPage {

	
	WebDriver driver;
	public JUnitExamPage (WebDriver driver) {
		this.driver= driver ;
	}

	

	@FindBy (how = How.XPATH, using= "/html/body/div[3]/input[3]") WebElement Toggle_All_Checkbox ;
	@FindBy (how = How.CSS , using= "input[name='todo[0]']") WebElement Toggle_Checkbox ;
	@FindBy (how = How.XPATH , using= "/html/body/div[3]/input[1]") WebElement Remove_Button ;

	
	public void clickOnToggleAllCheckBox () {
		
		Toggle_All_Checkbox.click();
	}
	public ArrayList<WebElement> CheckBoxListData() {
		
		ArrayList<WebElement> fileData = new ArrayList<WebElement>();
		int i =1;
		
		try {
			while(Toggle_Checkbox.isDisplayed()) {
				
				fileData.add(Toggle_Checkbox);
			Toggle_Checkbox = driver.findElement(By.cssSelector("input[name='todo["+i+"]']"));
			
			i++;}}catch (Exception e) {}
		return fileData;
		
		
		
	
	}
	
	public void checkBoxVerification() {
		
		ArrayList<WebElement> fileData = new ArrayList<WebElement>();
		fileData=CheckBoxListData();
		
		for(int j=0;j<fileData.size();j++) {
				fileData.get(j).isDisplayed();
				if (fileData.get(j).isSelected()) {
					System.out.println("checkbox"+j+"is selected");
				}
				else {
					System.out.println("checkbox"+j+"is not selected");
				}
			}
			
		
	}
	
	public void clickOnRemoveButton () {
		Remove_Button.click();
	}
	
	
	public void SelectCheckBox (int checkBoxLine) {
		ArrayList<WebElement> fileData = new ArrayList<WebElement>();
		fileData=CheckBoxListData();
		
		if (checkBoxLine<fileData.size()) {
			
			fileData.get(checkBoxLine).click();
			
					if (fileData.get(checkBoxLine).isSelected()) {
							System.out.println("The check box Line " + checkBoxLine +" is selected "  );
		                 }
		}
		else {
			System.out.println("no check box in the line provided");
		}		
		}
		
	public void verifyThatCheckBoxIsRemoved (int checkBoxLine) {
		
		ArrayList<WebElement> fileData = new ArrayList<WebElement>();
		fileData=CheckBoxListData();
		
		
   
	try {	fileData.get(checkBoxLine).isDisplayed();
	
	}catch(Exception e ) {
		System.out.println("the check box succesfully removed or did't exist ");
	}
		
		
	}
	public void verifyNoCheckboxisDisplayed() {
		ArrayList<WebElement> fileData = new ArrayList<WebElement>();
		fileData=CheckBoxListData();
		if (fileData.size()==0) {
		System.out.println("No check box is displayed,All the checkboxes has been removed");
		}else {
			System.out.println("one or more check boxes are displayed");
		}
	}
	
}
	
	
