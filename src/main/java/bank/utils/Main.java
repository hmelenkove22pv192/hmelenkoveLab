package bank.utils;

import bank.entity.*;
import bank.service.*;
import bank.service.impl.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Bank
        BankService bankImpl = new BankImpl();
        for (int i = 1; i <= 5; i++) {
            bankImpl.createBank(i, "bank_name" + i);
        }

        //BankOffice
        BankOfficeService bankOfficeImpl = new BankOfficeImpl();
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 3; j++) {
                bankOfficeImpl.createOffice(
                        bankImpl.readBank(i),
                        i-1+j,
                        "office_name" + i + j,
                        "address" + i + j,
                        Status.WORK,
                        Boolean.TRUE,
                        Boolean.TRUE,
                        Boolean.TRUE,
                        Boolean.TRUE,
                        0.0,
                        5.0);
            }
        }

        //BankAtm
        AtmService atmImpl = new AtmImpl();
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 3; j++) {
                atmImpl.createATM(
                        bankImpl.readBank(i),
                        bankOfficeImpl.readOffice(j),
                        i-1+j,
                        "ATM" + i + j,
                        Status.WORK,
                        i-1+j,
                        Boolean.TRUE,
                        Boolean.TRUE,
                        500.0,
                        50.0);
            }
        }

        //Employee
        EmployeeService employeeImpl = new EmployeeImpl();
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int a = 1; a <= 5; a++){
                    employeeImpl.createEmployee(
                            bankImpl.readBank(i),
                            bankOfficeImpl.readOffice(j),
                            i-1+j-1+a,
                            "Employee" + i + j + a,
                            new Date(),
                            "job" + i + j + a,
                            Boolean.TRUE,
                            Boolean.TRUE,
                            100.000);
                }
            }
        }

        //User
        UserService userImpl = new UserImpl();
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                userImpl.createUser(
                        i-1+j,
                        "User" + i + j,
                        new Date(),
                        "work" + i + j);
            }
        }

        //PaymentAccount
        PaymentAccountService payAccImpl = new PaymentAccountImpl();
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 2; j++) {
                PaymentAccount payAcc = payAccImpl.createPayAcc(
                        bankImpl.readBank(rnd(1,5)),
                        userImpl.readUser(i),
                        i-1+j);
            }
        }

        //CreditAccount
        CreditAccountService creditAccImpl = new CreditAccountImpl();
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 2; j++) {
                Integer randomIndex = rnd(1,5);
                CreditAccount creditAcc = creditAccImpl.createCreditAcc(
                        bankImpl.readBank(randomIndex),
                        userImpl.readUser(i),
                        employeeImpl.readEmployee(randomIndex * 15 - rnd(0, 14)),
                        payAccImpl.readPayAcc(j),
                        i-1+j,
                        new Date(),
                        new Date(),
                        82,
                        200.000,
                        30.000);
            }
        }
    }

    /**
     * Метод получения псевдослучайного целого числа от min до max (включая max);
     */
    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
