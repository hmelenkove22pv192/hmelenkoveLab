package bank.entity;

import bank.utils.*;

public class BankOffice {
    private Integer id;
    private Integer bankId;
    private String name;
    private String address;
    private Status status;
    private boolean canSetATM;
    private Integer countATM;
    private boolean canTakeCredit;
    private boolean canGiveMoney;
    private boolean canDepositMoney;
    private Double money;
    private Double cost;

    public BankOffice(Integer id, Integer bankId, String name, String address, Status status,
                      boolean canSetATM, boolean canTakeCredit, boolean canGiveMoney,
                      boolean canDepositMoney, Double money, Double cost) {
        this.setId(id);
        this.setBankId(bankId);
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

    public boolean getCanSetATM() {
        return canSetATM;
    }

    public void setCanSetATM(boolean canSetATM) {
        this.canSetATM = canSetATM;
    }

    public Integer getCountATM() {
        return countATM;
    }

    public void setCountATM(Integer countATM) {
        this.countATM = countATM;
    }

    public boolean getCanTakeCredit() {
        return canTakeCredit;
    }

    public void setCanTakeCredit(boolean canTakeCredit) {
        this.canTakeCredit = canTakeCredit;
    }

    public boolean getCanGiveMoney() {
        return canGiveMoney;
    }

    public void setCanGiveMoney(boolean canGiveMoney) {
        this.canGiveMoney = canGiveMoney;
    }

    public boolean getCanDepositMoney() {
        return canDepositMoney;
    }

    public void setCanDepositMoney(boolean canDepositMoney) {
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

    public void setBankId(Integer bankId) { this.bankId = bankId; }
    public Integer getBankId() {
        return bankId;
    }

    public String toString(){
        return (
                    "name: " + getName() + "\n" +
                    "address: " + getAddress() + "\n" +
                    "status: " + getStatus() + "\n" +
                    "canTakeCredit: " + getCanTakeCredit() + "\n"
                );
    }
}