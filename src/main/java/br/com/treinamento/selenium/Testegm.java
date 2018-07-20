package br.com.treinamento.selenium;

import java.awt.AWTException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Testegm {
	private static WebDriver navegador;

	// CHAMANDO EMULADOR

	@BeforeClass
	public static void antesDeTodosOsTestes() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("androidPackage", "com.android.chrome");

		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Google Nexus 4");

		Map<String, Object> chromeOptions1 = new HashMap<String, Object>();
		chromeOptions1.put("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions1);

		System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");

		navegador = new ChromeDriver(capabilities);
		navegador.manage().window().maximize();
		navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	// INICIO DO TESTE

	@Test
	public void conseguirCadastrarPropostaSimplificada() throws IOException, InterruptedException, AWTException {
		Actions builder = new Actions(navegador);

		navegador.get("http://oglobo.globo.com/fotogalerias/");

		// PEGANDO MATERIA FOTOGALERIA E VOLTANDO POR BOTAO

		WebElement p1 = navegador.findElement(By.cssSelector("#photoGallery >ul >li:nth-child(1)>a"));
		p1.click();
		WebElement fotosp1 = navegador.findElement(By.cssSelector(
				"#photoGallery > div > div > ul > li.horizontal.cycle-slide.cycle-slide-active > div.img > img"));

		WebElement volta = navegador.findElement(By.cssSelector("#lastFrom > a.linkAll"));
		Thread.sleep(7000);
		builder = builder.dragAndDropBy(fotosp1, 100, 0);
		builder.perform();
		builder.perform();
		builder.perform();
		builder.perform();
		builder.perform();
		builder.perform();

		volta.click();

		// PEGANDO MATERIA FOTO GALERIA E VOLTANDO POR LINK

		WebElement p2 = navegador.findElement(By.cssSelector("#photoGallery > ul > li:nth-child(2) > a > span.label"));
		p2.click();
		Thread.sleep(5000);
		navegador.get("http://oglobo.globo.com/fotogalerias/");

		// EDITORIAIS
		WebElement comboboxElement = navegador.findElement(By.id("selectEditorias"));
		WebElement vermais = navegador.findElement(By.cssSelector("#lastFrom > a"));
		vermais.click();

		Thread.sleep(7000);
		Select combobox = new Select(comboboxElement);
		combobox.selectByValue("rio");

		Thread.sleep(7000);
		combobox.selectByValue("pais");

		Thread.sleep(7000);
		combobox.selectByValue("mundo");

		Thread.sleep(7000);
		combobox.selectByValue("economia");

		Thread.sleep(7000);
		combobox.selectByValue("sociedade");

		Thread.sleep(7000);
		combobox.selectByValue("tecnologia");

		Thread.sleep(7000);
		combobox.selectByValue("ciencia");

		Thread.sleep(7000);
		combobox.selectByValue("saude");

		Thread.sleep(7000);
		combobox.selectByValue("cultura");

		Thread.sleep(5000);
		combobox.selectByValue("ela");

		Thread.sleep(5000);
		combobox.selectByValue("esportes");

		Thread.sleep(5000);
		combobox.selectByValue("topico-rio-2016");

		Thread.sleep(5000);
		combobox.selectByValue("revista-da-tv");

		Thread.sleep(5000);

		// PEGANDO MATERIA A PARTIR DO EDITORIAL

		WebElement MateriaUltimasNoticias = navegador
				.findElement(By.cssSelector("#listaConteudosMobi > li:nth-child(2) > a > span.label"));
		MateriaUltimasNoticias.click();
		Thread.sleep(5000);

		// MENU PRINCIPAL E BUSCA

		WebElement Menu = navegador.findElement(By.id("abrir_menu"));
		Menu.click();
		Thread.sleep(5000);
		navegador.get("http://oglobo.globo.com/fotogalerias/");

		WebElement Busca = navegador.findElement(By.id("fazer_busca"));
		Busca.click();
		WebElement PalavrasBusca = navegador.findElement(By.id("palavrasBusca"));
		PalavrasBusca.sendKeys("Rio");
		Thread.sleep(5000);
		PalavrasBusca.clear();
		Thread.sleep(3000);
		PalavrasBusca.sendKeys("Globo");
		Thread.sleep(3000);

		// MAIS VISTA E FACEBOOK

		navegador.get("http://oglobo.globo.com/fotogalerias/");

		WebElement vermais2 = navegador.findElement(By.cssSelector("#lastFrom > a"));
		vermais2.click();
		WebElement MaisVista = navegador.findElement(
				By.cssSelector("#widget_ogloboBoxDasMais-16018707-fotogalerias > div > ul > li:nth-child(1)"));
		MaisVista.click();
		Thread.sleep(15000);
		WebElement Facebook = navegador.findElement(By.id("idFacebook"));
		Facebook.click();
		Thread.sleep(5000);
		navegador.quit();

	}

}
