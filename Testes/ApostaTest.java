import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import models.Aposta;

public class ApostaTest {
	Aposta a1;
	Aposta a3;
	Aposta a2;
	
	@Before
	public void iniciar() {
		a1 = new Aposta("Mateus Lima", 2000 , "VAI ACONTECER");
		a2 = new Aposta("Mateus Lima", 2000 , "VAI ACONTECER");
		a3 = new Aposta("Mateus Lima", 200 , "VAI ACONTECER");
	}
	
	@Test
	public void cadastrarAposta() {
		a2 = new Aposta("Mateus de Lima", 200,"VAI ACONTECER");
	}
	
	@Test(expected = NullPointerException.class)
	public void cadastrarNomeNulo() {
		a2 = new Aposta(null, 200,"VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarNomeVazio() {
		a2 = new Aposta("", 200,"VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarValorZero() {
		a2 = new Aposta("Mateus", 0,"VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarValorNegativo() {
		a2 = new Aposta("Mateus", -1,"VAI ACONTECER");
	}

	@Test(expected = NullPointerException.class)
	public void cadastrarPrevisaoNula() {
		a2 = new Aposta("Mateus de Lima", 200,null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarPrevisaoVazia() {
		a2 = new Aposta("Mateus Lima", 200,"");
	}
	
	@Test
	public void equals() {
		assertTrue(a1.equals(a2));
	}
	
	@Test
	public void diferentes() {
		assertFalse(a2.equals(a3));
	}
	
	@Test
	public void toStringTest() {
		assertEquals("Mateus Lima - R$20,00 - VAI ACONTECER\n" , a2.toString());
	}


}
