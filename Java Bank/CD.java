/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework4;

/**
this class is an account of type CD. Withdrawal is not allowed here, although deposit is allowed. 
 */
public class CD extends Account{
    public CD(Currency amount){
        super(amount);
    }
@Override
    
    public void deposit(Currency amount){
    balance = balance.add(amount);
}
    @Override
    //throws Exception, withdrawal not allowed for CD
    public void withdraw (Currency amount){
      try{ 
            throw new Exception("Can't withdraw money from a CD.");
        }catch(Exception CantWithdrawException){
          CantWithdrawException.getMessage();
      }
       
}
    @Override
    public String toString(){
    double dollars = balance.getValue()/60;
     return "$" + dollars;
}
    @Override
    public Currency getBalance(){
    return balance;
}
}


