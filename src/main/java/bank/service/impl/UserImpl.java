package bank.service.impl;

import bank.entity.*;
import bank.service.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static bank.utils.Constants.PAYS_AND_CREDITS_COUNT;

public class UserImpl implements UserService {
    private PaymentAccountService payService = PaymentAccountImpl.getInstance();
    private CreditAccountService creditService = CreditAccountImpl.getInstance();
    private final Map<Integer, User> users = new HashMap<>();

    // реализация Singleton
    private static UserImpl instance; // приватное статическое поле, содержащее одиночный объект
    private UserImpl(){} // приватный конструктор класса
    public static UserImpl getInstance(){ // статический создающий метод, который будет использоваться для получения одиночки
        if(instance == null){
            instance = new UserImpl();
        }
        return instance;
    }
    @Override
    public void setPayService(PaymentAccountService payService) {
        this.payService = payService;
    }

    @Override
    public void setCreditService(CreditAccountService creditService) {
        this.creditService = creditService;
    }

    @Override
    public User createUser(Integer id, String fullName, Date birthDay, String workPlace) {
        return users.put(id, new User(id, fullName, birthDay, workPlace));
    }

    @Override
    public User readUser(Integer id) {
        return users.get(id);
    }

    @Override
    public void updateUserWork(User user, String workPlace) {
        user.setWorkPlace(workPlace);
    }

    @Override
    public void getUserInfo(Integer id) {
        System.out.println("\n");
        System.out.println("Payment accounts");
        for (int i = 1; i <= PAYS_AND_CREDITS_COUNT; i++){
            PaymentAccount pay = payService.readPayAcc(i);
            if (Objects.equals(pay.getUserId(), id)){
                System.out.println("*************");
                System.out.println(pay);
            }
        }
        System.out.println("\n");
        System.out.println("Credit accounts");
        for (int j = 1; j <= PAYS_AND_CREDITS_COUNT; j++){
            CreditAccount credit = creditService.readCreditAcc(j);
            if (Objects.equals(credit.getUserId(), id)){
                System.out.println("*************");
                System.out.println(credit);
            }
        }
    }

}
