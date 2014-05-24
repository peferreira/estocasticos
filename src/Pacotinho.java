public class Pacotinho {
	private int numMaxFigurinhas;
	private int numFigurinhas;
	private int vetorFigurinhas[];

	Pacotinho(int numMaxFigurinhas) {
		this.numFigurinhas = 0;
		this.numMaxFigurinhas = numMaxFigurinhas;
		this.vetorFigurinhas = new int[numMaxFigurinhas];
	}

	boolean adicionaFigurinha(int numDaFigurinha) {
		if (checaExistenciaFigurinhaNoPacotinho(numDaFigurinha) == false) {
			if (numMaxFigurinhas - numFigurinhas > 0) {
				vetorFigurinhas[numFigurinhas] = numDaFigurinha;
				numFigurinhas++;
				return true;
			} else
				return false;
		}
		return false;
	}

	private boolean checaExistenciaFigurinhaNoPacotinho(int numFigurinha) {
		for (int i = 0; i < numMaxFigurinhas; i++) {
			if (numFigurinha == vetorFigurinhas[i]) {
				return true;
			}
		}
		return false;
	}

	public int getTamanho() {
		return numMaxFigurinhas;
	}

	public boolean figurinhaJaExisteNoPacotinho(int numFigurinha) {
		return checaExistenciaFigurinhaNoPacotinho(numFigurinha);
	}
}
