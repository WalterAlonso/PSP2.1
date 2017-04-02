package uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.test;


import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.modelo.UtilidadCalculo;

/**
 * Se encarga de validar la clase que realiza las operaciones matematicas
 * @author WALONSO
 *
 */
public class UtilidadCalculoTest extends TestCase {
	
	/**
	 * Valida que se calcule correctamente el promedio 	
	 */
	public void testValidarPromedio() {
    	try {
    		ArrayList<Double> listaDatos = new ArrayList<Double>();
    		listaDatos.add(1.0);
    		listaDatos.add(2.8);
    		listaDatos.add(4.7);
    		listaDatos.add(0.2);
    		
    		double promedio = UtilidadCalculo.darPromedio(listaDatos);    		    		
    		assertEquals( "El promedio debe ser 2.175 ", 2.175, promedio);
    		
    	}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
    }
	
	/**
	 * Valida que se calcule correctamente el promedio 	con un solo dato
	 */
	public void testValidarPromedioUnDato() {
    	try {
    		ArrayList<Double> listaDatos = new ArrayList<Double>();
    		listaDatos.add(2.8);
    		
    		double promedio = UtilidadCalculo.darPromedio(listaDatos);    		    		
    		assertEquals( "El promedio debe ser 2.8 ", 2.8, promedio);
    		
    	}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
    }
    
	/**
	 * Valida que se este realizando correctamente la suma de una lista
	 */
	public void testValidarSumatoria() {
    	try {
    		ArrayList<Double> listaDatos = new ArrayList<Double>();
    		listaDatos.add(1.0);
    		listaDatos.add(2.8);
    		listaDatos.add(4.7);
    		listaDatos.add(0.2);
    		
    		double sumatoria = UtilidadCalculo.darSumatoria(listaDatos);    		    		
    		assertEquals( "La sumatoria debe ser 8.7 ", 8.7, sumatoria);
    		
    	}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
    }
	
	/**
	 * Valida que se este realizando correctamente la suma de una lista con un solo dato
	 */
	public void testValidarSumatoriaConUnSoloDato() {
    	try {
    		ArrayList<Double> listaDatos = new ArrayList<Double>();    		
    		listaDatos.add(4.7);
    		
    		double sumatoria = UtilidadCalculo.darSumatoria(listaDatos);    		    		
    		assertEquals( "La sumatoria debe ser 4.7 ", 4.7, sumatoria);
    		
    	}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
    }
	
	/**
	 * Valida que se este realizando correctamente la suma de dos listas multiplicandose
	 */
	public void testValidarSumatoriaFactores() {
    	try {
    		ArrayList<Double> listaDatosUno = new ArrayList<Double>();    		
    		listaDatosUno.add(1.0);
    		listaDatosUno.add(2.8);
    		listaDatosUno.add(4.7);
    		listaDatosUno.add(0.2);
    		
    		ArrayList<Double> listaDatosDos = new ArrayList<Double>();    		
    		listaDatosDos.add(5.9);
    		listaDatosDos.add(2.4);
    		listaDatosDos.add(3.0);
    		listaDatosDos.add(0.8);
    		    		
    		double sumatoria = UtilidadCalculo.darSumatoriaFactores(listaDatosUno, listaDatosDos);     		
    		assertEquals( "La sumatoria de factores  debe ser 26.880000000000003 ", 26.880000000000003, sumatoria);
    	}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
    }
	
	
	/**
	 * Valida que se este realizando correctamente la suma de dos listas multiplicandose
	 * con un dato
	 */
	public void testValidarSumatoriaFactoresConUnDato() {
    	try {
    		ArrayList<Double> listaDatosUno = new ArrayList<Double>(); 
    		listaDatosUno.add(0.2);    		
    		ArrayList<Double> listaDatosDos = new ArrayList<Double>();    		
    		listaDatosDos.add(5.9);
    		
    		double sumatoria = UtilidadCalculo.darSumatoriaFactores(listaDatosUno, listaDatosDos);     		
    		assertEquals( "La sumatoria de factores debe ser 1.1800000000000002 ", 1.1800000000000002, sumatoria);
    		
    	}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
    }
	
	/**
	 * Valida que se este realizando correctamente la suma al cuadrado de la lista
	 */
	public void testValidarSumatoriaCuadrada() {
    	try {
    		ArrayList<Double> listaDatosUno = new ArrayList<Double>();    		
    		listaDatosUno.add(1.0);
    		listaDatosUno.add(2.8);
    		listaDatosUno.add(4.7);
    		listaDatosUno.add(0.2);
    		
    		double sumatoria = UtilidadCalculo.darSumatoriaCuadrada(listaDatosUno);     		
    		assertEquals( "La sumatoria cuadrada  debe ser 30.970000000000002 ", 30.970000000000002, sumatoria);
    		
    	}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
    }
		
	/**
	 * Valida que se este realizando correctamente la suma al cuadrado de la lista
	 */
	public void testValidarSumatoriaCuadradaConUnDato() {
    	try {
    		ArrayList<Double> listaDatosUno = new ArrayList<Double>();    		
    		listaDatosUno.add(1.0);
    		
    		double sumatoria = UtilidadCalculo.darSumatoriaCuadrada(listaDatosUno);     		
    		assertEquals( "La sumatoria cuadrada  debe ser 1.0 ", 1.0, sumatoria);
    		
    	}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
    }
	
