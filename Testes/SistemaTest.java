import static org.junit.Assert.*;
import org.junit.*;
import controllers.Sistema;

public class SistemaTest {
	Sistema s1;
	
	@Before
	public void iniciar() {
		s1 = new Sistema();
		s1.cadastrarCenario("Refrigerante da cancer");
	}
	
	@Test
	public void cadastraCenarioTest() {
		assertTrue(s1.cadastrarCenario("Mateus vai passar em discreta")== 2);
	}

	@Test
	public void exibirCenarioTest() {
		assertTrue(s1.exibirCenario(1).equals("1 - Refrigerante da cancer - Nao finalizado"));
	}
	
	@Test
	public void fecharApostaTest() {
		s1.fecharAposta(1, true);
	}

}
