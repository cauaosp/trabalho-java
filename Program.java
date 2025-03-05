import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Program {

  public static void main(String[] args) {
    String caminho_arquivo_de_leitura = "C:\\Users\\cauao\\source\\repos\\estrutura_de_dados\\trabalho1\\trabalho-java\\arquivo_de_leitura.txt";
    File arquivo_de_leitura = new File(caminho_arquivo_de_leitura);
    HashMap<String, List<Integer>> texto_em_hash = new HashMap<>();
    int linha = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(arquivo_de_leitura))) {
      String line = br.readLine();

      while (line != null) {
        String[] field = line.split("\\s+");
        for (String word : field) {
          texto_em_hash.putIfAbsent(word, new ArrayList<>());
          texto_em_hash.get(word).add(linha);
        }
        line = br.readLine();
        linha++;
      }

      System.out.println(texto_em_hash);
      System.out.println(texto_em_hash.get("de"));
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

  }
}