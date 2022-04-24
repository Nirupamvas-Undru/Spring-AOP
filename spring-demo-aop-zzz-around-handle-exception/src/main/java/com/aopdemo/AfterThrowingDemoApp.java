package com.aopdemo;

import com.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAcccountDao = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> theAccounts = null;
        try {
            // add a boolean flag to simulate exceptions
            boolean tripWire = true;
            theAccounts = theAcccountDao.findAccounts(tripWire);
        }
        catch (Exception ex){
            System.out.println("\n\n Main Program... caught exception: "+ex);
        }
        // display the accounts
        System.out.println("\n\nMain Program: AfterThrowingDemoAPp");
        System.out.println("-----");

        System.out.println(theAccounts);

        System.out.println("\n");

        // close the context
        context.close();
    }
}
