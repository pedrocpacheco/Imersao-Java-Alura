import java.util.List;
import java.util.Map;

public class FiltradorLista {
  
  public List<Map<String, String>> filtrarLista(String dadosAPI){
    JsonParser parser = new JsonParser();
    List<Map<String, String>> listaDeConteudo = parser.parse(dadosAPI);
    return listaDeConteudo;

  }

}
