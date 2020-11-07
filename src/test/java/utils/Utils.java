package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import io.qameta.allure.Allure;



public class Utils {
	
	public static ChromeDriver driver;

	public static void acessarSistema() {
		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.verity.com.br");
	}
	
	public static void addEnvironmentAllure() {
		try {
			File env = new File("./target/allure-reports/environment.properties");
			BufferedWriter as = new BufferedWriter(new FileWriter(env));
			as.write("Analista: Hellen Alves de Sousa Silva");
			as.newLine();
			as.write("E-mail: leehalvess@gmail.com");
			as.newLine();
			as.write("Navegador = Chrome");
			as.newLine();
			as.write("Desafio = VERITY");
			as.newLine();
			as.write("Sistema Operacional = " + System.getProperty("os.name").toLowerCase());
			as.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void capturarTela(Scenario scenario) {
		File screenshot = gerarScreenShot(scenario);
		embedScreenshot(screenshot, scenario.getName());
		addEnvironmentAllure();
	}

	public static File gerarScreenShot(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");

		File imagem = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imagem,
					(new File("./target/allure-reports", scenario.getName() + " - " + scenario.getStatus() + ".png")));
		} catch (Exception e) {

		}

		return imagem;
	}

	public static void embedScreenshot(File file, String description) {
		Path content = Paths.get(file.getPath());
		try (InputStream is = Files.newInputStream(content)) {
			Allure.addAttachment(description, is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static boolean textoExiste(String arg1) {
		return driver.getPageSource().contains(arg1);

	}

	public static boolean elementoExiste(String elemento) {
		boolean existe = false;
		try {
			existe = driver.findElement(By.xpath(elemento)).isEnabled();
		} catch (NoSuchElementException e) {
			existe = false;
		}
		return existe;
	}

	public static void aguardarVisibilidade(Boolean visibilidade, Integer tempoEspera, WebElement elemento)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, tempoEspera);

		if (visibilidade = true) {
			wait.until(ExpectedConditions.visibilityOf(elemento));
		} else {
			wait.until(ExpectedConditions.invisibilityOf(elemento));
		}

	}
	
	public static void esperarPagina(int tempo) throws Exception {
		for (int i = 0; i < tempo; i++) {
			Thread.sleep(1000);
		}
	}
	
	public static void scrollBy(WebElement elemento) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor)driver;
	//	js.executeScript("window.scrollBy(0,250)");
		js.executeScript("arguments[0].scrollIntoView(true);",elemento);
	}
	
	
}
