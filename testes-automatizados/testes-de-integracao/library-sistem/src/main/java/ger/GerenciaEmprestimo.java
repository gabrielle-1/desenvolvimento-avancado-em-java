package ger;

import book.Livro;
import emp.Emprestimo;
import emp.excep.AtrasoException;
import emp.excep.MaximoExtensoesException;
import ger.exceptions.EmprestimoNaoEncontradoException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import user.Usuario;

public class GerenciaEmprestimo {
  private List<Emprestimo> emprestimos;

  public GerenciaEmprestimo(){
    this.emprestimos = new ArrayList<>();
  }

  public List<Emprestimo> getEmprestimos(){
    return this.emprestimos;
  }

  public void adicionarEmprestimo(Usuario usuario, Livro livro){
    if (!usuarioComEmprestimoAtivo(usuario.getIdUsuario())){
      this.emprestimos.add(new Emprestimo(livro.getIdLivro(), usuario.getIdUsuario(), Calendar.getInstance().getTime()));
    }
  }

  public void adicionarEmprestimo(Usuario usuario, Livro livro, Date date){
    if (!usuarioComEmprestimoAtivo(usuario.getIdUsuario())){
      this.emprestimos.add(new Emprestimo(livro.getIdLivro(), usuario.getIdUsuario(), date));
    }
  }

  private boolean usuarioComEmprestimoAtivo(String idUsuario){
    for(Emprestimo emprestimo: emprestimos){
      if (emprestimo.getIdUsuario().equals(idUsuario))
        return true;
    }
    return false;
  }

  public Emprestimo buscaEmprestimoPorIdLivro(String idLivro)
      throws EmprestimoNaoEncontradoException {
    for(Emprestimo emprestimo: emprestimos){
      if(emprestimo.getIdLivro().equals(idLivro))
        return emprestimo;
    }
    throw new EmprestimoNaoEncontradoException();
  }

  public void devolverLivro(String idLivro) throws EmprestimoNaoEncontradoException {
      try {
        Emprestimo emprestimo = buscaEmprestimoPorIdLivro(idLivro);
        emprestimo.devolverLivro();
      }catch (AtrasoException atrasoException){
        System.out.println(atrasoException.getMessage());
      }catch (EmprestimoNaoEncontradoException emprestimoNaoEncontradoException){
        System.out.println(emprestimoNaoEncontradoException.getMessage());
      }
  }

  public void estenderEmprestimo(String idLivro)
      throws MaximoExtensoesException, EmprestimoNaoEncontradoException {
      Emprestimo emprestimo = buscaEmprestimoPorIdLivro(idLivro);
      emprestimo.estenderEmprestimo();
  }

}
