package br.com.alura.stickers.Vizualizadores;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ConversorASCII{
  
  public String imageParaAscii(String imagemFilme) throws IOException{
    String urlImagem = imagemFilme;
    URL urlImagemURL =  new URL(urlImagem); // String para URL
    BufferedImage imagem = ImageIO.read(urlImagemURL); // Adicionando a Buffered Image

    // Definindo largura e altura da imagem
    int larguraPadrao = 100;
    int alturaPadrao = 100;

    // Passando a imagem para o tamanho desejado
    BufferedImage imagemRedimensionada = new BufferedImage(larguraPadrao, alturaPadrao, BufferedImage.TYPE_INT_RGB);
    Graphics2D g = imagemRedimensionada.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g.drawImage(imagem, 0, 0, larguraPadrao, alturaPadrao, null);
    g.dispose();

    // Passando os caracteres que desejo
    String caracteres = "@#S%?*+;:,. ";

    StringBuilder resultado = new StringBuilder();
    for (int y = 0; y < alturaPadrao; y++) {
        for (int x = 0; x < larguraPadrao; x++) {
            int cor = imagemRedimensionada.getRGB(x, y);
            int r = (cor >> 16) & 0xff;
            int l = (cor >> 8) & 0xff;
            int b = cor & 0xff;
            int brilho = (int) (0.2126 * r + 0.7152 * l + 0.0722 * b);
            int indiceCaractere = (int) (brilho / 255.0 * (caracteres.length() - 1));
            char caractere = caracteres.charAt(indiceCaractere);
            resultado.append(caractere);
        }
        resultado.append("\n");
    }

// Exibe o ASCII final no Terminal
return resultado.toString();
}

}