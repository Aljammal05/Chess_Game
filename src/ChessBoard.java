public class ChessBoard {

    private final Piece[][] board;
    private final PieceFactory pieceFactory;
    private final Team whiteTeam ;
    private final Team blackTeam ;
    private Piece whiteKing , blackKing;
    private String winnerName ;

    ChessBoard(String whiteName, String blackName){
        pieceFactory=new PieceFactory();
        board = new Piece[8][8];
        whiteTeam = new Team(whiteName,Color.WHITE);
        blackTeam = new Team(blackName,Color.BLACK);
        initWhite(whiteTeam.getColor());
        initBlack(blackTeam.getColor());
        System.out.println(this);
    }

    public Piece[][] getBoard() {
        return board;
    }

    public Piece pieceAt(Location location){
        return board[location.getX()][location.getY()];
    }

    private void initWhite(Color color){
        for (int i = 0 ; i < 8 ; i++)
            board[1][i]=pieceFactory.createPiece(PieceType.PAWN , color , new Location(1,i));

        board[0][0]=pieceFactory.createPiece(PieceType.ROOK , color , new Location(0,0));
        board[0][1]=pieceFactory.createPiece(PieceType.KNIGHT , color , new Location(0,1));
        board[0][2]=pieceFactory.createPiece(PieceType.BISHOP , color , new Location(0,2));
        board[0][3]=pieceFactory.createPiece(PieceType.QUEEN , color , new Location(0,3));
        whiteKing = pieceFactory.createPiece(PieceType.KING , color , new Location(0,4));
        board[0][4]=whiteKing;
        board[0][5]=pieceFactory.createPiece(PieceType.BISHOP , color , new Location(0,5));
        board[0][6]=pieceFactory.createPiece(PieceType.KNIGHT , color , new Location(0,6));
        board[0][7]=pieceFactory.createPiece(PieceType.ROOK , color , new Location(0,7));
    }

    private void initBlack(Color color){
        for (int i = 0 ; i < 8 ; i++)
            board[6][i]=pieceFactory.createPiece(PieceType.PAWN , color , new Location(6,i));

        board[7][0]=pieceFactory.createPiece(PieceType.ROOK , color , new Location(7,0));
        board[7][1]=pieceFactory.createPiece(PieceType.KNIGHT , color , new Location(7,1));
        board[7][2]=pieceFactory.createPiece(PieceType.BISHOP , color , new Location(7,2));
        board[7][3]=pieceFactory.createPiece(PieceType.QUEEN , color , new Location(7,3));
        blackKing=pieceFactory.createPiece(PieceType.KING , color , new Location(7,4));
        board[7][4]=blackKing;
        board[7][5]=pieceFactory.createPiece(PieceType.BISHOP , color , new Location(7,5));
        board[7][6]=pieceFactory.createPiece(PieceType.KNIGHT , color , new Location(7,6));
        board[7][7]=pieceFactory.createPiece(PieceType.ROOK , color , new Location(7,7));
    }

    public boolean isGameOver() {
        if(whiteKing.isKilled()){
            winnerName = blackTeam.getTeamName();
            return true;
        }else if(blackKing.isKilled()){
            winnerName = whiteTeam.getTeamName();
            return true;
        }else
            return false;
    }

    public boolean move(Location currentLoc , Location newLoc){
        if (pieceAt(currentLoc).canMove(this , newLoc)){
            if (pieceAt(newLoc)!=null)
                pieceAt(newLoc).setKilled(true);
            board[newLoc.getX()][newLoc.getY()] = pieceAt(currentLoc) ;
            board[currentLoc.getX()][currentLoc.getY()] = null;
            pieceAt(newLoc).setLocation(newLoc);
            System.out.println(this);
            return true;
        }
        System.out.println("invalid move, the piece can't move to this spot");
        return false;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public String toString() {

        final char[] LETTERS = {'A','B','C','D','E','F','G','H'};
        final char[] NUMS = {'8','7','6','5','4','3','2','1'};
        StringBuilder endString = new StringBuilder("\n  \u202F");
        for(char i: LETTERS) {
            endString.append("\u202F\u202F\u202F\u202F").append(i);
        }
        endString.append("\n");
        for(int i = 0; i < NUMS.length; i++) {
            endString.append(" ").append(NUMS[i]).append(" |");
            int count = 0;
            for(Piece j: board[i]){
                if (j != null) {
                    endString.append(j).append("|");
                } else {
                    if ((i+count)%2==0)
                    endString.append("\u26DA" + "|");
                    else
                        endString.append("\u202F\u202F\u202F\u202F" + "|");
                }
                count++;
            }
            endString.append("\n");
        }
        return endString.toString();

    }

}
