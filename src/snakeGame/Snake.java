package snakeGame;

public class Snake {
    private int speed; //How fast movement occurs
    private char direction; //Movement direction
    private int numParts; //Number of body parts
    private int[] xParts; //X location of body parts
    private int[] yParts; //Y location of body parts

    public Snake(int gameWidth, int gameHeight, int cellSize){
        this.speed = 25;
        this.direction = 'R';
        this.numParts = 3;
        this.xParts = new int[(gameWidth*gameHeight) / (cellSize * cellSize)];
        this.yParts = new int[(gameWidth*gameHeight) / (cellSize * cellSize)];
    }

    public char getDirection(){
        return direction;
    }

    public void setDirection(char direction){
        this.direction = direction;
    }

    public int getNumParts() {
        return numParts;
    }

    public int getX(int i){
        return xParts[i];
    }

    public int getY(int i){
        return yParts[i];
    }

}
