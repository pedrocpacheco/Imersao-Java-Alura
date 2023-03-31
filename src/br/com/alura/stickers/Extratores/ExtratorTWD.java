package br.com.alura.stickers.Extratores;

import java.util.List;
import java.util.Map;

import br.com.alura.stickers.Conteudos.ConteudoTWD;
import br.com.alura.stickers.JsonParsers.JsonParser;

public class ExtratorTWD extends Extrator{
  
  public List<ConteudoTWD> extraiTWD(String json){
    JsonParser parser = new JsonParser();
    List<Map<String, String>> listaAtributosBodyAPI = parser.parse(json);
    return listaAtributosBodyAPI.stream()
    .map((atributos) -> new ConteudoTWD(atributos.get("name"), atributos.get("image"), atributos.get("firstSeason"), atributos.get("community"), atributos.get("gunType"), atributos.get("status")))
    .toList();
  }

}
