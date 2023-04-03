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
import java.net.URL;

import javax.imageio.ImageIO;

import br.com.alura.stickers.Conteudos.Conteudo;

public class GeradorStickers {
 
  public GeradorStickers() {
  }

  public void criar(Conteudo item, String fraseAdicionada, InputStream imagemAvaliacao, InputStream imagemPedro, Color cor, int opcaoAPI) throws Exception{
      // Passando a imagem para URL
      URL urlImagemURL =  new URL(item.getUrlImagem());

      
      // Leitura da Imagem
      BufferedImage imagemOriginal = ImageIO.read(urlImagemURL);
      BufferedImage imagemTitulo = ImageIO.read(new File("sobreposicao/TITULOS/" + opcaoAPI + ".png"));
  
      // Cria nova imagem em memoria com transparencia e novo tamanho
      int largaura = imagemOriginal.getWidth();
      int altura = imagemOriginal.getHeight();
      int novaAltura = altura + 200;
      BufferedImage novaImagem = new BufferedImage(largaura, novaAltura, BufferedImage.TRANSLUCENT);
  
      // Copiar imagem original para nova
      Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
      graphics.drawImage(imagemOriginal, 0, 0, null);
      graphics.drawImage(imagemTitulo, imagemOriginal.getWidth() / 2 - imagemTitulo.getWidth() / 2, novaAltura - imagemTitulo.getHeight(), null);
      
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

      String nomeFilme = item.getTitulo().replaceAll(":", "");
      ImageIO.write(novaImagem, "png", new File("saida/" + nomeFilme + ".png"));

  }

  public void criarTWD(Conteudo item, String nome, InputStream imagemTemporada, InputStream imagemComunidade,  InputStream imagemArma,  InputStream imagemStatus, Color cor) throws Exception{
    // Passando a imagem para URL
    URL urlImagemURL =  new URL(item.getUrlImagem());

    // Leitura da Imagem
    BufferedImage imagemOriginal = ImageIO.read(urlImagemURL);
    BufferedImage imagemTitulo = ImageIO.read(new File("sobreposicao/TITULOS/TWD.png"));

    // Cria nova imagem em memoria com transparencia e novo tamanho
    int largaura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 400;
    BufferedImage novaImagem = new BufferedImage(largaura, novaAltura, BufferedImage.TRANSLUCENT);

    // Copiar imagem original para nova
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 200, null);
    graphics.drawImage(imagemTitulo, imagemOriginal.getWidth() / 2 - imagemTitulo.getWidth() / 2, 0, null);
    
    // Criando sobreposicao
    BufferedImage sobreposicaoTemporada = ImageIO.read(imagemTemporada);
    BufferedImage sobreposicaoComunidade = ImageIO.read(imagemComunidade);
    BufferedImage sobreposicaoArma = ImageIO.read(imagemArma);
    BufferedImage sobreposicaoStatus = ImageIO.read(imagemStatus);

    // Escrever frase na imagem
    // Configurando fonta
    var fonte = new Font("impact", Font.BOLD, 65);
    graphics.setColor(cor);
    graphics.setFont(fonte);

    // Juntando imagem e texto
    String texto = nome;
    FontMetrics fontMetrics = graphics.getFontMetrics();
    Rectangle2D retangulo = fontMetrics.getStringBounds(texto, graphics);
    int larguraTexto = (int) retangulo.getWidth();
    int posicaoTexto = (largaura - larguraTexto) / 2;
    int alturaTexto = 130;

    graphics.drawString(texto, posicaoTexto, novaAltura - alturaTexto);

    BufferedImage capaTemporada = ImageIO.read(new File("sobreposicao/TWD/CAPAS/FIRSTSEASON.png"));
    BufferedImage capaGunType = ImageIO.read(new File("sobreposicao/TWD/CAPAS/GUNTYPE.png"));
    BufferedImage capaCommunity = ImageIO.read(new File("sobreposicao/TWD/CAPAS/COMMUNITY.png"));
    BufferedImage capaStatus = ImageIO.read(new File("sobreposicao/TWD/CAPAS/STATUS.png"));

    //Esquerda
    graphics.drawImage(capaCommunity, 0, novaAltura -  capaCommunity.getHeight(), null);
    graphics.drawImage(sobreposicaoComunidade,  19, novaAltura - sobreposicaoComunidade.getHeight() - 28, null);
    
    graphics.drawImage(capaTemporada, 0, 0, null);
    graphics.drawImage(sobreposicaoTemporada, 20, 28, null);

    //Direita
    graphics.drawImage(capaGunType, imagemOriginal.getWidth() - capaGunType.getWidth(), 0, null);
    graphics.drawImage(sobreposicaoArma,  imagemOriginal.getWidth() - sobreposicaoArma.getWidth() - 20, 25, null);

    graphics.drawImage(capaStatus, imagemOriginal.getWidth() - capaStatus.getWidth(), novaAltura - capaStatus.getHeight(), null);
    graphics.drawImage(sobreposicaoStatus,  imagemOriginal.getWidth() - sobreposicaoStatus.getWidth() - 19, novaAltura - sobreposicaoComunidade.getHeight() - 29, null);

    // Fazendo Outline
    FontRenderContext fontRendererContext = graphics.getFontRenderContext();
    var textLayout = new TextLayout(texto, fonte, fontRendererContext);

    Shape outline = textLayout.getOutline(null);
    AffineTransform transform = graphics.getTransform();
    transform.translate(posicaoTexto, novaAltura - alturaTexto);
    graphics.setTransform(transform);

    BasicStroke outlineStroke = new BasicStroke(largaura * 0.004f);
    graphics.setStroke(outlineStroke);

    graphics.setColor(Color.BLACK);
    graphics.draw(outline);
    graphics.setClip(outline);

    String nomeFilme = item.getTitulo().replaceAll(":", "");
    ImageIO.write(novaImagem, "png", new File("saida/" + nomeFilme + ".png"));

}

}
