import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class HypergeometricaTest {
	Hypergeometrica h;
	
	@Before
	public void setUp() throws Exception {
		h = new Hypergeometrica();
	}

	@Test
	public void testaCombinatoria() {
		assertTrue(h.combinatoria3(5, 5) == 1);
		assertTrue(h.combinatoria3(10, 5) == 252);
		assertTrue(h.combinatoria3(6, 5) == 6);
		
	}
	@Test
	public void testaFuncaoDensidade(){
		double p = h.funcaoDensidade(5, 650, 50 , 1);
		p = h.funcaoDensidade(5, 650, 645 , 0);
		assertTrue(Math.abs(p - 0.000105029) < 0.001);
		System.out.println(h.funcaoDensidade(5, 649, 1 , 1));
	}
	
}
