/*
 @author Rivka Bar-Chaim
@date 12/01/2020
-Bank account project - Homework 4
 */
package homework4;
import java.util.*;

public class Homework4 {

        public static final double savingsInterestRate = .09;
    public static void main(String[] args) {
  
        
        Scanner sc = new Scanner(System.in);
        
        Customer[] bank = new Customer[200];
        String fName="";
        String lName="";
        for(int i = 0; i<200; i++){
            //creates array of customers
        bank[i] = new Customer(fName, lName);
        }
        //hold is the variable that controls where the program directs
        String hold ="";
        int accountsAmount = 0;
        // two do-while loops allow for one user to use the menu multiple times, 
        //for multiple users to use the program, and for the program to be ended entirely
       do{
        do{
            printMenu();
            hold = sc.next();
        
        if(hold.equals("O")){
           openAccount(bank, accountsAmount);
        }
        if(hold.equals("C")){
       openMoneyAccount(bank, accountsAmount);
        }
          if(hold.equals("W")){
       withdraw(bank, accountsAmount);
        }
          if(hold.equals("D")){
       deposit(bank, accountsAmount);
        }
        
        
        if(hold.equals("B")){
            checkBalance(bank, accountsAmount);
              
        }
            
            
        if(hold.equals("Q")){
            System.out.println("Thank you for using this bank. Have a great day!");
        }
        
          //printMenu();
          if(hold.equals("X")){
              break;
          }
      
        }while(!hold.equals("Q"));
           accountsAmount++;
        } while(!hold.equals("X"));
    }
    //prints the menu options
    public static void printMenu(){
        System.out.println("Main Menu:");
        System.out.println("Enter O to add yourself to our customer database");
        System.out.println("Enter B to search for the balance of your account");
        System.out.println("Enter W to withdraw money from your account");
        System.out.println("Enter D to Deposit money into your account");
        System.out.println("Enter C to create a new account");
        System.out.println("Enter Q to quit user session.");
        System.out.println("Enter X to end the program.");
    }
    //opens account for the user, as in it initializes a customer account for the user
    public static void openAccount(Customer[] bank, int accountsAmount){
        try{
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your first name, followed by your last name");
            String fName = sc.next();
            String lName = sc.next();
            
            bank[accountsAmount].setFirstName(fName);
            bank[accountsAmount].setLastName(lName);
            
            System.out.println("Welcome " + fName+" "+lName + " we are glad to have you as a customer");
        }catch(NullPointerException e){
            System.out.println("Null Exception");
        }
    }
    //opens a bank account for a user, this is done by initializing an element of the Account Arraylist in the customer array
    public static void openMoneyAccount(Customer[] bank, int accountsAmount){
         Scanner sc = new Scanner(System.in);
       try{ String holdAccount = "";
            int money;
            System.out.println("Choose what type of account you would like to open, enter CD for a CD, S for savings, and C for Checking:");
            holdAccount = sc.next();
            System.out.println("How much money do you want to have as an initial deposit for this account?");
            money = sc.nextInt();
            Currency holdMoney = new Currency(money*100);
            if(holdAccount.equals("S")){
                Savings holdSave = new Savings (holdMoney, savingsInterestRate);
                bank[accountsAmount].addAccount(holdSave, 0);
            }else if(holdAccount.equals("C")){
                Checking holdCheck = new Checking(holdMoney);
                 bank[accountsAmount].addAccount(holdCheck, 1);
            }else if(holdAccount.equals("CD")){
                CD holdCD = new CD(holdMoney);
                bank[accountsAmount].addAccount(holdCD, 2);
            }
            
        }catch(NullPointerException e){
           System.out.println("null Exception caught.");
        }
    }
    //withdraws money from a specified account
      public static void withdraw(Customer[] bank, int accountsAmount) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter your name");
        
