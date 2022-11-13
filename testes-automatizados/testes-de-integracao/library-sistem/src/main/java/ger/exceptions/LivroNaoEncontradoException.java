package ger.exceptions;

public class LivroNaoEncontradoException extends Exception{

  public LivroNaoEncontradoException(){
    super("Livro não cadastrado. Por favor, verifique o código informado");
  }

}
