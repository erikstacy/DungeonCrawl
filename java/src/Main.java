import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static Board board = new Board();
    static Hero hero = new Hero();
    static Monster monster = new Monster();
    static char quit = 'n';

    public static void main(String[] args) {
        printIntro();
        while (quit == 'n') {
            board.printBoard();
            userInput();
            getMonsterMove();
            checkEndGame();
        }
    }

    public static void printIntro() {
        System.out.println("\n" + "Welcome to D U N G E O N    C R A W L \n");
    }

    public static void userInput() {
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

    public static void getMonsterMove() {
        int check = monster.getMove() % 3;
        switch (check) {
            case 0:
                if (hero.getiPos() < monster.getiPos()) {
                    if (checkMove(monster.getiPos() - 1, monster.getjPos()) == 'y') {
                        moveMonster(monster.getiPos() - 1, monster.getjPos());
                    }
                } else {
                    if (checkMove(monster.getiPos() + 1, monster.getjPos()) == 'y') {
                        moveMonster(monster.getiPos() + 1, monster.getjPos());
                    }
                }
                break;
            case 1:
                if (hero.getjPos() < monster.getjPos()) {
                    if (checkMove(monster.getiPos(), monster.getjPos() - 1) == 'y') {
                        moveMonster(monster.getiPos(), monster.getjPos() - 1);
                    }
                } else {
                    if (checkMove(monster.getiPos(), monster.getjPos() + 1) == 'y') {
                        moveMonster(monster.getiPos(), monster.getjPos() + 1);
                    }
                }
                break;
            case 2:
                if (hero.getiPos() < monster.getiPos()) {
                    if (checkMove(monster.getiPos() + 1, monster.getjPos()) == 'y') {
                        moveMonster(monster.getiPos() + 1, monster.getjPos());
                    }
                } else {
                    if (checkMove(monster.getiPos() - 1, monster.getjPos()) == 'y') {
                        moveMonster(monster.getiPos() - 1, monster.getjPos());
                    }
                }
                break;
        }
        monster.setMove(monster.getMove() + 1);
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

    public static void moveMonster(int i, int j) {
        board.changeBoard(monster.getiPos(), monster.getjPos(), '-');
        monster.setiPos(i);
        monster.setjPos(j);
        board.changeBoard(i, j, 'M');
    }

    public static void checkEndGame() {
        if (hero.getiPos() == monster.getiPos() && hero.getjPos() == monster.getjPos()) {
            System.out.println("You LOST");
        }
    }

}
