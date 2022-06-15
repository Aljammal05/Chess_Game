
public class Knight extends Piece{

    public Knight(Color color , Location location) {
        super(PieceType.KNIGHT ,color , location);
    }

    @Override
    public boolean canMove(ChessBoard board, Location newLoc) {
        return true;
    }

    @Override
    public String toString() {
        if (getColor().equals(Color.BLACK)) {
            return "\u265E";
        } else {
            return "\u2658";
        }
    }

}
