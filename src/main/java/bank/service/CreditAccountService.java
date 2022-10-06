package bank.service;

import bank.entity.*;

import java.util.Date;

public interface CreditAccountService {
    CreditAccount createCreditAcc(Bank bank, User user, Employee employee, PaymentAccount paymentAccount,
                                         Integer id, Date startDate, Date endDate, Integer countMonth,
                                         Double creditSum, Double monthPay);
    void readCreditAcc(CreditAccount creditAcc);
    void updateCreditPayAcc(CreditAccount creditAcc, PaymentAccount payAcc);
}