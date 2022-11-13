package book;

public abstract class Livro {
  protected String titulo;
  protected String autor;
  protected String idLivro;

  public Livro(String titulo, String autor, String idLivro){
    this.titulo = titulo;
    this.autor = autor;
    this.idLivro = idLivro;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getIdLivro() {
    return idLivro;
  }

  public void setIdLivro(String idLivro) {
    this.idLivro = idLivro;
  }

}
