import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Program {
  public static void main(String[] args) {
    String caminho_arquivo_de_leitura = "C:\\Users\\cauao\\source\\repos\\estrutura_de_dados\\trabalho1\\trabalho-java\\arquivo_de_leitura.txt";
    File arquivo_de_leitura = new File(caminho_arquivo_de_leitura);

    String caminho_input_para_busca = "C:\\Users\\cauao\\source\\repos\\estrutura_de_dados\\trabalho1\\trabalho-java\\input_para_busca.txt";
    File input_para_busca = new File(caminho_input_para_busca);

    HashMap<String, List<Integer>> texto_em_hash = new HashMap<>();
    int linha = 1;
    List<String> lista_para_buscar = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(arquivo_de_leitura))) {
      String line = br.readLine();

      while (line != null) {
        String[] field = line.split("\\s+");
        for (String palavra : field) {
          texto_em_hash.putIfAbsent(palavra, new ArrayList<>());
          texto_em_hash.get(palavra).add(linha);
        }
        line = br.readLine();
        linha++;
      }
    } catch (IOException e) {
      System.out.println("Um erro ocorreu!");
      e.printStackTrace();
    }

    try (BufferedReader br = new BufferedReader(new FileReader(input_para_busca))) {
      String line = br.readLine();

      while (line != null) {
        String[] field = line.replaceAll("[,.]", "").split("\\s+");
        lista_para_buscar.addAll(Arrays.asList(field));
        line = br.readLine();
      }
    } catch (IOException e) {
      System.out.println("Um erro ocorreu!");
      e.printStackTrace();
    }

    for (String palavra : lista_para_buscar) {
      if (texto_em_hash.get(palavra) != null) {
        System.out.println(palavra + " " + texto_em_hash.get(palavra).toString().replace("[", "").replace("]", ""));
      }
    }
  }
}