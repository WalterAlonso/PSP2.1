package uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo;

import java.util.ArrayList;

/**
 * Clase que se encarga de realizar las operaciones referentes a la regla Simpson.
 * @author WALONSO
 *
 */
public class ReglaSimpson {
	
	private static ReglaSimpson INSTANCE = null;
	
	private int numeroSegmentos;
	
	private double errorAceptable;
		 
	private ReglaSimpson(){		
	}

	private synchronized static void createInstance() {
	    if (INSTANCE == null) { 
	        INSTANCE = new ReglaSimpson();
	    }
	}
	
	/**
	 * Devuelve instancia unica de Regla Simpson.
	 * @return la instancia de Regla Simpson.
	 */
	public static ReglaSimpson getInstance() {
	    if (INSTANCE == null) {
	    	createInstance();
	    }
	    return INSTANCE;
	}
	
	/**
	 * Asigna el vaor del error aceptable.
	 * @param errorAceptable : valor del error aceptable.
	 */
	public void asignarErrorAceptable(double errorAceptable) {
		this.errorAceptable = errorAceptable;
	}
	
	/**
	 * Asigna el valor de numeros de segmentos
	 * @param numeroSegmentos : numero de segmentos el cual partir 
	 */
	public void asignarNumeroSegmentos(int numeroSegmentos) {
		this.numeroSegmentos = numeroSegmentos;
	}
	
	/**
	 * devuelve el ancho de los segmentos 
	 * @param rangoFinal : el rango final de los segmentos a analizar.
	 * @return el ancho de los segmentos.
	 */
	private double  darAnchoSegmento(double rangoFinal) {
		return rangoFinal / this.numeroSegmentos;
	}
	
	/**
	 * Realiza el calculo de la regla Simpson.
	 * @param rangoFinal : valor del rango final para el metodo Simpson.
	 * @param metodoDistribucionSimetrica: metodo de la funcion simetrica.
	 * @return el calculo de la regla Simpson.
	 */
	public double darCalculo(double rangoFinal, IMetodoDistribucionSimetrica metodoDistribucionSimetrica) {
		boolean esAceptableElError = false;
		int iteraciones = 0;
		double valorCalculoAnterior = 0;	
		double valorSimpson = 0;
		while (!esAceptableElError) {
			iteraciones += 1;
			double valorCalculoActual = 0;			
			ArrayList<SegmentoSimpson> segmentos = darSegmentosSimpson(rangoFinal, metodoDistribucionSimetrica);
			for (int indice = 0; indice < segmentos.size(); indice ++) {
				valorCalculoActual += segmentos.get(indice).darValorFuncion();
			}			
			
			if (iteraciones > 1) {
				if (Math.abs(valorCalculoAnterior - valorCalculoActual) < this.errorAceptable) {
					valorSimpson = valorCalculoActual;
					esAceptableElError = true;
				}
			}
			this.numeroSegmentos *=2;	
			valorCalculoAnterior = valorCalculoActual;
		}
		return valorSimpson;
	}
	
	private ArrayList<SegmentoSimpson> darSegmentosSimpson(double rangoFinal, IMetodoDistribucionSimetrica metodoDistribucionSimetrica) {
		double anchoSegmento = darAnchoSegmento(rangoFinal);
		double valorSegmento = 0;	
		ArrayList<SegmentoSimpson> segmentos = new ArrayList<SegmentoSimpson>();
		for (int indice = 0; indice <= this.numeroSegmentos; indice ++) {
			int multiplicador = 4;
			if (indice == 0 || indice == this.numeroSegmentos) {
				multiplicador = 1;
			}
			else if (indice % 2 == 0) {
				multiplicador = 2;
			}
			
			SegmentoSimpson segmento = new SegmentoSimpson(valorSegmento, anchoSegmento, multiplicador, metodoDistribucionSimetrica);
			segmento.calcular();
			segmentos.add(segmento);			
			valorSegmento += anchoSegmento;
		}
		return segmentos;
	}	
}