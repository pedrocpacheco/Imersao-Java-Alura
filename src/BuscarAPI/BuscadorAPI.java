package BuscarAPI;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class BuscadorAPI {

    private int tipoBuscado; 
    private String url;

    public int getTipoBuscado() {
      return tipoBuscado;
    }

  public String buscarDadosApi(){
    Scanner cc = new Scanner(System.in);
    System.out.println("De qual API você deseja importar os dados? ");
    System.out.println("1- Séries | 2- Filmes | 3- Nasa");
    int opcao = cc.nextInt();

    escolhaDaAPI(opcao);

    try{

        URI endereco = URI.create(this.url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        return body;
    } catch(IOException | InterruptedException ex){
        throw new RuntimeException(ex);
    }
  }

  public void escolhaDaAPI(int opcao){
    Scanner cc = new Scanner(System.in);
    if(opcao == 1){
        System.out.println("Você deseja receber a API de Séries mais Populares ou de Melhores Séries?");
        System.out.println("1- Melhores | 2- Mais Populares");
        int opcao2 = cc.nextInt();
        this.tipoBuscado = opcao;
        if(opcao2 == 1){
            this.url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";
        } else if(opcao2 == 2){
            this.url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";
        } else{
            throw new RuntimeException("Opção Indisponivel");
        };
    } else if(opcao == 2){
        System.out.println("Você deseja receber a API de Séries mais Populares ou de Melhores Séries?");
        System.out.println("1- Melhores | 2- Mais Populares");
        int opcao2 = cc.nextInt();
        if(opcao2 == 1){
            this.url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        } else if(opcao2 == 2){
            this.url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        ;} else{
            throw new RuntimeException("Opção Indisponivel");
        } 
        this.tipoBuscado = opcao;
    }  else if(opcao == 3){
        this.url = "https://api.nasa.gov/planetary/apod?api_key=whLrBn3wuZs7z1dG6CkcdQSGA7dnw1kNkNEDpbmR";
        this.tipoBuscado = opcao; 
    }
    else{
            throw new RuntimeException("Opção Indisponivel");
    } 
    }

}
