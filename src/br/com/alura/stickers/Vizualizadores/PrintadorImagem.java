package br.com.alura.stickers.Vizualizadores;

import java.io.InputStream;
import java.io.FileInputStream;
import java.awt.Color;
import java.io.File;

import br.com.alura.stickers.Conteudos.Conteudo;
import br.com.alura.stickers.Conteudos.ConteudoIMDB;
import br.com.alura.stickers.Conteudos.ConteudoNasa;
import br.com.alura.stickers.Conteudos.ConteudoTWD;

public class PrintadorImagem {

  public void fazerImagem(int opcaoImagem, Conteudo item, int opcaoAPI) throws Exception{
    if(opcaoImagem == 1){
      ConversorASCII conversorASCII = new ConversorASCII();
      System.out.println(conversorASCII.imageParaAscii(item.getUrlImagem()));

    } else if(opcaoImagem == 2){
      CriadorJFrame criadorJFrame = new CriadorJFrame();
      criadorJFrame.criarJframe(item.getUrlImagem());
    } else if (opcaoImagem == 3){
      GeradorStickers geradorStickers = new GeradorStickers();
      if(item instanceof ConteudoIMDB){
        ConteudoIMDB itemIMDB = (ConteudoIMDB) item;
        double notaEmDouble = Double.parseDouble(itemIMDB.getRating());
        if(notaEmDouble >= 9){
          InputStream imagemAvaliacao = new FileInputStream(new File("sobreposicao/IMDB/masterpeca.png"));
          InputStream imagemPedro = new FileInputStream(new File("sobreposicao/IMDB/aprovado.png"));
          geradorStickers.criar(itemIMDB, "MASTERPIECE", imagemAvaliacao, imagemPedro, Color.GREEN, opcaoAPI);
        } else if(notaEmDouble < 9 && notaEmDouble >= 8.7){
          InputStream imagemAvaliacao = new FileInputStream(new File("sobreposicao/IMDB/bom.png"));
          InputStream imagemPedro = new FileInputStream(new File("sobreposicao/IMDB/naMedia.png"));
          geradorStickers.criar(itemIMDB, "BOM CONTEUDO", imagemAvaliacao, imagemPedro, Color.CYAN, opcaoAPI);
        } else{
          InputStream imagemAvaliacao = new FileInputStream(new File("sobreposicao/IMDB/ruim.png"));
          InputStream imagemPedro = new FileInputStream(new File("sobreposicao/IMDB/umCoco.jpg"));
          geradorStickers.criar(itemIMDB, "HORRIPILANTE", imagemAvaliacao, imagemPedro, Color.RED, opcaoAPI);
        }
        
      } else if(item instanceof ConteudoNasa){
        ConteudoNasa itemNasa = (ConteudoNasa) item;
        String date = itemNasa.getDate().substring(0, 4);
        int notaEmDouble = Integer.parseInt(date);
        notaEmDouble -= 2;
        if(notaEmDouble == 2023){
          InputStream imagemAvaliacao = new FileInputStream(new File("sobreposicao/NASA/esquerdaA.png"));
          InputStream imagemPedro = new FileInputStream(new File("sobreposicao/NASA/direitaA.png"));
          geradorStickers.criar(itemNasa, "FOI ESSE ANO", imagemAvaliacao, imagemPedro, Color.GRAY, opcaoAPI);
        } else if(notaEmDouble == 2022){
          InputStream imagemAvaliacao = new FileInputStream(new File("sobreposicao/NASA/esquerdaB.png"));
          InputStream imagemPedro = new FileInputStream(new File("sobreposicao/NASA/direitaB.png"));
          geradorStickers.criar(itemNasa, "ANO PASSADO", imagemAvaliacao, imagemPedro, Color.BLUE, opcaoAPI);
        } else{
          InputStream imagemAvaliacao = new FileInputStream(new File("sobreposicao/NASA/esquerdaC.png"));
          InputStream imagemPedro = new FileInputStream(new File("sobreposicao/NASA/direitaC.png"));
          geradorStickers.criar(itemNasa, "FAZ TEMPO", imagemAvaliacao, imagemPedro, Color.RED, opcaoAPI);
        }
      } else if(item instanceof ConteudoTWD){
        ConteudoTWD itemTWD = (ConteudoTWD) item;
        Color cor;
        if(itemTWD.isAlive().equals("Alive")){
          cor = Color.YELLOW;
        } else if(itemTWD.isAlive().equals("Missing")){
          cor = Color.GRAY;
        } else{
          cor = Color.RED;
        }
        InputStream imagemTemporada = new FileInputStream(new File("sobreposicao/TWD/TEMPORADA/" + itemTWD.getFirstSeason() + ".png"));
        InputStream imagemComunidade = new FileInputStream(new File("sobreposicao/TWD/COMUNIDADE/" + itemTWD.getCommunity() + ".png"));
        InputStream imagemArma = new FileInputStream(new File("sobreposicao/TWD/ARMA/" + itemTWD.getGunType() + ".png"));
        InputStream imagemStatus = new FileInputStream(new File("sobreposicao/TWD/STATUS/" + itemTWD.isAlive() + ".png"));
        geradorStickers.criarTWD(itemTWD, itemTWD.getTitulo(), imagemTemporada, imagemComunidade, imagemArma, imagemStatus, cor);
        
      }
    }
  }
  
}
