package uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo.Archivo;

/**
 * Test de los metodos de manejo de archivos
 * @author WALONSO
 *
 */
public class ArchivoTest extends TestCase {
	
	/**
	 * Clase ArchivoEstimar testear
	 */
	private Archivo archivoProcesar;
	
	/**
	 * Constante donde estan los archivos a testear
	 */
	public static final String rutaArchivo = "./ArchivoProcesarTest/TestArchivo/";
		
	/**
     * Este metodo se encarga de verificar si el archivo tiene extension erronea
     * 
     */
    public void testArchivoConExtensionErronea() {
    	try {
    		String archivo = rutaArchivo + "ArchivoExtensionErronea.dat";
    		archivoProcesar = new Archivo(archivo);
    		archivoProcesar.procesarArchivo();
    		fail("Debio fallar: No valido el formato del archivo");
    	}
    	catch(Exception ex) { 		
    		assertEquals( "El mensaje debe coincidir: El archivo debe ser en formato txt", "El archivo debe ser en formato txt", ex.getMessage());
    	}
    }
    
	/**
     * Este metodo se encarga de verificar si el archivo esta vacio
     * 
     */
    public void testArchivoVacio() {
    	try {
    		String archivo = rutaArchivo + "ArchivoVacio.txt";
    		archivoProcesar = new Archivo(archivo);
    		archivoProcesar.procesarArchivo();
    		fail("Debio fallar: No valido si el archivo estaba vacio");
    	}
    	catch(Exception ex) {  		
    		assertEquals( "El mensaje debe coincidir: El archivo esta vacio", "El archivo esta vacio", ex.getMessage());
    	}
    }
    
    /**
     * Este metodo se encarga de verificar si el archivo existe
     * 
     */
    public void testArchivoExiste() {
    	try {
    		String archivo = rutaArchivo + "ArchivoVacioNoExiste.txt";
    		archivoProcesar = new Archivo(archivo);
    		archivoProcesar.procesarArchivo();
    		fail("Debio fallar: No valido si el archivo existia");
    	}
    	catch(Exception ex) {  		
    		assertEquals( "El mensaje debe coincidir: No hay archivo que cargar", "No hay archivo que cargar", ex.getMessage());
    	}
    }
	  
    /**
     * Este metodo se encarga de verificar si el archivo tiene las columnas permitidas.
     * 
     */
    public void testArchivoSinEstructuraCorrecta() {
    	try {
    		String archivo = rutaArchivo + "ArchivoSinEstructuraCorrecta.txt";    		
    		archivoProcesar = new Archivo(archivo,3);
    		archivoProcesar.procesarArchivo();
    		fail("Debio fallar: No valido si el archivo tenia la estructura correcta");
    	}
    	catch(Exception ex) {  		
    		assertEquals( "El mensaje debe coincidir: Tiene cantidad de columnas inadecuadas.", "Tiene cantidad de columnas inadecuadas.", ex.getMessage());
    	}
    }
    
    
    /**
     * Este metodo se encarga de verificar si el archivo tiene solo un dato, dado que arrojaria un error
     * para el calculo de la desviacion estandar
     * 
     */
    public void testDatosCargados() {
    	try {
	    	String archivo = rutaArchivo + "ArchivoCargaReglaSimpson.txt";
	    	archivoProcesar = new Archivo(archivo);
	    	archivoProcesar.procesarArchivo();
	    	ArrayList<String> datos = archivoProcesar.darContenidoArchivo();
	    		    	
	    	assertEquals( "1 fila: 1.1,9,0.35006", "1.1,9,0.35006",datos.get(0));
	    	assertEquals( "2 fila: 1.1812,10,0.36757", "1.1812,10,0.36757", datos.get(1));
	    	assertEquals( "3 fila: 2.750,30,0.49500", "2.750,30,0.49500",datos.get(2));	    		    	
    	}
    	catch(Exception ex) {
    		ex.printStackTrace();
    		fail("Error :" + ex.getMessage());
    	}
    }	
}


