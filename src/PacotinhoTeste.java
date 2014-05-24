import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PacotinhoTeste {
	int tamanhoAlbum = 600, tamanhoPacotinho = 5;
	Fabrica fabrica;
	Album album;
	Pacotinho pacotinho;
	@Before
	public void setUp() throws Exception {
		fabrica = new Fabrica(tamanhoAlbum,tamanhoPacotinho);
		pacotinho = fabrica.novoPacotinho();
	}

	
	@Test
	public void testaSeFigurinhaJaExisteNoPacotinho() {
		pacotinho.adicionaFigurinha(10);
		pacotinho.adicionaFigurinha(320);
		assertTrue(pacotinho.figurinhaJaExisteNoPacotinho(10));
		assertTrue(pacotinho.figurinhaJaExisteNoPacotinho(320));
	}
	
	@Test
	public void testaAdicionaFigurinhas(){
		int figurinhas[] = {100,200,300,400,500};
		for(int i = 0; i < pacotinho.getTamanho(); i++){
			assertTrue(pacotinho.adicionaFigurinha(figurinhas[i]));
		}
		for(int i = 0; i < pacotinho.getTamanho(); i++){
			assertFalse(pacotinho.adicionaFigurinha(figurinhas[i]));
		}
	}
	

}
