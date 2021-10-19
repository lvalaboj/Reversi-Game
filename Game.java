import java.util.Scanner;

/**
 * Game
 * <p>
 * Constructs the Reversi game
 *
 * @author Lakshmi Valaboju, Purdue CS
 * @version July 12, 2021
 */
public class Game {

    public Point point;
    private final char[][] board;
    public int wScore;
    public int bScore;
    public int remaining;
    private final char[] boardX = new char
            []{'1', '2', '3', '4', '5', '6', '7', '8'};

    public Game() {
        board = new char[][]{
                {'_', '_', '_', '_', '_', '_', '_', '_', } ,
                {'_', '_', '_', '_', '_', '_', '_', '_', } ,
                {'_', '_', '_', '_', '_', '_', '_', '_', } ,
                {'_', '_', '_', 'W', 'B', '_', '_', '_', } ,
                {'_', '_', '_', 'B', 'W', '_', '_', '_', } ,
                {'_', '_', '_', '_', '_', '_', '_', '_', } ,
                {'_', '_', '_', '_', '_', '_', '_', '_', } ,
                {'_', '_', '_', '_', '_', '_', '_', '_', } , };
    }

    public void displayBoard() {
        System.out.print(" ");
        for (int k = 0; k < boardX.length; k++) {
            System.out.print(" " + boardX[k]);
        }
        System.out.print(" ");
        System.out.print("\n");
        int k = 0;
        for (int i = 0; i < 8; i++) {
            System.out.print(boardX[k] + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");

            }
            k++;
            System.out.print("\n");
        }
    }

    public int gameResult(Point[] whitePiecePlaceableLocations, Point[] blackPiecePlaceableLocations) {
        wScore = whitePiecePlaceableLocations.length;
        bScore = blackPiecePlaceableLocations.length;
        if (blackPiecePlaceableLocations.length > whitePiecePlaceableLocations.length) {
            return 1;
        } else if (whitePiecePlaceableLocations.length > blackPiecePlaceableLocations.length) {
            return -1;
        }
        /*
         * ODO: Update the score and determine the game result
         * @param whitePiecePlaceableLocations Array of possible moves for white pie
        ces
         * @param blackPiecePlaceableLocations Array of possible moves for black pie
        ces
         * @return The integer corresponding to the game result: 1 for black win, 0
        for draw, -1 for white win
         */

        return 0;
    }

