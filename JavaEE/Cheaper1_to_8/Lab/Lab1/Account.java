package Lab1;

public class Account {
    private int id;
    protected double balance;
    private double annualInterestRate;

    public Account(int id, double balance, double annualInterestRate){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId(){
        return id;
    }
    public double getBalance(){
        return balance;
    }
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest(){
        double MonthlyInterest = annualInterestRate / 12;
        return MonthlyInterest;
    }
    public void withdraw(double amount){
        if(balance < amount){
            System.out.println("余额不足!");
        }else{
            balance -= amount;
            System.out.println("取款成功!");
        }
    }
    public void deposit(double amount){
        balance += amount;
        System.out.println("存款成功!");
    }
}
