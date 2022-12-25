package Source.practice8;

public class Account {

    private int id;
    private String passward = "000000";
    private double balance;

    private static double interestRate;
    private static double minMoney = 1.0;
    private static int init = 1001;

    public Account() {
        id = init++;
    }

    public Account(String passward, double balance){
        id = init++;
        this.passward = passward;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public double getBalance() {
        return balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    public static double getMinMoney() {
        return minMoney;
    }

    public static void setMinMoney(double minMoney) {
        Account.minMoney = minMoney;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", passward='" + passward + '\'' +
                ", balance=" + balance +
                '}';
    }
}
