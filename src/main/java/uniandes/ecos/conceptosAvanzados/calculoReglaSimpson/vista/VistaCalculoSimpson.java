package uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.vista;

import java.util.ArrayList;

import uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo.ModelViewReglaSimpson;

/**
 * Se encarga de desplegar el modelo de Regla Simpson
 * @author WALONSO
 *
 */
public class VistaCalculoSimpson extends Vista {

	private ArrayList<ModelViewReglaSimpson> listaCalculosReglaSimpson;  
	
	/**
	 * Asigna los modelos Simpson a la vista
	 * @param modelosSimpson : los calculos de los datos del archivo
	 */
	public void asignarModeloSimpson(ArrayList<ModelViewReglaSimpson> modelosSimpson) {
		this.listaCalculosReglaSimpson = modelosSimpson;
	}
	
	/**
	 * muestra los calculos de la regla simpson
	 */
	public void mostrarCalculosReglaSimpson() {
		for (int indice = 0; indice < listaCalculosReglaSimpson.size(); indice++) {
			System.out.println("");
			ModelViewReglaSimpson reglaSimpson = listaCalculosReglaSimpson.get(indice);
			mostrarDatos("x (Rango Final)", "0 to X = " + Double.toString(reglaSimpson.darRangoFinal()));
			mostrarDatos("dof", Integer.toString(reglaSimpson.darDof()));
			mostrarDatos("Expected value - P", Double.toString(reglaSimpson.darValorEsperado()));
			mostrarDatos("Actual value", Double.toString(reglaSimpson.darValorCalculado()));
		}
	}
}
