package ger;

import book.Livro;
import book.LivroAudio;
import book.LivroEBook;
import book.LivroFisico;
import ger.exceptions.LivroNaoEncontradoException;
import java.util.ArrayList;
import java.util.List;

public class GerenciaLivros {
  private List<Livro> livros;

  public GerenciaLivros(){
    this.livros = new ArrayList<>();
  }

  public List<Livro> getLivros(){
    return this.livros;
  }

  public void adicionarNovoLivroFisico(String titulo, String autor, String idLivro,
      String isbn, int numPaginas){
    if (!livroExistente(idLivro)){
      this.livros.add(new LivroFisico(titulo, autor, idLivro, isbn, numPaginas));
    }
  }

  public void adicionarNovoEBook(String titulo, String autor, String idLivro,
      String link, int numPaginas){
    if (!livroExistente(idLivro)){
      this.livros.add(new LivroEBook(titulo, autor, idLivro, link, numPaginas));
    }
  }

  public void adicionarNovoAudioBook(String titulo, String autor, String idLivro,
      String link, int minutos){
    if (!livroExistente(idLivro)){
      this.livros.add(new LivroAudio(titulo, autor, idLivro, link, minutos));
    }
  }

  private boolean livroExistente(String idLivro){
    for(Livro livro: livros){
      if (livro.getIdLivro().equals(idLivro)){
        return true;
      }
    }
    return false;
  }

  public Livro buscaLivroPorId(String idLivro) throws LivroNaoEncontradoException {
    for(Livro livro: livros){
      if (livro.getIdLivro().equals(idLivro)){
        return livro;
      }
    }
    throw new LivroNaoEncontradoException();
  }

}
