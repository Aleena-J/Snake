package snakeGame;

import javax.swing.*;
import java.awt.*;

public class WelcomeWindow {
    private int windowHeight;
    private int windowWidth;
    //Add leaderboard functionality and usernames later
    //String username;

    //Add ability to read from a config file later
    public WelcomeWindow(int windowHeight, int windowWidth){
        this.windowHeight = 600;
        this.windowWidth = 600;
    }

    public void display(){
        JFrame frame = new JFrame("Snake Game");
        JLabel gameTitle = new JLabel("SNAKE", SwingConstants.CENTER);
        gameTitle.setFont(new Font("Papyrus", Font.BOLD, 108));
        gameTitle.setForeground(Color.GREEN);

        frame.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(gameTitle, BorderLayout.CENTER);
        titlePanel.setPreferredSize(new Dimension(this.windowWidth, this.windowHeight/3));
        titlePanel.setBackground(Color.BLACK);

        frame.add(titlePanel, BorderLayout.NORTH);

        frame.setSize(this.windowWidth, this.windowHeight);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);

    }
}
