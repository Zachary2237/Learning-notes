package Lab1;

public class CheckAccount extends Account{
    private double overdraft;
    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }
    public double getOverdraft(){
        return overdraft;
    }
    public void withdraw(double amount){
        if(amount <= getBalance()){
            //方法一:
            //super.withdraw(amount);
            //方法二:
            balance = getBalance() - amount;
        }
        if(amount > getBalance()){
            double needMoney = amount - getBalance();
            if(overdraft >= needMoney){
                overdraft -= needMoney;
                balance = 0;
            }else{
                System.out.println("超过可透支限额!");
            }
        }
    }
}
