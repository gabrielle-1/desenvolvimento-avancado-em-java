package ger.exceptions;

import emp.Emprestimo;

public class EmprestimoNaoEncontradoException extends Exception{

  public EmprestimoNaoEncontradoException(){
    super("Emprestimo não encontrado. Por favor, verifique o código informado");
  }

}
