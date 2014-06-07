public class Colecionador {
	private int numPacotinhosComprados;
	private String name;
	private Album album;
	boolean albumCompleto = false;

	
	Colecionador(int num) {
		this.name = "Colecionador " + num;
	}

	public String getName(){
		return name;
	}
	
	public void incrementaPacotinhosComprados() {
		numPacotinhosComprados++;
	}

	public int getNumPacotinhosComprados() {
		return numPacotinhosComprados;
	}

	public boolean checaAlbumCompleto() {
		boolean[] b = album.getVetorFigurinhasDoAlbum();
		albumCompleto = true;
		for (int i = 0; i < b.length; i++) {
			if (!b[i]) {
				//System.out.println("não possui a figurinha" + i);
				albumCompleto = false;
			}
		}
		return albumCompleto;
	}

	public void setAlbum(Album newAlbum) {
		album = newAlbum;
	}

	public Album getAlbum() {
		return album;
	}

}
