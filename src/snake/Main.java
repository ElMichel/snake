package snake;

import javax.swing.*;

public class Main {

    // https://files.fm/u/uke9g3bre

    public static void main(String[] args) {
        App app = new App();

        JFrame jFrame = new JFrame();
        jFrame.add(app);
        jFrame.addKeyListener(app);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.pack();
    }

}
