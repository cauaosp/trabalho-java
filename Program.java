import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class Program {
  public static void main(String[] args) {
    LeituraDeArquivos leituraDeArquivos = new LeituraDeArquivos(
        "C:\\Users\\cauao\\source\\repos\\estrutura_de_dados\\trabalho1\\trabalho-java\\arquivo_de_leitura.txt",
        "C:\\Users\\cauao\\source\\repos\\estrutura_de_dados\\trabalho1\\trabalho-java\\input_para_busca.txt");
    List<String> names = Arrays.asList("Rahul", "Ajay", "Gourav", "Riya");

    HashMap<String, List<Integer>> texto_em_hash = leituraDeArquivos.EstruturandoTextoEmHash();

    List<String> lista_para_buscar = leituraDeArquivos.ListarPalavrasChave();

    ManipuladorDaFila manipuladorFila = new ManipuladorDaFila();
    Fila fila = manipuladorFila.criar();

    for (String palavra : lista_para_buscar) {
      if (texto_em_hash.get(palavra) != null) {
        Palavra novaPalavra = new Palavra(palavra, texto_em_hash.get(palavra));
        manipuladorFila.adicionarPalavra(fila, novaPalavra);
      }
    }

    Palavra palavra1 = new Palavra("hello", List.of(1, 3, 5));
    Palavra palavra2 = new Palavra("world", List.of(2, 4, 6));
    Palavra palavra3 = new Palavra("teste", List.of(7, 8, 9));

    manipuladorFila.adicionarPalavra(fila, palavra1);
    manipuladorFila.adicionarPalavra(fila, palavra2);
    manipuladorFila.adicionarPalavra(fila, palavra3);

    manipuladorFila.display(fila);
  }
}