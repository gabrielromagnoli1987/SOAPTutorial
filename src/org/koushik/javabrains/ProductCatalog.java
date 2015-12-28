package org.koushik.javabrains;

import java.util.List;

import javax.jws.WebService;

import org.koushik.javabrains.business.ProductServiceImpl;
import org.koushik.javabrains.model.Product;


@WebService(endpointInterface="org.koushik.javabrains.ProductCatalogInterface", 
portName="TestMartCatalogPort", serviceName="TestMartCatalogService")
public class ProductCatalog implements ProductCatalogInterface {
	
	ProductServiceImpl productService = new ProductServiceImpl();
	
	
	/* 
	 * El tipo dice que hay que separar la logica de negocio para que pueda ser llamada
	 * de distintas formas, ya sea mediante mvc web u otras aplicaciones mediante webservices.
	 * Entonces en productService se aisla la logica de negocio
	 * */
	
	/* cada llamado que se realiza al webservice se ejecuta sobre la misma instancia
	 * en el video nro 8 se agrega un libro y despues se pide el listado de libros y el
	 * listado devuelve el libro nuevo (como el ejemplo no tiene persistencia en DB se concluye que
	 * es la misma instancia en memoria) */
	
	/* (non-Javadoc)
	 * @see org.koushik.javabrains.ProductCatalogInterface#getProductCategories()
	 */
	@Override
	public List<String> getProductCategories(){		
		return productService.getProductCategories();
	}
	
	/* (non-Javadoc)
	 * @see org.koushik.javabrains.ProductCatalogInterface#getProducts(java.lang.String)
	 */
	@Override
	public List<String> getProducts(String category){
		return productService.getProducts(category);
	}
	
	/* (non-Javadoc)
	 * @see org.koushik.javabrains.ProductCatalogInterface#addProduct(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addProduct(String category, String product){
		return productService.addProduct(category, product);
	}
	
	/* cuando se cambia la signatura del metodo, tambien cambia el wsdl generado por lo que
	 * la mejor opcion es crear una version 2 del mismo y es responsabilidad de los clientes (consumers) pasarse a la version 2
	 * o quedarse con la 1 */
	/* (non-Javadoc)
	 * @see org.koushik.javabrains.ProductCatalogInterface#getProductsv2(java.lang.String)
	 */
	@Override
	public List<Product> getProductsv2(String category){
		return productService.getProductsv2(category);
	}

}
