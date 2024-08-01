package snakeGame;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        WelcomeWindow welcomeWindow = new WelcomeWindow();
        welcomeWindow.display();

        //Starts game only if user presses button
        if(welcomeWindow.getChosenOption() == 2){
            Game snakeGame = new Game();
        }
    }
}