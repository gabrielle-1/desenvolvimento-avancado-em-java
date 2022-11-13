package book;

public class LivroEBook extends LivroDigital{
  private int numeroPaginas;

  public LivroEBook(String titulo, String autor, String idLivro, String link, int numeroPaginas) {
    super(titulo, autor, idLivro, link);
    this.numeroPaginas = numeroPaginas;
  }

  public int getNumeroPaginas(){
    return this.numeroPaginas;
  }
}
