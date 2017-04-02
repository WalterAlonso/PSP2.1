package uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo;

/**
 * Interface que representa los metodos de distrbucion simetrica.
 * @author WALONSO
 *
 */
public interface IMetodoDistribucionSimetrica {
	
	/**
	 * Realiza el calculo propio del metodo de distibucion simetrica.
	 * @param segmento : el segmento que se esta validando
	 * @return el calculo del segmento que se esta procesando.
	 */
	public double darCalculo(double segmento);
}
