package br.newdevgirls.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import br.newdevgirls.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequestDto {
	
	  @NotNull
	  private String name;
	  @NotNull
	  private String cpf;
	  @NotNull
	  private String password;

	  private List<Product> products = new ArrayList<>();


}
