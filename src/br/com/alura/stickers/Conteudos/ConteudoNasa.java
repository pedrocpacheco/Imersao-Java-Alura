package br.com.alura.stickers.Conteudos;
public class ConteudoNasa extends Conteudo {

  private String date;

  public ConteudoNasa(String titulo, String urlImagem, String date) {
    super(titulo, urlImagem);
    this.date = date;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
  
}
