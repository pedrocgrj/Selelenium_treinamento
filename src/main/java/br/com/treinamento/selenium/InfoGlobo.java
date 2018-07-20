package br.com.treinamento.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InfoGlobo {
	
	private static WebDriver navegador;

	@BeforeClass
	public static void antesDeTodosOsTestes() {
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().window().maximize();
		navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Before
	public void antesDeCadaTeste() {
		navegador.get("http://www.infoglobo.com.br");
		System.out.println(navegador.getPageSource());

		navegador.manage().deleteAllCookies();

	}

	@Test
	public void testReportagem() throws InterruptedException {
		
		WebElement Reportagem = navegador.findElement(By.id("ctl00_ContentPrincipal_BtEntrarInicial"));
		Reportagem.click();
	
		
	

		Thread.sleep(30000);
	}
}



