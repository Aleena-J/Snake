package snakeGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game extends JPanel implements KeyListener, ActionListener {
    final private int gameWidth = 600;
    final private int gameHeight = 600;
    final private int screenHeight = 700; //Add 100 pixels for score count at bottom
    final private int cellSize = 50; //Width/Length of each cell on board(grid)
    private boolean gameStarted;
    private int score;
    private Snake snake;
    private Apple apple;

    public Game(){
        this.gameStarted = false;
        display();
    }

    public void display(){
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setResizable(false);

        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(gameWidth, screenHeight));
        this.setFocusable(true);
        this.addKeyListener(this);

        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        startGame();
    }

    public void startGame(){
        this.gameStarted = true;
        this.score = 0;
        this.snake = new Snake(gameWidth, gameHeight, cellSize);
        this.apple = new Apple();
        apple.generate(gameWidth, gameHeight, cellSize);
    }

    public void draw(Graphics graphic){
        if(gameStarted){
            //Draw grid lines
            for(int i = 0; i <= gameWidth/cellSize; i++){
                //Horizontal
                graphic.drawLine(0, i*cellSize, gameWidth, i*cellSize);
                //Vertical
                graphic.drawLine(i*cellSize, 0, i*cellSize, gameHeight);
            }

            //Draw apple
            graphic.setColor(Color.RED);
            graphic.fillOval(apple.getAppleXCoord(), apple.getAppleYCoord(), cellSize, cellSize);

            //Draw snake
            for(int i = 0; i < snake.getNumParts(); i++){
                graphic.setColor(Color.GREEN);
                graphic.fillRect(snake.getX(i), snake.getY(i), cellSize, cellSize);
            }

            //Draw scoreboard
            graphic.setColor(Color.WHITE);
            graphic.setFont(new Font("Papyrus", Font.BOLD, 48));
            graphic.drawString("Score: " + score, 0, 675);

        }else{

        }

    }

    public void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
        draw(graphic);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if(snake.getDirection() != 'R') {
                    snake.setDirection('L');
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(snake.getDirection() != 'L') {
                    snake.setDirection('R');
                }
                break;
            case KeyEvent.VK_UP:
                if(snake.getDirection() != 'D') {
                    snake.setDirection('U');
                }
                break;
            case KeyEvent.VK_DOWN:
                if(snake.getDirection() != 'U') {
                    snake.setDirection('D');
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
