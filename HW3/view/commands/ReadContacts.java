package HW3.view.commands;

import HW3.view.ConsoleUI;

public class ReadContacts extends Command{
    public ReadContacts(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать все контакты";
    }

    @Override
    public void execute() {
        consoleUI.read();
    }
}
