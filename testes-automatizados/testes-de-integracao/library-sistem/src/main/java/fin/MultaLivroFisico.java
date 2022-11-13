package fin;

import emp.Emprestimo;

public class MultaLivroFisico implements IMulta{
  private float valorMulta;

  public MultaLivroFisico(){
    this.valorMulta = 0;
  }

  @Override
  public void calcularMulta(Emprestimo emprestimo) {
    int days = emprestimo.numeroDiasAtraso();
    this.valorMulta = (float) (days * 0.5);
  }

  @Override
  public float getValorMulta() {
    return this.valorMulta;
  }
}
