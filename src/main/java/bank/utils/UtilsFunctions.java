package bank.utils;

public class UtilsFunctions {
    /**
     * Метод получения псевдослучайного целого числа от min до max (включая max);
     */
    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static boolean getRandomBooleanValue()
    {
        return rnd(0,1) == 1;
    }
}
