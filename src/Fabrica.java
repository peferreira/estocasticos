import java.util.Random;

public class Fabrica {

	private int numFigurinhasAlbum, numFigurinhasPacote;
	private Random rand;

	/* numero de figurinhas e numero de pacotinhos */
	Fabrica(int numFigurinhasAlbum, int numFigurinhasPacote) {
		this.numFigurinhasAlbum = numFigurinhasAlbum;
		this.numFigurinhasPacote = numFigurinhasPacote;
		rand = new Random();
	}

	public Album novoAlbum() {
		return (new Album(numFigurinhasAlbum));
	}
	/*inicializo com -1 para poder existir a figurinha 0*/
	public Pacotinho novoPacotinho() {
		Pacotinho p = new Pacotinho(numFigurinhasPacote);
		p.inicializaPacotinho(-1);
		while (!p.estaCheio()) {
			int figurinha = rand.nextInt(numFigurinhasAlbum);
			p.adicionaFigurinha(figurinha);
			
		}
		return (p);
	}
	
	public int tamanhoAlbum(){
		return numFigurinhasAlbum;
	}
	public int tamanhoPacotinho(){
		return numFigurinhasPacote;
	}
}
