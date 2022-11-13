package book;

public abstract class LivroDigital extends Livro{
  protected String link;

  public LivroDigital(String titulo, String autor, String idLivro, String link) {
    super(titulo, autor, idLivro);
    this.link = link;
  }

  public String getLink(){
    return this.link;
  }
}
