import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Pegando Informações da API:");

        // Fazer uma conexão http e os buscar os top 250 filmes
        String dadosAPI = buscarDadosApi();

        // extrair so os dados que interessam (titulo, poster, nota)

        // exibir os dados

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
}
