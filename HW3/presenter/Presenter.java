package HW3.presenter;

import HW3.model.Service;
import HW3.model.writer.MyException;
import HW3.model.writer.Writable;
import HW3.view.View;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void setWritable(Writable writable) {
        service.setWritable(writable);
    }
    public void addContact(String text){
        String line;
        try {
            line = service.addContact(text);
        } catch (MyException e) {
            throw new RuntimeException(e.getMessage());
        }
        view.answer("Успешно!\n");
        view.answer(line);
    }
    public void read(){
        try {
            service.read();
        } catch (MyException e){
            System.out.println(e.getMessage());
        }
    }
}
