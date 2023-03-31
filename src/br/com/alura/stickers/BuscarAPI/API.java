package br.com.alura.stickers.BuscarAPI;

import br.com.alura.stickers.Extratores.Extrator;
import br.com.alura.stickers.Extratores.ExtratorIMDB;
import br.com.alura.stickers.Extratores.ExtratorNasa;
import br.com.alura.stickers.Extratores.ExtratorTWD;

public enum API {
  
  IMDB_FILMES_TOP("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json",  new ExtratorIMDB()),
  IMDB_FILMES_POPULAR("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json",  new ExtratorIMDB()),
  IMDB_SERIES_TOP("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json",  new ExtratorIMDB()),
  IMDB_SERIES_POPULAR("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json", new ExtratorIMDB()),

  NASA_APOD("https://api.nasa.gov/planetary/apod?api_key=whLrBn3wuZs7z1dG6CkcdQSGA7dnw1kNkNEDpbmR", new ExtratorNasa()),

  TWD("http://localhost:8080/characters", new ExtratorTWD());

  private String url;
  private Extrator extrator;


  API(String url, Extrator extrator){
    this.url = url;
    this.extrator = extrator;
  }


  public String getUrl() {
    return url;
  }

  public Extrator getExtrator() {
    return extrator;
  }

}
