/************************************************************/
Codigo curso: CSOF5101 - 2017.
Nombre curso: CONCEPTOS AVANZADOS EN INGENIERIA DE SOFTWARE.
Nombre de la tarea: Assignment Kit for Program 5.
Fecha de envío de la tarea: 02 Abril 2017 (17:00), 
		GithHub: 02 Abril 2017 (13:00), Heroku: 02 Abril 2017 (02:47)
Autor: Walter Javier Alonso Roa
/************************************************************/

¨** Descripcion:
Primero se debe colocar el archivo a procesar en la carpeta "ArchivoProcesar". (deben ser txt),
el codigo fuente se encuentra en el repo: https://github.com/WalterAlonso/2_PSP2.git

** Ambiente de ejecucion:
Este programa fue realizado con JRE 1.8 en S.O 7.
Debe tener instalado Maven


**************** Instrucciones de ejecucion ************************
** clone repo desde github.
$git clone https://github.com/WalterAlonso/PSP2.1.git

** Ingresar al folder PSP2.1
  	cd PSP2.1

** Ejecucion maven

	 mvn clean install site

** Ejecute el programa:

	java -cp target/Ecos_CalculoReglaSimpson-1.0-SNAPSHOT-jar-with-dependencies.jar uniandes.ecos.conceptosAvanzados.calculoReglaSimpson.controlador.CalculoReglaSimpson "ArchivoCargaReglaSimpson.txt"

** Documentacion del sitio

	mvn site
		- Cobertura de pruebas unitarias: target/site/cobertura/index.html
		- Analisis de codigo (PMD): 	  target/site/pmd.html
		- Documentacion de codigo test: target/site/testapidocs/index.html
		- Documentacion de codigo de la aplicacion: target/site/apidocs/index.html

** Heroku:

	https://app-psp2-1-calcsimpson.herokuapp.com/

