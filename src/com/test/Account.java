package com.test;

public class Account {
    public final double MIN = 200.0;
    public final double FEE = 25.0;
    private int accountid = 0;
    private String Name;
    private boolean Type;
    private double Balance;

    public Account(String tempName, boolean tempType, double tempBalance){
        Name = tempName;
        setType(tempType);
        if (tempBalance > 0)
        setBalance(tempBalance);
        else
            Balance = 0;
        accountid++;
    }

    public Account(String tempName, String tempType, double tempBalance){
        Name = tempName;
        setType(tempType);
        if (tempBalance > 0)
            setBalance(tempBalance);
        else
            Balance = 0;
        accountid++;
    }

    public Account(String tempName, boolean tempType){
        Name = tempName;
        setType(tempType);
        Balance = 0;
        accountid++;
    }

    public Account(String tempName, String tempType){
        Name = tempName;
        setType(tempType);
        Balance = 0;
        accountid++;
    }

    public int getID(){
        return accountid;
    }

    public String getName(){
        return Name;
    }

    public String getType(){
        if (Type)
            return "Checking";
        else
            return "Saving";
    }

    public double getBalance(){
        return Balance;
    }

    public void setName(String tempName){
        Name = tempName;
    }

    public void setType(boolean tempType){
        Type = tempType;
    }

    public boolean setType(String tempType){
        if (tempType.toLowerCase().equals("saving")) {
            Type = false;
            return true;
        }
        else if (tempType.toLowerCase().equals("checking")){
            Type = true;
            return true;
        }
        Type = false;
        return false;
    }

    public boolean setBalance(double tempBalance){
        if (tempBalance >= 0.0){
        Balance = tempBalance;
        return true;
        }
        return false;
    }

    public boolean withdraw(double amnt){
        if (getBalance() > amnt + MIN)
            return setBalance(Balance-amnt);
        else if (getBalance() + FEE > 0)
            return setBalance(Balance-(FEE+amnt));
        else
            return false;
    }

    public String toString(){
        return (Name +"'s " + Type + " account has a balance of: " + Balance);
    }

    public boolean equals (Object x) {
        if (x instanceof Account){
            Account g = (Account)x;
            if (Name == g.getName() && getType().equals(g.getType()) && Balance == g.getBalance())
                return true;
            else
                return false;
        }
        else
            return false;
    }

    public boolean transfer(Account take, double amnt){
        if (Name.equals(take.getName())) {
            if (take.withdraw(amnt)) {
                return setBalance(Balance + amnt);
            } else
                return false;
        }
        else
            return false;
    }

}