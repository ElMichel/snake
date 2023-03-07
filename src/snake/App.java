package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class App extends JPanel implements KeyListener, ActionListener {


    private final Timer timer;
    private boolean life = true;
    private ArrayList<Snake> snakes = new ArrayList<>();
    private Apple apple = new Apple();

    public App() {
        timer = new Timer(220, this);
        timer.start();
        snakes.add(new Snake());

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
        for (int i = 0; i < snakes.size(); i++) {
            if (direct.getKeyCode() == KeyEvent.VK_RIGHT || direct.getKeyCode() == KeyEvent.VK_D) {
                snakes.get(i).setDirection(Direction.RIGHT);
            } else if (direct.getKeyCode() == KeyEvent.VK_LEFT || direct.getKeyCode() == KeyEvent.VK_A) {
                snakes.get(i).setDirection(Direction.LEFT);
            } else if (direct.getKeyCode() == KeyEvent.VK_UP || direct.getKeyCode() == KeyEvent.VK_W) {
                snakes.get(i).setDirection(Direction.UP);
            } else if (direct.getKeyCode() == KeyEvent.VK_DOWN || direct.getKeyCode() == KeyEvent.VK_S) {
                snakes.get(i).setDirection(Direction.DOWN);
            }

            if (direct.getKeyCode() == KeyEvent.VK_N) {
                snakes.get(i).grow();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(apple.getImage(), apple.getPosition().getX(), apple.getPosition().getY(), this);
        for (int i = 0; i < snakes.size(); i++) {
            for (int j = 0; j < snakes.get(i).getBody().size(); j++) {
                Position position = snakes.get(i).getBody().get(j);
                ImageIcon imageIcon = null;
                if (j == 0) {
                    switch (snakes.get(i).getDirection()) {
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
    }

    private void checkCollision() {
        for (int i = 0; i < snakes.size(); i++) {
            if (snakes.get(i).getHeadPosition().getX() < 0 ) {
                snakes.get(i).getBody().clear();
            } else if (snakes.get(i).getHeadPosition().getX() > Constants.canvasSize ) {
                snakes.get(i).getBody().clear();
            } else if (snakes.get(i).getHeadPosition().getY() < 0 ) {
                snakes.get(i).getBody().clear();
            } else if (snakes.get(i).getHeadPosition().getY() > Constants.canvasSize ) {
                snakes.get(i).getBody().clear();
            }
        }
    }

    private void checkApple() {
        for (int i = 0; i < snakes.size(); i++) {
            if (snakes.get(i).getHeadPosition().equals(apple.getPosition())) {
                apple.move();
                snakes.get(i).grow();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for (int i = 0; i < snakes.size(); i++) {
            snakes.get(i).move();
            checkApple();
            checkCollision();
            repaint();
        }
    }


}
