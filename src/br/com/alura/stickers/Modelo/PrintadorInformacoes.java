package br.com.alura.stickers.Modelo;

public class PrintadorInformacoes {
  
  public void printarInfosGerais(String titulo, String infoImagem){
    System.out.println("\u001b[1mTitulo:\u001b[m " + titulo);
    System.out.println("\u001b[1mImagem:\u001b[m " + infoImagem);
  }

  public void printarIMDBRating(String rating){
    System.out.println("\u001b[1mRating:\u001b[m " + rating);
    double notaEmDouble = Double.parseDouble(rating);
    imprimirEstrelas(notaEmDouble);
  }

        public static void imprimirEstrelas(double notaEmDouble) {

          int notaEmInt = (int) notaEmDouble;

              // Printando Estrelinha
              for (int j = 1; j <= notaEmInt; j++){
                  System.out.print("⭐");
              }
              //Pulando Linha
              System.out.println("\n");

      }

  public void printarNasaDate(String date){
    System.out.println("\u001b[1mDate:\u001b[m " + date);
  }

  public void printarInfosTWD(String firstSeason, String community, String gunType, String alive){
     System.out.println("\u001b[1mPrimeira Temporada Que Apareceu:\u001b[m " + firstSeason);
     System.out.println("\u001b[1mComunidade que Pertence:\u001b[m " + community);
     System.out.println("\u001b[1mTipo de Arma:\u001b[m " + gunType);
     System.out.println("\u001b[1mEsta Vivo:\u001b[m " + alive);
  }

}
