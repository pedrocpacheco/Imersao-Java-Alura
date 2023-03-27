import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Pegando Informações da API:");

        // Fazer uma conexão http e os buscar os top 250 filmes
        String dadosAPI = buscarDadosApi();

        // extrair so os dados que interessam (titulo, poster, nota)
        List<Map<String, String>> listaFiltrada = filtrarLista(dadosAPI);

        // exibir os dados
        for (Map<String,String> filme : listaFiltrada) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
        }

    }

    public static String buscarDadosApi() throws IOException, InterruptedException{
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
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