package ger.exceptions;

public class UsuarioNaoEncontradoException extends Exception{

  public UsuarioNaoEncontradoException(){
    super("Usuário não disponível. Por favor, verifique o código informado");
  }

}
