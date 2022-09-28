package bank.entity;

import java.util.Date;
import bank.entity.additionalClasses.FullName;

public class Employee extends BankOffice{
    private Integer id;
    private FullName fullName;
    private Date birthDay;
    private String jobTitle;
    private Boolean isDistantWorker;
    private Boolean canGiveCredit;
    private Double salary;

    public Employee(BankOffice officeInstance, Integer id, FullName fullName, Date birthDay, String jobTitle,
                    Boolean isDistantWorker, Boolean canGiveCredit, Double salary) {
        super(officeInstance);
        this.setIdEmployee(id);
        this.setFullName(fullName);
        this.setBirthDay(birthDay);
        this.setJobTitle(jobTitle);
        this.setIsDistantWorker(isDistantWorker);
        this.setCanGiveCredit(canGiveCredit);
        this.setSalary(salary);
    }

    public Employee(Employee employeeInstance) {
        super(employeeInstance);
        this.setIdEmployee(employeeInstance.getIdEmployee());
        this.setFullName(employeeInstance.getFullName());
        this.setBirthDay(employeeInstance.getBirthDay());
        this.setJobTitle(employeeInstance.getJobTitle());
        this.setIsDistantWorker(employeeInstance.getIsDistantWorker());
        this.setCanGiveCredit(employeeInstance.getCanGiveCredit());
        this.setSalary(employeeInstance.getSalary());
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

    public Boolean getIsDistantWorker() {
        return isDistantWorker;
    }

    public void setIsDistantWorker(Boolean isDistantWorker) {
        this.isDistantWorker = isDistantWorker;
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