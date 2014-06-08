public class SimulacoesAlbumCopa {
	Colecionador[] colecionadores;

	public static void main(String[] args) {
		SimulacoesAlbumCopa s = new SimulacoesAlbumCopa();
		s.simulacao();
	}

	void simulacao(){
		Fabrica f = new Fabrica(650, 5);
		Fabrica f2 = new Fabrica(650, 1);
		GeradorDeGraficos g = new GeradorDeGraficos();
		/* simulação normal do album */
		g.criaHistograma(primeiraSimulacao(10000, f));

		/* igual a primeira mas utiliza 1 figurinha por pacotinho */
		g.criaHistograma(primeiraSimulacao(10000, f2));

		g.criaHistograma(segundaSimulacao(1000, f));
		g.criaHistograma(terceiraSimulação(1000, f));
		tempoEsperado();
		
	}
	
	public String calcularCusto(int numPacotinho, double valorPacotinho) {
		String custo = null;
		double valor = numPacotinho * valorPacotinho;
		int valorInteiro = (int) valor;
		custo = valorInteiro + "R$";
		return custo;
	}

	/*
	 * Simulação proposta inicialmente, completando 1 album a partir de um
	 * determinado numero de figurinhas por pacotinhos, e o número de figurinhas
	 * necessárias para completar o album.
	 */
	public double[] primeiraSimulacao(int n, Fabrica f) {
		int numPacotinhosTotais = 0, media = 0;
		double valorFigurinha = 0.2;
		double vetorAmostras[] = new double[n];
		int numPacotinhos;
		for (int i = 0; i < n; i++) {
			
			numPacotinhos = completandoUmAlbum(f);

			numPacotinhosTotais = numPacotinhosTotais + numPacotinhos;
			vetorAmostras[i] = numPacotinhos;
;
		}

		
		
		media = numPacotinhosTotais / n;
		double valorPacotinho = valorFigurinha * f.tamanhoPacotinho();
		System.out
				.println("Primeira Simulação: média do número de pacotinhos para completar 1 album: "
						+ media);
		System.out.println(calcularCusto(media, valorPacotinho));
		return vetorAmostras;
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
	public double[] segundaSimulacao(int n, Fabrica f) {
		int numPacotinhosTotais = 0, media = 0;
		int numDeColecionadores = f.tamanhoPacotinho();
		double valorFigurinha = 0.2;
		double valorPacotinho = valorFigurinha * f.tamanhoPacotinho();
		double vetorAmostras[] = new double[n];
		int amostra;
		for (int i = 0; i < n; i++) {
			
			amostra = completandoAlbum1ColecionadorPorFigurinhaNoPacotinho(f);
			numPacotinhosTotais = numPacotinhosTotais
					+ amostra
					/ numDeColecionadores;
			vetorAmostras[i] = amostra;
		}
		media = numPacotinhosTotais / n;
		System.out
				.println("Segunda Simulação: média do número de pacotinhos para completar 5 albuns: "
						+ media);
		System.out.println(calcularCusto(media, valorPacotinho));
		return vetorAmostras;
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

	public int completandoAlbum1ColecionadorPorFigurinhaNoPacotinho(Fabrica f) {
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
	public double[] terceiraSimulação(int n, Fabrica f) {
		int numPacotinhosTotais = 0, media = 0;
		int numDeColecionadores = f.tamanhoPacotinho();
		double valorFigurinha = 0.2;
		double valorPacotinho = valorFigurinha * f.tamanhoPacotinho();
		double vetorAmostras[] = new double[n];
		int amostra;
		for (int i = 0; i < n; i++) {
			amostra = otimizandoAlbum1ColecionadorPorFigurinhaNoPacotinho(f);
			numPacotinhosTotais = numPacotinhosTotais
					+ amostra
					/ numDeColecionadores;
			vetorAmostras[i] = amostra;
		}

		media = numPacotinhosTotais / n;
		System.out
				.println("Terceira Simulação: média do número de pacotinhos para completar 5 albuns de forma otimizada: "
						+ media);
		System.out.println(calcularCusto(media, valorPacotinho));
		return vetorAmostras;
	}

	/*
	 * Calcula o número de pacotinhos necessários para se completar o album de 5
	 * colecionadores onde em cada pacotinho tentamos otimizar para que tenhamos
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
				} else {
					for (int j = 0; j < p.getTamanho(); j++) {
						if (j != i) {
							album = colecionadores[j].getAlbum();
							if (!album.figurinhaJaExisteNoAlbum(figurinha)) {
								album.colarFigurinha(figurinha);
							}
						}
					}
				}
			}
		}
		albumColecionadoresCompleto(colecionadores);
		return colecionadores[0].getNumPacotinhosComprados();
	}

	/*
	 * Encontrar o tempo esperado do preenchimento do álbum utilizando "Law of
	 * Total Expectation"
	 */
	void tempoEsperado() {
		Hypergeometrica h = new Hypergeometrica();
		double prob = 0;
		int tamanhoAlbum = 649, tamanhoPacotinho = 5;
		double[] tempoEsperado = new double[tamanhoAlbum + 1];
		tempoEsperado[649] = 0;
		for (int i = tamanhoAlbum - 1; i > 0; i--) {
			prob = h.funcaoDensidade(tamanhoPacotinho, tamanhoAlbum,
					tamanhoAlbum - i, 0);
			tempoEsperado[i] = prob / (1 - prob);
			for (int j = 1; j <= tamanhoPacotinho; j++) {
				if (i + j <= tamanhoAlbum) {
					tempoEsperado[i] = tempoEsperado[i]
							+ (1 + tempoEsperado[i + j])
							* h.funcaoDensidade(tamanhoPacotinho, tamanhoAlbum,
									tamanhoAlbum - i, j) / (1 - prob);
				}
			}
		}
		System.out.println("Tempo esperado: " + tempoEsperado[1]);

	}
}
