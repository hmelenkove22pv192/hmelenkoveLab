package bank.service.CRUD;

import bank.entity.Bank;
import bank.service.BankService;

public interface BankServiceOperations extends BankService {
    @Override
    public default void addMoney(Bank bank, Double money) {
        Double sum = bank.getMoney();
        bank.setMoney(sum + money);
    }

    @Override
    public default Boolean subtractMoney(Bank bank, Double money) {
        Double sum = bank.getMoney();
        if (money > sum)
            return Boolean.FALSE;
        bank.setMoney(sum - money);
        return Boolean.TRUE;
    }
}
