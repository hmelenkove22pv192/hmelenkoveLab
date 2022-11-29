package bank.entity;

public class PaymentAccount{
    private User user;
    private Bank bank;
    private Integer id;
    private String userName;
    private String bankName;
    private Double money;

    public PaymentAccount(Bank bank, User user, Integer id) {
        this.setUser(user);
        this.setBank(bank);
        this.setIdPayAcc(id);
        this.setUserName();
        this.setBankName();
        this.setMoney(0.0);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getUserId() { return user.getIdUser();}

    public Bank getBank() { return bank;}

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Integer getIdPayAcc() {
        return id;
    }

    public void setIdPayAcc(Integer id) {
        this.id = id;
    }

    public String getUserName() {
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String toString(){
        return (
                    "id: " + getIdPayAcc() + "\n" +
                    "money: " + getMoney() + "\n" +
                    "user: " + getUserName() + "\n" +
                    "bankName: " + getBankName() + "\n" + "\n"
                );
    }
}