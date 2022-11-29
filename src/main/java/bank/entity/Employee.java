package bank.entity;

import java.util.Date;

public class Employee{
    private Bank bank;
    private BankOffice office;
    private Integer id;
    private String fullName;
    private Date birthDay;
    private String jobTitle;
    private String bankName;
    private boolean isDistantWorker;
    private boolean canGiveCredit;
    private Double salary;

    public Employee(Bank bank, BankOffice office,Integer id, String fullName, Date birthDay, String jobTitle,
                    boolean isDistantWorker, boolean canGiveCredit, Double salary) {
        this.setBank(bank);
        this.setOffice(office);
        this.setIdEmployee(id);
        this.setFullName(fullName);
        this.setBirthDay(birthDay);
        this.setJobTitle(jobTitle);
        this.setBankName();
        this.setIsDistantWorker(isDistantWorker);
        this.setCanGiveCredit(canGiveCredit);
        this.setSalary(salary);
    }

    public void setOffice(BankOffice office) {
        this.office = office;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Integer getBankId() {
        return bank.getId();
    }

    public Integer getIdEmployee() {
        return id;
    }

    public void setIdEmployee(Integer id) {
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName() {
        this.bankName = bank.getName();
    }

    public boolean getIsDistantWorker() {
        return isDistantWorker;
    }

    public void setIsDistantWorker(boolean isDistantWorker) {
        this.isDistantWorker = isDistantWorker;
    }

    public Integer getOfficeId() {
        return office.getId();
    }

    public boolean getCanGiveCredit() {
        return canGiveCredit;
    }

    public void setCanGiveCredit(boolean canGiveCredit) {
        this.canGiveCredit = canGiveCredit;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String toString(){
        return (
                    "fullName: " + getFullName() + "\n" +
                    "canGiveCredit: " + getCanGiveCredit() + "\n"
                );
    }
}