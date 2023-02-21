package lab1;
/**
*
* @author Dascalu Rares-Vasilica A5
*/

public class Lab1 {
    
 public static void main(String args[]) {
Lab1 lab1 = new Lab1();
lab1.compulsory();
 }
 void compulsory() {
     
 System.out.println("Hello World!");
 
 String languages[]= {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
 
 int n = (int) (Math.random() * 1_000_000);
 int sum=0,digit;
 
 n=((n*3)+0b10101+0xFF)*6;
    while(n>9)
    {
    while(n>0)
    {
        digit=n%10;
        sum=sum+digit;
        n=n/10;
    }
    n=sum;
    sum=0;
    }
    int result=n;
    System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
 }
}