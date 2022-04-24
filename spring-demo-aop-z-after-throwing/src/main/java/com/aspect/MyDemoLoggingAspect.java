package com.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.ForkJoinTask;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @AfterThrowing(
            pointcut = "execution(* com.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint, Throwable theExc){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=======>>>>> Executing @AfterThrowing on method:" + method);

        // log the exception
        System.out.println("\n=======>>>>> The Exception is:" + theExc);

    }
    @AfterReturning(
            pointcut = "execution(* com.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(
            JoinPoint theJoinPoint, List<Account> result){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=======>>>>> Executing @AfterReturning on method:" + method);

        // print out the results of the method call
        System.out.println("\n=======>>>>> result is: " + result);

        // let's post-process the data.. let's modify it

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n=======>>>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts

        for(Account tempAccount : result){
            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);
        }
    }


    @Before("com.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJointPoint){
        System.out.println("\n=======>>> Executing @Before advice on addAccount");

        // display the method signature
        MethodSignature methodSig = (MethodSignature) theJointPoint.getSignature();

        System.out.println("Method: "+ methodSig);
        // display method arguments

        // get args
        Object[] args = theJointPoint.getArgs();

        // loop through args
        for(Object tempArg : args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){
                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("account name: "+ theAccount.getName());
                System.out.println("account level: "+ theAccount.getLevel());

            }
        }
    }




}
