public class Pawn extends Piece{

    public Pawn(Color color , Location location) {
        super(PieceType.PAWN , color , location);
    }

    private boolean isEnPassant(ChessBoard board,Location newLoc){
        if (newLoc.getY()!=this.getLocation().getY())
            if(board.getBoard()[this.getLocation().getX()][newLoc.getY()].equals(PieceType.PAWN))
                return board.getBoard()[this.getLocation().getX()][newLoc.getY()].getColor() != this.getColor();
        return false ;
    }

    private boolean isPromotion(Location newLoc){
        return (this.getColor() == Color.BLACK && newLoc.getX() == 0) || (this.getColor() == Color.WHITE && newLoc.getX() == 7);
    }

    @Override
    public boolean canMove(ChessBoard board, Location newLoc) {
        if(isEnPassant(board,newLoc))
            board.getBoard()[this.getLocation().getX()][newLoc.getY()]=null;
        if (isPromotion(newLoc))
            board.getBoard()[this.getLocation().getX()][this.getLocation().getY()]=new Queen(this.getColor(),newLoc);
        return true;
    }

    @Override
    public String toString() {
        if (getColor().equals(Color.BLACK)) {
            return "\u265F";
        } else {
            return "\u2659";
        }
    }

}
