package steps_mapper;

import org.openqa.selenium.WebElement;
import java.util.Random;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import models.Cadastro;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegisterPage;
import pages.SignInPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

public class Step_mapping {

	private static WebDriver driver;
	Random random = new Random();
	private int aleatorio_email = random.nextInt(1001);
	
	// Secao dedicada a gerar/inserir os dados a serem utilizados pelo pedido
	
	static Cadastro cadastro = new Cadastro();
	
	public void insereDadosPedido() {
		cadastro.setNome("Nome");
		cadastro.setSobrenome("Sobrenome do Cliente");
		cadastro.setEmail("emaildo.cliente_"+aleatorio_email+"@email.com");
		cadastro.setSenha("S3nh@");
		cadastro.setTelefone("12125558737");
		cadastro.setRua("711 11th Ave");
		cadastro.setCidade("New York");
		cadastro.setCep("10019");
		cadastro.setEstado("New York");
		cadastro.setAliasEndereco("Commercial Address");
	}
	
	
	// Steps para criar uma nova conta
	
	@Given ("Acessada a pagina da loja")
	   public void lojahomePage_open() {
	   	System.setProperty("webdriver.firefox.driver", "/usr/local/bin/geckodriver");
			driver = new FirefoxDriver();
		    driver.get("http://automationpractice.com/");
		    driver.manage().window().maximize();
		    driver.manage().deleteAllCookies();
	   }
	
	@And ("E clicado o botao Sign in")
	public void signInButton_click() {
		HomePage homePage = new HomePage(driver);
		homePage.signInButton_click();
	}
	
	@Given ("Ao preencher um e-mail e clicar no botao de Create an account")
	public void typeEmailNewAccountButton_click() {
		SignInPage signinPage = new SignInPage(driver);
		signinPage.typeNewEmail();
		signinPage.clickNewAccount();
		
	}
	
	@And ("E preencher todos os dados obrigatorios da compra")
	public void fillOutAccountFormAndRegisterButton_click() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.fillOutForm_method(driver);
		System.out.println("fillOutAccountFormRegisterButton_click() Done!");
	}
	
	@Then ("O site abre a pagina de detalhes da conta")
	public void myAccountPage_validate() {
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		myAccountPage.validateMyAccountPage_method();
		System.out.println("myAccountPage_validate() Done!");
		driver.close();
	}
	
}
