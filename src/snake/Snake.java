package snake;

import java.util.ArrayList;
import java.util.Random;

public class Snake {
    private ArrayList<Position> body = new ArrayList<>();
    private Direction direction = Direction.UP;

    public Snake() {
        Random random = new Random();
        int y = random.nextInt(Constants.canvasSize / Constants.imageSize);
        body.add(new Position(5 * Constants.imageSize, y * Constants.imageSize));
        body.add(new Position(4 * Constants.imageSize, y * Constants.imageSize));
        body.add(new Position(3 * Constants.imageSize, y * Constants.imageSize));
    }

    public void move() {
        for (int i = body.size() - 1; i > 0; i--) {
            body.get(i).setX(body.get(i - 1).getX());
            body.get(i).setY(body.get(i - 1).getY());
        }

        switch (direction) {
            case RIGHT -> body.get(0).incX(Constants.imageSize);
            case LEFT -> body.get(0).incX(-Constants.imageSize);
            case UP -> body.get(0).incY(-Constants.imageSize);
            case DOWN -> body.get(0).incY(Constants.imageSize);
        }

    }

    public ArrayList<Position> getBody() {
        return body;
    }


    public void setDirection(Direction direction) {
        switch (direction) {
            case RIGHT -> {
                if (this.direction == Direction.LEFT) {
                    return;
                }
            }
            case LEFT -> {
                if (this.direction == Direction.RIGHT) {
                    return;
                }
            }
            case UP -> {
                if (this.direction == Direction.DOWN) {
                    return;
                }
            }
            case DOWN -> {
                if (this.direction == Direction.UP) {
                    return;
                }
            }
        }
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}
