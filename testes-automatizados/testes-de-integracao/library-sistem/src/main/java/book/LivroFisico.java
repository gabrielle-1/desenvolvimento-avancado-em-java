package book;

public class LivroFisico extends Livro{
  private String isbn;
  private int numPaginas;

  public LivroFisico(String titulo, String autor, String idLivro, String isbn, int numPaginas) {
    super(titulo, autor, idLivro);
    this.isbn = isbn;
    this.numPaginas = numPaginas;
  }

  public String getIsbn() {
    return isbn;
  }

  public int getNumPaginas() {
    return numPaginas;
  }
}
