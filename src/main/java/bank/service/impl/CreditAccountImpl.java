package bank.service.impl;

import bank.entity.*;
import bank.service.CreditAccountService;

import java.util.HashMap;
import java.util.Map;

public class CreditAccountImpl implements CreditAccountService {
    private final Map<Integer, CreditAccount> credits = new HashMap<>();
    // реализация Singleton
    private static CreditAccountImpl instance; // приватное статическое поле, содержащее одиночный объект
    private CreditAccountImpl(){} // приватный конструктор класса
    public static CreditAccountImpl getInstance(){ // статический создающий метод, который будет использоваться для получения одиночки
        if(instance == null){
            instance = new CreditAccountImpl();
        }
        return instance;
    }

    @Override
    public CreditAccount createCreditAcc(Bank bank, User user, Employee employee,
                                         PaymentAccount paymentAccount, Integer id, String startDate,
                                         String endDate, Integer countMonth, Double creditSum, Double monthPay) {
        return credits.put(id, new CreditAccount(bank, user, employee, paymentAccount, id, startDate,
                endDate, countMonth, creditSum, monthPay));
    }

    @Override
    public CreditAccount readCreditAcc(Integer id) {
        return credits.get(id);
    }

    @Override
    public void updateCreditPayAcc(CreditAccount creditAcc, PaymentAccount payAcc) {
        creditAcc.setPaymentAccount(payAcc);
    }
}
