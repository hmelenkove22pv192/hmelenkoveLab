package bank.entity;

import java.util.Date;
import java.util.Random;

import static bank.utils.UtilsFunctions.rnd;

public class User{
    private Integer id;
    private String fullName;
    private Date birthDay;
    private String workPlace;
    private Double monthSalary;
    private Integer creditRating;

    public User(Integer id, String fullName, Date birthDay, String workPlace) {
        this.setIdUser(id);
        this.setFullName(fullName);
        this.setBirthDay(birthDay);
        this.setWorkPlace(workPlace);
        this.setMonthSalary((double)rnd(30000, 100000));
        this.setCreditRating(rnd(1000, 10000));
    }

    public Integer getIdUser() {
        return id;
    }

    public void setIdUser(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public Double getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(Double monthSalary) {
        this.monthSalary = monthSalary;
    }

    public Integer getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(Integer creditRating) {
        this.creditRating = creditRating;
    }

    public String toString(){
        return (
            "id: " + getIdUser() + "\n" +
            "fullName: " + getFullName() + "\n" +
            "birthDay: " + getBirthDay() + "\n" +
            "workPlace: " + getWorkPlace() + "\n" +
            "monthSalary: " + getMonthSalary() + "\n" +
            "creditRating: " + getCreditRating()
        );
    }
}