package br.com.alura.stickers.Menu;

import java.util.Scanner;

public class Menu {
  
  public int perguntarQualAPI(){
    Scanner cc = new Scanner(System.in);
    System.out.println("Pegando Informações da API:"); 
    System.out.println("De qual API você deseja importar os dados? ");
    System.out.println("1- Séries | 2- Filmes | 3- Nasa");
    int opcao = cc.nextInt();
    return opcao;
  }

}


