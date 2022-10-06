package bank.service;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.entity.Employee;

import java.util.Date;

public interface EmployeeService {
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
    Employee createEmployee(Bank bank, BankOffice office, Integer id, String fullName, Date birthDay, String jobTitle,
                                   Boolean isDistantWorker, Boolean canGiveCredit, Double salary);
    /**
     * вывод в консоль экземпляра класса Employee
     * @param employee экземпляр класса Employee
     * */
    void readEmployee(Employee employee);
    /**
     * обновление статуса дистанционной работы сотрудника
     * @param employee экземпляр класса Employee
     * @param isDistantWorker флаг статуса (0 - не работает дистанционно, 1 - работает дистанционно)
     * */
    void updateEmployeeDistant(Employee employee, Boolean isDistantWorker);

    /**
     * обновление статуса выдачи кредитов сотрудником
     * @param employee экземпляр класса Employee
     * @param canGiveCredit флаг статуса (0 - не может выдавать кредиты, 1 - может выдавать кредиты)
     * */
    void updateEmployeeGiving(Employee employee, Boolean canGiveCredit);
}