import java.lang.reflect.Array;

public class Board {

    private char[][] board = new char[10][10];

    public Board() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.board[i][j] = '-';
            }
        }

        this.board[0][0] = 'H';
        this.board[9][9] = 'M';
    }

    public void printBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j] + "   ");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    public void changeBoard(int i, int j, char character) {
        this.board[i][j] = character;
    }

}
