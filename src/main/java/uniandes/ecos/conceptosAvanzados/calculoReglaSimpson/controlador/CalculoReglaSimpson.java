/**
 * Proposito:     Calcular regla Simpson con distribucion T de un conjunto de datos dado.
 * Autor(s):   Walter Alonso
 * Fecha creacion: 1 Abril 2017
 * Modificado por: Walter Alonso. 
 * Ultima modificacion: 1 Abril 2017.
*/

package uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.controlador;

import uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.vista.VistaCalculoSimpson;

/**
 * Clase principal, al cual llega el usuario cuando inicia el programa.
 * @author WALONSO
 *
 */
public class CalculoReglaSimpson {

	/**
	 * Recibe la ruta del archivo que se va a procesar.
	 * @param args : en la posicion 0, llega el nombre del archivo a procesar.
	 */
	public static void main(String[] args) {
		VistaCalculoSimpson vista = new VistaCalculoSimpson();
		try
		{		
			if(args.length < 1) {
				throw new Exception("No tiene argumentos, debe ingresar la ruta del archivo");
			}
			
			Fachada fachada = new Fachada();			
			String rutaArchivo = "./ArchivoProcesar/" + args[0];
			fachada.procesarReglaSimpson(rutaArchivo, 0.00001, 10);
			fachada.mostrarCalculos(vista);
		}
		catch(Exception ex) {				
			vista.mostrarError(ex.getMessage());
		}
	}
}
