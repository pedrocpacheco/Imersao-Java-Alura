import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class BuscadorAPI {

  public String buscarDadosApi() throws IOException, InterruptedException{
    Scanner cc = new Scanner(System.in);
    System.out.println("De qual API você deseja importar os dados? ");
    System.out.println("1- Séries | 2- Filmes");
    int opcao = cc.nextInt();
    String url;
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

}
