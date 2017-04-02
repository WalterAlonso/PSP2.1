package uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.controlador;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo.ArchivoReglaSimpson;

/**
 * Se encarga de recibir las peticiones desde un ambiente web, utilizando Spark.
 * @author WALONSO
 *
 */
public class CalculoReglaSimpsonWeb {
	/**
	 * Recibe los parametros del usuario en ambiente web para ser procesados.
	 * @param args el cual son los argumentos que se reciben del programa.
	 */
	public static void main(String[] args) {
		port(Integer.valueOf(System.getenv("PORT")));
		staticFileLocation("/ArchivoProcesar");
		Fachada fachada = new Fachada();		
		//Request al home del sitio.
		get("/", (req, res) -> {
			Map<String, Object> attributes = new HashMap<>();
			try {
				String rutaArchivo = "target/classes/ArchivoProcesar/ArchivoCargaReglaSimpson.txt";
				fachada.procesarReglaSimpson(rutaArchivo, 0.00001, 10);
				return fachada.mostrarCalculosWeb();				
			} catch (Exception ex) {
				attributes.put("message", ex.getMessage());
				return new ModelAndView(attributes, "error.ftl");
			}
		}, new FreeMarkerEngine());

		// Request para ver las pruebas de archivo
		get("/PruebasArchivo", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			try {
				String rutaArchivo = "target/classes/ArchivoProcesar/ArchivoExtensionErronea.dat";
				ArchivoReglaSimpson archivoReglaSimpson = new ArchivoReglaSimpson(rutaArchivo);
				archivoReglaSimpson.procesarArchivo();
			} catch (Exception ex) {
				attributes.put("ExtensionErronea", ex.getMessage());
				attributes.put("MensajeEsperadoExtensionErronea", "El archivo debe ser en formato txt");
			}

			try {
				String rutaArchivo = "target/classes/ArchivoProcesar/ArchivoVacio.txt";
				ArchivoReglaSimpson archivoReglaSimpson = new ArchivoReglaSimpson(rutaArchivo);
				archivoReglaSimpson.procesarArchivo();
			} catch (Exception ex) {
				attributes.put("ArchivoVacio", ex.getMessage());
				attributes.put("MensajeEsperadoArchivoVacio", "El archivo esta vacio");
			}

			try {
				String rutaArchivo = "target/classes/ArchivoProcesar/ArchivoNoExiste.txt";
				ArchivoReglaSimpson archivoReglaSimpson = new ArchivoReglaSimpson(rutaArchivo);
				archivoReglaSimpson.procesarArchivo();
			} catch (Exception ex) {
				attributes.put("ArchivoNoExiste", ex.getMessage());
				attributes.put("MensajeEsperadoArchivoNoExiste", "No hay archivo que cargar");
			}
			
			try {
				String rutaArchivo = "target/classes/ArchivoProcesar/ArchivoSinEstructuraCorrecta.txt";
				ArchivoReglaSimpson archivoReglaSimpson = new ArchivoReglaSimpson(rutaArchivo);
				archivoReglaSimpson.procesarArchivo();
			} catch (Exception ex) {
				attributes.put("ArchivoEstructuraIncorrecta", ex.getMessage());
				attributes.put("MensajeEsperadoEstructuraIncorrecta", "Tiene cantidad de columnas inadecuadas.");
			}
			
			return new ModelAndView(attributes, "testArchivo.ftl");
		}, new FreeMarkerEngine());
	}
}
