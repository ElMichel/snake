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

    private ArrayList<Snake> snakes = new ArrayList<>();
    private HitableObject apple = new HitableObject("assets/apple.png");
    private HitableObject spider = new HitableObject("assets/spider.png");

    public App() {
        snakes.add(new Snake());
        snakes.add(new Snake(KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_R));


        timer = new Timer(80, this);
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
    public void keyPressed(KeyEvent e) {
        for (Snake snake : snakes) {
            snake.changeDirection(e.getKeyCode());

            switch (e.getKeyCode()) {
                case KeyEvent.VK_N -> snake.grow();
                case KeyEvent.VK_1 -> timer.setDelay(80);
                case KeyEvent.VK_2 -> timer.setDelay(150);
                case KeyEvent.VK_3 -> timer.setDelay(300);
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_R) {
            snakes.add(new Snake());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(apple.getImage(), apple.getPosition().getX(), apple.getPosition().getY(), this);
        g.drawImage(spider.getImage(), spider.getPosition().getX(), spider.getPosition().getY(), this);

        int x = 18;
        for (Snake snake : snakes) {
            for (int i = 0; i < snake.getBody().size(); i++) {
                Position position = snake.getBody().get(i);
                ImageIcon imageIcon = null;
                if (i == 0) {
                    imageIcon = switch (snake.getDirection()) {
                        case RIGHT -> new ImageIcon("assets/snake_right.png");
                        case LEFT -> new ImageIcon("assets/snake_left.png");
                        case UP -> new ImageIcon("assets/snake_up.png");
                        case DOWN -> new ImageIcon("assets/snake_down.png");
                    };
                } else {
                    imageIcon = new ImageIcon("assets/square.png");
                }
                g.drawImage(imageIcon.getImage(), position.getX(), position.getY(), this);
            }
            g.setColor(Color.WHITE);
            g.drawString(snake.getSnakeSize() + "", x, 18);
            x += 18;
        }
    }


    private void checkHitable() {
        for (Snake snake : snakes) {
            if (snake.getHeadPosition().equals(apple.getPosition())) {
                snake.grow();
                apple.move();
            }
            if (snake.getHeadPosition().equals(spider.getPosition())) {
                snake.shrink();
                spider.move();
            }

        }
    }

    private void checkCollision() {
        for (int s1 = 0; s1 < snakes.size(); s1++) {
            Snake snake1 = snakes.get(s1);
            Position head1 = snake1.getHeadPosition();
            if (head1.getX() < 0 || head1.getX() > Constants.canvasSize || head1.getY() < 0 || head1.getY() > Constants.canvasSize) {
                snakes.remove(snake1);
                continue;
            }
            for (int s2 = 0; s2 < snakes.size(); s2++) {
                Snake snake2 = snakes.get(s2);
                if (s1 != s2) {
                    for (Position p : snake2.getBody()) {
                        if (head1.equals(p)) {
                            snakes.remove(snake1);
                        }
                    }
                } else {
                    for (int b = 1; b < snake1.getBody().size(); b++) {
                        Position position = snake1.getBody().get(b);
                        if (head1.equals(position)) {
                            snakes.remove(snake1);
                        }
                    }
                }


            }


        }
    }

    //vykonava sa pravidelne kazdych X ms
    @Override
    public void actionPerformed(ActionEvent e) {
        for (Snake snake : snakes) {
            snake.move();
        }
        checkHitable();
        checkCollision();
        repaint();
    }
}
