package br.com.alura.stickers.Vizualizadores;

import java.io.IOException;

import javax.swing.JFrame;

import br.com.alura.stickers.Conteudos.Conteudo;
import br.com.alura.stickers.Conteudos.ConteudoIMDB;

public class EscolhaVizualizacao {

  public void escolherVizualizacao(int opcao, Conteudo item) throws IOException{
    if(opcao == 1){
      ConversorASCII conversorASCII = new ConversorASCII();
      System.out.println(conversorASCII.imageParaAscii(item.getUrlImagem()));

    } else if(opcao == 2){
      CriadorJFrame criadorJFrame = new CriadorJFrame();
      criadorJFrame.criarJframe(item.getUrlImagem());
    } else if (opcao == 3){
      GeradorStickers geradorStickers = new GeradorStickers();
      if(item instanceof ConteudoIMDB){
        
      }
    }
  }
  
}
