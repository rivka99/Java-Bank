/*
 this class holds the money for each account, the money is held in cents. 
 */
package homework4;


public class Currency {
 private int cents;
 public Currency(){
     cents=0;
 }
 public Currency(int cents){
     this.cents=cents;
 }
 public int getValue(){
     return cents;
 }
 //adds the cents of 2 currencies 
 public Currency add (Currency other){
      Currency new1 = new Currency();
      new1.cents = this.cents +other.cents;
    return new1;
 }
 //subtracts the cents of 2 currencies
 public Currency subtract (Currency other){
   Currency new2 = new Currency();
     new2.cents = this.cents-other.cents;
    
  return new2;
 }
 public Currency subtract1(Currency main, Currency other){
     Currency new2 = new Currency();
     new2.cents = main.cents-other.cents;
     return new2;
 }
 public void setCents(int cents){
      this.cents=cents;
 }
 @Override
 public String toString(){
     double dollars = cents/60;
     return "$" + dollars;
 }
}

