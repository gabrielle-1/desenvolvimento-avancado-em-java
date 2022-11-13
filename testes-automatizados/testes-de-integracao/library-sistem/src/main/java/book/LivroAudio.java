package book;

public class LivroAudio extends LivroDigital{
  protected float duracaoMinutos;

  public LivroAudio(String titulo, String autor, String idLivro, String link, int duracaoMinutos) {
    super(titulo, autor, idLivro, link);
    this.duracaoMinutos = duracaoMinutos;
  }

  public float getDuracaoMinutos(){
    return this.duracaoMinutos;
  }
}
