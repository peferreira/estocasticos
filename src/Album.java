public class Album {
	int tamanho;
	int numFigurinhasColadas;
	boolean vetorFigurinhasColadas[];
	
	Album(int tamanho){
		this.tamanho = tamanho;
		vetorFigurinhasColadas = new boolean[tamanho];
	}
	
	public int getTamanho(){
		return this.tamanho;
	}
	
	public boolean []getVetorFigurinhasDoAlbum(){
		return vetorFigurinhasColadas;
	}
	public void colarFigurinha(int numFigurinha){
		vetorFigurinhasColadas[numFigurinha] = true;
		numFigurinhasColadas++;
	}
	
	boolean estaCompleto(){
		if(numFigurinhasColadas >= tamanho){
			return true;
		}
		return false;
	}
	public boolean figurinhaJaExisteNoAlbum(int numFigurinha){
		if(vetorFigurinhasColadas[numFigurinha]){
			return true;
		}
		else
			return false;
	}
	
	
}
