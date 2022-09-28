package bank.utils;

import bank.entity.*;
import bank.entity.additionalClasses.FullName;
import bank.entity.additionalClasses.Status;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Bank
        Bank bank = new Bank(1, "bank_name");
        System.out.println("Bank\n");
        System.out.println("id: " + bank.getId());
        System.out.println("name: " + bank.getName());
        System.out.println("countOffice: " + bank.getCountOffice());
        System.out.println("countATM: " + bank.getCountATM());
        System.out.println("countEmployees: " + bank.getCountEmployees());
        System.out.println("countClients: " + bank.getCountClients());
        System.out.println("rating: " + bank.getRating());
        System.out.println("money: " + bank.getMoney());
        System.out.println("interestRate: " + bank.getInterestRate());

        //BankOffice
        System.out.println("\nBankOffice\n");
        BankOffice office = new BankOffice(bank, 1, "office_name", "address", Status.Work,
                Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,0.0,5.0);
        System.out.println("id: " + office.getId());
        System.out.println("name: " + office.getName());
        System.out.println("address: " + office.getAddress());
        System.out.println("countATM: " + office.getCountATM());
        System.out.println("status: " + office.getStatus());
        System.out.println("canSetATM: " + office.getCanSetATM());
        System.out.println("canTakeCredit: " + office.getCanTakeCredit());
        System.out.println("canGiveMoney: " + office.getCanGiveMoney());
        System.out.println("canDepositMoney: " + office.getCanDepositMoney());
        System.out.println("money: " + office.getMoney());
        System.out.println("cost: " + office.getCost());


        //BankAtm
        System.out.println("\nBankAtm:\n");
        BankATM atm = new BankATM(office, 1, "ATM_1", Status.Work, 1, Boolean.TRUE, Boolean.TRUE,
                500.0, 50.0);
        System.out.println("id: " + atm.getId());
        System.out.println("name: " + atm.getName());
        System.out.println("bankName: " + bank.getName());
        System.out.println("address: " + office.getAddress());
        System.out.println("status: " + atm.getStatus());
        System.out.println("employeeId: " + atm.getEmployeeId());
        System.out.println("canGiveMoney: " + atm.getCanGiveMoney());
        System.out.println("canDepositMoney: " + atm.getCanDepositMoney());
        System.out.println("money: " + atm.getMoney());
        System.out.println("cost: " + atm.getCost());

        //Employee
        System.out.println("\nEmployee:\n");
        Employee employee = new Employee(office, 1, new FullName("Ivan", "Ivanov"),
                new Date(), "employer_1", Boolean.TRUE, Boolean.TRUE, 100.000);
        System.out.println("id: " + employee.getId());
        System.out.println("fullName: " + employee.getFullName());
        System.out.println("birthDay: " + employee.getBirthDay());
        System.out.println("bankName: " + bank.getName());
        System.out.println("jobTitle: " + employee.getJobTitle());
        System.out.println("isDistantWorker: " + employee.getIsDistantWorker());
        System.out.println("canGiveCredit: " + employee.getCanGiveCredit());
        System.out.println("salary: " + employee.getSalary());

        //User
        System.out.println("\nUser:\n");
        User user = new User(bank, 1, new FullName("Petr", "Petrov"), new Date(),
                "work_1");
        System.out.println("id: " + user.getId());
        System.out.println("fullName: " + user.getFullName());
        System.out.println("birthDay: " + user.getBirthDay());
        System.out.println("workPlace: " + user.getWorkPlace());
        System.out.println("monthSalary: " + user.getMonthSalary());
        System.out.println("creditRating: " + user.getCreditRating());

        //PaymentAccount
        System.out.println("\nPaymentAccount:\n");
        PaymentAccount payAcc = new PaymentAccount(bank, 1, 1);
        System.out.println("id: " + payAcc.getId());
        System.out.println("money: " + payAcc.getMoney());
        System.out.println("userId: " + payAcc.getUserIdPayAcc());
        System.out.println("bankName: " + bank.getName());

        //CreditAccount
        System.out.println("\nCreditAccount:");
        CreditAccount creditAcc = new CreditAccount(bank, 1, new Date(), new Date(),
                82, 200.000, 1);
        System.out.println("id: " + creditAcc.getId());
        System.out.println("startDate: " + creditAcc.getStartDate());
        System.out.println("endDate: " + creditAcc.getEndDate());
        System.out.println("countMonth: " + creditAcc.getCountMonth());
        System.out.println("creditSum: " + creditAcc.getCreditSum());
        System.out.println("employeeId: " + creditAcc.getEmployeeId());
        System.out.println("interestRate: " + bank.getInterestRate());

    }
}
