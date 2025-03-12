public class No {
  private Palavra valor;
  private No proximo;

  public No(Palavra valor) {
    this.valor = valor;
    this.proximo = null;
  }

  public Palavra getValor() {
    return valor;
  }

  public void setValor() {
    this.valor = valor;
  }

  public No getProximo() {
    return proximo;
  }

  public void setProximo(No proximo) {
    this.proximo = proximo;
  }
}
