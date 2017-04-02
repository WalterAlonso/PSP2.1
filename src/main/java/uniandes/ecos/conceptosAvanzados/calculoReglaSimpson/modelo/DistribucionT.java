package uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo;

/**
 * Representa a la funcion simetrica de distribucionT, el cual tiene sus operaciones
 * propias de calculo.
 * @author WALONSO
 *
 */
public class DistribucionT implements IMetodoDistribucionSimetrica {
	
	private int dof;
	
	private static DistribucionT INSTANCE = null;
			 
	private DistribucionT(){		
	}

	private synchronized static void createInstance() {
	    if (INSTANCE == null) { 
	        INSTANCE = new DistribucionT();
	    }
	}
	
	/**
	 * Devuelve instancia unica de DistribucionT
	 * @return la instancia de DistribucionT
	 */
	public static DistribucionT getInstance() {
	    if (INSTANCE == null) {
	    	createInstance();
	    }
	    return INSTANCE;
	}
	
	/**
	 * Asigna dof
	 * @param dof : el parametro dof para realizar los calculos.
	 */
	public void asignarDof(int dof) {
		this.dof = dof;
	}
	
	private double darCalculoGamma() {
		double numeradorGammaAProcesar = ((this.dof + 1)/2.0);
		double factorialGamma = 0;
		if(this.esValorEntero(numeradorGammaAProcesar)) {				
			factorialGamma = UtilidadCalculo.darFactorial(numeradorGammaAProcesar-1, 1);
		}
		else {
			factorialGamma = UtilidadCalculo.darFactorial(numeradorGammaAProcesar-1, 0.5);
			factorialGamma *= Math.sqrt(Math.PI); 
		}
		
		double valorFactorialDof = this.dof / 2.0;
		double factorialDof = 0;
		if (this.esValorEntero(valorFactorialDof)) {
			factorialDof = UtilidadCalculo.darFactorial(valorFactorialDof-1, 1);
		}
		else {
			factorialDof = UtilidadCalculo.darFactorial(valorFactorialDof-1, 0.5);
			factorialDof *= Math.sqrt(Math.PI);
		}	
		
		double denominador = Math.pow((this.dof * Math.PI), (0.5));
		denominador = denominador * factorialDof;
		
		return factorialGamma / denominador;
	}
	
	/**
	 * Realiza los calculos de Distribucion T.
	 * @param segmento : el segmento que se esta calculando.
	 */
	public double darCalculo(double segmento) {
		double funcionGamma = this.darCalculoGamma();
				
		double potenciaRestaDof = -((this.dof + 1)/2.0);
		double segundaParteFuncion = (1 + (Math.pow(segmento, 2)/this.dof));		
		segundaParteFuncion = Math.pow(segundaParteFuncion, potenciaRestaDof);
		
		return funcionGamma * segundaParteFuncion;
	}
	
	private boolean esValorEntero(double valor) {
		 if (valor % 1 == 0) {
			 return true;
		 }
		 return false;
	}
	
}



