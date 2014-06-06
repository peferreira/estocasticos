public class Colecionador {
	static int numColecionadores;
	int numPacotinhosComprados;
	String name;
	Album album;

	/*
	 * Colecionador(){ numColecionadores++; this.name = "Colecionador" +
	 * numColecionadores; }
	 */
	public static void main(String[] args) {
		Colecionador c = new Colecionador();
		Fabrica f = new Fabrica(650, 5);
		Album a = f.novoAlbum();
		c.setAlbum(a);
		c.testeCompletandoAlbum(f);
		c.checaAlbumCompleto(a);
	}

	void testeCompletandoAlbum(Fabrica f) {

		Pacotinho p;
		int figurinha;
		while (!album.estaCompleto()) {
			p = f.novoPacotinho();
			numPacotinhosComprados++;
			for (int i = 0; i < p.getTamanho(); i++) {
				figurinha = p.getFigurinha(i);

				if (!album.figurinhaJaExisteNoAlbum(figurinha)) {
					album.colarFigurinha(figurinha);
				}
			}
		}
		System.out.println("num pacotinhos comprados= "
				+ numPacotinhosComprados);
	}

	void checaAlbumCompleto(Album a) {
		boolean[] b = a.getVetorFigurinhasDoAlbum();
		for (int i = 0; i < b.length; i++) {
			if (!b[i]) {
				System.out.println("não possui a figurinha" + i);
			}
		}
		System.out.println("num de figurinhas coladas no album"
				+ a.numFigurinhasColadas);
	}

	public void setAlbum(Album newAlbum) {
		album = newAlbum;
	}

	public Album getAlbum() {
		return album;
	}

	public void compraPacotinho() {

	}

}
