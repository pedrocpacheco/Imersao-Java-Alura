package br.com.alura.stickers.Extratores;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.alura.stickers.Conteudos.ConteudoIMDB;
import br.com.alura.stickers.JsonParser.JsonParser;

public class ExtratorIMDB{
  public List<ConteudoIMDB> extrai(String json){

   // Pegando o JSON da API e pegando so o valor que dejamos.
   JsonParser parser = new JsonParser();
   List<Map<String, String>> listaAtributosBodyAPI = parser.parse(json);

   // Criando lista de Conteudos
   List<ConteudoIMDB> conteudos = new ArrayList<>();

   for(Map<String, String> atributos: listaAtributosBodyAPI){
    // Pegando valor da chave Title do Conteudo X
    String titulo = atributos.get("title");
    // Pegando valor da chave url do Conteudo X
    String urlImagem = atributos.get("image");
    // Pegando o valor da chave ratng do Conteudo X
    String rating = atributos.get("imDbRating");

    ConteudoIMDB conteudo = new ConteudoIMDB(titulo, urlImagem, rating);

     conteudos.add(conteudo);      
   }

   //
   return conteudos;

  }
}
