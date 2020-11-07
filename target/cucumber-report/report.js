$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Contato.feature");
formatter.feature({
  "name": "Menu Contato",
  "description": "",
  "keyword": "Funcionalidade"
});
formatter.scenario({
  "name": "Menu Contato",
  "description": "",
  "keyword": "Cenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que eu acessei a home page da Verity",
  "keyword": "Dado "
});
formatter.match({
  "location": "ContatoSteps.queEuAcesseiAHomePageDaVerity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "eu clicar na opção de menu Contato",
  "keyword": "Quando "
});
formatter.match({
  "location": "ContatoSteps.euClicarNaOpçãoDeMenuContato()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "preencher os campos Nome Completo, Empresa, Email, Fone e Mensagem",
  "keyword": "E "
});
formatter.match({
  "location": "ContatoSteps.preencherOsCamposNomeCompletoEmpresaEmailFoneEMensagem()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicar no botão Enviar",
  "keyword": "E "
});
formatter.match({
  "location": "ContatoSteps.clicarNoBotãoEnviar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "o site irá registrar o envio apresentando uma mensagem de que a mensagem foi enviada com sucesso",
  "keyword": "Então "
});
formatter.match({
  "location": "ContatoSteps.oSiteIráRegistrarOEnvioApresentandoUmaMensagemDeQueAMensagemFoiEnviadaComSucesso()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
});