import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeituraDeArquivos {
  String caminhoArquivoDeLeitura;
  String caminhoInputPalavrasChave;

  public LeituraDeArquivos(String caminhoArquivoDeLeitura, String caminhoInputPalavrasChave) {
    this.caminhoArquivoDeLeitura = caminhoArquivoDeLeitura;
    this.caminhoInputPalavrasChave = caminhoInputPalavrasChave;
  }

  public HashMap<String, List<Integer>> EstruturandoTextoEmHash() {
    File arquivo_de_leitura = new File(this.caminhoArquivoDeLeitura);
    HashMap<String, List<Integer>> texto_em_hash = new HashMap<>();
    int linha = 1;

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

    return texto_em_hash;
  }

  public List<String> OrdenarLista(List<String> lista) {
    int tamanhoLista = lista.size();
    String palavraTemporaria;

    for (int i = 0; i < tamanhoLista; i++) {
      for (int j = i + 1; j < tamanhoLista; j++) {
        if (lista.get(i).compareTo(lista.get(j)) > 0) {
          palavraTemporaria = lista.get(i);
          lista.set(i, lista.get(j));
          lista.set(j, palavraTemporaria);
        }
      }
    }

    return lista;
  }

  public List<String> ListarPalavrasChave() {
    File input_para_busca = new File(this.caminhoInputPalavrasChave);
    List<String> lista_para_buscar = new ArrayList<>();

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

    return OrdenarLista(lista_para_buscar);
  }

  public String getCaminhoArquivoDeLeitura() {
    return caminhoArquivoDeLeitura;
  }

  public String getCaminhoInputPalavrasChave() {
    return caminhoInputPalavrasChave;
  }

}
