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
    cc.close();

    String url;
    if(opcao == 1){
        System.out.println("Você deseja receber a API de Séries mais Populares ou de Melhores Séries?");
        System.out.println("1- Melhores | 2- Mais Populares");
        int opcao2 = cc.nextInt();
        if(opcao2 == 1){
            url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";
        } else if(opcao2 == 2){
            url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";
        } else{
            throw new RuntimeException("Opção Indisponivel");
        };
    } else if(opcao == 2){
        System.out.println("Você deseja receber a API de Séries mais Populares ou de Melhores Séries?");
        System.out.println("1- Melhores | 2- Mais Populares");
        int opcao2 = cc.nextInt();
        if(opcao2 == 1){
            url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        } else if(opcao2 == 2){
            url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        ;} else{
            throw new RuntimeException("Opção Indisponivel");
        }
    }  else{
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
