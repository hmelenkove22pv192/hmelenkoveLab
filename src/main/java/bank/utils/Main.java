package bank.utils;

import bank.entity.CreditAccount;
import bank.entity.PaymentAccount;
import bank.service.*;
import bank.service.impl.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Bank
        BankService bankImpl = new BankImpl();
        for (int i = 1; i <= 5; i++) {
            bankImpl.createBank(i, "bank_name" + i);
        }

        //BankOffice
        BankOfficeService bankOfficeImpl = new BankOfficeImpl();
        Integer counter = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 3; j++) {
                counter++;
                bankOfficeImpl.createOffice(
                        bankImpl.readBank(i),
                        counter,
                        "office_name" + counter,
                        "address" + counter,
                        Status.WORK,
                        Boolean.TRUE,
                        Boolean.TRUE,
                        Boolean.TRUE,
                        Boolean.TRUE,
                        0.0,
                        5.0);
            }
        }
        bankImpl.setOfficeService(bankOfficeImpl);

        //BankAtm
        AtmService atmImpl = new AtmImpl();
        counter = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 3; j++) {
                counter++;
                atmImpl.createATM(
                        bankImpl.readBank(i),
                        bankOfficeImpl.readOffice(j),
                        counter,
                        "ATM" + counter,
                        Status.WORK,
                        counter,
                        Boolean.TRUE,
                        Boolean.TRUE,
                        500.0,
                        50.0);
            }
        }
        bankImpl.setAtmService(atmImpl);

        //Employee
        EmployeeService employeeImpl = new EmployeeImpl();
        counter = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int a = 1; a <= 5; a++){
                    counter++;
                    employeeImpl.createEmployee(
                            bankImpl.readBank(i),
                            bankOfficeImpl.readOffice(j),
                            counter,
                            "Employee" + counter,
                            new Date(),
                            "job" + counter,
                            Boolean.TRUE,
                            Boolean.TRUE,
                            100.000);
                }
            }
        }
        bankImpl.setEmployeeService(employeeImpl);

        //User
        UserService userImpl = new UserImpl();
        counter = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                counter++;
                userImpl.createUser(
                        counter,
                        "User" + counter,
                        new Date(),
                        "work" + counter);
            }
        }

        //PaymentAccount
        PaymentAccountService payAccImpl = new PaymentAccountImpl();
        counter = 0;
        Integer userCounter = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                userCounter++;
                for (int a = 1; a <= 2; a++) {
                    counter++;
                    payAccImpl.createPayAcc(
                            bankImpl.readBank(i),
                            userImpl.readUser(userCounter),
                            counter);
                }
            }
        }
        userImpl.setPayService(payAccImpl);

        //CreditAccount
        CreditAccountService creditAccImpl = new CreditAccountImpl();
        counter = 0;
        userCounter = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                userCounter++;
                for (int a = 1; a <= 2; a++) {
                    counter++;
                    creditAccImpl.createCreditAcc(
                            bankImpl.readBank(i),
                            userImpl.readUser(userCounter),
                            employeeImpl.readEmployee(i * 15 - rnd(0, 14)),
                            payAccImpl.readPayAcc(a),
                            counter,
                            new Date(),
                            new Date(),
                            82,
                            200.000,
                            30.000);
                }
            }
        }
        userImpl.setCreditService(creditAccImpl);

        // вывод информации о банке
        for (int i = 1; i <= 5; i++) {
            System.out.println("----------------------");
            System.out.println("Bank" + i + "\n");
            System.out.println(bankImpl.readBank(i));
            bankImpl.getBankInfo(i);
            System.out.println("\n");
            System.out.println("----------------------");
        }
        // вывод информации о клиенте
        for (int i = 1; i <= 25; i++) {
            System.out.println("----------------------");
            System.out.println("User" + i + "\n");
            System.out.println(userImpl.readUser(i));
            userImpl.getUserInfo(i);
            System.out.println("\n");
            System.out.println("----------------------");
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
