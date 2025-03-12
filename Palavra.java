import java.util.List;

public class Palavra {
  String palavra;
  List<Integer> linhas;

  public Palavra(String palavra, List<Integer> linhas) {
    this.palavra = palavra;
    this.linhas = linhas;
  }

  public String getPalavra() {
    return palavra;
  }

  public List<Integer> getLinhas() {
    return linhas;
  }

  @Override
  public String toString() {
    return palavra + ": " + linhas;
  }
}
