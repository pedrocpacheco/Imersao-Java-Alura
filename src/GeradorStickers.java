import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

public class GeradorStickers {
 
  public GeradorStickers() {
  }

  public void criar(String urlImagem, String nomeFilme, String fraseAdicionada) throws Exception{

  // Passando a imagem para URL
  URL urlImagemURL =  new URL(urlImagem);

  // Leitura da Imagem
  BufferedImage imagemOriginal = ImageIO.read(urlImagemURL);

  // Cria nova imagem em memoria com transparencia e novo tamanho
  int largaura = imagemOriginal.getWidth();
  int altura = imagemOriginal.getHeight();
  int novaAltura = altura + 200;
  BufferedImage novaImagem = new BufferedImage(largaura, novaAltura, BufferedImage.TRANSLUCENT);

  // Copiar imagem original para nova
  Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
  graphics.drawImage(imagemOriginal, 0, 0, null);
  
  // Escrever frase na imagem
  // Configurando fonta
  var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
  graphics.setColor(Color.YELLOW);
  graphics.setFont(fonte);

  // Juntando imagem e texto
  graphics.drawString(fraseAdicionada, (imagemOriginal.getWidth()) / 2 - 150, novaAltura - 100);

  // Escrever em arquivo
  ImageIO.write(novaImagem, "png", new File("saida/" + nomeFilme + ".png"));

  }
  
  public static void main(String[] args) throws Exception {
    GeradorStickers geradorStickers = new GeradorStickers();
    geradorStickers.criar("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs_2.jpg", "BreakingBad",  "SEXO!");
  }


}
