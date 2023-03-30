package br.com.alura.stickers.Modelo;

import java.util.Scanner;

import br.com.alura.stickers.BuscarAPI.API;
import br.com.alura.stickers.BuscarAPI.ConexaoAPIException;

public class DefinidorAPIBuscada {
  
  private int tipoBuscado; 
  private String url;
  private API api;

  public API getApi() {
    return api;
  }

  public String escolhaDaAPI(int opcao){
    Scanner cc = new Scanner(System.in);
    if(opcao == 1){
        System.out.println("Você deseja receber a API de Séries mais Populares ou de Melhores Séries?");
        System.out.println("1- Melhores | 2- Mais Populares");
        int opcao2 = cc.nextInt();
        this.tipoBuscado = opcao;
        if(opcao2 == 1){
            this.api = API.IMDB_SERIES_TOP;
            this.url = api.getUrl();
        } else if(opcao2 == 2){
            this.api = API.IMDB_SERIES_POPULAR;
            this.url = api.getUrl();
        } else{
            throw new RuntimeException("Opção Indisponivel");
        };
    } else if(opcao == 2){
        System.out.println("Você deseja receber a API de Filmes mais Populares ou de Melhores Filmes?");
        System.out.println("1- Melhores | 2- Mais Populares");
        int opcao2 = cc.nextInt();
        if(opcao2 == 1){
            this.api = API.IMDB_FILMES_TOP;
            this.url = api.getUrl();
        } else if(opcao2 == 2){
            this.api = API.IMDB_FILMES_POPULAR;
            this.url = api.getUrl();
        ;} else{
            throw new RuntimeException("Opção Indisponivel");
        } 
        this.tipoBuscado = opcao;
    }  else if(opcao == 3){
        this.api = API.NASA_APOD;
        this.url = api.getUrl();
        this.tipoBuscado = opcao; 
    }
    else{
        throw new ConexaoAPIException("Erro ao Consultar AP");
    }
      return this.url; 
    }

    public int getTipoBuscado() {
      return tipoBuscado;
    }

}
