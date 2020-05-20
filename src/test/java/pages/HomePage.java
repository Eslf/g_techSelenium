package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	// Construtor

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Elementos
	
	@FindBy(how = How.LINK_TEXT, using = "Sign in")
	private WebElement signInButton;
	
	// Acoes
	
	public void signInButton_click() {
		signInButton.click();
	}
	
}
