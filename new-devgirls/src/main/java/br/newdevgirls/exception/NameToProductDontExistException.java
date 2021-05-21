package br.newdevgirls.exception;

public class NameToProductDontExistException extends RuntimeException{
	public NameToProductDontExistException(String name) {
	    super(String.format("Name %s to prodcut don't exist.", name));
	  }

}
