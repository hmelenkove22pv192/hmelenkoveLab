package bank.service.CRUD;

import bank.entity.PaymentAccount;
import bank.service.PaymentAccountService;

public interface PaymentAccountServiceOperations extends PaymentAccountService {
    @Override
    public default void addMoney(PaymentAccount payAcc, Double money) {
        payAcc.setMoney(payAcc.getMoney() + money);
    }

    @Override
    public default Boolean subtractMoney(PaymentAccount payAcc, Double money) {
        if (payAcc.getMoney() < money)
            return Boolean.FALSE;
        payAcc.setMoney(payAcc.getMoney() - money);
        return Boolean.TRUE;
    }
}
