package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;
    int nWithdraw;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
        this.nWithdraw = 0;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public int getnWithdraw() {
        return nWithdraw;
    }

    public void setnWithdraw(int nWithdraw) {
        this.nWithdraw = nWithdraw;
    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(nWithdraw > maxWithdrawalLimit){
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        if(amount > super.getBalance()){
            throw new Exception("Insufficient Balance");
        }

        super.setBalance(super.getBalance() - amount);
        nWithdraw++;
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        return super.getBalance() * rate * years * super.getBalance();

    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        return super.getBalance() * Math.pow(1 + rate / times, years);
    }

}
