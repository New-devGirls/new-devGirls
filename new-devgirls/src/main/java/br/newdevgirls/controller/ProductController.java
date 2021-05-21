package br.newdevgirls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.newdevgirls.model.Product;
import br.newdevgirls.service.ProductService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/products")
public class ProductController {

	  @Autowired
	  private ProductService productService;
	
	  @ApiOperation(value = "Cadastrar Produto")
	  @PostMapping
	  @ResponseStatus(HttpStatus.CREATED)
	  public Product createProduct(@RequestBody Product product) {
	    return productService.createProduct(product);
	  }

	  @ApiOperation(value = "Buscar produto por nome")
	  @GetMapping("/{name}")
	  @ResponseStatus(HttpStatus.OK)
	  public Product find(@PathVariable String name) {
	    return productService.buscarProdutoPorName(name);
	  }
}
