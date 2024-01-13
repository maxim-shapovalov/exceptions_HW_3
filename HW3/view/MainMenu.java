package HW3.view;

import HW3.view.commands.*;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddContact(consoleUI));
        commandList.add(new ReadContacts(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String getMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Выберите действие :\n");
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }
    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }
    public int getSize(){
        return commandList.size();
    }
}
