package bank.service.CRUD;

import bank.entity.Bank;
import bank.entity.BankATM;
import bank.entity.Employee;
import bank.service.EmployeeService;

public interface EmployeeServiceOperations extends EmployeeService {
    @Override
    public default void changeWorkPlace(Employee employee, Boolean flag){
        employee.setIsDistantWorker(flag);
    }

    @Override
    public default void licenseForCredit(Employee employee, Boolean flag) {
        employee.setCanGiveCredit(flag);
    }
}
