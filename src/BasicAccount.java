public class BasicAccount implements IAccount{

    private int accountNum;
    private int countWithdraw;
    private double withdrawalLimit;
    private double accountBalance;

    public BasicAccount(int accountNumber, double withdrawalLimit){
        this.accountNum = accountNumber;
        this.withdrawalLimit = withdrawalLimit;
        this.accountBalance = 0.0;
        this.countWithdraw = 0;
    }

    @Override
    public double GetCurrentBalance() {
        return this.accountBalance;
    }

    @Override
    public double Withdraw(double amount) {
        if(this.countWithdraw > 0) {
            return 0.0;
        } else {
            this.countWithdraw++;
        }

        if(this.withdrawalLimit < amount && this.withdrawalLimit > this.accountBalance) {
            double w = this.accountBalance;
            this.accountBalance = 0.0;
            return w;
        } else if(this.withdrawalLimit < amount) {
            this.accountBalance = this.accountBalance - this.withdrawalLimit;
            return this.withdrawalLimit;
        } else {
            this.accountBalance = this.accountBalance - amount;
            return amount;
        }
    }

    public int GetAccountNumber() {
        return accountNum;
    }

    @Override
    public void Deposit(double amount){
        this.accountBalance = this.accountBalance + amount;
    }
}

