package br.com.alura.stickers.Extratores;
import java.util.List;
import java.util.Map;

import br.com.alura.stickers.Conteudos.ConteudoNasa;
import br.com.alura.stickers.JsonParsers.JsonParser;

public class ExtratorNasa  extends Extrator{
  
  @Override
  public List<ConteudoNasa> extraiNasa(String json){
    JsonParser parser = new JsonParser();
    List<Map<String, String>> listaAtributosBodyAPI = parser.parse(json);

    return listaAtributosBodyAPI.stream()
      .map((atributos) -> new ConteudoNasa(atributos.get("title"), atributos.get("url"), atributos.get("date")))
      .toList();
    }
}