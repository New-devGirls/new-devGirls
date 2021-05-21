package br.newdevgirls.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @Column
	  @NotNull
	  private String barcode;

	  @Column
	  @NotNull
	  private String name;

	  @Column
	  @NotNull
	  private String category;

	  @Column
	  @NotNull
	  private double price;

	  @Column
	  @NotNull
	  private String image_url;

	  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
	  private List<Client> clients = new ArrayList<>();

	  public Long getId() {
	    return id;
	  }

	  public void setId(Long id) {
	    this.id = id;
	  }

	  public String getBarcode() {
	    return barcode;
	  }

}