             String fname =""; 
             String lname="";
             int amountMoney = 0;
             try{
           fname = sc.next();
            lname = sc.next();
            System.out.println("Please enter the amount you would like to withdraw, followed by your account type");
            amountMoney = sc.nextInt();
            amountMoney = amountMoney*100;
             Currency holdMoney = new Currency(amountMoney);
           
            int findAccountIndex;
            findAccountIndex = getIndexFromName(fname, lname, bank, 200);
            String holdAccountType;
            holdAccountType = sc.next();
                   
            if(holdAccountType.equals("S")){
                bank[findAccountIndex].withdraw(holdMoney, 0);
            }
             if(holdAccountType.equals("C")){
                 bank[findAccountIndex].withdraw(holdMoney, 1);
             
            }
              if(holdAccountType.equals("CD")){
                  System.out.println("You cannot withdraw from a CD");
            }
              }catch(NullPointerException e){
           System.out.println("null Exception caught.");
           }
      }
      //deposits money into a customer's account
       public static void deposit(Customer[] bank, int accountsAmount){
             Scanner sc = new Scanner(System.in);
             System.out.println("Please enter your name");
            
             String fname =""; 
             String lname="";
             int amountMoney = 0;
             try{
           fname = sc.next();
            lname = sc.next();
            System.out.println("Please enter the amount you would like to deposit, followed by your account type(S, C, or CD)");
            amountMoney = sc.nextInt();
            amountMoney = amountMoney*100;
             Currency holdMoney = new Currency(amountMoney);
           
            int findAccountIndex;
            findAccountIndex = getIndexFromName(fname, lname, bank, 200);
            String holdAccountType;
            holdAccountType = sc.next();
                   
            if(holdAccountType.equals("S")){
                bank[findAccountIndex].deposit(holdMoney, 0);
            }
             if(holdAccountType.equals("C")){
                 bank[findAccountIndex].deposit(holdMoney, 1);
             
            }
              if(holdAccountType.equals("CD")){
                  bank[findAccountIndex].deposit(holdMoney, 2);
            }
              }catch(NullPointerException e){
           System.out.println("null Exception caught.");
           }
        }
        
      //checks the balance of a speicifed customer account
       public static void checkBalance(Customer[] bank, int accountsAmount){
            Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name, followed by your account type(S, C, or CD)");
            //need a for loop method that finds account based on account name...
             String fname =""; 
             String lname="";
              String holdAccountType;
           try{
           fname = sc.next();
            lname = sc.next();
             holdAccountType = sc.next();
           
            int findAccountIndex;
            findAccountIndex = getIndexFromName(fname, lname, bank, 199);
         
                   
            if(holdAccountType.equals("S")){
                
               System.out.println( "you have $" + bank[findAccountIndex].balance(0) +" in your account");
              
            }
             if(holdAccountType.equals("C")){
                 System.out.println( "you have $" + bank[findAccountIndex].getAmount(1) +" in your account");
              
            }
              if(holdAccountType.equals("CD")){
                  System.out.println( "you have $" + bank[findAccountIndex].getAmount(2) +" in your account");
              
            }
              }catch(NullPointerException e){
           System.out.println("null Exception caught.");
           }
              
    }
       //this method is used throughout the program to find the index of a customer based on the customer's name
       //this is useful for when a customer uses the program again after another customer has used it.
    public static int getIndexFromName(String firstName, String lastName, Customer[] bank, int k){
        
        int holdFResult = -1;
        int holdLResult = -1;
        try{
        for(int i = 0; i < k; i++){
            
            if(firstName.equals(bank[i].getFirstName())){
                holdFResult = i;
            }
        }
               for(int i = 0; i < k; i++){
        if(lastName.equals(bank[i].getLastName())){
                holdLResult = i;
            }
        }
          
           if(holdFResult == -1||holdFResult!=holdLResult){
                   throw new Exception("Error, we did not find you in our system");
                   
                
               }
        }catch(Exception e){
            e.getMessage();
        }
       
         return holdFResult;
    }
    
}

