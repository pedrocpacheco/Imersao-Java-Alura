package br.com.alura.stickers.Conteudos;
public class ConteudoTWD extends Conteudo{

  private String firstSeason;
  private String community;
  private String gunType;
  private String alive;

  public ConteudoTWD(String titulo, String urlImagem, String string, String community, String gunType, String string2) {
    super(titulo, urlImagem);
    this.firstSeason = String.valueOf(string);
    this.community = community;
    this.gunType = gunType;
    this.alive = String.valueOf(string2);
    //TODO Auto-generated constructor stub
  }

  public String getFirstSeason() {
    return firstSeason;
  }

  public String getCommunity() {
    return community;
  }

  public String getGunType() {
    return gunType;
  }
  
  public String isAlive() {
    return alive;
  }
  
}
