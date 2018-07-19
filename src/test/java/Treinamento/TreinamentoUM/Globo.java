package Treinamento.TreinamentoUM;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Globo {

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
		navegador.get("https://oglobo.globo.com/");
		System.out.println(navegador.getPageSource());

		navegador.manage().deleteAllCookies();

	}

	@Test
	public void testReportagem() throws InterruptedException {
		
		int contador = 0;
		do {
			contador++;
		
			WebElement Reportagem = navegador.findElement(By.id("ciencia"));
		Reportagem.click();
	
		}	while (contador < 1);
		navegador.quit();
			}

	}
			
	


	