package HW3.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Contact implements Serializable{
    private String lastName;
    private String name;
    private String middleName;
    private LocalDate birthDate;
    private long phoneNumber;
    private String gender;

    public Contact (String lastName, String name, String middleName, LocalDate birthDate, long phoneNumber, String gender){
        this.lastName = lastName;
        this.name =  name;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
    public String getLastName(){
        return this.lastName;
    }

    public String getInfo(){
        StringBuilder info = new StringBuilder();
        info.append("ФИО: ");
        info.append(lastName);
        info.append(" ");
        info.append(name);
        info.append(" ");
        info.append(middleName);
        info.append(", дата рождения: ");
        info.append(birthDate);
        info.append(", номер телефона: ");
        info.append(phoneNumber);
        info.append(", пол: ");
        info.append(gender);
        return info.toString();
    }
    @Override
    public String toString(){
        return getInfo();
    }
}
