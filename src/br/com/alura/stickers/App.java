package br.com.alura.stickers;
import java.util.List;

import br.com.alura.stickers.BuscarAPI.ConstrutorAPI;
import br.com.alura.stickers.Conteudos.ConteudoIMDB;
import br.com.alura.stickers.Conteudos.ConteudoNasa;
import br.com.alura.stickers.Extratores.ExtratorIMDB;
import br.com.alura.stickers.Extratores.ExtratorNasa;
import br.com.alura.stickers.Menu.Menu;
import br.com.alura.stickers.Vizualizadores.EscolhaVizualizacao;

public class App {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        int opcaoAPI = menu.perguntarQualAPI();

        DefinidorAPIBuscada definidorAPI = new DefinidorAPIBuscada();
        String urlAPI = definidorAPI.escolhaDaAPI(opcaoAPI);

        ConstrutorAPI buscadorAPI = new ConstrutorAPI(); 
        String json = buscadorAPI.construirAPI(urlAPI);  

        // ExtratorIMDB extrator = new ExtratorIMDB();
        // List<ConteudoIMDB> listaConteudos = extrator.extraiIMDB(json);
        int opcaoImagem = menu.perguntarQualTipoImagem();

        switch(opcaoAPI){
            case(1):
                ExtratorIMDB extrator = (ExtratorIMDB) definidorAPI.getApi().getExtrator();
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
            case(2):
                ExtratorIMDB extrator2 = (ExtratorIMDB) definidorAPI.getApi().getExtrator();
                List<ConteudoIMDB> listaConteudos2 = extrator2.extraiIMDB(json);
                for(ConteudoIMDB item : listaConteudos2){
                    System.out.println("\u001b[1mTitulo:\u001b[m " + item.getTitulo());
                    System.out.println("\u001b[1mImagem:\u001b[m " + item.getUrlImagem());
                    System.out.println("\u001b[1mRating:\u001b[m " + item.getRating());
                    double notaEmDouble = Double.parseDouble(item.getRating());
                    imprimirEstrelas(notaEmDouble);
    
                    EscolhaVizualizacao escolha = new EscolhaVizualizacao();
                    escolha.escolherVizualizacao(opcaoImagem, item);
                }
            case(3):
                    ExtratorNasa extrator3 = new ExtratorNasa();
                    List<ConteudoNasa> listaConteudos3 = extrator3.extraiNasa(json);

                    for(ConteudoNasa item : listaConteudos3){
                        System.out.println("\u001b[1mTitulo:\u001b[m " + item.getTitulo());
                        System.out.println("\u001b[1mImagem:\u001b[m " + item.getUrlImagem());
                        System.out.println("\u001b[1mDate:\u001b[m " + item.getDate());
                        
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