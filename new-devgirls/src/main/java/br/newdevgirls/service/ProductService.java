package br.newdevgirls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.newdevgirls.exception.NameToProductDontExistException;
import br.newdevgirls.model.Product;
import br.newdevgirls.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	  private ProductRepository productRepository;


	  public Product createProduct(Product product) {
	    return productRepository.save(product);
	  }

	  public Product buscarProdutoPorName(String name) {
	    try {
	      return productRepository.findByName(name);
	    } catch (Exception e) {
	      throw new NameToProductDontExistException(name);
	    }
	  }
}
