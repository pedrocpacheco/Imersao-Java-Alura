package br.com.alura.stickers.Modelo;
import java.util.List;

import br.com.alura.stickers.BuscarAPI.ConstrutorAPI;
import br.com.alura.stickers.Conteudos.ConteudoIMDB;
import br.com.alura.stickers.Conteudos.ConteudoNasa;
import br.com.alura.stickers.Extratores.ExtratorIMDB;
import br.com.alura.stickers.Extratores.ExtratorNasa;
import br.com.alura.stickers.Menu.Menu;
import br.com.alura.stickers.Vizualizadores.EscolhaVizualizacao;

public class App {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        int opcaoAPI = menu.perguntarQualAPI();

        DefinidorAPIBuscada definidorAPI = new DefinidorAPIBuscada();
        String urlAPI = definidorAPI.escolhaDaAPI(opcaoAPI);

        ConstrutorAPI buscadorAPI = new ConstrutorAPI(); 
        String json = buscadorAPI.construirAPI(urlAPI);  

        // ExtratorIMDB extrator = new ExtratorIMDB();
        // List<ConteudoIMDB> listaConteudos = extrator.extraiIMDB(json);
        int opcaoImagem = menu.perguntarQualTipoImagem();
        
        PrintadorInformacoes printadorInformacoes = new PrintadorInformacoes();
        EscolhaVizualizacao escolha = new EscolhaVizualizacao();
       
        if(opcaoAPI == 1 || opcaoAPI == 2){
                ExtratorIMDB extrator = (ExtratorIMDB) definidorAPI.getApi().getExtrator();
                List<ConteudoIMDB> listaConteudos = extrator.extraiIMDB(json);
                for(ConteudoIMDB item : listaConteudos){
                    printadorInformacoes.printarInfosGerais(item.getTitulo(), item.getUrlImagem());
                    printadorInformacoes.printarIMDBRating(item.getRating());
                    escolha.escolherVizualizacao(opcaoImagem, item);
                }
            } else if(opcaoAPI == 3){
                ExtratorNasa extrator3 = new ExtratorNasa();
                List<ConteudoNasa> listaConteudos3 = extrator3.extraiNasa(json);

                for(ConteudoNasa item : listaConteudos3){
                    printadorInformacoes.printarInfosGerais(item.getTitulo(), item.getUrlImagem());
                    printadorInformacoes.printarNasaDate(item.getDate());
                    escolha.escolherVizualizacao(opcaoImagem, item);
                }

     }
}
}