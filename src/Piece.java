enum PieceType {
    KING,
    QUEEN,
    ROOK,
    BISHOP,
    KNIGHT,
    PAWN
}
public abstract class Piece {
    private final Color color;
    private final PieceType type ;
    private Location location ;
    private boolean killed ;

    public Piece(PieceType type ,Color color ,Location location) {
        this.type = type ;
        this.color = color ;
        this.location = location ;
        this.killed = false ;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public Color getColor() {
        return color;
    }

    public abstract boolean canMove(ChessBoard board, Location newLoc);

    public boolean equals(PieceType type) {
        return this.type == type ;
    }

    public abstract String toString();
}
