package ger;

import book.Livro;
import ger.exceptions.UsuarioNaoEncontradoException;
import java.util.ArrayList;
import java.util.List;
import user.Usuario;

public class GerenciaUsuario {
  private List<Usuario> usuarios;

  public GerenciaUsuario(){
    this.usuarios = new ArrayList<>();
  }

  public List<Usuario> getUsuarios(){
    return this.usuarios;
  }

  public void adicionarUsuario(String idUsuario, String nome){
    if(usuarioExistente(idUsuario) == false){
      this.usuarios.add(new Usuario(idUsuario, nome));
    }
  }

  private boolean usuarioExistente(String idUsuario){
    for(Usuario usuario: usuarios){
      if(usuario.getIdUsuario().equals(idUsuario)){
        return true;
      }
    }
    return false;
  }

  public Usuario buscaUsuarioPorId(String idUsuario) throws UsuarioNaoEncontradoException {
    for(Usuario usuario: usuarios){
      if(usuario.getIdUsuario().equals(idUsuario)){
        return usuario;
      }
    }
    throw new UsuarioNaoEncontradoException();
  }
}
