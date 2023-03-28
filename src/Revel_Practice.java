public class Revel_Practice {



}


class BankAccount {

    static double balance;


    BankAccount (String name) {}

    static double getBalance() {
        return balance;
    }

    static void withdraw(double amount) {
        balance -= amount;
    }

    public class CheckingAccount extends BankAccount{

        private final boolean overdraft;

        CheckingAccount(String name, boolean overdraft) {
            super(name);
            this.overdraft = overdraft;
        }

        public boolean hasOverdraft() {
            return overdraft;
        }

        public boolean clearCheck(double amount) {
            if (amount < getBalance() || hasOverdraft()) {
                withdraw(amount);
                return true;
            } else {
                return false;
            }
        }


    }

}



