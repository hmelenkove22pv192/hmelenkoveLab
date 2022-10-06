package bank.utils;

import bank.entity.*;
import bank.service.*;
import bank.service.impl.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Bank
        System.out.println("Bank\n");
        BankService bankImpl = new BankImpl();
        Bank bank = bankImpl.createBank(1, "bank_name");
        bankImpl.readBank(bank);
        bankImpl.updateBankName(bank, "new_bank_name");
        bankImpl.readBank(bank);

        //BankOffice
        System.out.println("\nBankOffice\n");
        BankOfficeService bankOfficeImpl = new BankOfficeImpl();
        BankOffice office = bankOfficeImpl.createOffice(bank, 1, "office_name", "address", Status.WORK,
                Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,0.0,5.0);
        bankOfficeImpl.readOffice(office);
        bankOfficeImpl.updateOfficeStatusOfWorking(office, Status.NOTWORK);
        bankOfficeImpl.updateOfficeStatusOfCredit(office, false);
        bankOfficeImpl.updateOfficeStatusOfDeposit(office, false);
        bankOfficeImpl.updateOfficeStatusOfGiving(office, false);
        bankOfficeImpl.updateOfficeStatusOfSetATM(office, false);
        bankOfficeImpl.readOffice(office);

        //BankAtm
        System.out.println("\nBankAtm:\n");
        AtmService atmImpl = new AtmImpl();
        BankATM atm = atmImpl.createATM(bank, office,1, "ATM_1", Status.WORK, 1, Boolean.TRUE, Boolean.TRUE,
                500.0, 50.0);
        atmImpl.readATM(atm);
        atmImpl.updateATMMoney(atm,bank,10.000);
        atmImpl.updateATMStatusOfDeposit(atm, false);
        atmImpl.updateATMStatusOfGiving(atm, false);
        atmImpl.updateATMStatusOfWorking(atm, Status.NOMONEY);
        atmImpl.readATM(atm);

        //Employee
        System.out.println("\nEmployee:\n");
        EmployeeService employeeImpl = new EmployeeImpl();
        Employee employee = employeeImpl.createEmployee(bank, office, 1, "Ivan Ivanov",
                new Date(), "employer_1", Boolean.TRUE, Boolean.TRUE, 100.000);
        employeeImpl.readEmployee(employee);
        employeeImpl.updateEmployeeDistant(employee, false);
        employeeImpl.updateEmployeeGiving(employee, false);
        employeeImpl.readEmployee(employee);

        //User
        System.out.println("\nUser:\n");
        UserService userImpl = new UserImpl();
        User user = userImpl.createUser(1, "Petr Petrov", new Date(),
                "work_1");
        userImpl.readUser(user);
        userImpl.updateUserWork(user, "new_work_1");
        userImpl.readUser(user);

        //PaymentAccount
        System.out.println("\nPaymentAccount:\n");
        PaymentAccountService payAccImpl = new PaymentAccountImpl();
        PaymentAccount payAcc = payAccImpl.createPayAcc(bank, user, 1);
        payAccImpl.readPayAcc(payAcc);
        payAccImpl.updateMoney(payAcc,10.000);
        payAccImpl.readPayAcc(payAcc);

        //CreditAccount
        System.out.println("\nCreditAccount:");
        CreditAccountService creditAccImpl = new CreditAccountImpl();
        CreditAccount creditAcc = creditAccImpl.createCreditAcc(bank,user, employee, payAcc,
                1, new Date(), new Date(), 82, 200.000, 30.000);
        creditAccImpl.readCreditAcc(creditAcc);
        creditAccImpl.updateCreditPayAcc(creditAcc,payAcc);
        creditAccImpl.readCreditAcc(creditAcc);

        // Экземпляры хранятся только в памяти приложения.
        // После присваивания null ссылки не будет, поэтому сброщик мусора удалит эти объекты
        bank = null;
        office = null;
        atm = null;
        employee = null;
        user = null;
        creditAcc = null;
        payAcc = null;
        System.out.println(bank);
        System.out.println(office);
        System.out.println(atm);
        System.out.println(employee);
        System.out.println(user);
        System.out.println(creditAcc);
        System.out.println(payAcc);
    }
}
