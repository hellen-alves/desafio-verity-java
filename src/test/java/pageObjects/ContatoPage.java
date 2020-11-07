package pageObjects;

import static utils.Utils.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static org.junit.Assert.assertTrue;
import static utils.Utils.*;

public class ContatoPage {
	
	// Construtor
	public ContatoPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-testid='linkElement']/div/div/p[text()='CONTATO']")
	private WebElement btnContato;

	@FindBy(css = "input[placeholder='Nome Completo']")
	private WebElement inputNomeCompleto;
	
	@FindBy(css = "input[placeholder='Empresa']")
	private WebElement inputEmpresa;
	
	@FindBy(css = "input[placeholder='E-mail']")
	private WebElement inputEmail;
	
	@FindBy(css = "input[placeholder='Fone']")
	private WebElement inputFone;
	
	@FindBy(css = "textarea[placeholder='Mensagem']")
	private WebElement textMensagem;
	
	@FindBy(xpath = "//div/iframe[@role='presentation']")
	private WebElement btnCaptcha;
	
	@FindBy(css = "button[data-testid='buttonElement']")
	private WebElement btnEnviar;
	

	
	public void clicarBotaoContato() throws Exception {
		btnContato.click();
	}
	
	public void dadosContato() throws Exception {
		scrollBy(inputNomeCompleto);
		inputNomeCompleto.isEnabled();
		inputNomeCompleto.sendKeys("Hellen Alves de Sousa Silva");
		inputEmpresa.sendKeys("Verity");
		inputEmail.sendKeys("hellen@verity.com");
		inputFone.sendKeys("61986237389");
		textMensagem.sendKeys("Teste Automatizado");
		aguardarVisibilidade(true, 2, btnCaptcha);
		btnCaptcha.click();
		System.out.println("Aguardando a seleção manual do captcha");
		esperarPagina(60);
	}
	
	public void clicarBotaoEnviar() throws Exception {
		btnEnviar.click();
	}
	
	public void validarEnvio() throws Exception {
		assertTrue(textoExiste("Mensagem enviada com sucesso!"));
		esperarPagina(1);
	}
}
