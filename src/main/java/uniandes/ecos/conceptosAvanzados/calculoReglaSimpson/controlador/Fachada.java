package uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo.ArchivoReglaSimpson;
import uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo.DistribucionT;
import uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo.ModelViewReglaSimpson;
import uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo.ReglaSimpson;
import uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.vista.VistaCalculoSimpson;

/**
 * Utilizando el patron fachada, se encargara de orquestar las clases desde la carga del archivo,
 * calcular la regla Simpson y mostrar los resultados, sean web o en consola. 
 * @author WALONSO
 *
 */
public class Fachada {
	
	private  ArrayList<ModelViewReglaSimpson> datosReglaSimpson;
	
	/**
	 * Procesa la regla Simpson
	 * @param rutaArchivo : ruta y nombre del archivo a procesar
	 * @param errorAceptable : el error aceptable
	 * @param numeroSegmentos : el numero de segmentos a partir
	 * @throws Exception al cargar archivo se valida que no este vacio, cantidad columnas adecuadas.
	 */
	public void procesarReglaSimpson(String rutaArchivo, double errorAceptable,int numeroSegmentos) throws Exception {
		this.cargarDatosInicialesReglaSimpson(rutaArchivo);
		for (int indice = 0; indice < this.datosReglaSimpson.size(); indice++) {
			ModelViewReglaSimpson modelReglaSimpson = this.datosReglaSimpson.get(indice); 
			this.asignarValoresConfiguracionSimpson(errorAceptable, numeroSegmentos);
			this.asignarValoresConfiguracionFuncionSimetrica(modelReglaSimpson.darDof());
			modelReglaSimpson.asignarValorCalculado(this.darCalculoSimpson(modelReglaSimpson));			
		}
	}
	
	private void cargarDatosInicialesReglaSimpson(String rutaArchivo) throws Exception {
		ArchivoReglaSimpson archivoReglaSimpson = new ArchivoReglaSimpson(rutaArchivo);
		archivoReglaSimpson.procesarArchivo();
		datosReglaSimpson = archivoReglaSimpson.darDatos();		
	}
	
	private void asignarValoresConfiguracionSimpson(double errorAceptable, int numeroSegmentos) {
		ReglaSimpson reglaSimpson = ReglaSimpson.getInstance();
		reglaSimpson.asignarErrorAceptable(errorAceptable);
		reglaSimpson.asignarNumeroSegmentos(numeroSegmentos);
	}

	private void asignarValoresConfiguracionFuncionSimetrica(int dof) {
		DistribucionT distribucion = DistribucionT.getInstance();
		distribucion.asignarDof(dof);
	}
	
	private double darCalculoSimpson(ModelViewReglaSimpson datosCalcular) {
		ReglaSimpson reglaSimpson = ReglaSimpson.getInstance();
		return reglaSimpson.darCalculo(datosCalcular.darRangoFinal(), DistribucionT.getInstance());
	}
	
	/**
	 * Muestra los calculos de la regla
	 * @param vista : la clase que se encarga de renderizar la informacion.
	 */
	public void mostrarCalculos(VistaCalculoSimpson vista) {
		vista.asignarModeloSimpson(this.datosReglaSimpson);
		vista.mostrarCalculosReglaSimpson();
	}

	/**
	 * Muestra los calculos web
	 * @return los datos y la vista de los datos que se van a desplegar.
	 */
	public ModelAndView mostrarCalculosWeb() {
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("datos", datosReglaSimpson);		
		return new ModelAndView(attributes, "reglaSimpson.ftl");
	}
}
