package bank.service.impl;

import bank.entity.*;
import bank.service.BankService;
import bank.service.PaymentAccountService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentAccountImpl implements PaymentAccountService {

    private static final BankService bankService = BankImpl.getInstance();
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


    public static void transitAcc() {
        try (BufferedReader reader = new BufferedReader(new FileReader("transit.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                Pattern integerPattern = Pattern.compile("\\d+");
                Matcher matcher = integerPattern.matcher(line);
                List<Integer> integerList = new ArrayList<>();
                while (matcher.find()) {
                    integerList.add(Integer.parseInt(matcher.group()));
                }
                PaymentAccount payAcc = instance.readPayAcc(integerList.get(0));
                Bank bank = bankService.readBank(integerList.get(1));

                System.out.println("Before: \n");
                System.out.println(payAcc);
                payAcc.setBank(bank);
                payAcc.setBankName();
                System.out.println("After: \n");
                System.out.println(payAcc);
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
