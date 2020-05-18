package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	// Construtor

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Elements
	
	@FindBy(how = How.LINK_TEXT, using = "Sign In")
	private WebElement signInButton;
	
	// Actions
	
	public void signInButton_click() {
		signInButton.click();
	}
	
}
