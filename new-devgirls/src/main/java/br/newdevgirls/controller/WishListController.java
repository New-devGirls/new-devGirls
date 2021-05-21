package br.newdevgirls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.newdevgirls.model.Client;
import br.newdevgirls.model.Product;
import br.newdevgirls.service.ClientService;
import br.newdevgirls.service.ProductService;
import br.newdevgirls.service.WishListService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/wishlist")
public class WishListController {
	
	@Autowired
	  ClientService clientService;

	  @Autowired
	  ProductService productService;

	  @Autowired
	  WishListService wishListService;

	  @ApiOperation(value = "Adicionar um produto na WishList")
	  @PostMapping("/{clientId}/{productId}")
	  public Client addProductToWishList(@PathVariable long clientId,
	      @PathVariable long productId) {
	    return wishListService.addProductToWishList(clientId, productId);
	  }

	  @ApiOperation(value = "Listar os produtos da WishList")
	  @GetMapping("/{clientId}")
	  public List<Product> getProductsByClientId(@PathVariable long clientId) {
	    return wishListService.getProductsByClientId(clientId);
	  }

	  @ApiOperation(value = "Buscar determinado da WishList produto por Id")
	  @GetMapping("/{clientId}/{productId}")
	  public Product getProductIfExistInAWishlist(@PathVariable long clientId,
	      @PathVariable long productId) {
	    return wishListService.getProductIfExistInAWishlist(clientId, productId);
	  }
	  
	  @ApiOperation(value = "Deletar um produto da WishList")
	  @DeleteMapping("/{clientId}/{productId}")
	  public Client deleteProductInWishlistByClientId(@PathVariable long clientId,
	      @PathVariable long productId) {
	    return wishListService.deleteProductInWishlistByClientId(clientId, productId);
	  }

}
