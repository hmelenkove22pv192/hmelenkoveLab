package bank.service.impl;

import bank.entity.*;
import bank.service.PaymentAccountService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PaymentAccountImpl implements PaymentAccountService {
    private final Map<Integer, PaymentAccount> pays = new HashMap<>();

    // реализация Singleton
    private static PaymentAccountImpl instance; // приватное статическое поле, содержащее одиночный объект
    private PaymentAccountImpl(){} // приватный конструктор класса
    public static PaymentAccountImpl getInstance(){ // статический создающий метод, который будет использоваться для получения одиночки
        if(instance == null){
            instance = new PaymentAccountImpl();
        }
        return instance;
    }

    @Override
    public PaymentAccount createPayAcc(Bank bank, User user, Integer id) {
        boolean isUserAlreadyExist = false;
        for (int i = 1; i <= pays.size(); i++){
            if (Objects.equals(pays.get(i).getUserId(), user.getIdUser())){
                isUserAlreadyExist = true;
            }
        }
        if (!isUserAlreadyExist){
            bank.setCountClients(bank.getCountClients() + 1);
        }
        return pays.put(id, new PaymentAccount(bank, user, id));
    }

    @Override
    public PaymentAccount readPayAcc(Integer id) {
        return pays.get(id);
    }

    @Override
    public void updateMoney(PaymentAccount payAcc, Double money) {
        payAcc.setMoney(money);
    }
}
