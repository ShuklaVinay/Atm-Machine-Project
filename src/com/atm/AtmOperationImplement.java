package com.atm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class AtmOperationImplement implements AtmOperationInterface{
    Atm at=new Atm();
    Map<Double,String> minist=new HashMap<>();
    @Override
    public void viewBalance() {
        System.out.println("Available balance is:"+at.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if(withdrawAmount%500==0)
        {
            if(withdrawAmount<=at.getBalance()){
                minist.put(withdrawAmount,"Amount Withdrawn.");
                System.out.println("Please collect your cash!"+" "+withdrawAmount);
                at.setBalance(at.getBalance()-withdrawAmount);
                viewBalance();
            }
            else {
                System.out.println("Sorry!! Insufficient Balance.");
            }
        }
        else {
            System.out.println("Please enter the amount in multiple of 500.");
        }

    }

    @Override
    public void depositAmount(double depositAmount) {
    minist.put(depositAmount,"Amount Deposited.");
        System.out.println(depositAmount+" "+"Amount Deposited Successfully!!");
        at.setBalance(at.getBalance()+depositAmount);
        viewBalance();
    }

    @Override
    public void viewMiniStatement() {
        for(Map.Entry<Double,String> m:minist.entrySet())
        {
            System.out.println(m.getKey()+" "+m.getValue());
            LocalDateTime dt=LocalDateTime.now();
            //System.out.println(dt);
            DateTimeFormatter df=DateTimeFormatter.ofPattern("dd/MM/yyyy--E  H:m a ");
            String myDate= dt.format(df);
            System.out.println(myDate);
        }
    }
}
