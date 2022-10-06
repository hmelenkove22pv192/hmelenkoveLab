package bank.service;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.entity.Employee;

import java.util.Date;

public interface EmployeeService {
    /**
     * создание экземпляра класса Employee
     * bank - экземпляр класса Bank
     * office - экземпляр класса BankOffice
     * id - идентификатор сотрудника
     * fullName - полное имя сотрудника
     * birthDay - дата рождения сотрудника
     * jobTitle - должность сотрудника
     * isDistantWorker - является ли сотрудник дистанционным работником (0 - нет, не является, 1 - да, является)
     * canGiveCredit - может ли сотрудник выдавать кредиты (0 - нет, не может, 1 - да, может)
     * salary - зарплата сотрудника
     * */
    Employee createEmployee(Bank bank, BankOffice office, Integer id, String fullName, Date birthDay, String jobTitle,
                                   Boolean isDistantWorker, Boolean canGiveCredit, Double salary);
    /**
     * вывод в консоль экземпляра класса Employee
     * */
    void readEmployee(Employee employee);
    /**
     * обновление статуса дистанционной работы сотрудника
     * employee - экземпляр класса Employee
     * isDistantWorker - флаг статуса (0 - не работает дистанционно, 1 - работает дистанционно)
     * */
    void updateEmployeeDistant(Employee employee, Boolean isDistantWorker);

    /**
     * обновление статуса выдачи кредитов сотрудником
     * employee - экземпляр класса Employee
     * canGiveCredit - флаг статуса (0 - не может выдавать кредиты, 1 - может выдавать кредиты)
     * */
    void updateEmployeeGiving(Employee employee, Boolean canGiveCredit);
}