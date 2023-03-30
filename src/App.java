import java.util.List;
import java.util.Scanner;

import BuscarAPI.API;
import BuscarAPI.BuscadorAPI;
import br.com.alura.stickers.Conteudos.Conteudo;
import br.com.alura.stickers.Conteudos.ConteudoIMDB;
import br.com.alura.stickers.Conteudos.ConteudoNasa;
import br.com.alura.stickers.Extratores.Extrator;
import br.com.alura.stickers.Extratores.ExtratorIMDB;
import br.com.alura.stickers.Extratores.ExtratorNasa;
import br.com.alura.stickers.Vizualizadores.EscolhaVizualizacao;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Pegando Informações da API:"); 
        BuscadorAPI buscadorAPI = new BuscadorAPI(); // Pegando API
        String json = buscadorAPI.buscarDadosApi();  // Salvando JSON em uma String

        int opcao = buscadorAPI.getTipoBuscado();
        Extrator extrator =  buscadorAPI.getApi().getExtrator();
        List<Conteudo> conteudos;

        // MENU escolha de modo de imagem
        Scanner cc = new Scanner(System.in);
        // Opções de modo de imagem
        System.out.println("Como você deseja vizualizar as imagens dos filmes/series?");
        System.out.println("1- ASCII | 2- JFRAME | 3- Figurinhas");
        int opcaoVizualicao = cc.nextInt();

        for(Conteudo item : conteudos){
            System.out.println("\u001b[1mTitulo:\u001b[m " + item.getTitulo());
            System.out.println("\u001b[1mImagem:\u001b[m " + item.getUrlImagem());
        }
        
        if(opcao == 1){
            
        }


        if(buscadorAPI.getTipoBuscado() == 1 || buscadorAPI.getTipoBuscado() == 2){
            extrator = (ExtratorIMDB) extrator;
            List<ConteudoIMDB> listaConteudos = extrator.extrai(json);
            // MENU escolha de modo de imagem
            Scanner cc = new Scanner(System.in);
            // Opções de modo de imagem
            System.out.println("Como você deseja vizualizar as imagens dos filmes/series?");
            System.out.println("1- ASCII | 2- JFRAME | 3- Figurinhas");
            int opcaoVizualicao = cc.nextInt();

            for(ConteudoIMDB item : listaConteudos){
                System.out.println("\u001b[1mTitulo:\u001b[m " + item.getTitulo());
                System.out.println("\u001b[1mImagem:\u001b[m " + item.getUrlImagem());
                System.out.println("\u001b[1mRating:\u001b[m " + item.getRating());
                double notaEmDouble = Double.parseDouble(item.getRating());
                imprimirEstrelas(notaEmDouble);

                cc.close();
                EscolhaVizualizacao escolha = new EscolhaVizualizacao();
                escolha.escolherVizualizacao(opcaoVizualicao, item);

            }
        } 
        else if (buscadorAPI.getTipoBuscado() == 3) {
            ExtratorNasa extrator = new ExtratorNasa();
            List<ConteudoNasa> listaConteudos = extrator.extrai(json);
            // MENU escolha de modo de imagem
            Scanner cc = new Scanner(System.in);
            // Opções de modo de imagem
            System.out.println("Como você deseja vizualizar as imagens dos filmes/series?");
            System.out.println("1- ASCII | 2- JFRAME | 3- Figurinhas");
            int opcaoVizualicao = cc.nextInt();

            for(ConteudoNasa item : listaConteudos){
                System.out.println("\u001b[1mTitulo:\u001b[m " + item.getTitulo());
                System.out.println("\u001b[1mImagem:\u001b[m " + item.getUrlImagem());
                System.out.println("\u001b[1mDate:\u001b[m " + item.getDate());
                
                cc.close();
                EscolhaVizualizacao escolha = new EscolhaVizualizacao();
                escolha.escolherVizualizacao(opcaoVizualicao, item);
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