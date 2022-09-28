package bank.service;

import bank.entity.Employee;

public interface EmployeeService {
    void changeWorkPlace(Employee employee, Boolean flag);
    void licenseForCredit(Employee employee, Boolean flag);
}