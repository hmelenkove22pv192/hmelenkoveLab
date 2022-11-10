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

    @Override
    public void updateBankName(Bank bank, String name) {
        bank.setName(name);
    }

    @Override
    public void getBankInfo(Integer id) {
        System.out.println("\n");
        System.out.println("Offices info");
        for (int i = 1; i <= officesCount; i++){
            BankOffice office = officeService.readOffice(i);
            if (Objects.equals(office.getBankId(), id)){
                System.out.println("*************");
                System.out.println(office);
            }
            System.out.println("\n");
            System.out.println("ATMs info:");
            for (int j = 1; j <= atmsCount; j++){
                BankATM atm = atmService.readATM(j);
                if (Objects.equals(atm.getOfficeId(), office.getId())){
                    System.out.println("*************");
                    System.out.println(atm);
                }
            }
            System.out.println("\n");
            System.out.println("Employees info:");
            for (int a = 1; a <= employeesCount; a++){
                Employee employee = employeeService.readEmployee(a);
                if (Objects.equals(employee.getBankId(), id)){
                    System.out.println("*************");
                    System.out.println(employee);
                }
            }
        }
    }
}
