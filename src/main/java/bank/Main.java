package bank;

import bank.service.*;
import bank.service.impl.*;
import bank.utils.Status;

import java.io.IOException;
import java.util.Date;

import static bank.utils.Constants.*;
import static bank.utils.UtilsFunctions.getRandomBooleanValue;
import static bank.utils.UtilsFunctions.rnd;

public class Main {
    public static void main(String[] args) throws IOException {
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
                        Status.values()[rnd(0,2)],
                        getRandomBooleanValue(),
                        getRandomBooleanValue(),
                        getRandomBooleanValue(),
                        getRandomBooleanValue(),
                        (double)rnd(10000, 1000000),
                        5.0);
            }
        }

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
                        getRandomBooleanValue(),
                        (double)rnd(10000, 1000000),
                        50.0);
            }
        }

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
                        getRandomBooleanValue(),
                        getRandomBooleanValue(),
                        100.000);
            }
        }

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

        // вывод всех счетов пользователя в текстовый файл
        userImpl.getUserPaysInfo(rnd(1, USERS_COUNT));

        // перенос счета из одного банка в другой
        PaymentAccountImpl.transitAcc();
    }
}
