package uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.test;

import junit.framework.TestCase;
import uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo.DistribucionT;
import uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo.ReglaSimpson;

/**
 * Esta se encarga de validar el correcto calculo de la regla simpson.
 * @author WALONSO
 *
 */
public class ReglaSimpsonTest extends TestCase {

	/**
	 * Valida el calculo de la regla Simpson 
	 */
	public void testValidarCalculoRegla() {
		try {		
			DistribucionT distribucion = DistribucionT.getInstance();
			distribucion.asignarDof(9);
			ReglaSimpson reglaSimpson = ReglaSimpson.getInstance();
			reglaSimpson.asignarErrorAceptable(0.00001);
			reglaSimpson.asignarNumeroSegmentos(10);
						
			assertEquals( "El valor de la regla debe ser 0.3500589", 0.3500589, reglaSimpson.darCalculo(1.1, distribucion), 0.0001);			
		}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}
	
	public void testValidarCalculoReglaDos() {
		try {		
			DistribucionT distribucion = DistribucionT.getInstance();
			distribucion.asignarDof(10);
			ReglaSimpson reglaSimpson = ReglaSimpson.getInstance();
			reglaSimpson.asignarErrorAceptable(0.00001);
			reglaSimpson.asignarNumeroSegmentos(10);
						
			assertEquals( "El valor de la regla debe ser 0.36757", 0.36757, reglaSimpson.darCalculo(1.1812, distribucion), 0.0001);			
		}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}
	
	public void testValidarCalculoReglaTres() {
		try {		
			DistribucionT distribucion = DistribucionT.getInstance();
			distribucion.asignarDof(30);
			ReglaSimpson reglaSimpson = ReglaSimpson.getInstance();
			reglaSimpson.asignarErrorAceptable(0.00001);
			reglaSimpson.asignarNumeroSegmentos(10);
						
			assertEquals( "El valor de la regla debe ser 0.49500", 0.49500, reglaSimpson.darCalculo(2.750, distribucion), 0.0001);			
		}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}
}

