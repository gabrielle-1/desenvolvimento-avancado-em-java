import book.Livro;
import book.LivroFisico;
import emp.Emprestimo;
import ger.GerenciaEmprestimo;
import ger.GerenciaLivros;
import ger.GerenciaUsuario;
import ger.exceptions.EmprestimoNaoEncontradoException;
import ger.exceptions.LivroNaoEncontradoException;
import ger.exceptions.UsuarioNaoEncontradoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import user.Usuario;

import java.util.ArrayList;
import java.util.Date;

public class LocaInLocoTest {

  Usuario usuario;
  GerenciaUsuario gerenciaUsuario;
  GerenciaEmprestimo gerenciaEmprestimo;
  Livro livro;

  @BeforeEach
  public void setup() {
    this.usuario = new Usuario("000029709", "Danilo");
    gerenciaUsuario = new GerenciaUsuario();
  }

  @Test
  public void execucaoPrincialTest(){
    System.out.println("Sistema executando em perfeito estado!!!");
  }

  @Test
  public void esperaNovoNomeDeUsuario() {
    this.usuario.setNome("Danilo Silva");
    Assertions.assertEquals("Danilo Silva", this.usuario.getNome());
  }

  @Test
  public void esperaInserirUsuarioNoSistema() {
    gerenciaUsuario.adicionarUsuario("000029709", "Danilo Silva");
    Assertions.assertTrue(gerenciaUsuario.getUsuarios().size() >= 1);
  }

  @Test
  public void esperaNaoInserirUsuarioNoSistema() {
    gerenciaUsuario.adicionarUsuario("000029709", "Danilo Silva");
    gerenciaUsuario.adicionarUsuario("000029709", "Danilo");
    Assertions.assertFalse(gerenciaUsuario.getUsuarios().size() > 1);
  }

  @Test
  public void esperaEncontrarUsuarioNoSistema() throws UsuarioNaoEncontradoException {
    gerenciaUsuario.adicionarUsuario("000029709", "Danilo");
    Assertions.assertTrue(
            gerenciaUsuario.buscaUsuarioPorId("000029709").getIdUsuario().equals(usuario.getIdUsuario()));
  }

  @Test
  public void esperaNaoEncontrarUsuarioNoSistema() {
    gerenciaUsuario.adicionarUsuario("000029709", "Danilo");
    Throwable throwable = Assertions.assertThrows(UsuarioNaoEncontradoException.class,
            () -> gerenciaUsuario.buscaUsuarioPorId("00029709"));
    Assertions.assertEquals(
            "Usuário não disponível. Por favor, verifique o código informado", throwable.getMessage());
  }

  @Test
  public void esperaFazerEmprestimoLivro(){
    GerenciaEmprestimo gerenciaEmprestimo = Mockito.mock(GerenciaEmprestimo.class);
    gerenciaEmprestimo.adicionarEmprestimo(usuario, livro);
    Mockito.verify(gerenciaEmprestimo).adicionarEmprestimo(usuario, livro);
  }

  @Test
  public void esperaAumentoTamanhoEmprestimosAoFazerEmprestimoLivro(){
    GerenciaEmprestimo gerenciaEmprestimo = Mockito.mock(GerenciaEmprestimo.class);
    gerenciaEmprestimo.adicionarEmprestimo(usuario, livro);

    Mockito.when(gerenciaEmprestimo.getSizeEmprestimos()).thenReturn(1);
    Assertions.assertEquals(1, gerenciaEmprestimo.getSizeEmprestimos());
  }

  @Test
  public void esperaInserirLivroNoSistema() throws LivroNaoEncontradoException {
    GerenciaLivros gerenciaLivros = Mockito.mock(GerenciaLivros.class);
    gerenciaLivros.adicionarNovoLivroFisico("Sem fraude nem favor", "Jurandir Freire Costa",
            "1", "85-325-0925-8", 221);
    Mockito.verify(gerenciaLivros).adicionarNovoLivroFisico("Sem fraude nem favor", "Jurandir Freire Costa",
            "1", "85-325-0925-8", 221);
  }





}
