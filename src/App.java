import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Pegando Informações da API:");

        // Fazer uma conexão http e os buscar os top 250 filmes
        BuscadorAPI buscadorAPI = new BuscadorAPI();

        String dadosAPI = buscadorAPI.buscarDadosApi();

        // Escolhendo metodo de Vizualização de Imagem
        Scanner cc = new Scanner(System.in);

        System.out.println("Como você deseja vizualizar as imagens dos filmes/series?");
        System.out.println("1- ASCII | 2- JFRAME | 3- Figurinhas");

        int opcaoVizualicao = cc.nextInt();

        cc.close();

        // extrair so os dados que interessam (titulo, poster, nota)
        FiltradorLista filtradorLista = new FiltradorLista();

        List<Map<String, String>> listaFiltrada =  filtradorLista.filtrarLista(dadosAPI);

        // exibir os dados
        for (Map<String,String> filme : listaFiltrada) {
            System.out.println("\u001b[1mTitulo:\u001b[m " + filme.get("title"));
            System.out.println("\u001b[1mImagem:\u001b[m " + filme.get("image"));
            System.out.println("\u001b[1mNota:\u001b[m " + filme.get("imDbRating"));
            
            // Passando valor da nota de String para Int
            double notaEmDouble = Double.parseDouble(filme.get("imDbRating"));
            int notaEmInt = (int) notaEmDouble;

            // Printando Estrelinha
            for (int j = 1; j <= notaEmInt; j++){
                System.out.print("⭐");
            }
            //Pulando Linha
            System.out.println("\n");
            
            //------------------------------------------------------
            // Forma de Vizualiar imagem referente a escolha
            switch(opcaoVizualicao){
                case 1: 
                    ConversorASCII conversorASCII = new ConversorASCII();
                    System.out.println(conversorASCII.imageParaAscii(filme.get("image")));
                case 2:
                    // Opcao de JFRAME
                    String urlImagem = filme.get("image");
                    CriadorJFrame criadorJFrame = new CriadorJFrame();
                    criadorJFrame.criarJframe(urlImagem);

                case 3:
                    GeradorStickers geradorStickers = new GeradorStickers();
                    geradorStickers.criar(filme.get("image"), filme.get("title"), "ATUALIZADO");
                default:
                    throw new RuntimeException("Opção Inexistente");
            }
        }
    }
    
}