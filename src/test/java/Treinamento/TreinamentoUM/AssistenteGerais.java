package Treinamento.TreinamentoUM;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AssistenteGerais {
	public static void printTela(String nomeArquivo, WebDriver navegador) throws IOException {

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		File imagemTela = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
		String nomeCompletoArquivo = "target\\" + nomeArquivo + "_" + dateFormat.format(date) + ".jpg";
		FileUtils.copyFile(imagemTela, new File(nomeCompletoArquivo));

		System.out.println("Tirou print da tela");
	}

	public static void executarRolagem(String posicaoVertical, WebDriver navegador) {
		String comandojs = "javascript:window.scrollBy(0," + posicaoVertical + ")";
		System.out.println("rolagem: " + comandojs);
		JavascriptExecutor js = (JavascriptExecutor) navegador;
		js.executeScript(comandojs);

	}

}


