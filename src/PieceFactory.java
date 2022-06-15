public class PieceFactory {

    public Piece createPiece ( PieceType type , Color color , Location location ){
        if(type == PieceType.KING)
            return new King(color , location);
        else if (type == PieceType.QUEEN)
            return new Queen(color , location);
        else if (type == PieceType.ROOK)
            return new Rook(color , location);
        else if (type == PieceType.BISHOP)
            return new Bishop(color , location);
        else if (type == PieceType.KNIGHT)
            return new Knight(color , location);
        else if (type == PieceType.PAWN)
            return new Pawn(color , location);
        return null ;
    }

}
