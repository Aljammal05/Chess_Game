public class Queen extends Piece{

    public Queen(Color color,Location location) {
        super(PieceType.QUEEN , color ,location);
    }

    @Override
    public boolean canMove(ChessBoard board, Location newLoc) {
        return true;
    }

    @Override
    public String toString() {
        if (getColor().equals(Color.BLACK)) {
            return "\u265B";
        } else {
            return "\u2655";
        }
    }

}
