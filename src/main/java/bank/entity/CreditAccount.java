package bank.entity;

import java.util.Date;

public class CreditAccount extends Bank {
    private Integer id;
    private Date startDate;
    private Date endDate;
    private Integer countMonth;
    private Double creditSum;
    private Integer employeeId;

    public CreditAccount(Bank bankInstance, Integer id, Date startDate, Date endDate, Integer countMonth,
                         Double creditSum, Integer employeeId) {
        super(bankInstance);
        this.setId(id);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setCountMonth(countMonth);
        this.setCreditSum(creditSum);
        this.setEmployeeId(employeeId);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getCountMonth() {
        return countMonth;
    }

    public void setCountMonth(Integer countMonth) {
        this.countMonth = countMonth;
    }

    public Double getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(Double creditSum) {
        this.creditSum = creditSum;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}