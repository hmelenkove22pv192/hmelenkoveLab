package bank.service.impl;

import bank.entity.Bank;
import bank.service.BankService;

import java.util.HashMap;
import java.util.Map;

public class BankImpl implements BankService {
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
}
