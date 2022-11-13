package emp;

import emp.excep.AtrasoException;
import emp.excep.MaximoExtensoesException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Emprestimo {
  private String idLivro;
  private String idUsuario;
  private Date dataEmprestimo;
  private Date dataDevolucao;
  private boolean extensaoRealizada;

  public Emprestimo(String idlivro, String idUsuario, Date dataEmprestimo){
    this.idLivro = idlivro;
    this.idUsuario = idUsuario;
    this.dataEmprestimo = dataEmprestimo;
    this.dataDevolucao = calcularDataDevolucao(dataEmprestimo);
    this.extensaoRealizada = false;
  }

  private Date calcularDataDevolucao(Date data){
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(data);
    calendar.add(Calendar.DATE, 7);
    return calendar.getTime();
  }

  private boolean livroEmAtraso(){
    if (Calendar.getInstance().getTime().compareTo(this.dataDevolucao) < 0){
      return true;
    }
    return false;
  }

  public void estenderEmprestimo() throws MaximoExtensoesException {
    if (this.extensaoRealizada == false){
      this.dataDevolucao = calcularDataDevolucao(this.dataDevolucao);
      this.extensaoRealizada = true;
    }else{
      throw new MaximoExtensoesException(idLivro, Calendar.getInstance().getTime().compareTo(this.dataDevolucao));
    }
  }

  public boolean devolverLivro() throws AtrasoException {
    if (livroEmAtraso())
      return true;
    else throw new AtrasoException(this.idLivro, this.idUsuario);
  }

  public int numeroDiasAtraso(){
    long diff = Math.abs(Calendar.getInstance().getTime().getTime() - this.dataDevolucao.getTime());
    return Integer.valueOf(String.valueOf(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)));
  }

  public String getIdLivro() {
    return idLivro;
  }

  public String getIdUsuario() {
    return idUsuario;
  }

  public Date getDataEmprestimo() {
    return dataEmprestimo;
  }

  public Date getDataDevolucao() {
    return dataDevolucao;
  }

  public boolean isExtensaoRealizada() {
    return extensaoRealizada;
  }

}
