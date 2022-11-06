package bank.service.impl;

import bank.entity.Bank;
import bank.service.BankOfficeService;
import bank.service.BankService;

import java.util.Map;

public class BankImpl implements BankService {
//    private BankOfficeService officeService;
    private Map<Integer, Bank>  banks;

    @Override
    public Bank createBank(Integer id, String name) {
        return banks.put(id, new Bank(id, name));
    }

    @Override
    public Bank readBank(Integer id) {
       return banks.get(id);
    }

    @Override
    public Map<Integer, Bank> getAllBanks() {
        return banks;
    }

    @Override
    public void updateBankName(Bank bank, String name) {
        bank.setName(name);
    }
}
