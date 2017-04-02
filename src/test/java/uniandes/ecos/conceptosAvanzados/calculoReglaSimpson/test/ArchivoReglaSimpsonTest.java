package uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo.ArchivoReglaSimpson;
import uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo.ModelViewReglaSimpson;

/**
 * Clase que se encarga de validar el archivo Simpson esperado.
 * @author WALONSO
 *
 */
public class ArchivoReglaSimpsonTest extends TestCase {
	
	/**
	 * Clase ArchivoEstimar testear
	 */
	private ArchivoReglaSimpson archivoProcesar;
	
	/**
	 * Constante donde estan los archivos a testear
	 */
	public static final String rutaArchivo = "./ArchivoProcesarTest/TestArchivoSimpson/";

	/**
     * Este metodo se encarga de verificar que se cargue bien cuando es clase
     * 
     */
    public void testCargarArchivo() {
    	try {
    		String archivo = rutaArchivo + "ArchivoCargaReglaSimpson.txt";
    		archivoProcesar = new ArchivoReglaSimpson(archivo);
    		archivoProcesar.procesarArchivo();
    		ArrayList<ModelViewReglaSimpson> datos = archivoProcesar.darDatos();
    		
    		assertEquals("Debe ser 1.1", 1.1, datos.get(0).darRangoFinal());
    		assertEquals("Debe ser 9", 9, datos.get(0).darDof());
    		assertEquals("Debe ser 0.35006", 0.35006, datos.get(0).darValorEsperado());
    		
    		assertEquals("Debe ser 1.1812", 1.1812, datos.get(1).darRangoFinal());
    		assertEquals("Debe ser 10", 10, datos.get(1).darDof());
    		assertEquals("Debe ser 0.36757", 0.36757, datos.get(1).darValorEsperado());
    		
    		assertEquals("Debe ser 2.750", 2.750, datos.get(2).darRangoFinal());
    		assertEquals("Debe ser 30", 30, datos.get(2).darDof());
    		assertEquals("Debe ser 0.49500", 0.49500, datos.get(2).darValorEsperado());    		
    	}
    	catch(Exception ex) { 		
    		fail("Excepcion: " + ex.getMessage());
    	}
    }
    
    /**
     * Se valida que no tenga caracteres
     */
    public void testValidarSoloReales() {
    	try {
    		String archivo = rutaArchivo + "ArchivoConCaracteres.txt";
    		archivoProcesar = new ArchivoReglaSimpson(archivo);
    		archivoProcesar.procesarArchivo();
    		archivoProcesar.darDatos();
    		fail("Debio fallar: Hay un valor que no es numero real.");
    	}
    	catch(Exception ex) { 		
    		assertEquals( "El mensaje debe coincidir: Hay un valor que no es numero real.", "Hay un valor que no es numero real.", ex.getMessage());
    	}
    }
    
    /**
     * Se valida que no tenga caracteres
     */
    public void testValidarValoresMayoresACero() {
    	try {
    		String archivo = rutaArchivo + "ArchivoConDatoIgualCero.txt";
    		archivoProcesar = new ArchivoReglaSimpson(archivo);
    		archivoProcesar.procesarArchivo();
    		archivoProcesar.darDatos();
    		fail("Debio fallar: Hay valores menores o iguales a 0, los deben ser mayores a 0 el dof y rango final(x).");
    	}
    	catch(Exception ex) { 		
    		assertEquals( "El mensaje debe coincidir: Hay valores menores o iguales a 0, los deben ser mayores a 0 el dof y rango final(x).", "Hay valores menores o iguales a 0, los deben ser mayores a 0 el dof y rango final(x).", ex.getMessage());
    	}
    }
    
    
}



