package bank.entity;
import java.util.Random;

public class Bank {
    private Integer id;
    private String name;
    private Integer countOffice;
    private Integer countATM;
    private Integer countEmployees;
    private Integer countClients;
    private Integer rating;
    private Double money;
    private Double interestRate;

    public Bank(Integer id, String name) {
        setId(id);
        setName(name);
        setCountOffice(0);
        setCountATM(0);
        setCountEmployees(0);
        setCountClients(0);
        Random random = new Random();
        setRating(random.nextInt(0, 100));
        setMoney(random.nextDouble(0, 1000000));
        setInterestRate(20.0- this.rating/5.0);
    }

    public Bank(Bank bankInstance) {
        setId(bankInstance.getId());
        setName(bankInstance.getName());
        setCountOffice(bankInstance.getCountOffice());
        setCountATM(bankInstance.getCountATM());
        setCountEmployees(bankInstance.getCountEmployees());
        setCountClients(bankInstance.getCountClients());
        setRating(bankInstance.getRating());
        setMoney(bankInstance.getMoney());
        setInterestRate(bankInstance.getInterestRate());
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

    public Integer getCountOffice() {
        return countOffice;
    }

    public void setCountOffice(Integer countOffice) {
        this.countOffice = countOffice;
    }

    public Integer getCountATM() {
        return countATM;
    }

    public void setCountATM(Integer countATM) {
        this.countATM = countATM;
    }

    public Integer getCountEmployees() {
        return countEmployees;
    }

    public void setCountEmployees(Integer countEmployees) {
        this.countEmployees = countEmployees;
    }

    public Integer getCountClients() {
        return countClients;
    }

    public void setCountClients(Integer countClients) {
        this.countClients = countClients;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public String toString(){
        return (
                    "id: " + getId() + "\n" +
                    "name: " + getName() + "\n" +
                    "money: " + getMoney() + "\n"
                );
    }
}
