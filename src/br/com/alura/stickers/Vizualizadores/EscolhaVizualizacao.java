package br.com.alura.stickers.Vizualizadores;

import java.io.InputStream;
import java.io.FileInputStream;
import java.awt.Color;
import java.io.File;

import br.com.alura.stickers.Conteudos.Conteudo;
import br.com.alura.stickers.Conteudos.ConteudoIMDB;
import br.com.alura.stickers.Conteudos.ConteudoNasa;

public class EscolhaVizualizacao {

  public void escolherVizualizacao(int opcao, Conteudo item) throws Exception{
    if(opcao == 1){
      ConversorASCII conversorASCII = new ConversorASCII();
      System.out.println(conversorASCII.imageParaAscii(item.getUrlImagem()));

    } else if(opcao == 2){
      CriadorJFrame criadorJFrame = new CriadorJFrame();
      criadorJFrame.criarJframe(item.getUrlImagem());
    } else if (opcao == 3){
      GeradorStickers geradorStickers = new GeradorStickers();
      if(item instanceof ConteudoIMDB){
        ConteudoIMDB itemIMDB = (ConteudoIMDB) item;
        double notaEmDouble = Double.parseDouble(itemIMDB.getRating());
        if(notaEmDouble >= 9){
          InputStream imagemAvaliacao = new FileInputStream(new File("sobreposicao/masterpeca.png"));
          InputStream imagemPedro = new FileInputStream(new File("sobreposicao/aprovado.png"));
          geradorStickers.criar(itemIMDB, "MASTERPIECE", imagemAvaliacao, imagemPedro, Color.GREEN);
        } else if(notaEmDouble < 9 && notaEmDouble >= 8.7){
          InputStream imagemAvaliacao = new FileInputStream(new File("sobreposicao/bom.png"));
          InputStream imagemPedro = new FileInputStream(new File("sobreposicao/naMedia.png"));
          geradorStickers.criar(itemIMDB, "BOM CONTEUDO", imagemAvaliacao, imagemPedro, Color.CYAN);
        } else{
          InputStream imagemAvaliacao = new FileInputStream(new File("sobreposicao/ruim.png"));
          InputStream imagemPedro = new FileInputStream(new File("sobreposicao/umCoco.jpg"));
          geradorStickers.criar(itemIMDB, "HORRIPILANTE", imagemAvaliacao, imagemPedro, Color.RED);
        }
        
      } else if(item instanceof ConteudoNasa){
        ConteudoNasa itemNasa = (ConteudoNasa) item;
        String date = itemNasa.getDate().substring(0, 4);
        int notaEmDouble = Integer.parseInt(date);
        if(notaEmDouble == 2023){
          InputStream imagemAvaliacao = new FileInputStream(new File("sobreposicao/masterpeca.png"));
          InputStream imagemPedro = new FileInputStream(new File("sobreposicao/aprovado.png"));
          geradorStickers.criar(itemNasa, "FOI ESSE ANO", imagemAvaliacao, imagemPedro, Color.GREEN);
        } else if(notaEmDouble == 2022){
          InputStream imagemAvaliacao = new FileInputStream(new File("sobreposicao/bom.png"));
          InputStream imagemPedro = new FileInputStream(new File("sobreposicao/naMedia.png"));
          geradorStickers.criar(itemNasa, "FOI ANO PASSADO", imagemAvaliacao, imagemPedro, Color.CYAN);
        } else{
          InputStream imagemAvaliacao = new FileInputStream(new File("sobreposicao/ruim.png"));
          InputStream imagemPedro = new FileInputStream(new File("sobreposicao/umCoco.jpg"));
          geradorStickers.criar(itemNasa, "FAZ TEMPO JÁ", imagemAvaliacao, imagemPedro, Color.RED);
        }
      }
    }
  }
  
}
