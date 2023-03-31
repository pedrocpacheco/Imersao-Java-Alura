package br.com.alura.stickers.Modelo;
import java.util.List;

import br.com.alura.stickers.BuscarAPI.ConstrutorAPI;
import br.com.alura.stickers.Conteudos.ConteudoIMDB;
import br.com.alura.stickers.Conteudos.ConteudoNasa;
import br.com.alura.stickers.Conteudos.ConteudoTWD;
import br.com.alura.stickers.Extratores.ExtratorIMDB;
import br.com.alura.stickers.Extratores.ExtratorNasa;
import br.com.alura.stickers.Extratores.ExtratorTWD;
import br.com.alura.stickers.Menu.Menu;
import br.com.alura.stickers.Vizualizadores.PrintadorImagem;

public class App {
    public static void main(String[] args) throws Exception {

        Menu menu = new Menu(); // Cria Menu
        int opcaoAPI = menu.perguntarQualAPI(); // Pergunta ao Usuario Qual API ele quer Importar Dados

        DefinidorAPIBuscada definidorAPI = new DefinidorAPIBuscada(); // Se for API do IMDB, pergunta se ele quer as MELHORES obras ou as MAIS POPUPALARES.
        String urlAPI = definidorAPI.escolhaDaAPI(opcaoAPI); // Salva a URL DA API FINAL em uma String

        ConstrutorAPI buscadorAPI = new ConstrutorAPI(); 
        String json = buscadorAPI.construirAPI(urlAPI);  // Constroi uma String que é o "JSON" da API

        int opcaoImagem = menu.perguntarQualTipoImagem(); // Pergunta se o usuario prefere Vizualizar em ASCII, JFRAME ou FIGURINHA
        
        PrintadorInformacoes printadorInformacoes = new PrintadorInformacoes(); // Cria o Printador de informações
        PrintadorImagem printadorImagem = new PrintadorImagem(); // Cria o Printador da Imagem
       
        if(opcaoAPI == 1 || opcaoAPI == 2){
                ExtratorIMDB extrator = (ExtratorIMDB) definidorAPI.getApi().getExtrator(); // Define o Extrator referente ao Tipo da API 
                List<ConteudoIMDB> listaConteudos = extrator.extraiIMDB(json); // Cria uma Lista de Conteudos

                for(ConteudoIMDB item : listaConteudos){ // Para cada Item na Lista de Conteudos:
                    printadorInformacoes.printarInfosGerais(item.getTitulo(), item.getUrlImagem()); // Printa Informações Gerais
                    printadorInformacoes.printarIMDBRating(item.getRating()); // Printa Informações Especificas desta API (RATING)
                    printadorImagem.fazerImagem(opcaoImagem, item); // Cria a imagem (ASCII | JFRAME | FIGURINNHA)
                }

            } else if(opcaoAPI == 3){
                ExtratorNasa extrator3 = new ExtratorNasa(); // Define o Extrator referente ao Tipo da API 
                List<ConteudoNasa> listaConteudos3 = extrator3.extraiNasa(json); // Cria uma Lista de Conteudos
                
                for(ConteudoNasa item : listaConteudos3){ // Para cada Item na Lista de Conteudos:
                    printadorInformacoes.printarInfosGerais(item.getTitulo(), item.getUrlImagem()); // Printa Informações Gerais
                    printadorInformacoes.printarNasaDate(item.getDate()); // Printa Informações Especificas desta API (DATE)
                    printadorImagem.fazerImagem(opcaoImagem, item); // Cria a imagem (ASCII | JFRAME | FIGURINNHA)
                }

            } else if(opcaoAPI == 4){
                ExtratorTWD extratorTWD = new ExtratorTWD();
                List<ConteudoTWD> listaConteudosTWD = extratorTWD.extraiTWD(json);
                for(ConteudoTWD item: listaConteudosTWD){
                    printadorInformacoes.printarInfosGerais(item.getTitulo(), item.getUrlImagem());
                    printadorInformacoes.printarInfosTWD(item.getFirstSeason(), item.getCommunity(), item.getGunType(), item.isAlive());
                    printadorImagem.fazerImagem(opcaoImagem, item);
                }
            }
}
}