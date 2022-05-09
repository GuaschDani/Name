package com.immune.tienda.service;

import com.immune.tienda.entity.Product;
import com.immune.tienda.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {	
	@Autowired
	private ProductRepository productRepository;

	//Devuelve todos los productos de la tabla.
    public Iterable<Product> getProducts() {
		return productRepository.findAll();
	}
	//Registra un producto dados sus datos.
    public Product registerProduct(Product product) throws Exception{
		return this.productRepository.save(product);
	}
	//Borra un producto de la tabla dado si ID.
    public void deleteProductByID(Integer ID) throws Exception{
		this.productRepository.deleteById(ID);;
	}
	//Devuelve un preducto de la tabla dado su ID.
	public Product findById(Integer ID) {
		return this.productRepository.findById(ID).get();
	}
	//Actualiza los valores de un producto dados por el usuario.
	public void updateProduct(Product product, String newName, Integer newPrice) throws Exception{
		product.setName(newName);
        product.setPrice(newPrice);
        product.setLM();
		productRepository.save(product);
	}	
}