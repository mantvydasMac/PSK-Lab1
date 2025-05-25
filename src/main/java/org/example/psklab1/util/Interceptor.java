package org.example.psklab1.util;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

import java.io.Serializable;
import java.util.logging.Logger;

@jakarta.interceptor.Interceptor
@ExceptionInterceptorBinding
public class Interceptor implements Serializable {
    private static final Logger logger = Logger.getLogger(Interceptor.class.getName());

    @AroundInvoke
    public Object handleExceptions(InvocationContext ctx) throws Exception {
        try {
            return ctx.proceed();
        } catch (IllegalArgumentException e) {
            logger.warning("Caught IllegalArgumentException in method: " + ctx.getMethod().getName());
            // You can optionally rethrow or wrap it
            return null;
        }
    }
}
