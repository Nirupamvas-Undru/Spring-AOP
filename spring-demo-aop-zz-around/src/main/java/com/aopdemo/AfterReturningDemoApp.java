package com.aopdemo;

import com.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAcccountDao = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> theAccounts = theAcccountDao.findAccounts(false);

        // display the accounts
        System.out.println("\n\nMain Program: AfterReturningDemoAPp");
        System.out.println("-----");

        System.out.println(theAccounts);

        System.out.println("\n");

        // close the context
        context.close();
    }
}
