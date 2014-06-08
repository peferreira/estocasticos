public class Hypergeometrica {

	public double funcaoDensidade(int n, int N, int K, int x) {
		double densidade = 0;

		double espacoAmostral = combinatoria3(N, n);
		double evento1 = combinatoria3(K, x);
		double evento2 = combinatoria3(N - K, n - x);

		densidade = evento1 * evento2 / espacoAmostral;
		return densidade;
	}



	double combinatoria2(int N, int K) {
		double resultado = 1;
		if (K == N)
			return resultado;
		else {
			resultado = resultado * (K + 1) * combinatoria2(N, K + 1) / (N - K);
		}
		return resultado;
	}
	
	double combinatoria3(int N,int K){
		double resultado = 1;
		
		for(int i = 0; i < K; i++){
			resultado = resultado*(N-i)/(i+1);
		}
		return resultado;
	}
	
}
