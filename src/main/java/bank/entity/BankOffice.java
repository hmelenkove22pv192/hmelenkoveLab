package bank.entity;

import bank.utils.*;

public class BankOffice {
    private Integer id;
    private String name;
    private String address;
    private Status status;
    private Boolean canSetATM;
    private Integer countATM;
    private Boolean canTakeCredit;
    private Boolean canGiveMoney;
    private Boolean canDepositMoney;
    private Double money;
    private Double cost;

    public BankOffice(Integer id, String name, String address, Status status,
                      Boolean canSetATM, Boolean canTakeCredit, Boolean canGiveMoney,
                      Boolean canDepositMoney, Double money, Double cost) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setStatus(status);
        this.setCanSetATM(canSetATM);
        this.setCountATM(0);
        this.setCanTakeCredit(canTakeCredit);
        this.setCanGiveMoney(canGiveMoney);
        this.setCanDepositMoney(canDepositMoney);
        this.setMoney(money);
        this.setCost(cost);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idBank) {
        this.id = idBank;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameBank) {
        this.name = nameBank;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getCanSetATM() {
        return canSetATM;
    }

    public void setCanSetATM(Boolean canSetATM) {
        this.canSetATM = canSetATM;
    }

    public Integer getCountATM() {
        return countATM;
    }

    public void setCountATM(Integer countATM) {
        this.countATM = countATM;
    }

    public Boolean getCanTakeCredit() {
        return canTakeCredit;
    }

    public void setCanTakeCredit(Boolean canTakeCredit) {
        this.canTakeCredit = canTakeCredit;
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
                    "countATM: " + getCountATM() + "\n" +
                    "status: " + getStatus() + "\n" +
                    "canSetATM: " + getCanSetATM() + "\n" +
                    "canTakeCredit: " + getCanTakeCredit() + "\n" +
                    "canGiveMoney: " + getCanGiveMoney() + "\n" +
                    "canDepositMoney: " + getCanDepositMoney() + "\n" +
                    "money: " + getMoney() + "\n" +
                    "cost: " + getCost()
                );
    }
}