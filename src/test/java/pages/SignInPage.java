package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.Random;

public class SignInPage {

	// Variaveis para os e-mails aleatórios
	
	private int aleatorio_email = 0;
	
	// Construtor
	
	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Elementos
	
	@FindBy(how = How.ID, using = "email_create")
	private WebElement createAccountEmail_input;
	
	@FindBy(how = How.ID, using = "SubmitCreate")
	private WebElement createAccount_button;
		
	// Acoes
	
	private String generateRandomEmail() {
		
		Random random = new Random();
		aleatorio_email = random.nextInt(1001);
		String email = "login.cliente_"+aleatorio_email+"@email.com";
		
		return email;
	}
	
	public void typeNewEmail() {
		
		String newEmail = generateRandomEmail();
		createAccountEmail_input.sendKeys(newEmail);
	}
	
	public void clickNewAccount() {
		createAccount_button.click();
	}
}
