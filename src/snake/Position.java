package snake;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
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

    public boolean equals(Position o) {
        return this.x == o.x && this.y == o.y;
    }
}
