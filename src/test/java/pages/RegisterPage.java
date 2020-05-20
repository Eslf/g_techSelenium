package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

	// Construtor
	
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	// Elementos
	
	@FindBy(how = How.ID, using = "id_gender1")
	private WebElement gender_radioButton;
	//WebDriverWait wait_id_gender1 = new WebDriverWait(driver, 3);
	//wait_id_gender1.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));
	//driver.findElement(By.cssSelector("#id_gender1")).click();
	
	@FindBy(how = How.CSS, using = "#customer_firstname")
	private WebElement firstName_input;
	
	@FindBy(how = How.CSS, using = "#customer_lastname")
	private WebElement lastName_input;
	
	@FindBy(how = How.CSS, using = "#passwd")
	private WebElement password_input;
	
	@FindBy(how = How.CSS, using = "#address1")
	private WebElement address_input;
	
	@FindBy(how = How.CSS, using = "#city")
	private WebElement city_input;
	
	@FindBy(how = How.NAME, using = "id_state")
	private WebElement state_selectable;
	
	//Select lista_estados = new Select(driver.findElement(By.name("id_state")));
	//lista_estados.selectByVisibleText(pedido.getEstado());
	
	@FindBy(how = How.CSS, using = "#postcode")
	private WebElement postcode_input;
	
	@FindBy(how = How.CSS, using = "#phone_mobile")
	private WebElement phoneMobile_input;
	
	@FindBy(how = How.CSS, using = "#alias")
	private WebElement aliasAddress_input;
	
	@FindBy(how = How.CSS, using = "#submitAccount")
	private WebElement submitAccount_button;
	
	/*
	driver.findElement(By.cssSelector("#alias")).clear();
	driver.findElement(By.cssSelector("#alias")).sendKeys(pedido.getAliasEndereco());
	*/
	
	// Acoes
	
	private void selectGender(WebDriver driver) {
		WebDriverWait wait_id_gender1 = new WebDriverWait(driver, 3);
		wait_id_gender1.until(ExpectedConditions.visibilityOf(gender_radioButton));
		gender_radioButton.click();
	}
	
	private void firstName_fillOut() {
		firstName_input.sendKeys("Nome");
	}
	
	private void lastName_fillOut() {
		lastName_input.sendKeys("Sobrenome do Cliente");
	}
	
	private void password_fillOut() {
		password_input.sendKeys("S3nh@");
	}
	
	private void address_fillOut() {
		address_input.sendKeys("711 11th Ave");
	}
	
	private void city_fillOut() {
		city_input.sendKeys("New York");
	}
	
	private void state_selection() {
		Select lista_estados = new Select(state_selectable);
		lista_estados.selectByVisibleText("New York");
	}
	
	private void postcode_fillOut() {
		postcode_input.sendKeys("10019");
	}
	
	private void phoneMobile_fillOut() {
		phoneMobile_input.sendKeys("12125558737");
	}
	
	private void aliasAddress_fillOut() {
		aliasAddress_input.sendKeys("Commercial Address");
	}
	
	private void submitAccountButton_click() {
		submitAccount_button.click();
	}
	
	// Acoes centralizadas num unico metodo
	
	public void fillOutForm_method(WebDriver driver) {
		selectGender(driver);
		firstName_fillOut();
		lastName_fillOut();
		password_fillOut();
		address_fillOut();
		city_fillOut();
		state_selection();
		postcode_fillOut();
		phoneMobile_fillOut();
		aliasAddress_fillOut();
		submitAccountButton_click();
	}
	
}
