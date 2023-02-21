package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class App extends JPanel implements KeyListener, ActionListener {


    private final Timer timer;
    private Snake snake = new Snake();

    public App() {
        timer = new Timer(120, this);
        timer.start();

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(Constants.canvasSize, Constants.canvasSize));
    }

    private void init() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent direct) {
        if (direct.getKeyCode() == KeyEvent.VK_RIGHT){
            snake.setDirection(Direction.RIGHT);
        } else if (direct.getKeyCode() == KeyEvent.VK_LEFT){
            snake.setDirection(Direction.LEFT);
        }else if (direct.getKeyCode() == KeyEvent.VK_UP){
            snake.setDirection(Direction.UP);
        }else if (direct.getKeyCode() == KeyEvent.VK_DOWN){
            snake.setDirection(Direction.DOWN);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < snake.getBody().size(); i++) {
            Position position = snake.getBody().get(i);
            ImageIcon imageIcon = null;
            if (i == 0) {
                switch (snake.getDirection()) {
                    case RIGHT -> imageIcon = new ImageIcon("assets/snake_right.png");
                    case LEFT -> imageIcon = new ImageIcon("assets/snake_left.png");
                    case UP -> imageIcon = new ImageIcon("assets/snake_up.png");
                    case DOWN -> imageIcon = new ImageIcon("assets/snake_down.png");
                }
            } else {
                imageIcon = new ImageIcon("assets/square.png");
            }
            g.drawImage(imageIcon.getImage(), position.getX(), position.getY(), this);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        repaint();
    }
}
