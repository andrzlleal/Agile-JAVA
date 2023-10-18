package pieces;

public class Pawn {
    private String color;
    public static final String WHITE = "White";
    public static final String BLACK = "Black";
    private char printableRepresentation;
    public Pawn(String color, char p) {
        this.color = color;
        this.printableRepresentation = printableRepresentation;
}
    public String getColor() {
      return color;
}
    public void setColor(String color) {
      this.color = color;
}
    public Pawn() { //novo construtor para criar um peao branco por padrao
        this.color = WHITE;
}

    public char getPrintableRepresentation() {
        return printableRepresentation;
    }


//    private final String color;
//    public static final String WHITE = "White";
//    public static final String BLACK = "Black";
//
//    private int rank;
//    private int file;
//
//    /** Create a new pieces.Pawn object with the specified color. **/
//   public Pawn(String color) {
//       this.color = color;
//       this.rank = rank;
//       this.file = file;
//   }
//   public Pawn(String color, int i, int i1){
//       this.color = color;
//   }
//   public String getColor(){
//       return color;
//   }
//   public int getRank() {
//       return rank;
//   }
//   public int getFile(){
//       return file;
//   }
//
//    public char getPrintableRepresentation() {
//        if (WHITE.equals(color)) {
//            return 'P';
//        }else {
//            return 'p';
//        }
//    }

}
