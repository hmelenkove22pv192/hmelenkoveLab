package bank.entity;

import bank.utils.Status;

public class BankATM {
    private BankOffice office;
    private Integer id;
    private String name;
    private Status status;
    private String address;
    private Integer employeeId;
    private Boolean canGiveMoney;
    private Boolean canDepositMoney;
    private Double money;
    private Double cost;

    public BankATM(BankOffice office, Integer id, String name, Status status, Integer employeeId,
                   Boolean canGiveMoney, Boolean canDepositMoney, Double money, Double cost) {
        setOffice(office);
        setId(id);
        setName(name);
        setStatus(status);
        setAddress();
        setEmployeeId(employeeId);
        setCanGiveMoney(canGiveMoney);
        setCanDepositMoney(canDepositMoney);
        setMoney(money);
        setCost(cost);
    }

    public void setOffice(BankOffice office) {
        this.office = office;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status statusATM) {
        this.status = statusATM;
    }

    public String getAddress() { return address; }

    public void setAddress() {
        this.address = office.getAddress();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Boolean getCanGiveMoney() {
        return canGiveMoney;
    }

    public void setCanGiveMoney(Boolean canGiveMoney) {
        this.canGiveMoney = canGiveMoney;
    }

    public Boolean getCanDepositMoney() {
        return canDepositMoney;
    }

    public void setCanDepositMoney(Boolean canDepositMoney) {
        this.canDepositMoney = canDepositMoney;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String toString(){
       return (
                   "id: " + getId() + "\n" +
                   "name: " + getName() + "\n" +
                   "address: " + getAddress() + "\n" +
                   "status: " + getStatus() + "\n" +
                   "employeeId: " + getEmployeeId() + "\n" +
                   "canGiveMoney: " + getCanGiveMoney() + "\n" +
                   "canDepositMoney: " + getCanDepositMoney() + "\n" +
                   "money: " + getMoney() + "\n" +
                   "cost: " + getCost()
               );
    }
}