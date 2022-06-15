public class King extends Piece{

    public King(Color color , Location location) {
        super(PieceType.KING,color , location);
    }

    private boolean isCastlingO_O_O(Location newLoc){
        if(newLoc.getY()- getLocation().getY()==-2 && newLoc.getX()== getLocation().getX()){
            System.out.println("castling O-O-O");
            return true;
        }
        return false;
    }

    private boolean isCastlingO_O(Location newLoc){
        if(newLoc.getY()- getLocation().getY()==2 && newLoc.getX()== getLocation().getX()){
            System.out.println("castling O-O");
            return true;
        }
        return false;
    }

    @Override
    public boolean canMove(ChessBoard board, Location newLoc) {
        if (isCastlingO_O(newLoc)) {
            board.getBoard()[newLoc.getX()][5] = board.getBoard()[newLoc.getX()][7];
            board.getBoard()[newLoc.getX()][7] = null;
        }
        if (isCastlingO_O_O(newLoc)) {
            board.getBoard()[newLoc.getX()][3] = board.getBoard()[newLoc.getX()][0];
            board.getBoard()[newLoc.getX()][0] = null;
        }
        return true;
    }

    @Override
    public String toString() {
        if (getColor().equals(Color.BLACK)) {
            return "\u265A";
        } else {
            return "\u2654";
        }
    }

}