	/**
	 * Valida la diviosn entre valores de 2 listas
	 */
	public void testDivisionListas() {
		try {
    		ArrayList<Double> listaDatosUno = new ArrayList<Double>();    		
    		listaDatosUno.add(1.0);
    		listaDatosUno.add(2.0);
    		listaDatosUno.add(3.0);
    		listaDatosUno.add(6.3);
    		
    		ArrayList<Double> listaDatosDos = new ArrayList<Double>();    		
    		listaDatosDos.add(1.0);
    		listaDatosDos.add(1.0);
    		listaDatosDos.add(2.0);
    		listaDatosDos.add(8.3);
    		
    		ArrayList<Double> datos = UtilidadCalculo.darDivision(listaDatosUno, listaDatosDos);
    		    		
    		assertEquals( "La division debe ser 1.0 ", 1.0, datos.get(0));
    		assertEquals( "La division debe ser 2.0 ", 2.0, datos.get(1));
    		assertEquals( "La division debe ser 1.5 ", 1.5, datos.get(2));
    		assertEquals( "La division debe ser 0.759 ", 0.759, datos.get(3), 0.01);
    		
    	}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}
	
	/**
	 * Valida el logaritmo natural de una lista de valores
	 */
	public void testLogaritmoNatural() {
		try {
    		ArrayList<Double> listaDatosUno = new ArrayList<Double>();    		
    		listaDatosUno.add(1.0);
    		listaDatosUno.add(2.0);
    		listaDatosUno.add(3.0);
    		listaDatosUno.add(6.3);
    		
    		ArrayList<Double> datos = UtilidadCalculo.darLogaritmoNatural(listaDatosUno);

    		assertEquals( "El ln debe ser 0.0", 0.0, datos.get(0));
    		assertEquals( "El ln debe ser 0.693", 0.693, datos.get(1), 0.001);
    		assertEquals( "El ln debe ser 1.098", 1.098, datos.get(2), 0.001);
    		assertEquals( "El ln debe ser 1.84", 1.84, datos.get(3), 0.001);
    	}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}
		
	/**
	 * Valida la resta de una lista de valores frente aun valor estatico
	 */
	public void testRestaSegunValor() {
		try {
    		ArrayList<Double> listaDatosUno = new ArrayList<Double>();    		
    		listaDatosUno.add(1.0);
    		listaDatosUno.add(2.0);
    		listaDatosUno.add(3.0);
    		listaDatosUno.add(6.3);
    		
    		ArrayList<Double> datos = UtilidadCalculo.darRestaSegunValor(listaDatosUno, 3.2);

    		assertEquals( "La resta debe ser -2.2", -2.2, datos.get(0), 0.001);
    		assertEquals( "La resta debe ser -1.2", -1.2, datos.get(1), 0.001);
    		assertEquals( "La resta debe ser -0.2", -0.2, datos.get(2), 0.001);
    		assertEquals( "La resta debe ser 3.1", 3.1, datos.get(3), 0.001);
    	}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}
	
	/**
	 * Valida la resta de una lista de valores frente aun valor estatico
	 */
	public void testExponencialInversoNeperiano() {
		try {
    		ArrayList<Double> listaDatosUno = new ArrayList<Double>();    		
    		listaDatosUno.add(1.0);
    		listaDatosUno.add(2.0);
    		listaDatosUno.add(3.0);
    		listaDatosUno.add(6.3);
    		
    		assertEquals( "El valor debe ser 4.3953", 4.3953, UtilidadCalculo.darExponencialInversoNeperiano(1.4805), 0.001);
    		assertEquals( "El valor debe ser 8.5081", 8.5081, UtilidadCalculo.darExponencialInversoNeperiano(2.1410), 0.001);
    		assertEquals( "El valor debe ser 16.4696", 16.4696, UtilidadCalculo.darExponencialInversoNeperiano(2.8015), 0.001);
    		assertEquals( "El valor debe ser 31.8811", 31.8811, UtilidadCalculo.darExponencialInversoNeperiano(3.4620), 0.001);
    		assertEquals( "El valor debe ser 61.7137", 61.7137, UtilidadCalculo.darExponencialInversoNeperiano(4.1225), 0.001);
    	}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}	
	
	/**
	 * Valida el factorial de un decimal
	 */
	public void testDarFactorialDouble() {
		try {
			double valorFactorial = UtilidadCalculo.darFactorial((7/2.0), 0.5);			
    		assertEquals( "El valor debe ser 6.5625", 6.5625, valorFactorial, 0.001);
    	}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}
		
	/**
	 * Valida el factorial de un entero
	 */
	public void testDarFactorialEntero() {
		try {
			double valorFactorial = UtilidadCalculo.darFactorial(4, 1);			
    		assertEquals( "El valor debe ser 24", 24, valorFactorial, 0.001);
    	}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
	}		
}