    public Point[] getPlaceableLocations(char player, char opponent) {
        Point[] placeablePositions = new Point[64];
        int ind = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Character.compare(board[i][j], player) == 0) {
                    int oj = j;
                    int oi = i;
                    if ((oj + 1) < (8)) {
                        oj++;
                        if (Character.compare(board[i][oj], opponent) == 0) {
                            oj++;
                            while (oj < 8) {
                                if (Character.compare(board[i][oj], opponent) == 0) {
                                    oj++;
                                } else {
                                    break;
                                }
                            }
                            if (oj < 8) {
                                if (Character.compare(board[oi][oj], player) != 0) {
                                    Point p = new Point(++oi, ++oj);
                                    if (ind < 64) {
                                        placeablePositions[ind] = p;
                                        ind++;
                                    }
                                }

                            }
                        }
                    }
                    oj = j;
                    oi = i;
                    if (oj - 1 >= 0) {
                        oj--;
                        if (Character.compare(board[i][oj], opponent) == 0) {
                            oj--;
                            while (oj >= 0) {
                                if (Character.compare(board[i][oj], opponent) == 0) {
                                    oj--;
                                } else {
                                    break;
                                }
                            }
                            if (oj >= 0) {
                                if (Character.compare(board[oi][oj], player) != 0) {
                                    Point p = new Point(++oi, ++oj);
                                    if (ind < 64) {
                                        placeablePositions[ind] = p;
                                        ind++;
                                    }
                                }
                            }
                        }
                    }
                    oj = j;
                    oi = i;
                    if (oi + 1 < 8) {
                        oi++;
                        if (Character.compare(board[oi][j], opponent) == 0) {
                            oi++;
                            while (oi < 8) {
                                if (Character.compare(board[oi][j], opponent) == 0) {
                                    oi++;
                                } else {
                                    break;
                                }
                            }
                            if (oi < 8) {
                                if (Character.compare(board[oi][oj], player) != 0) {
                                    Point p = new Point(++oi, ++oj);
                                    if (ind < 64) {
                                        placeablePositions[ind] = p;
                                        ind++;
                                    }
                                }
                            }
                        }
                    }
                    oj = j;
                    oi = i;
                    if (oi - 1 >= 0) {
                        oi--;
                        if (Character.compare(board[oi][j], opponent) == 0) {
                            oi--;
                            while (oi >= 0) {
                                if (Character.compare(board[oi][j], opponent) == 0) {
                                    oi--;
                                } else {
                                    break;
                                }
                            }
                            if (oi >= 0) {
                                if (Character.compare(board[oi][oj], player) != 0) {
                                    Point p = new Point(++oi, ++oj);
                                    if (ind < 64) {
                                        placeablePositions[ind] = p;
                                        ind++;
                                    }
                                }
                            }
                        }
                    }
                    oj = j;
                    oi = i;
                    if ((oj + 1) < 8 && (oi + 1) < 8) {
                        oj++;
                        oi++;
                        if (Character.compare(board[oi][oj], opponent) == 0) {
                            oi++;
                            oj++;
                            while (oj < 8 && oi < 8) {
                                if (Character.compare(board[oi][oj], opponent) == 0) {
                                    oi++;
                                    oj++;
                                } else {
                                    break;
                                }
                            }
                            if (oj < 8 && oi < 8) {
                                if (Character.compare(board[oi][oj], player) != 0) {
                                    Point p = new Point(++oi, ++oj);
                                    if (ind < 64) {
                                        placeablePositions[ind] = p;
                                        ind++;
                                    }
                                }
                            }
                        }
                    }
                    oj = j;
                    oi = i;
                    if ((oj + 1) < 8 && (oi - 1) >= 0) {
                        oj++;
                        oi--;
                        if (Character.compare(board[oi][oj], opponent) == 0) {
                            oi--;
                            oj++;
                            while (oj < 8 && oi >= 0) {
                                if (Character.compare(board[oi][oj], opponent) == 0) {
                                    oi--;
                                    oj++;
                                } else {
                                    break;
                                }
                            }
                            if (oj < 8 && oi >= 0) {
                                if (Character.compare(board[oi][oj], player) != 0) {
                                    Point p = new Point(++oi, ++oj);
                                    if (ind < 64) {
                                        placeablePositions[ind] = p;
                                        ind++;
                                    }
                                }
                            }
                        }
                    }
                    oj = j;
                    oi = i;
                    if ((oi + 1) < 8 && (oj - 1) >= 0) {
                        oi++;
                        oj--;
                        if (Character.compare(board[oi][oj], opponent) == 0) {
                            oj--;
                            oi++;
                            while (oi < 8 && oj >= 0) {
                                if (Character.compare(board[oi][oj], opponent) == 0) {
                                    oj--;
                                    oi++;
                                } else {
                                    break;
                                }
                            }
                            if (oi < 8 && oj >= 0) {
                                if (Character.compare(board[oi][oj], player) != 0) {
                                    Point p = new Point(++oi, ++oj);
                                    if (ind < 64) {
                                        placeablePositions[ind] = p;
                                        ind++;
                                    }
                                }
                            }
                        }
                    }
                    oj = j;
                    oi = i;
                    if ((oj - 1) >= 0 && (oi - 1) >= 0) {
                        oj--;
                        oi--;
                        if (Character.compare(board[oi][oj], opponent) == 0) {
                            oi--;
                            oj--;
                            while (oj >= 0 && oi >= 0) {
                                if (Character.compare(board[oi][oj], opponent) == 0) {
                                    oi--;
                                    oj--;
                                } else {
                                    break;
                                }
                            }
                            if (oj >= 0 && oi >= 0) {
                                if (Character.compare(board[oi][oj], player) != 0) {
                                    Point p = new Point(++oi, ++oj);
                                    if (ind < 64) {
                                        placeablePositions[ind] = p;
                                        ind++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 64; i++) {
            if (placeablePositions[i] == null) {
                Point p = new Point(-1, -1);
                placeablePositions[i] = p;
            }
        }
        return placeablePositions;
    }

    public void showPlaceableLocations(Point[] locations, char player, char opponent) {
        int ind = 0;
        int count = 0;
        char[][] boardy = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardy[i][j] = board[i][j];
            }
        }
        System.out.print(" ");
        for (int j = 0; j < 64; j++) {
            if (locations[j].x != -1) {
                count++;
            }
        }
        System.out.print("\n");
        int k = 0;
        if (count < 64) {
            do {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (locations[ind].x == (i + 1) && locations[ind].y == (j + 1)) {
                            boardy[i][j] = '*';
                            ind++;
                        }
                        k++;
                    }
                }
            } while (ind != count);
        }
        System.out.print(" ");
        for (int l = 0; l < boardX.length; l++) {
            System.out.print(" " + boardX[l]);
        }
        System.out.print(" ");
        System.out.print("\n");
        for (int i = 0; i < 8; i++) {
            System.out.print(boardX[i] + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(boardy[i][j] + " ");

            }
            k++;
            System.out.print("\n");
        }
    }

