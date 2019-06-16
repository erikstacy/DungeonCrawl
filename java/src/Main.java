import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static Board board = new Board();
    static Hero hero = new Hero();
    static char quit = 'n';

    public static void main(String[] args) {
        printIntro();
        while (quit == 'n') {
            board.printBoard();
            userInput();
        }
    }

    public static void printIntro() {
        System.out.println("\n" + "Welcome to D U N G E O N    C R A W L \n");
    }

    public static char userInput() {
        System.out.println("Move your hero");
        System.out.println("W moves up. A moves left. S moves down. D moves right.\n");
        System.out.println("Q quits the game");
        System.out.print("Your move: ");

        char move = input.next().charAt(0);

        switch (move) {
            case 'w':
                if (checkMove(hero.getiPos() - 1, hero.getjPos()) == 'y') {
                    moveHero(hero.getiPos() - 1, hero.getjPos());
                }
                break;
            case 'a':
                if (checkMove(hero.getiPos(), hero.getjPos() - 1) == 'y') {
                    moveHero(hero.getiPos(), hero.getjPos() - 1);
                }
                break;
            case 's':
                if (checkMove(hero.getiPos() + 1, hero.getjPos()) == 'y') {
                    moveHero(hero.getiPos() + 1, hero.getjPos());
                }
                break;
            case 'd':
                if (checkMove(hero.getiPos(), hero.getjPos() + 1) == 'y') {
                    moveHero(hero.getiPos(), hero.getjPos() + 1);
                }
                break;
            case 'q':
                quit = 'y';
                break;
        }
    }

    public static char checkMove(int i, int j) {
        if (i < 0 || i > 9 || j < 0 || j > 9) {
            return 'n';
        } else {
            return 'y';
        }
    }

    public static void moveHero(int i, int j) {
        board.changeBoard(hero.getiPos(), hero.getjPos(), '-');
        hero.setiPos(i);
        hero.setjPos(j);
        board.changeBoard(i, j, 'H');
    }

}
