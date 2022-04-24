package com.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account theAccount, boolean vipFlag){

        System.out.println(getClass() + ": Doing my DB work:ADDING AN ACCOUNT");
    }

    public boolean doWork(){

        System.out.println(getClass() + ": doWork()");
        return false;
    }
}
