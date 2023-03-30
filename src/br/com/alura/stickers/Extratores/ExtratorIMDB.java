package br.com.alura.stickers.Extratores;
import java.util.List;
import java.util.Map;

import br.com.alura.stickers.Conteudos.ConteudoIMDB;
import br.com.alura.stickers.JsonParsers.JsonParser;

public class ExtratorIMDB extends Extrator{

  @Override
  public List<ConteudoIMDB> extraiIMDB(String json){
    JsonParser parser = new JsonParser();
    List<Map<String, String>> listaAtributosBodyAPI = parser.parse(json);

    return listaAtributosBodyAPI.stream()
      .map((atributos) -> new ConteudoIMDB(atributos.get("title"), atributos.get("image"), atributos.get("imDbRating")))
      .toList();
    }
}