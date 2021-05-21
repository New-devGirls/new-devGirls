package br.newdevgirls.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.newdevgirls.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	Product findByName(String name);
}
