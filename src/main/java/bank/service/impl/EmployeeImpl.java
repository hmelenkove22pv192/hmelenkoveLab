package bank.service.impl;

import bank.entity.*;
import bank.service.EmployeeService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EmployeeImpl implements EmployeeService {
    private Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
    public EmployeeImpl(){}

    @Override
    public Employee createEmployee(Bank bank, BankOffice office, Integer id,
                                   String fullName, Date birthDay, String jobTitle,
                                   Boolean isDistantWorker, Boolean canGiveCredit, Double salary) {
        bank.setCountEmployees(bank.getCountEmployees() + 1);
        return employees.put(id, new Employee(bank, office, id, fullName, birthDay, jobTitle,
                isDistantWorker, canGiveCredit, salary));
    }

    @Override
    public Employee readEmployee(Integer id) {
        return employees.get(id);
    }

    @Override
    public void updateEmployeeDistant(Employee employee, Boolean isDistantWorker) {
        employee.setIsDistantWorker(isDistantWorker);
    }

    @Override
    public void updateEmployeeGiving(Employee employee, Boolean canGiveCredit) {
        employee.setCanGiveCredit(canGiveCredit);
    }
}
