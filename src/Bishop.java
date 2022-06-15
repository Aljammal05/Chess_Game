public class Bishop extends Piece{

    public Bishop(Color color , Location location) {
        super(PieceType.BISHOP, color ,location);
    }

    @Override
    public boolean canMove(ChessBoard board, Location newLoc) {
        return true;
    }

    @Override
    public String toString() {
        if (getColor().equals(Color.BLACK)) {
            return "\u265D";
        } else {
            return "\u2657";
        }
    }

}
