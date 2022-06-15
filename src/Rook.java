public class Rook extends Piece {

    public Rook(Color color , Location location) {
        super(PieceType.ROOK, color ,location);
    }

    @Override
    public boolean canMove(ChessBoard board, Location newLoc) {
        return false;
    }

    @Override
    public String toString() {
        if (getColor().equals(Color.BLACK)) {
            return "\u265C";
        } else {
            return "\u2656";
        }
    }

}
