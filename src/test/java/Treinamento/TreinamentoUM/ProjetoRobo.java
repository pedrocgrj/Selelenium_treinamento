package Treinamento.TreinamentoUM;



import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ProjetoRobo {
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
		navegador.get("http://172.22.156.45/crednet/htm/index.htm");
		System.out.println(navegador.getPageSource());

		navegador.manage().deleteAllCookies();

	}

	@AfterClass
	public static void depoisDeTodosOsTestes() {
		navegador.quit();

	}

	@Test
	public void conseguirCadastrarPropostaSimplificada() throws IOException, InterruptedException {
		int contador = 0;
		do {
			contador++;
		
		WebElement iframe = navegador.findElement(By.name("main"));
		navegador.switchTo().frame(iframe);
		AssistenteLogin.logarComUsuarioMGN5(navegador);

		WebElement menu = navegador.findElement(By.xpath("//*[@id=\"expTabelaMenu\"]/table/tbody/tr[4]/td/b/a"));;
		menu.click();
		Thread.sleep(5000);

		WebElement campoProduto = navegador.findElement(By.name("rdoTpProduto"));
		campoProduto.click();

		WebElement valorSolicitado = navegador.findElement(By.name("txtValorOperacao"));
		valorSolicitado.clear();
		valorSolicitado.sendKeys("1300");

		WebElement campoCPFAgente = navegador.findElement(By.id("txtCpfAgente"));
		campoCPFAgente.sendKeys("99710110500");

		WebElement botaoPesquisar = navegador.findElement(By.name("btnPesquisa"));
		botaoPesquisar.click();

		WebElement campoCPFCliente = navegador.findElement(By.id("txtCpfCgc"));
		GeraCPF cpf = new GeraCPF();
		String numCpf = cpf.geraCPFFinal();

		numCpf.replace(".", "").replace("-", "");

		// campoCPFCliente.sendKeys ("19100000000");
		campoCPFCliente.sendKeys(numCpf);

		WebElement campoDiaNascimento = navegador.findElement(By.id("txtDia"));
		campoDiaNascimento.sendKeys("01");

		WebElement campoMesNascimento = navegador.findElement(By.id("txtMes"));
		campoMesNascimento.sendKeys("01");

		WebElement campoAnoNascimento = navegador.findElement(By.id("txtAno"));
		campoAnoNascimento.sendKeys("1960");
		
		AssistenteGerais.executarRolagem("-200", navegador);

		AssistenteGerais.printTela ("simplificada" , navegador);
		
	WebElement valorRenda = navegador.findElement(By.name("txtValorRenda"));
		valorRenda.clear();
		valorRenda.sendKeys("9000");
		
		Thread.sleep(2000);
		
        WebElement botaoEnvia = navegador.findElement(By.name("btnEnvia"));
		botaoEnvia.click();

		AssistenteGerais.printTela ("resultado simplificada" , navegador);
		
		WebElement botaoSegue = navegador.findElement(By.name("btnSegue"));
		botaoSegue.click();
		
		Thread.sleep(4000);
		
		WebElement campoPlano = navegador
				.findElement(By.xpath("//*[@id=\"tblGridStatus\"]/tbody/tr[4]/td[2]/a/font/u"));
		campoPlano.click();
		
	Thread.sleep(3000);
		
        WebElement valorNome = navegador.findElement(By.name("txtNome"));
		valorNome.sendKeys("Robo treinamento");

		WebElement valorSexo = navegador.findElement(By.name("rdoSexo"));
		valorSexo.click();

		WebElement campoDocumento = navegador.findElement(By.name("cmbTpDocumento"));
		Select selectDocumento = new Select(campoDocumento);
		selectDocumento.selectByValue("01");

		WebElement valorNumeroIdenti = navegador.findElement(By.name("txtNumeroId"));
		valorNumeroIdenti.sendKeys("123456789");

		WebElement valorDataEmissaoDia = navegador.findElement(By.name("txtDtEmissDia"));
		valorDataEmissaoDia.sendKeys("27");

		WebElement valorDataEmissaoMes = navegador.findElement(By.name("txtDtEmissMes"));
		valorDataEmissaoMes.sendKeys("04");

		WebElement valorDataEmissaoAno = navegador.findElement(By.name("txtDtEmissAno"));
		valorDataEmissaoAno.sendKeys("1975");

		WebElement campoEmissor = navegador.findElement(By.name("txtOrgaoId"));
		Select selectEmissor = new Select(campoEmissor);
		selectEmissor.selectByValue("DETRA");

		WebElement campoUF = navegador.findElement(By.name("cmbUfEmissor"));
		Select selectUF = new Select(campoUF);
		selectUF.selectByValue("RJ");

		WebElement campoNacionalidade = navegador.findElement(By.name("cmbNacionalidade"));
		Select selectNacionalidade = new Select(campoNacionalidade);
		selectNacionalidade.selectByValue("0");

		WebElement campoNaturalidade = navegador.findElement(By.name("cmbNaturalidade"));
		Select selectNaturalidade = new Select(campoNaturalidade);
		selectNaturalidade.selectByValue("RJ");
        
		WebElement valorNomeMae = navegador.findElement(By.name("nome_mae"));
		valorNomeMae.sendKeys("Nome Teste Mae");

		WebElement campoEstadoCivil = navegador.findElement(By.name("cmbEstadoCivil"));
		Select selectEstadoCivil = new Select(campoEstadoCivil);
		selectEstadoCivil.selectByValue("1");

	AssistenteGerais.printTela ("dados pessoais 1" , navegador);
	
		WebElement valorCep = navegador.findElement(By.name("txtCep"));
		valorCep.sendKeys("20210030");

		Thread.sleep(8000);
		
		WebElement CepUm = navegador.findElement(By.name("txtNumero"));
		CepUm.click();

		WebElement valorNumero = navegador.findElement(By.id("txtNumero"));
		valorNumero.sendKeys("3131");

		WebElement valorComplemento = navegador.findElement(By.name("txtComplemento"));
		valorComplemento.sendKeys("4 andar");

		WebElement valorDdd = navegador.findElement(By.name("txtDDD"));
		valorDdd.sendKeys("21");

		WebElement valorTel = navegador.findElement(By.id("campotxtTel"));
		valorTel.sendKeys("25153676");

		WebElement valorTelCelDDD = navegador.findElement(By.id("txtDDDCelular"));
		valorTelCelDDD.sendKeys("21");

		WebElement valorTelCelNumero = navegador.findElement(By.id("campotxtCelular"));
		valorTelCelNumero.sendKeys("982025294");

		WebElement valorEmail = navegador.findElement(By.id("txtEmail"));
		valorEmail.sendKeys("teste@teste.com.br");

		WebElement campoOcupacaoAtual = navegador.findElement(By.name("cmbTpOcupacao"));
		Select selectcampoOcupacaoAtual = new Select(campoOcupacaoAtual);
		selectcampoOcupacaoAtual.selectByValue("ASSALARIADO COM CART ASSIN");
	
		WebElement valorCepProfissional = navegador.findElement(By.name("txtCepEmpresa"));
		valorCepProfissional.sendKeys("21820020");
		
		WebElement valornumeroempresa = navegador.findElement(By.name("txtNumeroEmpresa"));
		valornumeroempresa.click();
		
		Thread.sleep(8000);
		
		WebElement valorNumeroEmpresa = navegador.findElement(By.id("txtNumeroEmpresa"));
		valorNumeroEmpresa.sendKeys("3131");


		AssistenteGerais.printTela ("Referencias" , navegador);


		WebElement valorCPFVendedor = navegador.findElement(By.id("txtCodigoVendedor"));
		valorCPFVendedor.sendKeys("33262689637");

		WebElement valorNomeVendedor = navegador.findElement(By.id("txtNomeVendedor"));
		valorNomeVendedor.sendKeys("Teste de Hoje");

		AssistenteGerais.executarRolagem("300", navegador);
		
		Thread.sleep(3000);

		WebElement botaoEnviaTres = navegador.findElement(By.id("btnEnvia"));
		botaoEnviaTres.click();
		Thread.sleep(9000);
		AssistenteGerais.printTela ("resultado" , navegador);
		
		}	while (contador <1);
		navegador.quit();
			}

	}
			