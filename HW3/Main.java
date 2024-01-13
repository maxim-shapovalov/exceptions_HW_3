package HW3;

import HW3.model.writer.FileHandler;
import HW3.view.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.setWritable(new FileHandler());
        consoleUI.start();
    }
}
