package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import models.Cadastro;

import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

	// Construtor
	
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	// Elementos
	
	@FindBy(how = How.ID, using = "id_gender1")
	private WebElement gender_radioButton;
	
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
	
	@FindBy(how = How.CSS, using = "#postcode")
	private WebElement postcode_input;
	
	@FindBy(how = How.CSS, using = "#phone_mobile")
	private WebElement phoneMobile_input;
	
	@FindBy(how = How.CSS, using = "#alias")
	private WebElement aliasAddress_input;
	
	@FindBy(how = How.CSS, using = "#submitAccount")
	private WebElement submitAccount_button;
	
	// Secao dedicada a gerar/inserir os dados a serem utilizados pelo pedido
	
	static Cadastro cadastro = new Cadastro();
	
	public void geraDadosCadastro() {
		cadastro.setNome("Nome");
		cadastro.setSobrenome("Sobrenome do Cliente");
		cadastro.setSenha("S3nh@");
		cadastro.setTelefone("12125558737");
		cadastro.setRua("711 11th Ave");
		cadastro.setCidade("New York");
		cadastro.setCep("10019");
		cadastro.setEstado("New York");
		cadastro.setAliasEndereco("Commercial Address");
	}
	
	// Acoes
	
	private void selectGender(WebDriver driver) {
		WebDriverWait wait_id_gender1 = new WebDriverWait(driver, 3);
		wait_id_gender1.until(ExpectedConditions.visibilityOf(gender_radioButton));
		gender_radioButton.click();
	}
	
	private void firstName_fillOut() {
		firstName_input.sendKeys(cadastro.getNome());
	}
	
	private void lastName_fillOut() {
		lastName_input.sendKeys(cadastro.getSobrenome());
	}
	
	private void password_fillOut() {
		password_input.sendKeys(cadastro.getSenha());
	}
	
	private void address_fillOut() {
		address_input.sendKeys(cadastro.getRua());
	}
	
	private void city_fillOut() {
		city_input.sendKeys(cadastro.getCidade());
	}
	
	private void state_selection() {
		Select lista_estados = new Select(state_selectable);
		lista_estados.selectByVisibleText(cadastro.getEstado());
	}
	
	private void postcode_fillOut() {
		postcode_input.sendKeys(cadastro.getCep());
	}
	
	private void phoneMobile_fillOut() {
		phoneMobile_input.sendKeys(cadastro.getTelefone());
	}
	
	private void aliasAddress_fillOut() {
		aliasAddress_input.sendKeys(cadastro.getAliasEndereco());
	}
	
	private void submitAccountButton_click() {
		submitAccount_button.click();
	}
	
	// Acoes centralizadas num unico metodo
	
	public void fillOutForm_method(WebDriver driver) {
		geraDadosCadastro();
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
