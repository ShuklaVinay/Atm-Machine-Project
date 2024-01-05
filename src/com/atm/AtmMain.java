package com.atm;
import java.util.Scanner;
public class AtmMain {
    public static void main(String[] args) {

        AtmOperationInterface op = new AtmOperationImplement();
        int atmPin = 1234;
        System.out.println("Welcome to the SBI ATM Machine!!!");
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter your Atm Pin:");
        int pin=sc.nextInt();
        if(atmPin==pin){
           while (true){
                System.out.println("1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View Ministatement\n5.Exit.");
                System.out.println("Please enter your choice:");
                int ch=sc.nextInt();
                if(ch==1)
                {
                    op.viewBalance();
                } else if (ch==2) {
                    System.out.println("enter amount to Withdraw:");
                    double withdrawAmount=sc.nextDouble();
                    op.withdrawAmount(withdrawAmount);
                } else if (ch==3) {
                    System.out.println("enter amount to deposit:");
                    double depositAmount=sc.nextDouble();
                    op.depositAmount(depositAmount);
                } else if (ch==4) {
                    op.viewMiniStatement();
                } else if (ch==5) {
                    System.out.println("Please collect your ATM card!\nThanks for using SBI ATM Machine!! ");
                    System.exit(0);
                }
                else {
                    System.out.println("Entered wrong choice !!Please enter correct choice");
                }
            }

        }
        else {
            System.out.println("Entered ATM Pin is incorrect!\nPlease enter correct ATM Pin:");
            System.exit(0);
        }
    }
}