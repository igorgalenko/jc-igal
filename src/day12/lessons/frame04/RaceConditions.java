package day12.lessons.frame04;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by IVG 2015
 */
public class RaceConditions {

    public static void main(String[] args) {

        Random random = new Random();

        long husband = 111;
        long wife = 222;

        ATM atm = new LegacyATM();

        Set<Runnable> threads = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            threads.add(createWithdrawThread(atm, wife, random.nextInt(1000)));
            threads.add(createWithdrawThread(atm, husband, random.nextInt(1000)));
        }

        for (Runnable runnable : threads) {
            new Thread(runnable).start();
        }
    }

    private static Runnable createWithdrawThread(final ATM atm, final long accountId, final int amount) {
        return new Runnable() {
            @Override
            public void run() {
                atm.checkBalance(accountId);
                atm.withdrawMoney(accountId, amount);
            }
        };
    }

}
