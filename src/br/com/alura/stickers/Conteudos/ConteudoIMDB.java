package br.com.alura.stickers.Conteudos;
public class ConteudoIMDB extends Conteudo{

  private String rating;

  public ConteudoIMDB(String titulo, String urlImagem, String rating) {
    super(titulo, urlImagem);
    this.rating = rating;  
  }
  
  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

}
