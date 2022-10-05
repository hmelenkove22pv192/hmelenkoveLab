package bank.service.impl;

import bank.entity.*;
import bank.service.CreditAccountService;

import java.util.Date;

public class CreditAccountImpl implements CreditAccountService {
    public CreditAccountImpl(){}
    @Override
    public CreditAccount createCreditAcc(Bank bank, User user, Employee employee,
                                         PaymentAccount paymentAccount, Integer id, Date startDate,
                                         Date endDate, Integer countMonth, Double creditSum, Double monthPay) {
        return new CreditAccount(bank, user, employee, paymentAccount, id, startDate,
                endDate, countMonth, creditSum, monthPay);
    }

    @Override
    public void readCreditAcc(CreditAccount creditAcc) {
        System.out.println("id: " + creditAcc.getId());
        System.out.println("userName: " + creditAcc.getUserName());
        System.out.println("bankName: " + creditAcc.getBankName());
        System.out.println("startDate: " + creditAcc.getStartDate());
        System.out.println("endDate: " + creditAcc.getEndDate());
        System.out.println("countMonth: " + creditAcc.getCountMonth());
        System.out.println("creditSum: " + creditAcc.getCreditSum());
        System.out.println("interestRate: " + creditAcc.getInterestRate());
        System.out.println("employee: " + creditAcc.getEmployeeName());
        System.out.println("interestRate: " + creditAcc.getInterestRate());
        System.out.println("monthPay: " + creditAcc.getMonthPay());
        System.out.println("paymentAccountId: " + creditAcc.getPaymentAccountId());
    }

    @Override
    public void updateCreditPayAcc(CreditAccount creditAcc, PaymentAccount payAcc) {
        creditAcc.setPaymentAccount(payAcc);
    }

    @Override
    public void deleteCreditAcc(CreditAccount creditAcc) {
        creditAcc = null;
    }
}
