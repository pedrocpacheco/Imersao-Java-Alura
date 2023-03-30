package br.com.alura.stickers;
import java.util.List;
import java.util.Scanner;

import br.com.alura.stickers.BuscarAPI.ConstrutorAPI;
import br.com.alura.stickers.Conteudos.Conteudo;
import br.com.alura.stickers.Conteudos.ConteudoIMDB;
import br.com.alura.stickers.Conteudos.ConteudoNasa;
import br.com.alura.stickers.Extratores.ExtratorIMDB;
import br.com.alura.stickers.Extratores.ExtratorNasa;
import br.com.alura.stickers.Menu.Menu;
import br.com.alura.stickers.Vizualizadores.EscolhaVizualizacao;

public class App {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        int opcao = menu.perguntarQualAPI();

        DefinidorAPIBuscada definidorAPI = new DefinidorAPIBuscada();
        String urlAPI = definidorAPI.escolhaDaAPI(opcao);

        ConstrutorAPI buscadorAPI = new ConstrutorAPI(); 
        String json = buscadorAPI.construirAPI(urlAPI);  

        // ExtratorIMDB extrator = new ExtratorIMDB();
        // List<ConteudoIMDB> listaConteudos = extrator.extraiIMDB(json);
        int opcaoImagem = menu.perguntarQualTipoImagem();


        if(definidorAPI.getTipoBuscado() == 1 || definidorAPI.getTipoBuscado() == 2){
            
            ExtratorIMDB extrator = new ExtratorIMDB();
            List<ConteudoIMDB> listaConteudos = extrator.extraiIMDB(json);

            for(ConteudoIMDB item : listaConteudos){
                System.out.println("\u001b[1mTitulo:\u001b[m " + item.getTitulo());
                System.out.println("\u001b[1mImagem:\u001b[m " + item.getUrlImagem());
                System.out.println("\u001b[1mRating:\u001b[m " + item.getRating());
                double notaEmDouble = Double.parseDouble(item.getRating());
                imprimirEstrelas(notaEmDouble);

                EscolhaVizualizacao escolha = new EscolhaVizualizacao();
                escolha.escolherVizualizacao(opcaoImagem, item);

            }
        } 
        else if (definidorAPI.getTipoBuscado() == 3) {
            ExtratorNasa extrator = new ExtratorNasa();
            List<ConteudoNasa> listaConteudos = extrator.extraiNasa(json);
            // MENU escolha de modo de imagem
            Scanner cc = new Scanner(System.in);
            // Opções de modo de imagem

            for(ConteudoNasa item : listaConteudos){
                System.out.println("\u001b[1mTitulo:\u001b[m " + item.getTitulo());
                System.out.println("\u001b[1mImagem:\u001b[m " + item.getUrlImagem());
                System.out.println("\u001b[1mDate:\u001b[m " + item.getDate());
                
                cc.close();
                EscolhaVizualizacao escolha = new EscolhaVizualizacao();
                escolha.escolherVizualizacao(opcaoImagem, item);
            }
        }
    }
        
    public static void imprimirEstrelas(double notaEmDouble) {

        int notaEmInt = (int) notaEmDouble;

            // Printando Estrelinha
            for (int j = 1; j <= notaEmInt; j++){
                System.out.print("⭐");
            }
            //Pulando Linha
            System.out.println("\n");

    }

    

}