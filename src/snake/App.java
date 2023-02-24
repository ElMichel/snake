package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class App extends JPanel implements KeyListener, ActionListener {


    private final Timer timer;
    private boolean life = true;
    private Snake snake = new Snake();
    private Apple apple = new Apple();

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
        if (direct.getKeyCode() == KeyEvent.VK_RIGHT || direct.getKeyCode() == KeyEvent.VK_D){
            snake.setDirection(Direction.RIGHT);
        } else if (direct.getKeyCode() == KeyEvent.VK_LEFT || direct.getKeyCode() == KeyEvent.VK_A){
            snake.setDirection(Direction.LEFT);
        }else if (direct.getKeyCode() == KeyEvent.VK_UP || direct.getKeyCode() == KeyEvent.VK_W){
            snake.setDirection(Direction.UP);
        }else if (direct.getKeyCode() == KeyEvent.VK_DOWN || direct.getKeyCode() == KeyEvent.VK_S){
            snake.setDirection(Direction.DOWN);
        }

        if (direct.getKeyCode() == KeyEvent.VK_N) {
            snake.grow();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(apple.getImage(), apple.getPosition().getX(), apple.getPosition().getY(), this);
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
        if (snake.getBody().get(0).equals(apple.getPosition())) {
            snake.grow();
            apple.move();
        }
        repaint();
    }
}
