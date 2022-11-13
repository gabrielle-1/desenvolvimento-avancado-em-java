package emp.excep;

public class AtrasoException extends Exception{
  private String idLivro;
  private String idUsuario;

  public AtrasoException(String idLivro, String idUsuario){
    super("Empréstimo atrasado... Por favor, pague a multa!");
    this.idLivro = idLivro;
    this.idUsuario = idUsuario;
  }

  public String getIdLivro() {
    return idLivro;
  }

  public String getIdUsuario() {
    return idUsuario;
  }
}
