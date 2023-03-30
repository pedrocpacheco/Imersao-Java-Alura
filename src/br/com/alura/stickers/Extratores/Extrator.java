package br.com.alura.stickers.Extratores;

import java.util.List;
import java.util.Map;

import br.com.alura.stickers.Conteudos.Conteudo;
import br.com.alura.stickers.Conteudos.ConteudoIMDB;
import br.com.alura.stickers.Conteudos.ConteudoNasa;
import br.com.alura.stickers.JsonParsers.JsonParser;


public abstract class Extrator {

  // public List<Conteudo> extrai(String json){
  //   JsonParser parser = new JsonParser();
  //   List<Map<String, String>> listaAtributosGenericos = parser.parse(json);

  //   return listaAtributosGenericos.stream()
  //     .map((atributos) -> new Conteudo(atributos.get("title"), atributos.get("image")))
  //     .toList();
  //   } 
  

  public List<ConteudoIMDB> extraiIMDB(String json){
    throw new RuntimeException("Metodo não definido");
  }
  
  public List<ConteudoNasa> extraiNasa(String json){
    throw new RuntimeException("Metodo não definido");
  }


}
