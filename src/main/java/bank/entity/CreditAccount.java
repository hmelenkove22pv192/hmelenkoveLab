package bank.entity;

import bank.utils.FullName;

import java.util.Date;

public class CreditAccount {
    private User user;
    private Bank bank;
    private Employee employee;
    private PaymentAccount paymentAccount;
    private Integer id;
    private FullName userName;
    private String bankName;
    private Date startDate;
    private Date endDate;
    private Integer countMonth;
    private Double creditSum;
    private Double interestRate;
    private Double monthPay;
    private FullName employeeName;
    private Integer paymentAccountId;

    public CreditAccount(Bank bank, User user, Employee employee, PaymentAccount paymentAccount,
                         Integer id, Date startDate, Date endDate, Integer countMonth,
                         Double creditSum, Double monthPay) {
        setBank(bank);
        setUser(user);
        setEmployee(employee);
        setPaymentAccount(paymentAccount);
        setId(id);
        setUserName();
        setBankName();
        setStartDate(startDate);
        setEndDate(endDate);
        setCountMonth(countMonth);
        setCreditSum(creditSum);
        setInterestRate();
        setMonthPay(monthPay);
        setEmployeeName();
        setPaymentAccountId();
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FullName getUserName() {
        return userName;
    }

    public void setUserName() {
        this.userName = user.getFullName();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName() {
        this.bankName = bank.getName();
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

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate() {
        this.interestRate = bank.getInterestRate();
    }

    public Double getMonthPay() {
        return monthPay;
    }

    public void setMonthPay(Double monthPay) {
        this.monthPay = monthPay;
    }

    public FullName getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName() {
        this.employeeName = employee.getFullName();
    }

    public Integer getPaymentAccountId() {
        return paymentAccountId;
    }

    public void setPaymentAccountId() {
        this.paymentAccountId = paymentAccount.getIdPayAcc();
    }
}