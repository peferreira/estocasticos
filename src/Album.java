public class Album {
	int tamanho;
	Boolean vetorFigurinhasColadas[];
	
	Album(int tamanho){
		this.tamanho = tamanho;
		vetorFigurinhasColadas = new Boolean[tamanho];
	}
	
	public int getTamanho(){
		return this.tamanho;
	}
	
	public void colarFigurinha(int numFigurinha){
		vetorFigurinhasColadas[numFigurinha] = true;
	}
	
	public boolean figurinhaJaExisteNoAlbum(int numFigurinha){
		if(vetorFigurinhasColadas[numFigurinha]){
			return true;
		}
		else
			return false;
	}
	
	
}
