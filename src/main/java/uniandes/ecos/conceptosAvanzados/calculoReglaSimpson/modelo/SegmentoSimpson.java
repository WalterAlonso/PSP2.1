package uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo;

/**
 * Representa cada segmento partido en la regla Simpson, el cual realiza operaciones
 * pertinentes a cada segmento.
 * @author WALONSO
 *
 */
public class SegmentoSimpson {
	
	private double valorSegmento;	
	private double anchoSegmento;
	private int multiplicador;
	private IMetodoDistribucionSimetrica metodoDistribucionSimetrica;
	private double valorFuncion; 
	
	/**
	 * Ctor del segmento en regla Simpson
	 * @param valorSegmento : el valor del segmento.
	 * @param anchoSegmento : el ancho del segmento
	 * @param multiplicador : el factor de multiplicacion.
	 * @param metodoDistribucionSimetrica : el metodo de distribucion para el calculo.
	 */
	public SegmentoSimpson(double valorSegmento, double anchoSegmento, 
		int multiplicador, IMetodoDistribucionSimetrica metodoDistribucionSimetrica) {	
		this.valorSegmento = valorSegmento;
		this.anchoSegmento = anchoSegmento;
		this.multiplicador = multiplicador;
		this.metodoDistribucionSimetrica = metodoDistribucionSimetrica;
	}
	
	/**
	 * Da el calculo de la distribucion.
	 */
	public void calcular() {
		double valorDistribucion = metodoDistribucionSimetrica.darCalculo(this.valorSegmento);
		this.valorFuncion = (this.anchoSegmento / 3.0) * this.multiplicador * valorDistribucion; 
	}
	
	/**
	 * Da el valor de la distribucion.
	 * @return el valor de la distribucion.
	 */
	public double darValorFuncion() {
		return this.valorFuncion;
	}
}
