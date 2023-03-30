import java.util.List;
import java.util.Scanner;

import BuscarAPI.BuscadorAPI;
import br.com.alura.stickers.Conteudos.ConteudoIMDB;
import br.com.alura.stickers.Conteudos.ConteudoNasa;
import br.com.alura.stickers.Extratores.ExtratorIMDB;
import br.com.alura.stickers.Extratores.ExtratorNasa;
import br.com.alura.stickers.Vizualizadores.EscolhaVizualizacao;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Pegando Informações da API:");

        // OBJETO Buscador
        BuscadorAPI buscadorAPI = new BuscadorAPI();
        // METODO Buscar
        String json = buscadorAPI.buscarDadosApi();

        if(buscadorAPI.getTipoBuscado() == 1 || buscadorAPI.getTipoBuscado() == 2){
            ExtratorIMDB extrator = new ExtratorIMDB();
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


        // // MENU escolha de modo de imagem
        // Scanner cc = new Scanner(System.in);

        // // Opções de modo de imagem
        // System.out.println("Como você deseja vizualizar as imagens dos filmes/series?");
        // System.out.println("1- ASCII | 2- JFRAME | 3- Figurinhas");
        // int opcaoVizualicao = cc.nextInt();
        // cc.close();

        // // LOOP Mostrar Infos Padrões
        // for (Conteudo item : listaConteudos) {
        //     System.out.println("\u001b[1mTitulo:\u001b[m " + item.get("title"));
        //     System.out.println("\u001b[1mImagem:\u001b[m " + item.get("image"));
        //     System.out.println("\u001b[1mNota:\u001b[m " + item.get("imDbRating"));
            
        //     // METODO Imprirmir Estrelas
        //

        //     // OPÇÕES de Vizualização
        //     if(opcaoVizualicao == 1){
        //         //OBJETO e METODO de ASCII
        //         ConversorASCII conversorASCII = new ConversorASCII();
        //         System.out.println(conversorASCII.imageParaAscii(item.get("image")));
        //     } else if (opcaoVizualicao == 2){
        //         //OBJETO e Metodo de JFrame
        //         String urlImagem = item.get("image");
        //         CriadorJFrame criadorJFrame = new CriadorJFrame();
        //         criadorJFrame.criarJframe(urlImagem);
        //     } else if (opcaoVizualicao == 3){
        //         //OBJETO e METODO de Stickers
        //         GeradorStickers geradorStickers = new GeradorStickers();
        //         if(notaEmDouble >= 9){
        //             InputStream imagemAvaliacao = new FileInputStream(new File("sobreposicao/masterpeca.png"));
        //             InputStream imagemPedro = new FileInputStream(new File("sobreposicao/aprovado.png"));
        //             geradorStickers.criarIMDB(item.get("image"), item.get("title"), "MASTERPIECE", imagemAvaliacao, imagemPedro, Color.GREEN);
        //         } else if(notaEmDouble <= 9 && notaEmDouble >= 8.7){
        //             InputStream imagemAvaliacao = new FileInputStream(new File("sobreposicao/bom.png"));
        //             InputStream imagemPedro = new FileInputStream(new File("sobreposicao/naMedia.png"));
        //             geradorStickers.criarIMDB(item.get("image"), item.get("title"), "BOM CONTEUDO", imagemAvaliacao, imagemPedro, Color.BLUE);
        //         } else{
        //             InputStream imagemAvaliacao = new FileInputStream(new File("sobreposicao/ruim.png"));
        //             InputStream imagemPedro = new FileInputStream(new File("sobreposicao/umCoco.jpg"));
        //             geradorStickers.criarIMDB(item.get("image"), item.get("title"), "HORRÍVEL", imagemAvaliacao, imagemPedro, Color.RED);
        //         }
        //     } else{
        //         throw new RuntimeException("Opção Inexistente");
        //     }
        //     }
        // }
        
    public static void imprimirEstrelas(double notaEmDouble) {

        int notaEmInt = (int) notaEmDouble;

            // Printando Estrelinha
            for (int j = 1; j <= notaEmInt; j++){
                System.out.print("⭐");
            }
            //Pulando Linha
            System.out.println("\n");

    }

    // public static void definirEstrator(int opcao){
    //     Extrator extrator = new ExtratorIMDB();

    // }
    

}