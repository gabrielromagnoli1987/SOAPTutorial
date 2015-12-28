package org.koushik.javabrains;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.koushik.javabrains.model.Product;


/* SERVICE ENDPOINT INTERFACE */
/* Como buena practica el tipo recomienda separar en una interface la declaracion de lo que va a ser
 * el contrato (wsdl), de esta forma el contrato no queda atado a la implementacion del mismo, la idea es que 
 * queda fija la declaracion del contrato (video 13)*/

@WebService(name="TestMartCatalog", targetNamespace="http://www.testmart.com")
public interface ProductCatalogInterface {

	@WebMethod(action="fetch_categories", operationName="fetchCategories")
	public abstract List<String> getProductCategories();

	@WebMethod
	public abstract List<String> getProducts(String category);

	@WebMethod
	public abstract boolean addProduct(String category, String product);

	/* cuando se cambia la signatura del metodo, tambien cambia el wsdl generado por lo que
	 * la mejor opcion es crear una version 2 del mismo y es responsabilidad de los clientes (consumers) pasarse a la version 2
	 * o quedarse con la 1 */
	@WebMethod
	public abstract List<Product> getProductsv2(String category);

}