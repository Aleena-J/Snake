import snakeGame.WelcomeWindow;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        WelcomeWindow welcomeWindow = new WelcomeWindow();
        welcomeWindow.display();
    }
}