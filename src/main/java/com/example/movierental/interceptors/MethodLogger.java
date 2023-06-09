package com.example.movierental.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@LoggedInvocation
public class MethodLogger implements Serializable {
    @AroundInvoke
    public Object logMethodInvocation(InvocationContext context) throws Exception {
        System.out.println("Bean " + context.getTarget().getClass().getSimpleName() + "'s method called: " + context.getMethod().getName());
        return context.proceed();
    }
}