    public void placeMove(Point pointt, char player, char opponent) {
        this.point = pointt;
        Point[] change = new Point[64];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (point.x == (i + 1) && point.y == (j + 1)) {
                    int indexCount = 0;
                    int oi = i;
                    int oj = j;
                    int ind = 0;
                    if ((oj - 1) >= 0) {
                        oj--;
                        if (Character.compare(board[i][oj], opponent) == 0) {
                            Point points = new Point(oi, oj);
                            if (ind < 64) {
                                change[ind] = points;
                                ind++;
                            }
                            oj--;
                            while (oj >= 0) {
                                int comp = Character.compare(board[oi][oj], opponent);
                                if (comp == 0 || Character.compare(board[i][oj], '_') == 0) {
                                    if (Character.compare(board[oi][oj], opponent) == 0) {
                                        points = new Point(oi, oj);
                                        change[ind] = points;
                                        if (ind < 64) {
                                            change[ind] = points;
                                            ind++;
                                        }
                                    }
                                   // ind++;
                                    oj--;
                                } else {
                                    break;
                                }
                            }
                            if (oj < 0) {
                                ind = 0;
                            }
                        }
                    }
                    indexCount = ind;
                    oi = i;
                    oj = j;
                    if ((oi - 1) >= 0) {
                        oi--;
                        if (Character.compare(board[oi][oj], opponent) == 0) {
                            Point points = new Point(oi, oj);
                            if (ind < 64) {
                                change[ind] = points;
                                ind++;
                            }
                            oi--;
                            while (oi >= 0) {
                                int comp = Character.compare(board[oi][oj], opponent);
                                if (comp == 0 || Character.compare(board[oi][oj], '_') == 0) {
                                    if (Character.compare(board[oi][oj], opponent) == 0) {
                                        points = new Point(oi, oj);
                                        if (ind < 64) {
                                            change[ind] = points;
                                            ind++;
                                        }
                                    }
                                 //   ind++;
                                    oi--;
                                } else {
                                    break;
                                }
                            }
                            if (oi < 0) {
                                ind = indexCount;
                                change[ind] = null;
                            }
                        }
                    }
                    indexCount = ind;
                    oi = i;
                    oj = j;
                    if ((oi + 1) < 8) {
                        oi++;
                        if (Character.compare(board[oi][oj], opponent) == 0) {
                            Point points = new Point(oi, oj);
                            if (ind < 64) {
                                change[ind] = points;
                                ind++;
                            }
                            oi++;
                            while (oi < 8) {
                                int comp = Character.compare(board[oi][oj], opponent);
                                if (comp == 0 || Character.compare(board[oi][oj], '_') == 0) {
                                    if (Character.compare(board[oi][oj], opponent) == 0) {
                                        points = new Point(oi, oj);
                                        if (ind < 64) {
                                            change[ind] = points;
                                            ind++;
                                        }
                                    }
                                   // ind++;
                                    oi++;
                                } else {
                                    break;
                                }
                            }
                            if (oi >= 8) {
                                ind = indexCount;
                                change[ind] = null;
                            }
                        }
                    }
                    indexCount = ind;
                    oi = i;
                    oj = j;
                    if ((oj + 1) < 8) {
                        oj++;
                        if (Character.compare(board[oi][oj], opponent) == 0) {
                            Point points = new Point(oi, oj);
                            if (ind < 64) {
                                change[ind] = points;
                                ind++;
                            }
                            oj++;
                            while (oj < 8) {
                                int comp = Character.compare(board[oi][oj], opponent);
                                if (comp == 0 || Character.compare(board[oi][oj], '_') == 0) {
                                    if (Character.compare(board[oi][oj], opponent) == 0) {
                                        points = new Point(oi, oj);
                                        if (ind < 64) {
                                            change[ind] = points;
                                            ind++;
                                        }
                                    }
                                    //ind++;
                                    oj++;
                                } else {
                                    break;
                                }
                            }
                            if (oj >= 8) {
                                ind = indexCount;
                                change[ind] = null;
                            }
                        }
                    }
                    indexCount = ind;
                    oi = i;
                    oj = j;
                    if ((oj + 1) < 8 && (oi + 1) < 8) {
                        oj++;
                        oi++;
                        if (Character.compare(board[oi][oj], opponent) == 0) {
                            Point points = new Point(oi, oj);
                            if (ind < 64) {
                                change[ind] = points;
                                ind++;
                            }
                            oj++;
                            oi++;
                            while (oj < 8 && oi < 8) {
                                int comp = Character.compare(board[oi][oj], opponent);
                                if (comp == 0 || Character.compare(board[oi][oj], '_') == 0) {
                                    if (Character.compare(board[oi][oj], opponent) == 0) {
                                        points = new Point(oi, oj);
                                        if (ind < 64) {
                                            change[ind] = points;
                                            ind++;
                                        }
                                    }
                                    //ind++;
                                    oj++;
                                    oi++;
                                } else {
                                    break;
                                }
                            }
                            if (oi >= 8 || oj >= 8) {
                                ind = indexCount;
                                change[ind] = null;
                            }
                        }
                    }
                    indexCount = ind;
                    oi = i;
                    oj = j;
                    if ((oj + 1) < 8 && (oi - 1) >= 0) {
                        oj++;
                        oi--;
                        if (Character.compare(board[oi][oj], opponent) == 0) {
                            Point points = new Point(oi, oj);
                            if (ind < 64) {
                                change[ind] = points;
                                ind++;
                            }
                            oj++;
                            oi--;
                            while (oj < 8 && oi >= 0) {
                                int comp = Character.compare(board[oi][oj], opponent);
                                if (comp == 0 || Character.compare(board[oi][oj], '_') == 0) {
                                    if (Character.compare(board[oi][oj], opponent) == 0) {
                                        points = new Point(oi, oj);
                                        if (ind < 64) {
                                            change[ind] = points;
                                            ind++;
                                        }
                                    }
                                   // ind++;
                                    oj++;
                                    oi--;
                                } else {
                                    break;
                                }
                            }
                            if (oj >= 8 || oi < 0) {
                                ind = indexCount;
                                change[ind] = null;
                            }
                        }
                    }
                    indexCount = ind;
                    oi = i;
                    oj = j;
                    if ((oi + 1) < 8 && (oj - 1) >= 0) {
                        oi++;
                        oj--;
                        if (Character.compare(board[oi][oj], opponent) == 0) {
                            Point points = new Point(oi, oj);
                            if (ind < 64) {
                                change[ind] = points;
                                ind++;
                            }
                            oi++;
                            oj--;
                            while (oi < 8 && oj >= 0) {
                                int comp = Character.compare(board[oi][oj], opponent);
                                if (comp == 0 || Character.compare(board[oi][oj], '_') == 0) {
                                    if (Character.compare(board[oi][oj], opponent) == 0) {
                                        points = new Point(oi, oj);
                                        if (ind < 64) {
                                            change[ind] = points;
                                            ind++;
                                        }
                                    }
                                    //ind++;
                                    oi++;
                                    oj--;
                                } else {
                                    break;
                                }
                            }
                            if (oi >= 8 && oj < 0) {
                                ind = indexCount;
                                change[ind] = null;
                            }
                        }
                    }
                    indexCount = ind;
                    oi = i;
                    oj = j;
                    if ((oi - 1) >= 0 && (oj - 1) >= 0) {
                        oi--;
                        oj--;
                        if (Character.compare(board[oi][oj], opponent) == 0) {
                            Point points = new Point(oi, oj);
                            if (ind < 64) {
                                change[ind] = points;
                                ind++;
                            }
                            oi--;
                            oj--;
                            while (oi >= 0 && oj >= 0) {
                                int comp = Character.compare(board[oi][oj], opponent);
                                if (comp == 0 || Character.compare(board[oi][oj], '_') == 0) {
                                    if (Character.compare(board[oi][oj], opponent) == 0) {
                                        points = new Point(oi, oj);
                                        if (ind < 64) {
                                            change[ind] = points;
                                            ind++;
                                        }
                                    }
                                   // ind++;
                                    oi--;
                                    oj--;
                                } else {
                                    break;
                                }
                            }
                            if (oi < 0 || oj < 0) {
                                ind = indexCount;
                                change[ind] = null;
                            }
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 64; i++) {
            if (change[i] != null) {
                count++;
            }
        }
        int changeInd = 0;
        do {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (change[changeInd] != null) {
                        if (change[changeInd].x == i && change[changeInd].y == j) {
                            board[i][j] = player;
                        }
                    } else {
                        break;
                    }
                    if (point.x == (i + 1) && point.y == (j + 1) && changeInd == 0) {
                        board[i][j] = player;
                    }
                }
            }
            if (changeInd < 63) {
                changeInd++;
            }
        } while (changeInd != count);

        /*
         * TDO: Place a piece on the board at the location by the point p and update
         the board accordingly
         * @param p Point corresponding to the location of the piece to be placed
         * @param player Current player
         * @param opponent player's opponent
         */
    }

    public void updateScores() {
        wScore = 0;
        bScore = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Character.compare(board[i][j], 'W') == 0) {
                    wScore++;
                } else if (Character.compare(board[i][j], 'B') == 0) {
                    bScore++;
                }
            }
        }
        /*
         * TDO: Update the scores (number of pieces of a player'
         s color) of each player
         */
    }
}
