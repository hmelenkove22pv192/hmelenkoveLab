package bank.service;

import bank.entity.Bank;

import java.util.Map;

public interface BankService {
    /**
     * сохраняет ссылку на объект банкоматов
     * @param atmService экземпляра класса AtmService
     * */
    void setAtmService(AtmService atmService);

    /**
     * сохраняет ссылку на объект оффисов
     * @param officeService экземпляра класса BankOfficeService
     * */
    void setOfficeService(BankOfficeService officeService);

    /**
     * сохраняет ссылку на объект сотрудников
     * @param employeeService экземпляра класса EmployeeService
     * */
    void setEmployeeService(EmployeeService employeeService);

    /**
     * создание экземпляра класса Bank
     * @param id идентификатор банка
     * @param name название банка
     * */
    Bank createBank(Integer id, String name);

    /**
     * возвращает экземпляра класса Bank
     * @param id экземпляра класса Bank
     * */
    Bank readBank(Integer id);

    /**
     * обновление названия банка
     * @param bank экземпляр класса Bank
     * @param name новое название банка
     * */
    void updateBankName(Bank bank, String name);

    /**
     * вывод в консоль всех данных о банке
     * @param id экземпляра класса Bank
     * */
    void getBankInfo(Integer id);
}