package br.com.alura.stickers;
import java.util.List;
import java.util.Map;

import br.com.alura.stickers.JsonParsers.JsonParser;

public class FiltradorLista {
  
  public List<Map<String, String>> filtrarLista(String dadosAPI){
    JsonParser parser = new JsonParser();
    List<Map<String, String>> listaDeConteudo = parser.parse(dadosAPI);
    return listaDeConteudo;

  }

}
