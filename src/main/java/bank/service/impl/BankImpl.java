package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankATM;
import bank.entity.BankOffice;
import bank.entity.Employee;
import bank.service.*;

import java.util.HashMap;
import java.util.Map;

public class BankImpl implements BankService {
    private AtmService atmService = new AtmImpl();
    private BankOfficeService officeService = new BankOfficeImpl();
    private EmployeeService employeeService = new EmployeeImpl();
    private Map<Integer, Bank>  banks = new HashMap<Integer, Bank>();

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
        for (int i = 1; i <= 15; i++){
            BankOffice office = officeService.readOffice(i);
            if (office.getBankId() == id ){
                System.out.println("*************");
                System.out.println(office);
            }
            System.out.println("\n");
            System.out.println("ATMs info:");
            for (int j = 1; j <= 15; j++){
                BankATM atm = atmService.readATM(j);
                if (atm.getOfficeId() == office.getId() ){
                    System.out.println("*************");
                    System.out.println(atm);
                }
            }
            System.out.println("\n");
            System.out.println("Employees info:");
            for (int a = 1; a <= 75; a++){
                Employee employee = employeeService.readEmployee(a);
                if (employee.getBankId() == id ){
                    System.out.println("*************");
                    System.out.println(employee);
                }
            }
        }
    }
}
