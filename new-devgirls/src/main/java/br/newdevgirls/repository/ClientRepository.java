package br.newdevgirls.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.newdevgirls.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
