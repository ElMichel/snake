package snake;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Apple {

    private Position position;
    private final Image image;
    private static final Random random = new Random();


    public Apple() {
        ImageIcon imageIcon = new ImageIcon("assets/apple.png");
        this.image = imageIcon.getImage();
    }

    public void move() {
        int x = random.nextInt(Constants.blockCount);
        int y = random.nextInt(Constants.blockCount);
        position = new Position(x * Constants.imageSize, y * Constants.imageSize);
    }

    public Position getPosition() {
        return position;
    }

    public Image getImage() {
        return image;
    }
}
