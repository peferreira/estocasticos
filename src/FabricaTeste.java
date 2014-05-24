import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FabricaTeste {
	int tamanhoAlbum = 600, tamanhoPacotinho = 5;
	Fabrica fabrica;
	Album album;
	Pacotinho pacotinho;
	@Before
	public void setUp() throws Exception {
		fabrica = new Fabrica(tamanhoAlbum,tamanhoPacotinho);
		album = fabrica.novoAlbum();
		pacotinho = fabrica.novoPacotinho();
	}

	
	@Test
	public void testaTamanhoNovoAlbumEPacotinho() {
		assertTrue(album.getTamanho() == tamanhoAlbum);
		assertTrue(pacotinho.getTamanho() == tamanhoPacotinho);
	}

}
