import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CriadorJFrame {
  
  public void criarJframe(String urlImagem) throws IOException{
    URL urlImagemURL =  new URL(urlImagem); // String para URL
    BufferedImage imagem = ImageIO.read(urlImagemURL);
    JLabel label = new JLabel(new ImageIcon(imagem));
    JFrame frame = new JFrame();
    frame.add(label);
    frame.pack();
    frame.setVisible(true);
  }

}
