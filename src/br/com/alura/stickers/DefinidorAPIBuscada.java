package br.com.alura.stickers;

import java.util.Scanner;

import br.com.alura.stickers.BuscarAPI.ConexaoAPIException;

public class DefinidorAPIBuscada {
  
  private int tipoBuscado; 
  private String url;

  public String escolhaDaAPI(int opcao){
    Scanner cc = new Scanner(System.in);
    if(opcao == 1){
        System.out.println("Você deseja receber a API de Séries mais Populares ou de Melhores Séries?");
        System.out.println("1- Melhores | 2- Mais Populares");
        int opcao2 = cc.nextInt();
        this.tipoBuscado = opcao;
        if(opcao2 == 1){
            this.url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";
        } else if(opcao2 == 2){
            this.url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";
        } else{
            throw new RuntimeException("Opção Indisponivel");
        };
    } else if(opcao == 2){
        System.out.println("Você deseja receber a API de Séries mais Populares ou de Melhores Séries?");
        System.out.println("1- Melhores | 2- Mais Populares");
        int opcao2 = cc.nextInt();
        if(opcao2 == 1){
            this.url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        } else if(opcao2 == 2){
            this.url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        ;} else{
            throw new RuntimeException("Opção Indisponivel");
        } 
        this.tipoBuscado = opcao;
    }  else if(opcao == 3){
        this.url = "https://api.nasa.gov/planetary/apod?api_key=whLrBn3wuZs7z1dG6CkcdQSGA7dnw1kNkNEDpbmR";
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
