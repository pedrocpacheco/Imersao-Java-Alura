import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Pegando Informações da API:");

        // OBJETO Buscador
        BuscadorAPI buscadorAPI = new BuscadorAPI();
        // METODO Buscar
        String dadosAPI = buscadorAPI.buscarDadosApi();

        // MENU escolha de modo de imagem
        Scanner cc = new Scanner(System.in);

        // Opções de modo de imagem
        System.out.println("Como você deseja vizualizar as imagens dos filmes/series?");
        System.out.println("1- ASCII | 2- JFRAME | 3- Figurinhas");
        int opcaoVizualicao = cc.nextInt();
        cc.close();

        // OBJETO Filtador  
        FiltradorLista filtradorLista = new FiltradorLista();
        // METODO Buscar
        List<Map<String, String>> listaFiltrada =  filtradorLista.filtrarLista(dadosAPI);

        // LOOP Mostrar Infos Padrões
        for (Map<String,String> filme : listaFiltrada) {
            System.out.println("\u001b[1mTitulo:\u001b[m " + filme.get("title"));
            System.out.println("\u001b[1mImagem:\u001b[m " + filme.get("image"));
            System.out.println("\u001b[1mNota:\u001b[m " + filme.get("imDbRating"));
            
            // METODO Imprirmir Estrelas
            double notaEmDouble = Double.parseDouble(filme.get("imDbRating"));
            imprimirEstrelas(notaEmDouble);

            // OPÇÕES de Vizualização
            if(opcaoVizualicao == 1){
                //OBJETO e METODO de ASCII
                ConversorASCII conversorASCII = new ConversorASCII();
                System.out.println(conversorASCII.imageParaAscii(filme.get("image")));
            } else if (opcaoVizualicao == 2){
                //OBJETO e Metodo de JFrame
                String urlImagem = filme.get("image");
                CriadorJFrame criadorJFrame = new CriadorJFrame();
                criadorJFrame.criarJframe(urlImagem);
            } else if (opcaoVizualicao == 3){
                //OBJETO e METODO de Stickers
                GeradorStickers geradorStickers = new GeradorStickers();
                if(notaEmDouble >= 9){
                    InputStream imagemAvaliacao = new FileInputStream(new File("sobreposicao/masterpeca.png"));
                    InputStream imagemPedro = new FileInputStream(new File("sobreposicao/aprovado.png"));
                    geradorStickers.criar(filme.get("image"), filme.get("title"), "MASTERPIECE", imagemAvaliacao, imagemPedro, Color.GREEN);
                } else if(notaEmDouble <= 9 && notaEmDouble >= 8.7){
                    InputStream imagemAvaliacao = new FileInputStream(new File("sobreposicao/bom.png"));
                    InputStream imagemPedro = new FileInputStream(new File("sobreposicao/naMedia.png"));
                    geradorStickers.criar(filme.get("image"), filme.get("title"), "BOM CONTEUDO", imagemAvaliacao, imagemPedro, Color.BLUE);
                } else{
                    InputStream imagemAvaliacao = new FileInputStream(new File("sobreposicao/ruim.png"));
                    InputStream imagemPedro = new FileInputStream(new File("sobreposicao/umCoco.jpg"));
                    geradorStickers.criar(filme.get("image"), filme.get("title"), "UMA MERDA", imagemAvaliacao, imagemPedro, Color.RED);
                }
            } else{
                throw new RuntimeException("Opção Inexistente");
            }
            }
        }

    private static void imprimirEstrelas(double notaEmDouble) {

        int notaEmInt = (int) notaEmDouble;

            // Printando Estrelinha
            for (int j = 1; j <= notaEmInt; j++){
                System.out.print("⭐");
            }
            //Pulando Linha
            System.out.println("\n");

    }
    
}