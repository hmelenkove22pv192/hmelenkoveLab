package bank.entity;

import java.util.Date;
import java.util.Random;

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
        Random random = new Random();
        this.setMonthSalary(random.nextDouble(1, 10000));
        int creditRating = 0;
        Integer min = 0;
        Integer max = 1000;
        while ((min != 10000) && (creditRating == 0)) {
            if ((getMonthSalary() <= max) && (getMonthSalary() >= min))
                creditRating = max / 10;
            else {
                min += 1000;
                max += 1000;
            }
        }
        this.setCreditRating(creditRating);
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