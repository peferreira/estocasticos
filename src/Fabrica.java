import java.util.Random;

public class Fabrica {
	
	private int numFigurinhasAlbum, numFigurinhasPacote;
	Random rand;
	Fabrica(int numFigurinhasAlbum, int numFigurinhasPacote){
		this.numFigurinhasAlbum = numFigurinhasAlbum;
		this.numFigurinhasPacote = numFigurinhasPacote;
		rand = new Random(numFigurinhasAlbum);
	}
	
	public Album novoAlbum(){
		return (new Album(numFigurinhasAlbum));
	}
	
	public Pacotinho novoPacotinho(){
		return (new Pacotinho(numFigurinhasPacote));
	}
}
