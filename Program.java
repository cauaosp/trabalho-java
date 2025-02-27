import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
  public static void main(String[] args) {
    String path = "C:\\Users\\cauao\\source\\repos\\estrutura_de_dados\\trabalho1\\arquivo_de_leitura.txt";
    List<String> stringList = new ArrayList<>();
    File arquivo_de_leitura = new File(path);

    try (BufferedReader br = new BufferedReader(new FileReader(arquivo_de_leitura))) {
      String line = br.readLine();

      while (line != null) {
        String[] field = line.split("\\s+"); // Divide a linha em palavras
        stringList.addAll(Arrays.asList(field)); // Adiciona as palavras à lista
        System.out.println(Arrays.toString(field)); // Exibe as palavras
        line = br.readLine(); // Lê a próxima linha
      }
    } catch (IOException e) { // Captura exceções de leitura de arquivo
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}