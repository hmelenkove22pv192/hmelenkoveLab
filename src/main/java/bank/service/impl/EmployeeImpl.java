package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.entity.Employee;
import bank.service.EmployeeService;

import java.util.Date;

public class EmployeeImpl implements EmployeeService {
    public EmployeeImpl(){}
    /**
     * создание экземпляра класса Employee
     * @param bank экземпляр класса Bank
     * @param office экземпляр класса BankOffice
     * @param id идентификатор сотрудника
     * @param fullName полное имя сотрудника
     * @param birthDay дата рождения сотрудника
     * @param jobTitle должность сотрудника
     * @param isDistantWorker является ли сотрудник дистанционным работником (0 - нет, не является, 1 - да, является)
     * @param canGiveCredit может ли сотрудник выдавать кредиты (0 - нет, не может, 1 - да, может)
     * @param salary зарплата сотрудника
     * */
    @Override
    public Employee createEmployee(Bank bank, BankOffice office, Integer id,
                                   String fullName, Date birthDay, String jobTitle,
                                   Boolean isDistantWorker, Boolean canGiveCredit, Double salary) {
        bank.setCountEmployees(bank.getCountEmployees() + 1);
        return new Employee(bank, office, id, fullName, birthDay, jobTitle,
                isDistantWorker, canGiveCredit, salary);
    }

    /**
     * вывод в консоль экземпляра класса Employee
     * @param employee экземпляр класса Employee
     * */
    @Override
    public void readEmployee(Employee employee) {
        System.out.println(employee);
    }

    /**
     * обновление статуса дистанционной работы сотрудника
     * @param employee экземпляр класса Employee
     * @param isDistantWorker флаг статуса (0 - не работает дистанционно, 1 - работает дистанционно)
     * */
    @Override
    public void updateEmployeeDistant(Employee employee, Boolean isDistantWorker) {
        employee.setIsDistantWorker(isDistantWorker);
    }

    /**
     * обновление статуса выдачи кредитов сотрудником
     * @param employee экземпляр класса Employee
     * @param canGiveCredit флаг статуса (0 - не может выдавать кредиты, 1 - может выдавать кредиты)
     * */
    @Override
    public void updateEmployeeGiving(Employee employee, Boolean canGiveCredit) {
        employee.setCanGiveCredit(canGiveCredit);
    }
}
