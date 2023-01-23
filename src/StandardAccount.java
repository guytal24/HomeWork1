public class StandardAccount implements IAccount {

    private int accountNumber;
    private double creditLimit;
    private double accountBalance;


    public StandardAccount(int accountNumber, double creditLimit){
        this.accountNumber = accountNumber;
        if(creditLimit > 0) {
            this.creditLimit = 0;
        }
        else{
            this.creditLimit = creditLimit;
        }
        this.accountBalance = 0.0;
    }

    @Override
    public double GetCurrentBalance() {
        return this.accountBalance;
    }

    @Override
    public double Withdraw(double amount) {

        if(amount > this.accountBalance - this.creditLimit){
            amount = this.accountBalance - this.creditLimit;
            this.accountBalance = this.creditLimit;
            return amount;
        } else if(this.accountBalance == this.creditLimit){
            return 0.0;
        } else {
            this.accountBalance = this.accountBalance - amount;
            return amount;
        }
    }

    @Override
    public void Deposit(double amount) {
        this.accountBalance = this.accountBalance + amount;
    }


    @Override
    public int GetAccountNumber(){
        return this.accountNumber;
    }
}
