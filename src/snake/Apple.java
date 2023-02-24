package snake;

import java.util.ArrayList;
import java.util.Random;

public class Apple {

    private ArrayList<Position> apples = new ArrayList<>();

    public void addApple () {
        Random random = new Random();
        int y = random.nextInt(Constants.canvasSize / Constants.imageSize);
        int x = random.nextInt(Constants.canvasSize / Constants.imageSize);
        apples.add(new Position(x * Constants.imageSize, y * Constants.imageSize));
    }


}
