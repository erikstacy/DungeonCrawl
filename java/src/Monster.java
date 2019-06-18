public class Monster {

    private int iPos;
    private int jPos;
    private int move;

    public Monster() {
        this.iPos = 9;
        this.jPos = 9;
        this.move = 3;
    }

    public int getiPos() {
        return this.iPos;
    }

    public int getjPos() {
        return this.jPos;
    }

    public void setiPos(int val) {
        this.iPos = val;
    }

    public void setjPos(int val) {
        this.jPos = val;
    }

    public int getMove() {
        return this.move;
    }

    public void setMove(int val) {
        this.move = val;
    }

}
