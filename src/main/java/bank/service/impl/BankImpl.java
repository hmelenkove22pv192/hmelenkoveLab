package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankATM;
import bank.entity.BankOffice;
import bank.entity.Employee;
import bank.service.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static bank.utils.Constants.*;

public class BankImpl implements BankService {
    private AtmService atmService = AtmImpl.getInstance();
    private BankOfficeService officeService = BankOfficeImpl.getInstance();
    private EmployeeService employeeService = EmployeeImpl.getInstance();
    private final Map<Integer, Bank>  banks = new HashMap<>();

    // реализация Singleton
    private static BankImpl instance; // приватное статическое поле, содержащее одиночный объект
    private BankImpl(){} // приватный конструктор класса
    public static BankImpl getInstance(){ // статический создающий метод, который будет использоваться для получения одиночки
        if(instance == null){
            instance = new BankImpl();
        }
        return instance;
    }

    @Override
    public void setAtmService(AtmService atmService) {
        this.atmService = atmService;
    }
    @Override
    public void setOfficeService(BankOfficeService officeService) {
        this.officeService = officeService;
    }
    @Override
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Bank createBank(Integer id, String name) {
        return banks.put(id, new Bank(id, name));
    }

    @Override
    public Bank readBank(Integer id) {
       return banks.get(id);
    }
}
