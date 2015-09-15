package day12.lessons.frame04;

/**
 * Created by IVG 2015
 */
public interface ATM {

    public void checkBalance(long accountId);

    public void withdrawMoney(long accountId, int amount);
}
