package uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.test;

import junit.framework.TestCase;
import uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo.DistribucionT;
import uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo.SegmentoSimpson;

/**
 * Clase q se encarga de validar el segmento segun regla Simpson.
 * @author WALONSO
 *
 */
public class SegmentoSimpsonTest extends TestCase {

	/**
	 * Valida el calculo de segmentos segun regla Simpson con dof impar
	 */
	public void testValidarCalculoSegmentoSimpsonDofImpar() {
		try {
			
			DistribucionT distribucion = DistribucionT.getInstance();
			distribucion.asignarDof(9);
			SegmentoSimpson segmentoCero = new SegmentoSimpson(0, 0.11, 1, distribucion);
			segmentoCero.calcular();
			SegmentoSimpson segmentoUno = new SegmentoSimpson(0.11, 0.11, 4, distribucion);
			segmentoUno.calcular();
			SegmentoSimpson segmentoDos = new SegmentoSimpson(0.22, 0.11, 2, distribucion);
			segmentoDos.calcular();
			
			assertEquals( "El valor del segmento 0 debe ser 0,014227945 ", 0.014227945, segmentoCero.darValorFuncion(), 0.0001);
			assertEquals( "El valor del segmento 1 debe ser 0,056530743 ", 0.056530743, segmentoUno.darValorFuncion(), 0.0001);
			assertEquals( "El valor del segmento 2 debe ser 0.027702933 ", 0.027702933, segmentoDos.darValorFuncion(), 0.0001);
		}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}
	
	/**
	 * Valida el calculo de segmentos segun regla Simpson con dof par
	 */
	public void testValidarCalculoSegmentoSimpsonDofPar() {
		try {
			
			DistribucionT distribucion = DistribucionT.getInstance();
			distribucion.asignarDof(10);
			SegmentoSimpson segmentoCero = new SegmentoSimpson(0, 0.11812,1, distribucion);
			segmentoCero.calcular();
			SegmentoSimpson segmentoUno = new SegmentoSimpson(0.11812, 0.11812, 4, distribucion);
			segmentoUno.calcular();
			SegmentoSimpson segmentoDos = new SegmentoSimpson(0.23624, 0.11812, 2, distribucion);
			segmentoDos.calcular();
			
			assertEquals( "El valor del segmento 0 debe ser 0,0153204941046892 ", 0.0153204941046892, segmentoCero.darValorFuncion(), 0.0001);
			assertEquals( "El valor del segmento 1 debe ser 0.0608138367765828", 0.0608138367765828, segmentoUno.darValorFuncion(), 0.0001);
			assertEquals( "El valor del segmento 2 debe ser 0.029717283047177", 0.029717283047177, segmentoDos.darValorFuncion(), 0.0001);
		}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}
}
