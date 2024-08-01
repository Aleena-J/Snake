package snakeGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WelcomeWindow implements ActionListener, WindowListener {
    final private int windowHeight;
    final private int windowWidth;
    private volatile int chosenOption;

    //Add ability to read from a config file later
    public WelcomeWindow(){
        this.windowHeight = 700;
        this.windowWidth = 700;
        //Allows for control of window
        //3 -- Welcome window remains open
        //2 -- Welcome window closes, game starts
        //1 -- Exit program
        this.chosenOption = 3;
    }

    public void display() throws IOException {
        //Create window for the game
        JFrame frame = new JFrame("Snake Game");
        frame.setLayout(new BorderLayout());
        frame.addWindowListener(this);

        //Create label for the game's title
        JLabel gameTitle = new JLabel("SNAKE", SwingConstants.CENTER);
        gameTitle.setFont(new Font("Papyrus", Font.BOLD, 108));
        gameTitle.setForeground(Color.GREEN);
        gameTitle.setPreferredSize(new Dimension(windowWidth, windowHeight / 3));
        gameTitle.setBackground(Color.BLACK);
        gameTitle.setOpaque(true);

        //Add game title to the window
        frame.add(gameTitle, BorderLayout.NORTH);

        //Create panel for the start button to be centered
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.BLACK);

        //Create start button
        JButton startGame = new JButton("Start Game");
        startGame.setFont(new Font("Papyrus", Font.BOLD, 48));
        startGame.setForeground(Color.GREEN);
        startGame.setBackground(Color.BLACK);
        startGame.setFocusPainted(false);
        //Add event to make button open game window if pressed, as well as close the welcome window
        startGame.addActionListener(this);

        // Use GridBagConstraints to add the button without it expanding
        centerPanel.add(startGame, new GridBagConstraints());
        frame.add(centerPanel, BorderLayout.CENTER);

        //Create label with image of snake
        BufferedImage snakePic = ImageIO.read(new File("images/snakePic.png"));
        JLabel picLabel = new JLabel(new ImageIcon(snakePic));
        picLabel.setHorizontalAlignment(SwingConstants.CENTER);
        picLabel.setPreferredSize(new Dimension(windowWidth, windowHeight / 3));

        frame.add(picLabel, BorderLayout.SOUTH);

        //Make window visible
        frame.setSize(windowWidth, windowHeight);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setResizable(false);
        frame.setVisible(true);

        //Wait for user to either close the window or start game
        while(chosenOption == 3){
        }

        //Closes welcome window if user chooses to start game
        if(chosenOption == 2){
            frame.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.chosenOption = 2;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.chosenOption = 3;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.chosenOption = 1;
    }

    @Override
    public void windowClosed(WindowEvent e) {
        this.chosenOption = 1;
    }

    @Override
    public void windowIconified(WindowEvent e) {
        this.chosenOption = 3;
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        this.chosenOption = 3;
    }

    @Override
    public void windowActivated(WindowEvent e) {
        this.chosenOption = 3;
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        this.chosenOption = 1;
    }

    public int getChosenOption() {
        return chosenOption;
    }
}
