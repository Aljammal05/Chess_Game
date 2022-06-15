public class ChessGame {

    private final ChessBoard board;
    private boolean isWhiteTurn;

    public ChessGame(String whiteName, String blackName) {
        board = new ChessBoard(whiteName, blackName);
        isWhiteTurn = true ;
    }

    public boolean isDone() {
        return board.isGameOver();
    }

    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }

    public void playWhite(String move) {
        if(isValidMove(move))
            isWhiteTurn = false ;
        else
            System.out.println("invalid move");
    }

    public void playBlack(String move) {
        if(isValidMove(move))
            isWhiteTurn = true ;
        else
            System.out.println("invalid move");
    }

    private boolean isValidMove(String move){
        String currentLoc , newLoc ;
        currentLoc = move.split(" ")[1];
        newLoc = move.split(" ")[2];
        Location currentLocation = new Location(currentLoc);
        Location newLocation = new Location(newLoc);
        return board.move(currentLocation,newLocation);
    }

    public void printWinnerName() {
        System.out.println("the winner is "+board.getWinnerName());
    }
}
