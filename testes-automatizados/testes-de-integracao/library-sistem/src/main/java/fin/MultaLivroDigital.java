package fin;

import emp.Emprestimo;

public class MultaLivroDigital implements IMulta{
  private float valorMulta;

  public MultaLivroDigital(){
    this.valorMulta = 0;
  }

  @Override
  public void calcularMulta(Emprestimo emprestimo) {
    this.valorMulta = (float) (emprestimo.numeroDiasAtraso() * 0.25);
  }

  @Override
  public float getValorMulta() {
    return this.valorMulta;
  }
}
