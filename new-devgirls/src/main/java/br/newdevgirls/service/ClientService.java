package br.newdevgirls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.newdevgirls.exception.ClientDontExistException;
import br.newdevgirls.model.Client;
import br.newdevgirls.repository.ClientRepository;
import br.newdevgirls.repository.ProductRepository;

@Service
public class ClientService {

	@Autowired
	  private ClientRepository clientRepository;

	  @Autowired
	  private ProductRepository productRepository;

	  public Client addClient(Client client) {
	    return clientRepository.save(client);
	  }

	  public Client buscarClientePorId(long id) {
	    return clientRepository.findById(id).orElseThrow(() ->
	        new ClientDontExistException(id));
	  }
}
