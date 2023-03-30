package br.com.alura.stickers.Extratores;

import java.util.List;

import br.com.alura.stickers.Conteudos.ConteudoIMDB;
import br.com.alura.stickers.Conteudos.ConteudoNasa;


public abstract class Extrator {

  

  public List<ConteudoIMDB> extraiIMDB(String json){
    throw new RuntimeException("Metodo não definido");
  }
  
  public List<ConteudoNasa> extraiNasa(String json){
    throw new RuntimeException("Metodo não definido");
  }


}
