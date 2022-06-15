import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args){
        ChessGame game = new ChessGame("fahed","ahmad");

        while (!game.isDone()){
            String move = read_move_from_console();
            if(game.isWhiteTurn())
                game.playWhite(move);
            else
                game.playBlack(move);
        }
        game.printWinnerName();
    }

    private static String read_move_from_console() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter move: ");
        String move = scanner.nextLine();
        if(isValidMove(move))
            return move;
        System.out.println("invalid move, please try again ");
        return read_move_from_console();
    }

    private static boolean isValidMove(String move){
        return Pattern.matches("move [A-H][0-9] [A-H][0-9]", move);
    }
}
