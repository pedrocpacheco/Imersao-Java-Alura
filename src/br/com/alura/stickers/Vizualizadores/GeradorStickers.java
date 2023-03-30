package br.com.alura.stickers.Vizualizadores;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GeradorStickers {
 
  public GeradorStickers() {
  }

  public void criarNasa(){

  }

  public void criarIMDB(String urlImagem, String nomeFilme, String fraseAdicionada, InputStream imagemAvaliacao, InputStream imagemPedro, Color cor) throws Exception{

    BufferedImage novaImagem = criarPadrao(urlImagem, nomeFilme, fraseAdicionada, imagemAvaliacao, imagemPedro, cor);

    // Escrever em arquivo
    nomeFilme = nomeFilme.replaceAll(":", "");
    ImageIO.write(novaImagem, "png", new File("saida/" + nomeFilme + ".png"));

  }

  public BufferedImage criarPadrao(String urlImagem, String nomeFilme, String fraseAdicionada, InputStream imagemAvaliacao, InputStream imagemPedro, Color cor) throws Exception{
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
      
      // Criando sobreposicao
      BufferedImage imagemSobreposicao = ImageIO.read(imagemAvaliacao);
      BufferedImage imagemNotaPedro = ImageIO.read(imagemPedro);
      // Escrever frase na imagem
      // Configurando fonta
      var fonte = new Font("impact", Font.BOLD, 100);
      graphics.setColor(cor);
      graphics.setFont(fonte);
  
      // Juntando imagem e texto
      String texto = fraseAdicionada;
      FontMetrics fontMetrics = graphics.getFontMetrics();
      Rectangle2D retangulo = fontMetrics.getStringBounds(texto, graphics);
      int larguraTexto = (int) retangulo.getWidth();
      int posicaoTexto = (largaura - larguraTexto) / 2;
  
      graphics.drawString(texto, posicaoTexto, novaAltura - 100);
      graphics.drawImage(imagemSobreposicao,  0, novaAltura - imagemSobreposicao.getHeight(), null);
      graphics.drawImage(imagemNotaPedro,  imagemOriginal.getWidth() - imagemNotaPedro.getWidth(), novaAltura - imagemSobreposicao.getHeight(), null);
  
  
      // Fazendo Outline
      FontRenderContext fontRendererContext = graphics.getFontRenderContext();
      var textLayout = new TextLayout(texto, fonte, fontRendererContext);
  
      Shape outline = textLayout.getOutline(null);
      AffineTransform transform = graphics.getTransform();
      transform.translate(posicaoTexto, novaAltura - 100);
      graphics.setTransform(transform);
  
      BasicStroke outlineStroke = new BasicStroke(largaura * 0.004f);
      graphics.setStroke(outlineStroke);
  
      graphics.setColor(Color.BLACK);
      graphics.draw(outline);
      graphics.setClip(outline);
      return novaImagem;
  }

}
