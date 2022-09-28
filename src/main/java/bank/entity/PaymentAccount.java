package bank.entity;

public class PaymentAccount extends Bank {
    private Integer id;
    private Double money;

    private Integer userId;

    public PaymentAccount(Bank bankInstance, Integer id, Integer userId) {
        super(bankInstance);
        this.setIdPayAcc(id);
        this.setUserIdPayAcc(userId);
        this.setMoney(0.0);
    }

    public PaymentAccount(PaymentAccount payAccInstance) {
        super(payAccInstance);
        this.setIdPayAcc(payAccInstance.getIdPayAcc());
        this.setUserIdPayAcc(payAccInstance.getUserIdPayAcc());
        this.setMoney(payAccInstance.getMoney());
    }

    public Integer getIdPayAcc() {
        return id;
    }

    public void setIdPayAcc(Integer id) {
        this.id = id;
    }

    public Integer getUserIdPayAcc() {
        return userId;
    }

    public void setUserIdPayAcc(Integer userId) {
        this.userId = userId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}