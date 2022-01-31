/*
This class is the class for the account of type Checking. This class allows for both deposit and withdrawal 
 */
package homework4;


public class Checking extends Account {
    public Checking(Currency Amount){
        super(Amount);
    }

    @Override
    public void deposit(Currency amount){
    balance = balance.add(amount);
}
    @Override
    public void withdraw (Currency amount){
      try{ if(balance.getValue()-amount.getValue() < 0){
            throw new Exception("Can't withdraw more money than you already have in the account.");
        }else
         balance = balance.subtract1(balance, amount);
      }catch(Exception AccountOverdrawnException){
          AccountOverdrawnException.getMessage();
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
