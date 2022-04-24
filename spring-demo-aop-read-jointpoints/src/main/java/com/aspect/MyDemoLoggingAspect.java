package com.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

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
