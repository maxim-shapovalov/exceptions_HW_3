package HW3.model.writer;

import HW3.model.Contact;
import java.io.IOException;

public interface Writable {
    void save(Contact contact) throws IOException, MyException;
    void read(String fileName) throws MyException;
}
