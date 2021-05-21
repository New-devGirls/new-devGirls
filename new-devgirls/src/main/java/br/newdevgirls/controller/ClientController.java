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

import br.newdevgirls.model.Client;
import br.newdevgirls.service.ClientService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	  @Autowired
	  private ClientService clientService;

	  @ApiOperation(value = "Cadastra Cliente")
	  @PostMapping
	  @ResponseStatus(HttpStatus.CREATED)
	  public Client create(@RequestBody Client client) {
	    return clientService.addClient(client);
	  }
	  
	  @ApiOperation(value = "Buscar Cliente por Id")
	  @GetMapping("/{id}")
	  @ResponseStatus(HttpStatus.OK)
	  public Client find(@PathVariable long id) {
	    return clientService.buscarClientePorId(id);
	  }

}
