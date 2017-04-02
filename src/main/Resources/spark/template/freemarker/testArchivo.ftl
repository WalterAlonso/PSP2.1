<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>

  <#include "nav.ftl">

<div class="jumbotron text-center">
  <div class="container">    
    <h3>PRUEBAS CLASE ARCHIVO</h3>
  </div>
</div>
<div class="container">
  <table class="table table-striped">
	<tr>
		<th>Tipo de prueba</th>
		<th>Mensaje esperado</th>
		<th>Mensaje obtenido</th>		
	</tr>
	<tr>
		<td>Archivo extensi&otilde;n erronea</td>
		<td>${MensajeEsperadoExtensionErronea}</td>
		<td>${ExtensionErronea}</td>
	</tr>
	<tr>
		<td>Archivo vacio</td>
		<td>${MensajeEsperadoArchivoVacio}</td>
		<td>${ArchivoVacio}</td>
	</tr>
	<tr>
		<td>Archivo no existe</td>
		<td>${MensajeEsperadoArchivoNoExiste}</td>
		<td>${ArchivoNoExiste}</td>
	</tr>
	<tr>
		<td>Estructura Incorrecta</td>
		<td>${MensajeEsperadoEstructuraIncorrecta}</td>
		<td>${ArchivoEstructuraIncorrecta}</td>
	</tr>
	</tr>
  </table>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $('[name ^= "lnkHome"]').removeClass('active');
        $('[name = "lnkArchivo"]').addClass('active');
    });
</script>

</body>
</html>
