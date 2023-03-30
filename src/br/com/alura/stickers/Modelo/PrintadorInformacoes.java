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

}
