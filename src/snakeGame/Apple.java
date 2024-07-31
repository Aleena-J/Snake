package snakeGame;

import java.util.Random;

public class Apple {
    private int appleXCoord;
    private int appleYCoord;
    Random random;
    public Apple(){
        random = new Random();
    }

    public void generate(int screenWidth, int screenHeight, int cellSize){
        appleXCoord = random.nextInt((int)(screenWidth/cellSize)) * cellSize;
        appleYCoord = random.nextInt((int)(screenHeight/cellSize)) * cellSize;
    }

    public int getAppleXCoord(){
        return appleXCoord;
    }

    public int getAppleYCoord(){
        return appleYCoord;
    }

}
