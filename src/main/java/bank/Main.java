package bank;

import bank.service.*;
import bank.service.impl.*;
import bank.utils.Status;
import bank.utils.UserInputException;

import java.util.Date;

import static bank.utils.Constants.*;
import static bank.utils.UtilsFunctions.getRandomBooleanValue;
import static bank.utils.UtilsFunctions.rnd;

public class Main {
    public static void main(String[] args) throws UserInputException {
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

        // Механизм получения кредита на примере 1 Клиента
        boolean isUserOk = false;
        while (!isUserOk){
            int index = rnd(1, USERS_COUNT);
            isUserOk = userImpl.giveUserCredit(index, 100000.00);
        }
    }
}
