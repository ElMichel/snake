package snake;

import java.util.ArrayList;
import java.util.Random;

public class Snake {
    private ArrayList<Position> body = new ArrayList<>();
    private Direction direction = Direction.RIGHT;

    public Snake() {
        Random random = new Random();
        int y = random.nextInt(Constants.canvasSize / Constants.imageSize);
        body.add(new Position(5 * Constants.imageSize, y * Constants.imageSize));
    }

    public ArrayList<Position> getBody() {
        return body;
    }

    public void setDirection(Direction direction) {
        switch (direction) {
            case RIGHT:
                if (this.direction == Direction.LEFT) {
                    return;
                }
                break;
            case LEFT:
                if (this.direction == Direction.RIGHT) {
                    return;
                }
                break;
            case UP:
                if (this.direction == Direction.DOWN) {
                    return;
                }
                break;
            case DOWN:
                if (this.direction == Direction.UP) {
                    return;
                }
                break;
        }
        this.direction = direction;
    }


}
