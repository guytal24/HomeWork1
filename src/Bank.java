import java.util.ArrayList;
import java.util.List;

    public class Bank implements IBank {

        List<IAccount> bankList;
        public Bank(){
            this.bankList = new ArrayList<IAccount>();
        }

        @Override
        public void OpenAccount(IAccount account) {
            this.bankList.add(account);
        }

        @Override
        public void CloseAccount(int accountNumber) {
            for(int i = 0; i < this.bankList.size(); i++){
                int tempAccount = this.bankList.get(i).GetAccountNumber();
                if(tempAccount == accountNumber){
                    if(this.bankList.get(i).GetCurrentBalance() < 0){
                        System.out.println("Sorry, this bank account number: "+ this.bankList.get(i).GetAccountNumber() +" cannot be closed at this time due to debt");
                    }
                    else{
                        this.bankList.remove(i);
                    }
                    break;
                }
            }
        }

        @Override
        public List<IAccount> GetAllAccounts() {
            return this.bankList;
        }

        @Override
        public List<IAccount> GetAllAccountsInDebt() {
            List<IAccount> inDebtList = new ArrayList<>();

            for(int i = 0; i < this.bankList.size(); i++){
                if(this.bankList.get(i).GetCurrentBalance() < 0){
                    inDebtList.add(this.bankList.get(i));
                }
            }

            return inDebtList;
        }

        @Override
        public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
            List<IAccount> aboveBalanceList = new ArrayList<>();

            for(int i = 0; i < this.bankList.size(); i++){
                if(this.bankList.get(i).GetCurrentBalance() > balanceAbove){
                    aboveBalanceList.add(this.bankList.get(i));
                }
            }

            return aboveBalanceList;
        }

    }

