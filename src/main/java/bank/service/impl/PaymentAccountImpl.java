package bank.service.impl;

import bank.entity.Bank;
import bank.entity.PaymentAccount;
import bank.entity.User;
import bank.service.PaymentAccountService;

public class PaymentAccountImpl implements PaymentAccountService {
    /**
     * создание экземпляра класса PaymentAccount
     * @param bank экземпляр класса Bank
     * @param user экземпляр класса User
     * @param id идентификатор платежного счета
     * */
    @Override
    public PaymentAccount createPayAcc(Bank bank, User user, Integer id) {
        bank.setCountClients(bank.getCountOffice() + 1);
        return new PaymentAccount(bank, user, id);
    }

    /**
     * вывод в консоль экземпляра класса PaymentAccount
     * @param payAcc экземпляр класса PaymentAccount
     * */
    @Override
    public void readPayAcc(PaymentAccount payAcc) {
        System.out.println(payAcc);
    }

    /**
     * обновление суммы денег на счету
     * @param payAcc экземпляр класса PaymentAccount
     * @param money новая сумма
     * */
    @Override
    public void updateMoney(PaymentAccount payAcc, Double money) {
        payAcc.setMoney(money);
    }
}
