import java.util.Scanner;

/**
 * Reversi
 * <p>
 * Operates on the game class
 *
 * @author Lakshmi Valaboju, Purdue CS
 * @version July 12, 2021
 */
public class Reversi {


    //  String Draw = "It is a draw.";
    // String WhiteWins = "White wins: " + g.WScore + ":" + g.BScore;
    //String BlackWins = "Black wins: " + g.BScore + ":" + g.WScore;
    //  String Exit = "Exiting!";

    //  String BlackMove = "Place move (Black): row then column: ";
    //  String BlackSkipping = "Black needs to skip... Passing to white";
    //   String InvalidBlackMove = "Invalid move!\nPlace move (Black): row then column: ";
    //   //String BlackScoreShow = "Black: " + g.BScore + " White: " + g.WScore;

    //  String WhiteSkipping = "White needs to skip... Passing to Black";
    // String WhiteMove = "Place move (White): row then column: ";
    // String InvalidWhiteMove = "Invalid move!\nPlace move (White): row then column: ";
    //String WhiteScoreShow = "White: " + g.WScore + " Black: " + g.BScore;

    public static boolean isFull(Point[] board) {
        int count = 0;
        for (int j = 0; j < board.length; j++) {
            if (board[j].x == -1) {
                count++;
            }
        }

        return count != 64;
        /*
         * ODO: Check whether any valid moves can be played
         * @param board The game board to be checked
         * @return true if there are valid moves; false if there are no valid mov
        es
         */
    }

    //Check whether a Point is the Points array or not

    public static boolean contains(Point[] board, Point point) {
        int count = 0;
        for (int j = 0; j < board.length; j++) {
            if (board[j].x == point.x && board[j].y == point.y) {
                count++;
            }
        }

        if (count == 0) {
            return false;
        }
        /*
         * T Check whether the board already contains a point corresponding t
         o a previous move
         * @param board The game board to be checked
         * @param p The point to be checked for validity
         * @return true if the board contains the point; false if the board does
        not contain the point
         */

        return true;

    }

    public static void start(Game game) {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        int exit = 0;
        char play;
        char opp;
        int x;
        int y;
        do {
            if (count % 2 == 0) {
                play = 'B';
                opp = 'W';
                if (isFull(game.getPlaceableLocations(play, opp))) {
                    game.showPlaceableLocations(game.getPlaceableLocations(play, opp), play, opp);
                    System.out.println("\nPlace move (Black): row then column: ");
                    String move = scan.nextLine();

                    if (move.equals("exit")) {
                        System.out.println("Exiting!");
                        exit++;
                        break;
                    }
                    Point contain;
                    while (move.length() != 2) {
                        System.out.println("Invalid move!\nPlace move (Black): row then column: ");
                        move = scan.nextLine();
                        if (move.equals("exit")) {
                            System.out.println("Exiting!");
                            exit++;
                            break;
                        }

                    }
                    x = Integer.parseInt(move.substring(0, 1));
                    y = Integer.parseInt(move.substring(1));
                    contain = new Point(x, y);

                    while (contains(game.getPlaceableLocations(play, opp), contain) == false ) {
                        System.out.println("Invalid move!\nPlace move (Black): row then column: ");
                        move = scan.nextLine();
                        if (move.equals("exit")) {
                            System.out.println("Exiting!");
                            exit++;
                            break;
                        }

                        x = Integer.parseInt(move.substring(0, 1));
                        y = Integer.parseInt(move.substring(1));
                        contain = new Point(x, y);

                    }

                    if (exit == 0) {
                        game.placeMove(contain, play, opp);
                        game.updateScores();
                        System.out.println("Black: " + game.bScore + " White: " + game.wScore);
                    }
                } else {
                    System.out.println("Black needs to skip... Passing to white");
                }

            } else {
                play = 'W';
                opp = 'B';

                if (isFull(game.getPlaceableLocations(play, opp))) {
                    game.showPlaceableLocations(game.getPlaceableLocations(play, opp), play, opp);
                    System.out.println("\nPlace move (White): row then column: ");
                    String move = scan.nextLine();

                    if (move.equals("exit")) {
                        System.out.println("Exiting!");
                        exit++;
                        break;
                    }

                    Point contain;
                    while (move.length() != 2) {
                        System.out.println("Invalid move!\nPlace move (Black): row then column: ");
                        move = scan.nextLine();
                        if (move.equals("exit")) {
                            System.out.println("Exiting!");
                            exit++;
                            break;
                        }

                    }
                    x = Integer.parseInt(move.substring(0, 1));
                    y = Integer.parseInt(move.substring(1));
                    contain = new Point(x, y);


                    while (contains(game.getPlaceableLocations(play, opp), contain) == false) {
                        System.out.println("Invalid move!\nPlace move (White): row then column: ");
                        move = scan.nextLine();
                        if (move.equals("exit")) {
                            System.out.println("Exiting!");
                            exit++;
                            break;
                        }

                        x = Integer.parseInt(move.substring(0, 1));
                        y = Integer.parseInt(move.substring(1));
                        contain = new Point(x, y);

                    }

                    if (exit == 0) {
                        game.placeMove(contain, play, opp);
                        game.updateScores();
                        System.out.println("White: " + game.wScore + " Black: " + game.bScore);
                    }
                } else {
                    System.out.println("White needs to skip... Passing to Black");
                }


            }
            count++;
            if (exit > 0) {
                break;
            }

        } while (isFull(game.getPlaceableLocations(play, opp)));


        if (exit == 0) {
            System.out.print("\n");
            game.displayBoard();
            game.updateScores();
            if (game.bScore > game.wScore) {
                System.out.println("Black wins: " + game.bScore + ":" + game.wScore);
            } else if (game.wScore > game.bScore) {
                System.out.println("White wins: " + game.wScore + ":" + game.bScore);
            } else if (game.wScore == game.bScore) {
                System.out.println("It is a draw.");
            }
        }


        /*
         *  Handle input corresponding to the sequence of moves entered by t
         he user
         *  Check the validity of the move, update the board, and print out
         the updated board after each move
         * Determine and print out the result after the game is completed
         * @param g The Reversi game currently in play
         */

    }

    public static void main(String[] args) {
        Game game = new Game();
        start(game);
    }

}
