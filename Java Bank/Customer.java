/*
 This class is used to create customers, the customers name, and the customers accounts. 
This class is called from main for different methods to be called on each account
 */
package homework4;
import java.util.*;
/**
 *
 * @author Bagelnosh
 */
public class Customer {
    private String fName;
    private String lName;
    private int numOfAccnts;
    private int numElements;
   
//creates an array list of accounts
 public ArrayList<Account> accounts = new ArrayList<Account>();
 Currency hold = new Currency(0);
//contrcutor which initializes array 
  public Customer(String first, String last){
      fName = first;
      lName = last;
       for(int i = 0; i<100; i++) {
    Account holAc = new Checking(hold);
  accounts.add(holAc);
}

  }
public void addAccount(Account account, int i){
    accounts.set(i,account);
    
};
//returns the value in an account
public int getAmount(int i){
    return accounts.get(i).balance.getValue()/100;
}
public void setAccountUp(Currency money){
    
}
    
//This method will allow the Customer to open an account.
public String getFirstName(){
    return fName;
}
public String getLastName(){
    return lName;
}
//This will allow customer name to be changed
public void setFirstName(String fName){
     this.fName=fName;
}
public void setLastName(String lName){
    this.lName=lName;
}
//Accessor methods for the Customer class.
public void deposit(Currency money, int k){
    accounts.get(k).deposit(money);
}
public void withdraw(Currency money, int k){
    accounts.get(k).withdraw(money);
}
public int balance(int k){
   return (accounts.get(k).getBalance().getValue())/100;
}

}
