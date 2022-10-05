package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.entity.Employee;
import bank.service.EmployeeService;
import bank.utils.FullName;

import java.util.Date;

public class EmployeeImpl implements EmployeeService {
    public EmployeeImpl(){}
    @Override
    public Employee createEmployee(Bank bank, BankOffice office, Integer id,
                                   FullName fullName, Date birthDay, String jobTitle,
                                   Boolean isDistantWorker, Boolean canGiveCredit, Double salary) {
        bank.setCountEmployees(bank.getCountEmployees() + 1);
        return new Employee(bank, office, id, fullName, birthDay, jobTitle,
                isDistantWorker, canGiveCredit, salary);
    }

    @Override
    public void readEmployee(Employee employee) {
        System.out.println("id: " + employee.getIdEmployee());
        System.out.println("fullName: " + employee.getFullName());
        System.out.println("birthDay: " + employee.getBirthDay());
        System.out.println("bankName: " + employee.getBankName());
        System.out.println("jobTitle: " + employee.getJobTitle());
        System.out.println("isDistantWorker: " + employee.getIsDistantWorker());
        System.out.println("Office: " + employee.getOfficeId());
        System.out.println("canGiveCredit: " + employee.getCanGiveCredit());
        System.out.println("salary: " + employee.getSalary());
    }

    @Override
    public void updateEmployeeDistant(Employee employee, Boolean isDistantWorker) {
        employee.setIsDistantWorker(isDistantWorker);
    }

    @Override
    public void updateEmployeeGiving(Employee employee, Boolean canGiveCredit) {
        employee.setCanGiveCredit(canGiveCredit);
    }

    @Override
    public void deleteEmployee(Employee employee, Bank bank) {
        bank.setCountATM(bank.getCountATM() - 1);
        employee = null;
    }
}
