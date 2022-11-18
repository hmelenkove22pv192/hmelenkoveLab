package bank.utils;

import bank.entity.Bank;
import bank.entity.BankOffice;

import java.util.HashMap;
import java.util.Map;

public class UtilsFunctions {
    /**
     * Метод получения псевдослучайного целого числа от min до max (включая max);
     */
    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
