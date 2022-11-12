package bank;

import bank.service.*;
import bank.service.impl.*;
import bank.utils.Status;

import java.util.Date;

import static bank.utils.Constants.*;
import static bank.utils.UtilsFunctions.rnd;

public class Main {
    public static void main(String[] args) {
        //Bank
        BankService bankImpl = BankImpl.getInstance();
        for (int i = 1; i <= BANKS_COUNT; i++) {
            bankImpl.createBank(i, "bank_name" + i);
        }
        //BankOffice
        BankOfficeService bankOfficeImpl = BankOfficeImpl.getInstance();
        Integer counter = 0;
        for (int i = 1; i <= BANKS_COUNT; i++) {
            for (int j = 1; j <= OFFICES_IN_ONE_BANK; j++) {
                counter++;
                bankOfficeImpl.createOffice(
                        bankImpl.readBank(i),
                        counter,
                        "office_name" + counter,
                        "address" + counter,
                        Status.WORK,
                        true,
                        true,
                        true,
                        true,
                        0.0,
                        5.0);
            }
        }
        bankImpl.setOfficeService(bankOfficeImpl);

        //BankAtm
        AtmService atmImpl = AtmImpl.getInstance();
        counter = 0;
        for (int j = 1; j <= OFFICES_COUNT; j++) {
            for (int a = 1; a <= ATMS_IN_ONE_OFFICE; a++){
                counter++;
                atmImpl.createATM(
                        bankImpl.readBank(bankOfficeImpl.readOffice(j).getBankId()),
                        bankOfficeImpl.readOffice(j),
                        counter,
                        "ATM" + counter,
                        Status.WORK,
                        counter,
                        true,
                        true,
                        500.0,
                        50.0);
            }
        }
        bankImpl.setAtmService(atmImpl);

        //Employee
        EmployeeService employeeImpl = EmployeeImpl.getInstance();
        counter = 0;
        for (int j = 1; j <= OFFICES_COUNT; j++) {
            for (int a = 1; a <= EMPLOYEES_IN_ONE_OFFICE; a++){
                counter++;
                employeeImpl.createEmployee(
                        bankImpl.readBank(bankOfficeImpl.readOffice(j).getBankId()),
                        bankOfficeImpl.readOffice(j),
                        counter,
                        "Employee" + counter,
                        new Date(),
                        "job" + counter,
                        true,
                        true,
                        100.000);
            }
        }
        bankImpl.setEmployeeService(employeeImpl);

        //User
        UserService userImpl = UserImpl.getInstance();
        counter = 0;
        for (int i = 1; i <= BANKS_COUNT; i++) {
            for (int j = 1; j <= USERS_IN_ONE_BANK; j++) {
                counter++;
                userImpl.createUser(
                        counter,
                        "User" + counter,
                        new Date(),
                        "work" + counter);
            }
        }

        //PaymentAccount
        PaymentAccountService payAccImpl = PaymentAccountImpl.getInstance();
        counter = 0;
        Integer userCounter = 0;
        for (int i = 1; i <= BANKS_COUNT; i++) {
            for (int j = 1; j <= USERS_IN_ONE_BANK; j++) {
                userCounter++;
                for (int a = 1; a <= PAYS_AND_CREDITS_IN_ONE_USER; a++) {
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
        CreditAccountService creditAccImpl = CreditAccountImpl.getInstance();
        counter = 0;
        userCounter = 0;
        for (int i = 1; i <= BANKS_COUNT; i++) {
            for (int j = 1; j <= USERS_IN_ONE_BANK; j++) {
                userCounter++;
                for (int a = 1; a <= PAYS_AND_CREDITS_IN_ONE_USER; a++) {
                    counter++;
                    creditAccImpl.createCreditAcc(
                            bankImpl.readBank(i),
                            userImpl.readUser(userCounter),
                            employeeImpl.readEmployee(i * EMPLOYEES_IN_ONE_BANK - rnd(0, EMPLOYEES_IN_ONE_BANK-1)),
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
        for (int i = 1; i <= BANKS_COUNT; i++) {
            System.out.println("----------------------");
            System.out.println("Bank" + i + "\n");
            System.out.println(bankImpl.readBank(i));
            bankImpl.getBankInfo(i);
            System.out.println("\n");
            System.out.println("----------------------");
        }
        // вывод информации о клиенте
        for (int i = 1; i <= USERS_COUNT; i++) {
            System.out.println("----------------------");
            System.out.println("User" + i + "\n");
            System.out.println(userImpl.readUser(i));
            userImpl.getUserInfo(i);
            System.out.println("\n");
            System.out.println("----------------------");
        }
    }
}
