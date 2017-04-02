package uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo;

import java.util.ArrayList;

/**
 * Realiza calculos matematicos estandar para servicio de toda la aplicacion.
 * @author WALONSO
 *
 */
public final class UtilidadCalculo {
	
	/**
	 * Calcula el promedio de un conjunto de datos.
	 * Precondicion: hay minimo un valor en la lista
	 * @param valoresPromediar: la lista que se va a promediar
	 * @return el promedio de los valores
	 */
	public static double darPromedio(ArrayList<Double> valoresPromediar) {
		double sumaValores = 0;	
		int cantidadDatos = valoresPromediar.size();
		
		if(cantidadDatos == 1) {
			return valoresPromediar.get(0);
		}
		
		for (int indice=0; indice < cantidadDatos; indice++) {
			sumaValores += valoresPromediar.get(indice);
		}
		return sumaValores / cantidadDatos;
	}
	
	/**
	 * Calcula la sumatoria de los datos.
	 * @param valoresSumar: la lista que se va a sumar
	 * @return la sumatoria de los valores
	 */
	public static double darSumatoria(ArrayList<Double> valoresSumar) {
		double sumaValores = 0;	
		int cantidadDatos = valoresSumar.size();
		
		if(cantidadDatos == 1) {
			return valoresSumar.get(0);
		}
		
		for (int indice=0; indice < cantidadDatos; indice++) {
			sumaValores += valoresSumar.get(indice);
		}
		return sumaValores;
	}
	
	/**
	 * Calcula la sumatoria de los datos multiplicados.
	 * Precondicion: la cantidad de valores es la misma
	 * @param primeraLista: lista de los primeros datos a calcular
	 * @param segundaLista: lista de los segundos datos a calcular
	 * @return la suma de la multiplicacion de cada dato en cada lista
	 */
	public static double darSumatoriaFactores(ArrayList<Double> primeraLista, ArrayList<Double> segundaLista) {
		double sumaValores = 0;	
		int cantidadDatos = primeraLista.size();
		
		for (int indice=0; indice < cantidadDatos; indice++) {			
			sumaValores += (primeraLista.get(indice) * segundaLista.get(indice));
		}
		return sumaValores;
	}
	
	/**
	 * Calcula la sumatoria al cuadrado de los datos.
	 * @param valoresSumar: la lista de los valores a sumar al cuadrado
	 * @return el valor de la suma a cuadrado
	 */
	public static double darSumatoriaCuadrada(ArrayList<Double> valoresSumar) {
		double sumaValores = 0;	
		int cantidadDatos = valoresSumar.size();
		
		for (int indice=0; indice < cantidadDatos; indice++) {			
			sumaValores += (Math.pow(valoresSumar.get(indice), 2));
		}
		return sumaValores;
	}
	
	/**
	 * Calcula la division de valores entre 2 listas
	 * @param primerLista: la primera lista a realizar la operacion
	 * @param segundaLista: la segunda lista a realizar la operacion.
	 * @return una nueva lista con los datos dividos.
	 */
	public static ArrayList<Double> darDivision(ArrayList<Double> primerLista, ArrayList<Double> segundaLista) {
		ArrayList<Double> valores = new ArrayList<Double>(); 
		int cantidadDatos = primerLista.size();
		
		for (int indice=0; indice < cantidadDatos; indice++) {
			double primerValor = primerLista.get(indice);
			double segundoValor = segundaLista.get(indice);
			valores.add(primerValor / segundoValor);			
		}
		return valores;
	}
	
	/**
	 * Calculo el logaritmo natural de cada uno de los valores de una lista
	 * @param listaDatos: los datos a procesar
	 * @return lista con los datos calculados en logaritmo neperiano
	 */
	public static ArrayList<Double> darLogaritmoNatural(ArrayList<Double> listaDatos) {
		ArrayList<Double> valores = new ArrayList<Double>(); 
		int cantidadDatos = listaDatos.size();
		
		for (int indice=0; indice < cantidadDatos; indice++) {
			double valor = listaDatos.get(indice);			
			valores.add(Math.log(valor));			
		}
		return valores;
	}
	
	/**
	 * Calcula la resta de los valores de la  lista segun otro valor 
	 * @param listaDatos: la lista de datos a procesar.
	 * @param valor: el dato segun el cual se hara el calculo
	 * @return la lista de datos transformados.
	 */
	public static ArrayList<Double> darRestaSegunValor(ArrayList<Double> listaDatos, double valor) {
		ArrayList<Double> valores = new ArrayList<Double>(); 
		int cantidadDatos = listaDatos.size();
		
		for (int indice=0; indice < cantidadDatos; indice++) {
			double valorLista = listaDatos.get(indice);			
			valores.add(valorLista - valor);			
		}
		return valores;
	}
	
	/**
	 * Calula el exponencial de un valor, inverso al logaritmo neperiano
	 * @param valor: el valor a ser procesado
	 * @return el valor resultante.
	 */
	public static double darExponencialInversoNeperiano(double valor) {
		return Math.pow(Math.E, valor);
	}
	
	/**
	 * Calcula el valor factorial de valores decimales.
	 * @param valorDesde : el valor desde el cual se comienza a calcular.
	 * @param valorHasta : el valor hasta el cual se deja de procesar.
	 * @return el valor factorial calculado.
	 */
	public static double darFactorial(double valorDesde, double valorHasta) {
		if (valorDesde <= valorHasta)
            return valorHasta;
        else
            return valorDesde * darFactorial(valorDesde - 1, valorHasta);
	}
	
	/**
	 * Calcula el valor factorial de valores enteros.
	 * @param valorDesde : el valor desde el cual se comienza a calcular.
	 * @param valorHasta : el valor hasta el cual se deja de procesar.
	 * @return el valor factorial calculado.
	 */
	public static double darFactorial(int valorDesde, int valorHasta) {
		if (valorDesde <= valorHasta)
            return valorHasta;
        else
            return valorDesde * darFactorial(valorDesde - 1, valorHasta);
	}	
}
