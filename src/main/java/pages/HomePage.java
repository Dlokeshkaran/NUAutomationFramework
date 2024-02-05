package pages;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.GlobalVariables;
//import wdMethods.EddieBauerMethods;
import wdMethods.ProjMethods;

public class HomePage extends ProjMethods {
	

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	// new repo
	@FindBy(how = How.XPATH, using = "//*[contains(@aria-label,'Enter Keyword or Item Number')]")
	public WebElement searchIconLesslies;
	
	// Home Page Elements
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'styles__StyledSearchButton')]")
	public WebElement searchIcon;
	

	
	
	// Home Page Function
	public void clicksearch() {
		clickElementByJavaScript(searchIcon);
	}
	
	
	public void verifyHomePage() {
		verifyTitleContains("Pool Supplies, Service & Repair | Leslie's Pool Supplies");
		waitForServerToPerformAction(10);
		reportStep("Successfully Landed to Home Page", "INFO");
	}
	


	
	public void searchByProductName() {
		getDriver().navigate().refresh();
		click(searchIconLesslies);
		Actions searchProduct = new Actions(getDriver());
		searchProduct.sendKeys("Water", Keys.ENTER).build().perform();
		
//		if(GlobalVariables.getGlobalVariable("mobileWeb").contains("true")? true : false) {
//			
//		}else 
		
	}
	
	
	
}
