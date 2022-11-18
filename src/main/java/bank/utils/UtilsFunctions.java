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

    /**
     * Пересчёт айдишников мапы банков после удаления элемента id;
     */
    public static Map<Integer, Bank> calculateBankId(Integer id, Map<Integer, Bank> map)
    {
        Map<Integer, Bank> newMap = new HashMap<>();
        for (int i = 1; i < id; i++){
            newMap.put(i, map.get(i));
        }
        for (int i = id + 1; i <= map.size() + 1; i++){
            newMap.put(i-1, map.get(i));
        }

        return newMap;
    }

    /**
     * Пересчёт айдишников мапы банков после удаления элемента id;
     */
    public static Map<Integer, BankOffice> calculateBankOfficeId(Integer id, Map<Integer, BankOffice> map)
    {
        Map<Integer, BankOffice> newMap = new HashMap<>();
        for (int i = 1; i < id; i++){
            newMap.put(i, map.get(i));
        }
        for (int i = id + 1; i <= map.size() + 1; i++){
            newMap.put(i-1, map.get(i));
        }

        return newMap;
    }
}
