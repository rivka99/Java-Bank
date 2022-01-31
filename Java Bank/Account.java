/*
 This class is a generalized class of which several specific classes are made. 
This class allows for there to be an arrayList of accounts of various types.
 */
package homework4;

public abstract class Account {
    public Currency balance;
    public Account(Currency initialDeposit){
      balance = initialDeposit;
    }
   
public abstract void withdraw(Currency money);
public abstract void deposit(Currency money);
abstract Currency getBalance();
}
