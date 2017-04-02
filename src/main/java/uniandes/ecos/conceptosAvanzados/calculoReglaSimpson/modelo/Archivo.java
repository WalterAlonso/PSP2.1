package uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Representa a los  archivos
 * @author WALONSO
 *
 */
public class Archivo {
	
	/**
	 * Representa la cantidad de columnas permitidas en el archivo
	 */
	protected int cantidadColumnasPermitidas;
	
	/**
	 * Indica si se debe valida la cantidad de columnas.
	 */
	protected boolean validarCantidadColumnas;
	
	/**
	 * El contenido del archivo
	 */
	protected ArrayList<String> contenidoArchivo; 
	
	/**
	 * Ruta del archivo a procesar
	 */
	protected String rutaArchivo;
	
	/**
	 * Constructor que cargara el archivo.
	 * @param rutaArchivo la ruta del archivo a procesar.
	 */
	public Archivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
		this.contenidoArchivo = new ArrayList<>();
	}
	
	/**
	 * Cstor que ademas del archivo a cargar indica la cantidad de columnas que debe tener
	 * @param rutaArchivo: la ruta y nombre del archivo
	 * @param cantidadColumnasPermitidas: la cantidad de columnas que debe tener el archivo.
	 */
	public Archivo(String rutaArchivo, int cantidadColumnasPermitidas) {
		this.rutaArchivo = rutaArchivo;
		this.contenidoArchivo = new ArrayList<>();
		this.cantidadColumnasPermitidas = cantidadColumnasPermitidas;
		this.validarCantidadColumnas = true;
	}
	
	/**
	 * Da el contenido del archivo
	 * @return ArrayList con el contenido del archivo
	 */
	public ArrayList<String> darContenidoArchivo() {
		return this.contenidoArchivo;
	}
	
	/**
	 * Da la ruta del archivo
	 * @return String con el contenido del archivo
	 */
	public String darRutaArchivo() {
		return this.rutaArchivo;
	}
	
	/**
	 * Toma el archivo, lo valida y devuelve el conjunto de datos en el
	 * @throws Exception Al cargar el archivo se realizan validaciones como archivo esta vacio, o el fomrato inadecuado.
	 */
	public void procesarArchivo() throws Exception {
		File archivo = new File(this.rutaArchivo);
		if(elArchivoExiste(archivo)) {
			if(elArchivoTieneElFormatoCorrecto(archivo)) {
				if(!elArchivoEstaVacio(archivo)) {
					FileReader stream = new FileReader(archivo);
					BufferedReader reader = new BufferedReader( stream);					
					String linea = reader.readLine();					
					while(linea != null) {
						if(this.validarCantidadColumnas(linea)) {
							this.contenidoArchivo.add(linea);
						}
						linea = reader.readLine();						
					}					
					stream.close();
					reader.close();	
				}
				else {
					throw new Exception("El archivo esta vacio");
				}
			}
			else {
				throw new Exception("El archivo debe ser en formato txt");
			}
		}
		else {
			throw new Exception("No hay archivo que cargar");			
		}		
	}
	
	/**
	 * valida que el archivo exista
	 * @return true si el archivo existe o false si no existe
	 */
	private boolean elArchivoExiste(File archivo) {		
		if(archivo.exists()) {
			return true;
		}		
		
		return false;			
	}
	
	/**
	 * Valida que el archivo se pueda leer y que sea un archivo plano txt
	 * @param archivo: el archivo que se va a cargar
	 * @return true si es valido o false si no es valido.
	 */
	private boolean elArchivoTieneElFormatoCorrecto(File archivo) {
		String nombreArchivo = archivo.getName();
		if(archivo.canRead()) {
			if(nombreArchivo.toLowerCase().endsWith(".txt")) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Valida si el archivo tiene datos
	 * @return true si tiene datos, false si no tiene datos.
	 * @throws Exception si hay problema con la lectura de archivos
	 */
	private boolean elArchivoEstaVacio(File archivo) throws Exception {		
		FileReader stream = new FileReader(archivo);
		BufferedReader reader = new BufferedReader( stream);
		String line = reader.readLine();
		boolean esVacio = false;
		if(line == null) {
			esVacio = true;
		}
		
		reader.close();
		stream.close();
		
		return esVacio;		
	}
	
	private boolean validarCantidadColumnas(String cadena) throws Exception{
		if (this.validarCantidadColumnas) {
			String[] divisionValores = cadena.split(",");		
			if (divisionValores.length != this.cantidadColumnasPermitidas) {
				throw new Exception("Tiene cantidad de columnas inadecuadas.");
			}			
		}
		return true;
	}
}

