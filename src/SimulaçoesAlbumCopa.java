public class SimulaçoesAlbumCopa {
	Colecionador[] colecionadores;

	public static void main(String[] args) {
		SimulaçoesAlbumCopa s = new SimulaçoesAlbumCopa();
		Fabrica f = new Fabrica(650, 5);
		Fabrica f2 = new Fabrica(650, 1);
		s.primeiraSimulacao(500, f);
		s.segundaSimulacao(500, f);
		s.primeiraSimulacao(500, f2);
	}

	/*
	 * Simulação proposta inicialmente, completando 1 album a partir de um
	 * determinado numero de figurinhas por pacotinhos, e o número de figurinhas
	 * necessárias para completar o album.
	 */
	public String calcularCusto(int numPacotinho, double valorPacotinho) {
		String custo = null;
		double valor = numPacotinho * valorPacotinho;
		int valorInteiro = (int) valor;
		custo = valorInteiro + "R$";
		return custo;
	}

	public void primeiraSimulacao(int n, Fabrica f) {
		int numPacotinhosTotais = 0, media = 0;
		double valorFigurinha = 0.2;
		for (int i = 0; i < n; i++) {
			numPacotinhosTotais = numPacotinhosTotais + completandoUmAlbum(f);
		}

		media = numPacotinhosTotais / n;
		double valorPacotinho = valorFigurinha * f.tamanhoPacotinho();
		System.out
				.println("Primeira Simulação: média do número de pacotinhos para completar 1 album: "
						+ media);
		System.out.println(calcularCusto(media, valorPacotinho));
	}

	int completandoUmAlbum(Fabrica f) {
		Colecionador c = new Colecionador(1);
		Pacotinho p;
		Album album = f.novoAlbum();
		c.setAlbum(album);
		int figurinha;
		while (!album.estaCompleto()) {
			p = f.novoPacotinho();
			c.incrementaPacotinhosComprados();
			for (int i = 0; i < p.getTamanho(); i++) {
				figurinha = p.getFigurinha(i);
				if (!album.figurinhaJaExisteNoAlbum(figurinha)) {
					album.colarFigurinha(figurinha);
				}
			}
		}
		if (!c.checaAlbumCompleto()) {
			System.out.println("album não foi completo");
		}
		return c.getNumPacotinhosComprados();
	}

	/*
	 * Fazer uma simulação do tempo de preenchimento de 5 álbuns com pacotes
	 * contendo 5 figurinhas, onde cada pacote aberto preenche os 5 álbuns da
	 * seguinte forma, a primeira figurinha do pacote vai para o primeiro álbum,
	 * a segunda figurinha vai para o segundo álbum
	 */
	public void segundaSimulacao(int n, Fabrica f) {
		int numPacotinhosTotais = 0, media = 0;
		int numDeColecionadores = f.tamanhoPacotinho();
		double valorFigurinha = 0.2;
		double valorPacotinho = valorFigurinha * f.tamanhoPacotinho();
		for (int i = 0; i < n; i++) {
			numPacotinhosTotais = numPacotinhosTotais
					+ completandoAlbum1ColecionadorPorFigurinhaNoPacotinho(f)
					/ numDeColecionadores;
		}

		media = numPacotinhosTotais / n;
		System.out
				.println("Segunda Simulação: média do número de pacotinhos para completar 1 album: "
						+ media);
		System.out.println(calcularCusto(media, valorPacotinho));

	}

	boolean todosAlbunsForamCompletados(Colecionador colecionadores[],
			int numColecionadores) {
		for (int i = 0; i < numColecionadores; i++) {
			if (!colecionadores[i].checaAlbumCompleto()) {
				// System.out.println("colecionador "+ i
				// +" não completou o album");
				return false;
			}
		}
		return true;
	}

	void inicializaColecionadores(Colecionador colecionadores[],
			int numColecionadores, Fabrica f) {
		for (int i = 0; i < numColecionadores; i++) {

			colecionadores[i] = new Colecionador(i);
			colecionadores[i].setAlbum(f.novoAlbum());
		}

	}

	boolean albumColecionadoresCompleto(Colecionador colecionadores[]) {
		for (int i = 0; i < colecionadores.length; i++) {
			if (!colecionadores[i].albumCompleto) {
				return false;
			}
		}
		return true;
	}

	int completandoAlbum1ColecionadorPorFigurinhaNoPacotinho(Fabrica f) {
		Album album;
		int numColecionadores = f.tamanhoPacotinho();
		Colecionador colecionadores[] = new Colecionador[numColecionadores];
		inicializaColecionadores(colecionadores, numColecionadores, f);
		Pacotinho p;
		int figurinha;
		while (!todosAlbunsForamCompletados(colecionadores, numColecionadores)) {
			p = f.novoPacotinho();
			for (int i = 0; i < p.getTamanho(); i++) {
				figurinha = p.getFigurinha(i);
				album = colecionadores[i].getAlbum();
				colecionadores[i].incrementaPacotinhosComprados();
				if (!album.figurinhaJaExisteNoAlbum(figurinha)) {
					album.colarFigurinha(figurinha);
				}

			}
		}
		albumColecionadoresCompleto(colecionadores);
		return colecionadores[0].getNumPacotinhosComprados();
	}

	/*
	 * Fazer uma simulação do tempo de preenchimento de 5 álbuns com pacotes
	 * contendo 5 figurinhas, onde cada pacote aberto preenche todos os álbuns
	 * de forma a otimizar o tempo de preenchimento dos álbuns.
	 */
	public void terceiraSimulação(Fabrica f) {

	}

	/*
	 * Calcula o número de pacotinhos necessários para se completar o album de 5
	 * colecionadoresonde em cada pacotinho tentamos otimizar para que tenhamos
	 * um numero maximo de figurinhascoladas
	 */
	int otimizandoAlbum1ColecionadorPorFigurinhaNoPacotinho(Fabrica f) {
		Album album;
		int numColecionadores = f.tamanhoPacotinho();
		Colecionador colecionadores[] = new Colecionador[numColecionadores];
		inicializaColecionadores(colecionadores, numColecionadores, f);
		Pacotinho p;
		int figurinha;
		while (!todosAlbunsForamCompletados(colecionadores, numColecionadores)) {
			p = f.novoPacotinho();
			for (int i = 0; i < p.getTamanho(); i++) {
				figurinha = p.getFigurinha(i);
				album = colecionadores[i].getAlbum();
				colecionadores[i].incrementaPacotinhosComprados();
				if (!album.figurinhaJaExisteNoAlbum(figurinha)) {
					album.colarFigurinha(figurinha);
				}
				for(int j = 0; j < p.getTamanho(); j++){
					if(j != i){
						if (!album.figurinhaJaExisteNoAlbum(figurinha)) {
							album.colarFigurinha(figurinha);
						}					
					}
				}

			}
		}
		albumColecionadoresCompleto(colecionadores);
		return colecionadores[0].getNumPacotinhosComprados();
	}

}
