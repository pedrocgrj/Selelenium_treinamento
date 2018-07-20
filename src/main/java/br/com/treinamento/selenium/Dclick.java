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

public class Dclick {
	private static WebDriver navegador;

	@BeforeClass
	public static void antesDeTodosOsTestes() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().window().maximize();
		navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Before
	public void antesDeCadaTeste() {
		navegador.get("http://www.dclick.com.br/");
		System.out.println(navegador.getPageSource());

		navegador.manage().deleteAllCookies();

	}

	@Test
	public void testReportagem() throws InterruptedException, IOException {

		int contador = 0;
		do {
			contador++;
			System.out.println("pedrohenrique" + contador + "@gmail.com");
			WebElement Sobre = navegador.findElement(By.id("menu-item-5590"));
			Sobre.click();
			
			AssistenteGerais.printTela("Sobre", navegador);

			Thread.sleep(2000);

			WebElement Tecnologias = navegador.findElement(By.xpath("//*[@id=\"flexipages-21\"]/ul/li[3]/a"));
			Tecnologias.click();

			AssistenteGerais.printTela("Tecnologias", navegador);

			Thread.sleep(2000);

			WebElement Projetos = navegador.findElement(By.id("menu-item-567"));
			Projetos.click();

			AssistenteGerais.printTela("Projetos", navegador);

			WebElement Imagem = navegador.findElement(By.id("ngg-image-0"));
			Imagem.click();

			Thread.sleep(2000);

			AssistenteGerais.printTela("Imagem", navegador);

			WebElement Fechar = navegador.findElement(By.id("fancybox-close"));
			Fechar.click();

			AssistenteGerais.executarRolagem("1699", navegador);

			AssistenteGerais.printTela("Porto", navegador);

		} while (contador < 4);
		navegador.quit();

		// Thread.sleep (200000);
	}

}
