package br.newdevgirls.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class Client {
	
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @Column
	  private String name;

	  @Column(unique = true)
	  private String cpf;

	  @Column
	  private String password;

	  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	  @JoinTable(name = "wishlist",
	      joinColumns = @JoinColumn(name = "id_client"),
	      inverseJoinColumns = @JoinColumn(name = "id_product"))
	  private List<Product> products = new ArrayList<>();

	  public Long getId() {
	    return id;

	  }

	  public void setId(Long id) {
	    this.id = id;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public String getCpf() {
	    return cpf;
	  }

	  public void setCpf(String cpf) {
	    this.cpf = cpf;
	  }

	  public String getPassword() {
	    return password;
	  }

	  public void setPassword(String password) {
	    this.password = password;
	  }

	  public List<Product> getProducts() {
	    return products;
	  }

	  public void setProducts(List<Product> products) {
	    this.products = products;
	  }

	  public void addProduct(Product product1) {
	    this.getProducts().add(product1);
	  }

	  public void remove(Product product1) {
	    this.getProducts().remove(product1);
	  }

	  public boolean productExist(Product product1) {
	    return this.getProducts().contains(product1);
	  }
	}


