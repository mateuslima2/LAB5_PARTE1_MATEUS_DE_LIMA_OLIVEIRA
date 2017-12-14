import static org.junit.Assert.*;
import org.junit.*;

import models.Aposta;
import models.Cenario;

public class CenarioTest {
	Cenario c1;
	Cenario c2;
	Cenario c3;

	
	@Before
	public void iniciar() {
		c1 = new Cenario("Mateus vai passar em discreta");
		c2 = new Cenario("A minoria da turma vai passar em discreta");
		c3 = new Cenario("Mateus vai passar em discreta");
		c1.cadAposta(new Aposta("Mateus", 200, "VAI ACONTECER"));
	}
	
	@Test
	public void criarCenario() {
		c3 = new Cenario("Café faz mal para a saude");
	}
	
	@Test(expected = NullPointerException.class)
	public void criarCenarioNulo() {
		c3 = new Cenario(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cirarCenarioVazio() {
		c3 = new Cenario("");
	}
	
	@Test(expected = NullPointerException.class)
	public void cadastrarApostaNula() {
		c3 = new Cenario(null);
	}
	
	@Test
	public void cadastrarAposta() {
		c1.cadAposta(new Aposta("Mateus", 200, "VAI ACONTECER"));
	}
	
	@Test
	public void exibeApostasDeCenario() {
		assertEquals("Mateus - R$2,00 - VAI ACONTECER\n",c1.exibeApostas());
	}
	
	@Test
	public void cenariosIguais() {
		assertEquals(c3,c1);
	}
	
	@Test
	public void cenariosDiferentes() {
		assertFalse(c3.equals(c2));
	}
	
	@Test
	public void toStringTest() {
		assertEquals(" - Mateus vai passar em discreta - Nao finalizado",c1.toString());
	}
	


}
