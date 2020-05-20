package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MyAccountPage {

	// Construtor
	
	public MyAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Elementos
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div[3]/div/h1")
	private WebElement myAccount_title;
		
	// Acoes
	
	public void validateMyAccountPage_method() {
		assertThat(myAccount_title.getText(), is("MY ACCOUNT"));
	}
	
}
