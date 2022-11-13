package emp.excep;

import book.Livro;

public class MaximoExtensoesException extends Exception{
  private int numDiasAtraso;
  private String idlivro;

  public MaximoExtensoesException(String idLivro, int numDiasAtraso){
    super("Número máximo de extensões realizado...");
    this.idlivro = idLivro;
    this.numDiasAtraso = numDiasAtraso;
  }

  public int getNumDiasAtraso() {
    return numDiasAtraso;
  }

  public String getIdlivro() {
    return idlivro;
  }
}
