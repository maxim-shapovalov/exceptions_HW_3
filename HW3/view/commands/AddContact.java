package HW3.view.commands;

import HW3.view.ConsoleUI;

public class AddContact extends Command{
    public AddContact(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "�������� �������";
    }

    @Override
    public void execute() {
        consoleUI.addContact();
    }
}
