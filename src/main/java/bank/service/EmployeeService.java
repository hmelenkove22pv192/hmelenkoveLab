package bank.service;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.entity.Employee;
import bank.utils.FullName;

import java.util.Date;

public interface EmployeeService {
    Employee createEmployee(Bank bank, BankOffice office, Integer id, FullName fullName, Date birthDay, String jobTitle,
                                   Boolean isDistantWorker, Boolean canGiveCredit, Double salary);
    void readEmployee(Employee employee);
    void updateEmployeeDistant(Employee employee, Boolean isDistantWorker);
    void updateEmployeeGiving(Employee employee, Boolean canGiveCredit);
    void deleteEmployee(Employee employee, Bank bank);
}