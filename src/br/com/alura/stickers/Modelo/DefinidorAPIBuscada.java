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
    switch(opcao){
        case(1):
            System.out.println("Você deseja receber a API de Séries mais Populares ou de Melhores Séries?");
            System.out.println("1- Melhores | 2- Mais Populares");
            int opcao2 = cc.nextInt();
            this.tipoBuscado = opcao;
            switch(opcao2){
                case(1):
                    this.api = API.IMDB_SERIES_TOP;
                    this.url = api.getUrl();
                    return this.url; 
                case(2):
                    this.api = API.IMDB_SERIES_POPULAR;
                    this.url = api.getUrl();
                    return this.url; 
                default:
                    throw new RuntimeException("Opção Indisponivel");

            }
        case(2):
            System.out.println("Você deseja receber a API de Filmes mais Populares ou de Melhores Filmes?");
            System.out.println("1- Melhores | 2- Mais Populares");
            int opcaoFilmes = cc.nextInt();
            switch(opcaoFilmes){
                case(1):
                    this.api = API.IMDB_FILMES_TOP;
                    this.url = api.getUrl();
                    return this.url;
                case(2):   
                    this.api = API.IMDB_FILMES_POPULAR;
                    this.url = api.getUrl();
                    return this.url;
                default:
                    throw new RuntimeException("Opção Indisponivel");

            }
        case(3):
            this.api = API.NASA_APOD;
            this.url = api.getUrl();
            this.tipoBuscado = opcao; 
            return this.url; 
        case(4):
            this.api = API.TWD;
            this.url = api.getUrl();
            this.tipoBuscado = opcao; 
            return this.url; 
        default:
            throw new ConexaoAPIException("Erro ao Consultar AP");
    }

    }

    public int getTipoBuscado() {
      return tipoBuscado;
    }

}
