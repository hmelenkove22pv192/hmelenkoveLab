package bank.utils;

public class FullName {
    String name;
    String surname;
    String middleName = null;

    public FullName(String name, String surname, String middleName) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
    }

    public FullName(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
