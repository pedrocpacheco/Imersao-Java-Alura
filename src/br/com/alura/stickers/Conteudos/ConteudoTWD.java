package br.com.alura.stickers.Conteudos;
public class ConteudoTWD extends Conteudo{

  private String firstSeason;
  private String community;
  private String gunType;
  private String alive;

  public ConteudoTWD(String titulo, String urlImagem, String firstSeason, String community, String gunType, String alive) {
    super(titulo, urlImagem);
    this.firstSeason = firstSeason;
    this.community = community;
    this.gunType = gunType;
    this.alive = alive;
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
