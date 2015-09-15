package day12.lessons.frame04;

import java.util.List;

/**
 * Created by IVG 2015
 */
public class LegacyATM implements ATM {

    private int balance;

    public LegacyATM() {
        balance = 10_000;
    }

    @Override
    public void checkBalance(long accountId) {
        System.out.println(accountId + " is checking balance: " + balance);
    }

    @Override
    public synchronized void withdrawMoney(long accountId, int amount) {
        if (allowWithdraw(accountId, amount)) {
            updateBalance(accountId, amount);
        }

    }

    private boolean allowWithdraw(long accountId, int amount) {

        if (balance <= amount) {
            System.out.println("Sorry, " + accountId + ", but you can't withdraw " + amount + " money");
            return false;
        }
        return true;

    }

    private void updateBalance(long accountId, int amount) {
        balance -= amount;
        System.out.println(accountId + " withdrew " + amount + " cash. Balance = "+ balance);
    }
}
