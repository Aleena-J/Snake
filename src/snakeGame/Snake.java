package snakeGame;

public class Snake {
    private int speed; //How fast movement occurs
    private char direction; //Movement direction
    private int numParts; //Number of body parts
    private int[] xParts; //X location of body parts
    private int[] yParts; //Y location of body parts

    public Snake(int gameWidth, int gameHeight, int cellSize){
        this.speed = 110;
        this.direction = 'R';
        this.numParts = 3;
        this.xParts = new int[(gameWidth*gameHeight) / (cellSize * cellSize)];
        this.yParts = new int[(gameWidth*gameHeight) / (cellSize * cellSize)];
        this.xParts[0] = ((gameWidth/cellSize) / 2) * cellSize;
        this.yParts[0] = ((gameHeight/cellSize) / 2) * cellSize;
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

    public int getSpeed(){
        return speed;
    }

    public void move(int cellSize){
        //Make body parts move into location of body part ahead of it
        for(int i = numParts - 1; i > 0; i--){
            xParts[i] = xParts[i - 1];
            yParts[i] = yParts[i - 1];
        }

        //Depending on direction key, make the snake head move by one grid unit
        if(direction == 'R'){
            xParts[0] = xParts[0] + cellSize;
        }
        else if(direction == 'L'){
            xParts[0] = xParts[0] - cellSize;
        }else if(direction == 'U'){
            yParts[0] = yParts[0] - cellSize;
        }else if(direction == 'D'){
            yParts[0] = yParts[0] + cellSize;
        }
    }

    public void addPart(){
        xParts[numParts] = xParts[numParts - 1];
        yParts[numParts] = yParts[numParts - 1];
        numParts++;
    }

    public void adjustSpeed(){
        if(speed > 40) {
            speed = speed - 5;
        }else{
            speed = 40;
        }
    }

}
