package br.com.treinamento.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssistenteLogin {
	public static void logarComUsuarioMGN5(WebDriver navegador) {
		
		
		WebElement caixaLoja = navegador.findElement(By.id("txtLoja")); 
		caixaLoja.sendKeys("547554000");
		
		WebElement caixaUsuario = navegador.findElement(By.id("txtuid")); 
		caixaUsuario.sendKeys("t198042");
		
		WebElement caixaDeSenha = navegador.findElement(By.id("txtSenha")); 
		caixaDeSenha.sendKeys("Senha*17");

		WebElement botaoAcessa = navegador.findElement(By.xpath(
				"/html/body/form/center/table[2]/tbody/tr[1]/td[2]/table/tbody/tr[10]/td/table/tbody/tr/td[3]/a/font/b"));
		botaoAcessa.click();
	}

}
