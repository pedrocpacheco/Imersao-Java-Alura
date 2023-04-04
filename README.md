# Criador de Figurinhas com APIs

Aplicação que cria figurinhas dinâmicas a partir das informações da API (incluindo uma própria) desejada pelo Usuario. 

![App Screenshot](https://pbs.twimg.com/media/FszklfJXwBEYy7d?format=jpg&name=4096x4096)

(Para rodar o projeto, acesse a pasta "modelo" e de run na Classe "App.java")

## Escolhendo de Qual API Importar Dados

Quando você iniciar o projeto, você podera escolher de qual API importar os dados, existem 4 opções funcionando no momento:

- API de Melhores Séries no IMDB;
- API de Melhores Filmes no IMDB;
- API diaria da NASA;
- API de Personagens de The Walking Dead (feita por mim).

![App Screenshot](https://pbs.twimg.com/media/FszlkkTWYAAIgOI?format=png&name=small)

### Escolhendo APIs do IMDB

Se o usuario escolher alguma das API relacionadas com o IMDB (Séries ou Filmes), o programa irá perguntar se ele deseja a API de das Melhores Obras ou das Obras mais Populares.

- Exemplo de escolha das APIs de Séries: ![App Screenshot](https://pbs.twimg.com/media/FszmIi_XwAMB3ab?format=png&name=small)

- Exemplo de escolha das APIs de Filmes: ![App Screenshot](https://pbs.twimg.com/media/Fszmdz0XwAEoqBx?format=png&name=small)

## Escolhendo o Tipo de Vizualização das Imagens das APIs

Depois de definir qual será a API buscada pelo programa, este, pergunta ao usuário qual tipo de modo de vizualização ele deseja.

As opções são:

- ASCII
- JFRAME
- Figurinhas

![App Screenshot](https://pbs.twimg.com/media/FsznVN4XwAosojI?format=png&name=small)

### Vizualizando em ASCII

Se o usuario escolher a forma de ASCII, o programa irá printar em seu terminal, a Imagem da URL convertida em ASCII.

#### ASCII do Filme TOP GUN Maverick

![App Screenshot](https://pbs.twimg.com/media/Fszq9YqWIAw2VGU?format=png&name=900x900)

### Vizualizando em JFRAME

Se o usuario escolher a forma de JFRAME, o programa irá converter a Imagem da URL para JRAME.

#### JFRAME do Personagem Daryl Dixon

![App Screenshot](https://pbs.twimg.com/media/FszslgvWAAMJGTB?format=png&name=small)

# Criação de Figurinhas

Finalmente, vamos ver como a nossa aplicação cria as figurinhas. Existem 3 tipos diferentes de Figurinhas.

- As das APIs do IMDB;
- As da API diaria da NASA;
- As da API desenvolvida em Aula de The Walking Dead.

Vamos entender agora, a dinamicidade de cada uma deles.

## Figurinhas de Séries/Filmes

Utilizando a informação da Nota das Séries/Filmes, eu deixei as figurinhas dinamicas.
Existem 3 tipos de figurinhas do IMDB

- Obras com Nota > 9.0
  Obras com 9.0 > Nota > 8.6
  Obras com 8.8 > Nota

Vamos entender Vizualizar cada uma delas agora.

- Todas as figurinhas do IMDB contém uma logo do mesmo para indicar de qual API elas são.

### Obras com Nota > 9.0

Figurinhas com essa nota contém:

- Um selo de "Must See" do Metacritic
- Imagem minha Sorrindo
- Legenda verde escrita "Masterpiece"
  ![App Screenshot](https://pbs.twimg.com/media/FszurSzWAAAlWb-?format=jpg&name=medium)

### Obras com 9.0 > Nota > 8.6

Figurinhas com essa nota contém:

- Um selo de "Recommended";
- Imagem da minha cachorrinha Lully;
- Legenda ciano escrita "Bom Conteudo"
  ![App Screenshot](https://pbs.twimg.com/media/Fszu0liXoAMAXzW?format=jpg&name=medium)

### Obras com 8.6 > Nota

Figurinhas com essa nota contém:

- Um selo de "Lixo";
- Imagem minha com gesto obceno;
- Legenda vermelha escrita "Horripilante"
  ![App Screenshot](https://pbs.twimg.com/media/FszvAQEX0AAiWEa?format=jpg&name=medium)

## Figurinhas da Nasa

Utilizando a informação da Data da informação da Nasa, eu deixei as figurinhas dinamicas.
Existem 3 tipos de figurinhas da Nasa

- Obras com Date = 2023
  Obras com Date = 2022
  Obras com Date <= 2021

Vamos entender Vizualizar cada uma delas agora.

- Todas as figurinhas da Nasa contém uma logo do mesmo para indicar de qual API elas serão
- Como a API da Nasa só tras 1 informação por dia, as figurinhas terão a mesma imagem (mas a lógica é funcional)

### Obras com Date = 2023

Figurinhas com essa data contém:

- Um Homem Feliz;
- Um astronauta fazendo um Joinha;
- Legenda cinza escrita "Foi Esse Ano"
  ![App Screenshot](https://pbs.twimg.com/media/FszxiQLWIBg3ZA4?format=png&name=900x900)

### Obras com Date = 2022

Figurinhas com essa data contém:

- Um Gato Surpreso;
- Um astronauta feliz;
- Legenda azul escrita "Foi Ano Passado"
  ![App Screenshot](https://pbs.twimg.com/media/FszyS--XoAELoG0?format=png&name=900x900)

### Obras com Date <= 2021

Figurinhas com essa data contém:

- Um Homem Triste;
- Um astronauta;
- Legenda vermelha escrita "Faz Tempo"
  ![App Screenshot](https://pbs.twimg.com/media/FszvLwOWIAk2Nez?format=png&name=900x900)

## Figurinhas de The Walking Dead

As figurinhas de Personagens de The Walking Dead são feitas através de uma API que eu desenvolvi, você pode acessalá em:

- Link API: https://api-twd-characters-production.up.railway.app/characters
- Link repositorio no Github da API: https://github.com/pedrocpacheco/API-TWD-Characters

Os personagens que estão nessa API, contém as seguintes informações:
![App Screenshot](https://pbs.twimg.com/media/Fsz0NnNWIA0ZLIg?format=png&name=medium)

####

A partir dos atributos "Name"", "Image", "firstSeason", "community", "gunType" e "status" as figurinhas são feitas dinamicamente.

Cada figurinha tem 4 cantos, e em cada canto uma imagem referente à um atributo será adicionada a figurinha. Cada canto é especificado e mostra o que ele representa.

O Nome do Personagem escrito no meio também muda referente a seu status:

- Alive = Cor Amarela
- Missing = Cor Cinza
- Dead = Cor vermelha

Exemplo: O personagem "King Ezekiel" tem os seguintes atributos:

- "fisrtSeason" = "7";
- "gunType" = "shiva";
- "community" = "Kingdom";
- "status" = "Alive";

![App Screenshot](https://pbs.twimg.com/media/Fsz3-aSWIAAq--e?format=png&name=900x900)

Vamos ver quais são as possibilidades de imagens de cada atributo.

### Imagens Referentes a cada Atributo

#### Possibilidades de First Season:

Existem 11 Temporadas Diferentes que uma Figurinha pode ter:
| Atributo | Imagem |
| ------------- | ------------- |
|1|![App Screenshot](https://pbs.twimg.com/media/Fsz1C96WIAcolVo?format=png&name=120x120)|
|2|![App Screenshot](https://pbs.twimg.com/media/Fsz1C94WIAUu6MY?format=png&name=120x120)|
|3|![App Screenshot](https://pbs.twimg.com/media/Fsz1C-nWIAwrHOv?format=png&name=120x120)|
|4|![App Screenshot](https://pbs.twimg.com/media/Fsz1C_MXgAA-eSU?format=png&name=120x120)|
|5|![App Screenshot](https://pbs.twimg.com/media/Fsz1FizXgAASlvn?format=png&name=120x120)|
|6|![App Screenshot](https://pbs.twimg.com/media/Fsz1FjXX0AEfG_F?format=png&name=120x120)|
|7|![App Screenshot](https://pbs.twimg.com/media/Fsz1FkTWIAsy2hB?format=png&name=120x120)|
|8|![App Screenshot](https://pbs.twimg.com/media/Fsz1JExWIAceKED?format=png&name=120x120)|
|9|![App Screenshot](https://pbs.twimg.com/media/Fsz1JCtWIBc0hQG?format=png&name=120x120)|
|10|![App Screenshot](https://pbs.twimg.com/media/Fsz1JC5XoAAKTx4?format=png&name=120x120)|
|11|![App Screenshot](https://pbs.twimg.com/media/Fsz1JD1WIAU1-OW?format=png&name=120x120)|

#### Possibilidades de gunType:

Existem 12 Tipos de Armas Diferentes que uma Figurinha pode ter:
| Atributo | Imagem |
| ------------- | ------------- |
|axe |![App Screenshot](https://pbs.twimg.com/media/Fsz5ibZXsAEdSSL?format=png&name=120x120)|
|crossbow|![App Screenshot](https://pbs.twimg.com/media/Fsz5ibrWIAkH8FY?format=png&name=120x120)|
|fist|![App Screenshot](https://pbs.twimg.com/media/Fsz5ictWIBMpOqL?format=png&name=120x120)|
|katana|![App Screenshot](https://pbs.twimg.com/media/Fsz5idpWIBQqpAT?format=png&name=120x120)|
|knife|![App Screenshot](https://pbs.twimg.com/media/Fsz5sOeWIAoDQ1K?format=png&name=120x120)|
|lucille|![App Screenshot](https://pbs.twimg.com/media/Fsz5sPiWIAc0TxB?format=png&name=120x120)|
|pistol|![App Screenshot](https://pbs.twimg.com/media/Fsz5sQyWYAA9edt?format=png&name=120x120)|
|revolver|![App Screenshot](https://pbs.twimg.com/media/Fsz5tmpXoAA4sHI?format=png&name=120x120)|
|rifle|![App Screenshot](https://pbs.twimg.com/media/Fsz5pa0WIAwYSwa?format=png&name=120x120)|
|shiva|![App Screenshot](https://pbs.twimg.com/media/Fsz5pbuWIB4fX1G?format=png&name=120x120)|
|slingshot|![App Screenshot](https://pbs.twimg.com/media/Fsz5pcnWwAAyhS7?format=png&name=120x120)|
|walkers|![App Screenshot](https://pbs.twimg.com/media/Fsz5pdxXgAA4ozD?format=png&name=120x120)|

#### Possibilidades de community:

Existem 9 Temporadas Diferentes que uma Figurinha pode ter:
| Atributo | Imagem |
| ------------- | ------------- |
|Alexandria |![App Screenshot](https://pbs.twimg.com/media/Fsz7NXuWIBU7nAg?format=png&name=120x120)|
|CRM|![App Screenshot](https://pbs.twimg.com/media/Fsz7NXqWIAM1rxL?format=png&name=120x120)|
|Farm|![App Screenshot](https://pbs.twimg.com/media/Fsz7NYWWwAAl6b-?format=png&name=120x120)|
|Hilltop|![App Screenshot](https://pbs.twimg.com/media/Fsz7NY9WIAs8pze?format=png&name=120x120)|
|Kingdown|![App Screenshot](https://pbs.twimg.com/media/Fsz7O79WIC4N520?format=png&name=120x120)|
|Prison|![App Screenshot](https://pbs.twimg.com/media/Fsz7O8qWIBMNSWk?format=png&name=120x120)|
|Sanctuary|![App Screenshot](https://pbs.twimg.com/media/Fsz7O9bWIAQGwQg?format=png&name=120x120)|
|Whispers|![App Screenshot](https://pbs.twimg.com/media/Fsz7O-EWIAwbhTZ?format=png&name=120x120)|
|Woodbury|![App Screenshot](https://pbs.twimg.com/media/Fsz7QPBWIAI6rmi?format=png&name=120x120)|

#### Possibilidades de community:

Existem 3 Temporadas Diferentes que uma Figurinha pode ter:
| Atributo | Imagem |
| ------------- | ------------- |
|Alive |![App Screenshot](https://pbs.twimg.com/media/Fsz9FTQWIAYGUvf?format=png&name=120x120)|
|Missing|![App Screenshot](https://pbs.twimg.com/media/Fsz9FUBWIAEBnh9?format=png&name=120x120)|
|Dead|![App Screenshot](https://pbs.twimg.com/media/Fsz9FTQWIB4NSXa?format=png&name=120x120)|

- "Alive": Deixa o nome do Personagem Amarelo.
- "Missing": Deaixa o nome do Personagem Cinza;
- "Dead": Deixa o nome do Personagem Vermelho.

### Exemplos de Figurinhas de The Walking Dead

E Então, como foi visto, a maneira de criar uma figurinha de Personagem de The Walking Dead é totalmente dinamica, aqui estão algumas figurinhas para exemplo:

#### Rick Grimes

- "fisrtSeason" = "1";
- "gunType" = "revolver";
- "community" = "CRM";
- "status" = "Missing";
  ![App Screenshot](https://pbs.twimg.com/media/Fsz8JjZWIAIzKkZ?format=png&name=900x900)

#### Negan Smith

- "fisrtSeason" = "6";
- "gunType" = "lucille";
- "community" = "Sanctuary";
- "status" = "Alive".
  ![App Screenshot](https://pbs.twimg.com/media/Fsz8PJlWIAkJss6?format=png&name=900x900)

#### Carl Grimes

- "fisrtSeason" = "1";
- "gunType" = "pistol";
- "community" = "Alexandria";
- "status" = "Dead";
  ![App Screenshot](https://pbs.twimg.com/media/Fsz8SL-WIBgbMbj?format=png&name=900x900)

Vamos entender Vizualizar cada uma delas agora.

- Todas as figurinhas da Nasa contém uma logo do mesmo para indicar de qual API elas serão
- Como a API da Nasa só tras 1 informação por dia, as figurinhas terão a mesma imagem (mas a lógica é funcional)

## Vizualizando as Informações das APIs

Independente da forma de vizualização de Imagem que você escolher, a aplicação sempre irá printar as informações de seus itens da mesma maneira

### Printando Informações das Séries/Filmes

O programa printa o Titulo, a URL da Imagem e a Nota da Série/Filme.

- Assim como estrelas dinâmicas, referentes à nota de tal obra.
  ![App Screenshot](https://pbs.twimg.com/media/FszoWSqXwB0FdM9?format=png&name=small)

### Printando Informações da Nasa

O programa printa o Titulo, a URL da Imagem e a Data de tal informação.

![App Screenshot](https://pbs.twimg.com/media/FszokejXwA818lf?format=png&name=small)

### Printando Informações dos Personagens de The Walking Dead.

O programa printa o Titulo, a URL da Imagem, a Primeira Temporada que o Personagem Aparece, a Comunidade que o Personagem pertence, o Tipo de Arma que ele Utiliza e o Status dele (essas informações serão usadas na construção da figurinha do personagem).

![App Screenshot](https://pbs.twimg.com/media/FszpN54XwBQeZY5?format=png&name=900x900)

## 🔗 Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/pedro-carvalho-pacheco/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/OPaches)
