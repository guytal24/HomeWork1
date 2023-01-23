public class PremiumAccount implements IAccount{

    int accountNum;
    double accountBalance;

    public PremiumAccount(int accountNumber){
        this.accountNum = accountNumber;
        this.accountBalance = 0.0;
    }

    @Override
    public void Deposit(double amount){
        this.accountBalance = this.accountBalance + amount;
    }
    @Override
    public double Withdraw(double amount){
        this.accountBalance = this.accountBalance - amount;
        return amount;
    }
    @Override
    public double GetCurrentBalance(){
        return this.accountBalance;
    }

    @Override
    public int GetAccountNumber(){
        return this.accountNum;
    }
}