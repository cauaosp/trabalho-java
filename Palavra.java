public class Palavra {
  String palavra;
  int linhas;

  public Palavra(String palavra, int linhas){
    this.palavra = palavra;
    this.linhas = linhas;
  }

  public String getPalavra() {
    return palavra;
  }

  public int getLinhas() {
    return linhas;
  }

  @Override
  public String toString() {
      return palavra + ": " + linhas;
  }
}
