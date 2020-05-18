package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	// Construtor
	
	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Elements
	
	@FindBy(how = How.ID, using = "email_create")
	private WebElement createAccountEmail_input;
	
	@FindBy(how = How.ID, using = "SubmitCreate")
	private WebElement createAccount_button;
		
	// Actions
	
	public void typeNewEmail() {
		createAccountEmail_input.sendKeys("");
	}
	
	public void clickNewAccount() {
		createAccount_button.click();
	}
}
