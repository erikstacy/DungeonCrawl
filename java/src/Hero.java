

public class Hero {

    private int iPos;
    private int jPos;
    private int treasures;

    public Hero() {
        this.iPos = 0;
        this.jPos = 0;
        this.treasures = 0;
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

    public void setTreasures(int val) {
        this.treasures = val;
    }

    public int getTreasures() {
        return this.treasures;
    }

}
