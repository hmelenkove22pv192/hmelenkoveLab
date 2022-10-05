package bank.service.impl;

import bank.entity.Bank;
import bank.entity.PaymentAccount;
import bank.entity.User;
import bank.service.PaymentAccountService;

public class PaymentAccountImpl implements PaymentAccountService {
    @Override
    public PaymentAccount createPayAcc(Bank bank, User user, Integer id) {
        bank.setCountClients(bank.getCountOffice() + 1);
        return new PaymentAccount(bank, user, id);
    }

    @Override
    public void readPayAcc(PaymentAccount payAcc) {
        System.out.println("id: " + payAcc.getIdPayAcc());
        System.out.println("money: " + payAcc.getMoney());
        System.out.println("user: " + payAcc.getUserName());
        System.out.println("bankName: " + payAcc.getBankName());
    }

    @Override
    public void updateMoney(PaymentAccount payAcc, Double money) {
        payAcc.setMoney(money);
    }

    @Override
    public void deletePayAcc(PaymentAccount payAcc, Bank bank) {
        bank.setCountATM(bank.getCountATM() - 1);
        payAcc = null;
    }
}
