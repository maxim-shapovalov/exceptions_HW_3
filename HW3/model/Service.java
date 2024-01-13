package HW3.model;

import HW3.model.writer.MyException;
import HW3.model.writer.Writable;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    List<String> personalInfo;
    Writable writable;

    public Service() {
        personalInfo = new ArrayList<>();
    }

    public String addContact(String text) throws MyException {
        setPersonalInfo(text);
        return save(createContact());
    }
    public void setWritable(Writable writable) {
        this.writable = writable;
    }
    public String save(Contact contact){
        try {
            writable.save(contact);
        } catch (MyException | IOException e) {
            System.out.println(e.getMessage());
        }
        return contact.getInfo();
    }
    public void read() throws MyException {
        File folder = new File("src/HW3/model/writer/contacts/");
        File [] listOfFiles = folder.listFiles();
        assert listOfFiles != null;
        if (listOfFiles.length != 0) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    try {
                        writable.read(file.getName());
                    } catch (MyException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        } else {
            throw new MyException("Контакты отсутствуют");
        }
    }

    public void setPersonalInfo(String text) throws MyException {
        String[] personalInfo = text.split(" ");
        if(checkLengthExceptions(checkInputLength(personalInfo))){
            this.personalInfo = new ArrayList<>(List.of(personalInfo));
        } else {
            throw new MyException("Повторите ввод");
        }
    }
    public Contact createContact() throws MyException {
        String lastName;
        String name;
        String middleName;
        LocalDate birthDate = getDate();
        long phoneNumber = getPhoneNumber();
        String gender = getGender();
        if(personalInfo.size() == 3) {
            lastName = getName("Фамилия");
            name = getName("Имя");
            middleName = getName("Отчество");
        } else {
            throw new MyException ("Данные введены некорретно");
        }
        return new Contact(lastName, name, middleName, birthDate, phoneNumber, gender);
    }
    public int checkInputLength (String[]personalInfo){
        return Integer.compare(personalInfo.length, 6);
    }
    public boolean checkLengthExceptions(int code){
        if (code == -1) {
            System.out.println("Вы ввели недостаточно информации.");
            return false;
        } else if (code == 1) {
            System.out.println("Вы ввели слишком много информации.");
            return false;
        } else {
            return true;
        }
    }
    public LocalDate getDate() throws MyException {
        LocalDate date = null;
        String str;
        for (int i = 0; i < personalInfo.size(); i++) {
            if (personalInfo.get(i).matches("[0-9]*\\.+[0-9]*\\.+[0-9]+")) {
                str = personalInfo.remove(i).replace(".", "-");
                try {
                    date = LocalDate.parse(str);
                } catch (Exception e) {
                    throw new MyException("Вы ввели некорректную дату. Формат ввода должен быть YYYY.MM.DD");
                }
            }
        }
        return date;
    }
    public long getPhoneNumber(){
        long phoneNumber = 0;
        for (int i = 0; i < personalInfo.size(); i++) {
            if (personalInfo.get(i).matches("[0-9]+")) {
                phoneNumber = Long.parseLong(personalInfo.remove(i));
            }
        }
        return phoneNumber;
    }
    public String getGender() throws MyException {
        String gender = null;
        for (int i = 0; i < personalInfo.size(); i++) {
            if(personalInfo.get(i).length() == 1) {
                if (personalInfo.get(i).equals("m") | personalInfo.get(i).equals("f")) {
                    gender = personalInfo.remove(i);
                } else {
                    throw new MyException("Пол введен некорректно");
                }
            }
        }
        return gender;
    }
    public boolean checkIfText(String text){
        return text.matches("\\D+");
    }
    public String getName(String comment){
        String name;
        if(checkIfText(personalInfo.get(0))) {
            name = personalInfo.remove(0);
        } else {
            throw new RuntimeException(comment+" - ошибка ввода");
        }
        return name;
    }
}
