package com.aopdemo;

import com.dao.AccountDAO;
import com.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAcccountDao = context.getBean("accountDAO", AccountDAO.class);


        // get membership bean from spring container
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call the business method
        Account myAccount = new Account();
        theAcccountDao.addAccount(myAccount, true);
        theAcccountDao.doWork();

        // call the membership business method
        theMembershipDAO.addSillyAccount();
        theMembershipDAO.goToSleep();
/*        // do it again
        System.out.println("\n let's call it again!\n");

        // call the business method again
        theAcccountDao.addAccount();*/

        // close the context
        context.close();
    }
}
