package snake;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class Snake {

    private Direction direction = Direction.RIGHT;
    private ArrayList<Position> body = new ArrayList<>();

    private int up = KeyEvent.VK_UP;
    private int down = KeyEvent.VK_DOWN;
    private int left = KeyEvent.VK_LEFT;
    private int right = KeyEvent.VK_RIGHT;

    //https://files.fm/u/jvbt6j5hq
    public Snake(int up, int down, int left, int right) {
        init();
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public Snake() {
        init();
    }

    private void init() {
        Random random = new Random();
        int y = random.nextInt(Constants.blockCount);
        body.add(new Position(6 * Constants.imageSize, y * Constants.imageSize));
        for (int i = 0; i < 2; i++) {
            grow();
        }
    }

    public void grow() {
        Position lastPosition = body.get(body.size() - 1);
        body.add(lastPosition.copy());
    }

    public void changeDirection(int key) {
        if (key == up) {
            if (this.direction != Direction.DOWN) {
                this.direction = Direction.UP;
            }
        } else if (key == down) {
            if (this.direction != Direction.UP) {
                this.direction = Direction.DOWN;
            }
        } else if (key == left) {
            if (this.direction != Direction.RIGHT) {
                this.direction = Direction.LEFT;
            }
        } else if (key == right) {
            if (this.direction != Direction.LEFT) {
                this.direction = Direction.RIGHT;
            }
        }
    }




    public void move() {
        for (int i = body.size() - 1; i > 0; i--) {
            body.get(i).setX(body.get(i - 1).getX());
            body.get(i).setY(body.get(i - 1).getY());
        }
        switch (direction) {
            case RIGHT:
                body.get(0).incX(Constants.imageSize);
                break;
            case LEFT:
                body.get(0).incX(-Constants.imageSize);
                break;
            case UP:
                body.get(0).incY(-Constants.imageSize);
                break;
            case DOWN:
                body.get(0).incY(Constants.imageSize);
                break;
        }
    }

    public void end() {
        body.clear();
    }

    public Position getHeadPosition() {
        return body.get(0);
    }

    public Direction getDirection() {
        return direction;
    }

    public ArrayList<Position> getBody() {
        return body;
    }

}
