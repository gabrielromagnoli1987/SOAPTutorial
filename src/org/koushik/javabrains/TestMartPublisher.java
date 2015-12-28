package org.koushik.javabrains;

import javax.xml.ws.Endpoint;

public class TestMartPublisher {
	
	/* En el video 19 se explica que una de las implementaciones de JAXWS se llama METRO y es la encargada de 
	 parsear las anotaciones de la clase que se quiere exponer como servicio y si las anotaciones respetan el standard
	 entonces se crea el servicio. METRO viene incluido en Glassfish y tambien con la JDK pero lo que el tipo quiere mostrar es que no 
	 hace falta andar haciendo el deploy cada vez que hay un cambio y que de esta manera se puede acceder directamente al servicio
	 (esta orientado a la etapa de desarrollo) */

	public static void main(String[] args) {
		
		/* Es single thread a traves de esta forma de "deploy" */
		Endpoint.publish("http://localhost:1234/productcatalog", new ProductCatalog());
		
		/* Si el deploy es a traves de glassfish es multithread */
	}

}
