package snakeGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game extends JPanel implements KeyListener, ActionListener {
    final private int gameWidth = 700;
    final private int gameHeight = 700;
    final private int screenHeight = 800; //Add 100 pixels for score count at bottom
    final private int cellSize = 35; //Width/Length of each cell on board(grid)
    private boolean gameStarted;
    private int score;
    private Snake snake;
    private Apple apple;
    private JFrame frame;
    private Timer timer;
    private boolean directionChanged;

    public Game(){
        this.gameStarted = false;
        display();
    }

    public void display(){
        frame = new JFrame("Snake Game");
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
        this.score = 0;
        this.snake = new Snake(gameWidth, gameHeight, cellSize);
        this.apple = new Apple();
        gameStarted = true;
        apple.generate(gameWidth, gameHeight, cellSize); //Generate apple location
        timer = new Timer(snake.getSpeed(), this);
        timer.start();
        directionChanged = false;
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

            //Draw snake
            for(int i = 0; i < snake.getNumParts(); i++){
                if(i == 0){
                    graphic.setColor(new Color(18, 165, 43));
                    graphic.fillRect(snake.getX(i), snake.getY(i), cellSize, cellSize);
                }else if(i % 2 == 0) {
                    graphic.setColor(Color.GREEN);
                    graphic.fillRect(snake.getX(i), snake.getY(i), cellSize, cellSize);
                }else{
                    graphic.setColor(Color.BLUE);
                    graphic.fillRect(snake.getX(i), snake.getY(i), cellSize, cellSize);
                }
            }

            //Draw apple
            graphic.setColor(Color.RED);
            graphic.fillOval(apple.getAppleXCoord(), apple.getAppleYCoord(), cellSize, cellSize);

            //Draw scoreboard
            graphic.setColor(Color.WHITE);
            graphic.setFont(new Font("Papyrus", Font.BOLD, 48));
            graphic.drawString("Score: " + score, gameWidth/3, gameHeight + 75);

        }else{
            timer.stop();
            frame.dispose();
        }

    }



    public void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
        draw(graphic);
    }

    public boolean checkCollision(){
        //Check if snake head collides with rest of body
        for(int i = 1; i < snake.getNumParts(); i++){
            if((snake.getX(i) == snake.getX(0)) && (snake.getY(i) == snake.getY(0))){
                return true;
            }
        }

        //Check if snake head collides with screen borders
        if(snake.getY(0) < 0 || snake.getY(0) >= gameHeight){
            return true;
        }

        if(snake.getX(0) < 0 || snake.getX(0) >= gameWidth){
            return true;
        }

        return false;
    }

    public boolean checkAppleCollision(){
        if(snake.getX(0) == apple.getAppleXCoord() && snake.getY(0) == apple.getAppleYCoord()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        directionChanged = false;
        //Move the snake
        snake.move(cellSize);
        //Check for an apple
        if(checkAppleCollision()){
            apple.generate(gameWidth, gameHeight, cellSize);
            score++;
            snake.addPart();
            //Every 5 apple, make the snake go faster
            if(score % 5 == 0) {
                snake.adjustSpeed();
            }
            timer.setDelay(snake.getSpeed());
        }
        //Check for collision
        if(checkCollision()){
            gameStarted = false;
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(!directionChanged) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (snake.getDirection() != 'R') {
                        snake.setDirection('L');
                        directionChanged = true;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (snake.getDirection() != 'L') {
                        snake.setDirection('R');
                        directionChanged = true;
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (snake.getDirection() != 'D') {
                        snake.setDirection('U');
                        directionChanged = true;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (snake.getDirection() != 'U') {
                        snake.setDirection('D');
                        directionChanged = true;
                    }
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
