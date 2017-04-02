package uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo;

/**
 * Modelo de lo que posee ReglaSimpson y se comparte enre capas de presentacion y modelo.
 * @author WALONSO
 *
 */
public class ModelViewReglaSimpson {
	
	private double rangoFinal;
	private int dof;
	private double valorEsperado;
	private double valorCalculado;
	
	/**
	 * Tiene el rango final para calcular los segmentos.
	 * @return el rango final
	 */
	public double darRangoFinal() {
		return rangoFinal;
	}
	
	/**
	 * Asigna el rango final
	 * @param rangoFinal: el rango final calculado segun segmentos.
	 */
	public void asignarRangoFinal(double rangoFinal) {
		this.rangoFinal = rangoFinal;
	}
	
	/**
	 * Da el dof de la distribucion T
	 * @return el dof de la distribucion T 
	 */
	public int darDof() {
		return dof;
	}
	
	/**
	 * Asigna el dof de la distribucion T
	 * @param dof : segun la distribucion T retorna el dof
	 */
	public void asignarDof(int dof) {
		this.dof = dof;
	}
	
	/**
	 * El valor esperado, segun el archivo.
	 * @return el valor esperado del archivo.
	 */
	public double darValorEsperado() {
		return this.valorEsperado;
	}
	
	/**
	 * Asigna el valor esperado.
	 * @param valorEsperado: el valor esperado del proceso.
	 */
	public void asignarValorEsperado(double valorEsperado) {
		this.valorEsperado = valorEsperado;
	}
	
	/**
	 * da el valor calculado del programa de la regla simpson
	 * @return el valor calculado del programa de la regla simpson
	 */
	public double darValorCalculado() {
		return this.valorCalculado;
	}
	
	/**
	 * Asigna el valor calculado de regla Simpson
	 * @param valorCalculado : contiene el valor calculado del programa.
	 */
	public void asignarValorCalculado(double valorCalculado) {
		this.valorCalculado = valorCalculado;
	}
	
}
