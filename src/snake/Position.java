package snake;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

//    public Position(Position old) {
//        x = old.x;
//        y = old.y;
//    }

    public Position copy() {
        return new Position(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void incX(int x) {
        this.x += x;
    }

    public void incY(int y) {
        this.y += y;
    }

    public boolean equals(Position other) {
        return this.x == other.x && this.y == other.y;
    }
}
