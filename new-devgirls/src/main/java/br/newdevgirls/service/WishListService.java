package br.newdevgirls.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.newdevgirls.model.Client;
import br.newdevgirls.model.Product;
import br.newdevgirls.repository.ClientRepository;
import br.newdevgirls.repository.ProductRepository;

@Service
public class WishListService {
	@Autowired
	  private ProductRepository productRepository;

	  @Autowired
	  private ClientRepository clientRepository;
	

    public Client addProductToWishList(long clientId, long productId) {
    List<Product> productList = this.getProductsByClientId(clientId);
    if (productList.size() >= 20) {
        throw new ResponseStatusException(BAD_GATEWAY, "Limite de produtos 20 foi atingido!");
    }

    List<Product> product = this.getProductIfExistInAWishlist(clientId, productId);
    if (product.isPresent()) {
        throw new ResponseStatusException(CONFLICT, "O item já está na lista do cliente!");
    }

    Optional<Client> client = clientRepository.findById(clientId);
    if (client.isPresent()) {
        Optional<Product> product = (productRepository.findById(productId));
        if (product.isPresent()) {

            Product product1 = product.get();
            Client client1 = client.get();
            client1.addProduct(product1);
            return clientRepository.save(client1);
        }
    } else {
        return null;
    }
    return null;
}

	  public List<Product> getProductsByClientId(long clientId) {
	    Optional<Client> client = clientRepository.findById(clientId);
	    return client.map(Client::getProducts).orElse(null);
	  }

	  public Client deleteProductInWishlistByClientId(long clientId, long productId) {
	    Optional<Client> client = clientRepository.findById(clientId);
	    if (client.isPresent()) {
	      Optional<Product> product = (productRepository.findById(productId));
	      if (product.isPresent()) {

	        Product product1 = product.get();
	        Client client1 = client.get();
	        client1.remove(product1);
	        return clientRepository.save(client1);
	      }
	    }
	    return null;
	  }

	  public Product getProductIfExistInAWishlist(long clientId, long productId) {
	    Optional<Client> client = clientRepository.findById(clientId);
	    if (client.isPresent()) {
	      Optional<Product> product = (productRepository.findById(productId));
	      if (product.isPresent()) {

	        Product product1 = product.get();
	        Client client1 = client.get();
	        if (client1.productExist(product1)) {
	          return product1;
	        } else {
	          return null;
	        }
	      }
	    }
	    return null;
	  }

}
