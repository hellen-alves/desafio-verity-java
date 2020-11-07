package stepsDefinitions;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pageObjects.ContatoPage;


public class ContatoSteps {
	
	ContatoPage contatoPage = new ContatoPage();
	
	@Dado("^que eu acessei a home page da Verity$")
	public void queEuAcesseiAHomePageDaVerity() throws Exception {
	    
	}

	@Quando("^eu clicar na opção de menu Contato$")
	public void euClicarNaOpçãoDeMenuContato() throws Exception {
		contatoPage.clicarBotaoContato();
	}

	@Quando("^preencher os campos Nome Completo, Empresa, Email, Fone e Mensagem$")
	public void preencherOsCamposNomeCompletoEmpresaEmailFoneEMensagem() throws Exception {
	    contatoPage.dadosContato();
	}

	@Quando("^clicar no botão Enviar$")
	public void clicarNoBotãoEnviar() throws Exception {
	    contatoPage.clicarBotaoEnviar();
	}

	@Então("^o site irá registrar o envio apresentando uma mensagem de que a mensagem foi enviada com sucesso$")
	public void oSiteIráRegistrarOEnvioApresentandoUmaMensagemDeQueAMensagemFoiEnviadaComSucesso() throws Exception {
	    contatoPage.validarEnvio();
	}

}
