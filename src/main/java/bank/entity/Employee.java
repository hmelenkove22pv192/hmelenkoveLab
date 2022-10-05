package bank.entity;

import java.util.Date;
import bank.utils.FullName;

public class Employee{
    private Bank bank;
    private BankOffice office;
    private Integer id;
    private FullName fullName;
    private Date birthDay;
    private String jobTitle;
    private String bankName;
    private Boolean isDistantWorker;
    private Integer officeId;
    private Boolean canGiveCredit;
    private Double salary;

    public Employee(Bank bank, BankOffice office,Integer id, FullName fullName, Date birthDay, String jobTitle,
                    Boolean isDistantWorker, Boolean canGiveCredit, Double salary) {
        this.setBank(bank);
        this.setOffice(office);
        this.setIdEmployee(id);
        this.setFullName(fullName);
        this.setBirthDay(birthDay);
        this.setJobTitle(jobTitle);
        this.setBankName();
        this.setIsDistantWorker(isDistantWorker);
        this.setOfficeId();
        this.setCanGiveCredit(canGiveCredit);
        this.setSalary(salary);
    }

    public void setOffice(BankOffice office) {
        this.office = office;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Integer getIdEmployee() {
        return id;
    }

    public void setIdEmployee(Integer id) {
        this.id = id;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
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

    public Boolean getIsDistantWorker() {
        return isDistantWorker;
    }

    public void setIsDistantWorker(Boolean isDistantWorker) {
        this.isDistantWorker = isDistantWorker;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId() {
        this.officeId = office.getId();
    }

    public Boolean getCanGiveCredit() {
        return canGiveCredit;
    }

    public void setCanGiveCredit(Boolean canGiveCredit) {
        this.canGiveCredit = canGiveCredit;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}