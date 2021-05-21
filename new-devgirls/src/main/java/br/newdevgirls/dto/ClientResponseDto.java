package br.newdevgirls.dto;

import java.util.ArrayList;
import java.util.List;

import br.newdevgirls.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {
	
	  private long id;
	  private String name;
	  private String cpf;
	  private String password;
	  private List<Product> products = new ArrayList<>();

}
