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
        timer = new Timer(1200, this);
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

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < snake.getBody().size(); i++) {
            Position position = snake.getBody().get(i);
            ImageIcon imageIcon = new ImageIcon("assets/square.png");
            g.drawImage(imageIcon.getImage(), position.getX(), position.getY(), this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
