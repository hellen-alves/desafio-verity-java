package stepsDefinitions;

import static utils.Utils.acessarSistema;
import static utils.Utils.driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.Utils;

public class Hooks {
	
	@Before
	public void suiteSetUp() {
		acessarSistema();
	}
	

	@After
	public void tearDown(Scenario scenario) throws Exception {
		Utils.capturarTela(scenario);
		driver.quit();
	}

}
