package br.com.alura.stickers.Extratores;
import java.util.List;

import br.com.alura.stickers.Conteudos.Conteudo;


public interface Extrator {
  
  public List<Conteudo> extrai(String json);
  


}
