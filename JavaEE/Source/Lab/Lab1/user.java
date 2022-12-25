package Lab1;

public class user {

    public static void main(String[] args) {
        Account account1 = new Account(1122, 20000, 0.045);
        account1.withdraw(30000);
        System.out.println("您的账户余额为: " + account1.getBalance());
        account1.withdraw(2500);
        account1.deposit(3000);
        System.out.println("您的账户余额为: " + account1.getBalance());
        System.out.println("月利率为: " + account1.getMonthlyInterest());

        CheckAccount checkAccount = new CheckAccount(1122, 20000, 0.0045, 5000);
        checkAccount.withdraw(5000);
        System.out.println("您的账户余额为: " + checkAccount.getBalance());
        System.out.println("您的可透支额: " + checkAccount.getOverdraft());
        checkAccount.withdraw(18000);
        System.out.println("您的可账户余额: " + checkAccount.getBalance());
        System.out.println("你的可透支额: " + checkAccount.getOverdraft());
        checkAccount.withdraw(3000);
        System.out.println("您的账户余额: " + checkAccount.getBalance());
        System.out.println("您的可透支额: " + checkAccount.getOverdraft());
    }
}
