package br.newdevgirls.exception;

public class ClientDontExistException extends RuntimeException{
	public ClientDontExistException(long clientId) {
	    super(String.format("Id %d to client don't exist.", clientId));
	  }
}
