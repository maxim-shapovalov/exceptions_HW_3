package HW3.view.commands;

import HW3.view.ConsoleUI;
public class Finish extends Command{
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "��������� ������";
    }

    @Override
    public void execute() {
        consoleUI.finish();
    }
}
