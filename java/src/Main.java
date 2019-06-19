import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static Board board = new Board();
    static Hero hero = new Hero();
    static Monster monster = new Monster();
    static char endGame = 'c';

    public static void main(String[] args) {
        printIntro();
        while (endGame == 'c') {
            board.printBoard();
            userInput();
            getMonsterMove();
            checkEndGame();
        }
        board.printBoard();
        if (endGame == 'w') {
            System.out.println("You WON!!");
        }
        if (endGame == 'l') {
            System.out.println("You LOST!!");
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
                    char tCheck = checkTreasure(hero.getiPos(), hero.getjPos());
                    if (tCheck == 'y') {
                        hero.setTreasures(hero.getTreasures() + 1);
                        System.out.println("You have " + hero.getTreasures() + " treasure!");
                    }
                }
                break;
            case 'a':
                if (checkMove(hero.getiPos(), hero.getjPos() - 1) == 'y') {
                    moveHero(hero.getiPos(), hero.getjPos() - 1);
                    char tCheck = checkTreasure(hero.getiPos(), hero.getjPos());
                    if (tCheck == 'y') {
                        hero.setTreasures(hero.getTreasures() + 1);
                        System.out.println("You have " + hero.getTreasures() + " treasure!");
                    }
                }
                break;
            case 's':
                if (checkMove(hero.getiPos() + 1, hero.getjPos()) == 'y') {
                    moveHero(hero.getiPos() + 1, hero.getjPos());
                    char tCheck = checkTreasure(hero.getiPos(), hero.getjPos());
                    if (tCheck == 'y') {
                        hero.setTreasures(hero.getTreasures() + 1);
                        System.out.println("You have " + hero.getTreasures() + " treasure!");
                    }
                }
                break;
            case 'd':
                if (checkMove(hero.getiPos(), hero.getjPos() + 1) == 'y') {
                    moveHero(hero.getiPos(), hero.getjPos() + 1);
                    char tCheck = checkTreasure(hero.getiPos(), hero.getjPos());
                    if (tCheck == 'y') {
                        hero.setTreasures(hero.getTreasures() + 1);
                        System.out.println("You have " + hero.getTreasures() + " treasure!");
                    }
                }
                break;
            case 'q':
                endGame = 'q';
                break;
        }
    }

    public static void getMonsterMove() {
        int check = monster.getMove() % 2;
        switch (check) {
            case 0:
                if (hero.getiPos() < monster.getiPos()) {
                    if (checkMove(monster.getiPos() - 1, monster.getjPos()) == 'y' && checkTreasure(monster.getiPos() - 1, monster.getjPos()) == 'n') {
                        moveMonster(monster.getiPos() - 1, monster.getjPos());
                    }
                } else {
                    if (checkMove(monster.getiPos() + 1, monster.getjPos()) == 'y' && checkTreasure(monster.getiPos() + 1, monster.getjPos()) == 'n') {
                        moveMonster(monster.getiPos() + 1, monster.getjPos());
                    }
                }
                break;
            case 1:
                if (hero.getjPos() < monster.getjPos()) {
                    if (checkMove(monster.getiPos(), monster.getjPos() - 1) == 'y' && checkTreasure(monster.getiPos(), monster.getjPos() - 1) == 'n') {
                        moveMonster(monster.getiPos(), monster.getjPos() - 1);
                    }
                } else {
                    if (checkMove(monster.getiPos(), monster.getjPos() + 1) == 'y' && checkTreasure(monster.getiPos(), monster.getjPos() + 1) == 'n') {
                        moveMonster(monster.getiPos(), monster.getjPos() + 1);
                    }
                }
                break;
            case 2:
                if (hero.getiPos() < monster.getiPos()) {
                    if (checkMove(monster.getiPos() + 1, monster.getjPos()) == 'y' && checkTreasure(monster.getiPos() + 1, monster.getjPos()) == 'n') {
                        moveMonster(monster.getiPos() + 1, monster.getjPos());
                    }
                } else {
                    if (checkMove(monster.getiPos() - 1, monster.getjPos()) == 'y' && checkTreasure(monster.getiPos() - 1, monster.getjPos()) == 'n') {
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

    public static char checkTreasure(int i, int j) {
        if ((i == 2 && j ==2) || (i == 2 && j == 7) || (i == 7 && j == 2) || (i == 7 && j == 7)) {
            if (board.printSpot(i, j) == 'T') {
                return 'y';
            } else {
                return 'n';
            }
        } else {
            return 'n';
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
            endGame = 'l';
        } else if (hero.getTreasures() == 4) {
            endGame = 'w';
        }
    }

}
