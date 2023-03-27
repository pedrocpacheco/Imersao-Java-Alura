import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Pegando Informações da API:");

        // Fazer uma conexão http e os buscar os top 250 filmes
        String dadosAPI = buscarDadosApi();

        // extrair so os dados que interessam (titulo, poster, nota)
        List<Map<String, String>> listaFiltrada = filtrarLista(dadosAPI);

        // exibir os dados
        for (Map<String,String> filme : listaFiltrada) {
            System.out.println("\u001b[1m Titulo:\u001b[m " + filme.get("title"));
            System.out.println("\u001b[1m Imagem:\u001b[m " + filme.get("image"));
            System.out.println("\u001b[1m Nota:\u001b[m " + filme.get("imDbRating"));

            // Printando Estrelinha
            for (int j = 1; j <= 5; j++){
                System.out.print("⭐");
            }
            //Pulando Linha
            System.out.println("\n");

        
        }

    }

    public static String buscarDadosApi() throws IOException, InterruptedException{
        Scanner cc = new Scanner(System.in);
        System.out.println("De qual API você deseja importar os dados? ");
        System.out.println("1- Filmes | 2- Séries");
        int opcao = cc.nextInt();
        String url;
        cc.close();
        if(opcao == 1){
            url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";
        } else if(opcao == 2){
            url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        } else{
            throw new RuntimeException("Opção Indisponivel");
        }

            URI endereco = URI.create(url);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String body = response.body();
            return body;
    }

    public static List<Map<String, String>> filtrarLista(String dadosAPI){
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(dadosAPI);
        return listaDeFilmes;
        
    }


}