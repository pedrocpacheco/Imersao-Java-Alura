package br.com.alura.stickers.Extratores;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.alura.stickers.Conteudos.Conteudo;
import br.com.alura.stickers.Conteudos.ConteudoNasa;
import br.com.alura.stickers.JsonParser.JsonParser;

public class ExtratorNasa {
  public List<Conteudo> extraiConteudos(String json){

    // Pegando o JSON da API e pegando so o valor que dejamos.
    JsonParser parser = new JsonParser();
    List<Map<String, String>> listaAtributosBodyAPI = parser.parse(json);

    // Criando lista de Conteudos
    List<Conteudo> conteudos = new ArrayList<>();

    for(Map<String, String> atributos: listaAtributosBodyAPI){
      // Pegando valor da chave Title do Conteudo X
      String titulo = atributos.get("title");
      // Pegando valor da chave url do Conteudo X
      String urlImagem = atributos.get("url");
      // Pegando valor da chave date do Conteudo X
      String date = atributos.get("date");

      Conteudo conteudo = new ConteudoNasa(titulo, urlImagem, date);

      conteudos.add(conteudo);      
    }

    //
    return conteudos;

  }
}