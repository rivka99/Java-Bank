/*
This is the class for the account of type savings, it allows for both deposit and withdrawal, but it
also has an interest rate
 */
package homework4;


public class Savings extends Account {
    private final double interestRate ;
   public Savings(Currency money, double interestRate){
     super(new Currency(money.getValue() * (int)(1+interestRate)));
       this.interestRate = interestRate;
     
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
           //this.balance= balance.subtract(amount);
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
    //interest rate is applied to the balance here
    public Currency getBalance(){
        double hold = (balance.getValue()/100)*(1+interestRate);
        
        int holdInt = (int)(hold * 100);
        
        Currency newBalance = new Currency(holdInt);
     //   newBalance.setCents( balance.getValue() * (1=interestRate));
    return newBalance;
}
}
