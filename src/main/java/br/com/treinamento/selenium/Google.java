package br.com.treinamento.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {

	
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
			navegador.get("https://www.google.com.br");
			System.out.println(navegador.getPageSource());

			navegador.manage().deleteAllCookies();

		}

		@Test
		public void testReportagem() throws InterruptedException, IOException {
			int contador = 0;
			do {
				contador++;
				
			WebElement Pesquisa = navegador.findElement(By.name("q"));
			Pesquisa.sendKeys("Selenium");
			
			AssistenteGerais.printTela ("Pesquisa1" , navegador);
			
			WebElement Pesquisar2 = navegador.findElement(By.name("q"));
			Pesquisar2.submit();
			
		AssistenteGerais.printTela ("Pesquisa2" , navegador);
		
		Thread.sleep (200000);
			}	while (contador < 1);
			navegador.quit();
				}

		}
				
		


