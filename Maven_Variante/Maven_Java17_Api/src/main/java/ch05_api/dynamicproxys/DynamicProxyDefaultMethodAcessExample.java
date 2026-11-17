package ch05_api.dynamicproxys;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class DynamicProxyDefaultMethodAcessExample
{

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
                    IllegalArgumentException, InvocationTargetException
    {
        var instance = new ExampleClass();
        var classLoader = ExampleIf.class.getClassLoader();
        var proxy = (ExampleIf) Proxy.newProxyInstance(classLoader,
                                                       new Class[] { ExampleIf.class },
                                                       new DynamicInvocationHandler(instance));
        
        System.out.println(proxy.msgDefault());
        System.out.println(proxy.greeting());

        ExampleIf newProxy = (ExampleIf) Proxy.newProxyInstance(classLoader,
                                                                new Class[] { ExampleIf.class },
                                                                new DynamicInvocationHandlerV2(instance));
        
        System.out.println(newProxy.msgDefault());
        System.out.println(newProxy.greeting());
    }

    public static class SimpleInvocationHandler implements InvocationHandler
    {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
        {
            System.err.println("Invoked method: %s".formatted(method.getName()));
    
            if (method.isDefault())
            {
                // if it's a default method, invoke it
                return InvocationHandler.invokeDefault(proxy, method, args);
            }
            
            return "42";
        }
    }

    public static class DynamicInvocationHandler implements InvocationHandler
    {
        private final Object target;
    
        public DynamicInvocationHandler(Object target)
        {
            this.target = target;
        }
    
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
        {
            System.err.println("Invoked method: %s".formatted(method.getName()));
    
            return method.invoke(target, args);
        }
    }

    public static class DynamicInvocationHandlerV2 implements InvocationHandler
    {
        private Object target;
    
        public DynamicInvocationHandlerV2(Object target)
        {
            this.target = target;
        }
    
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
        {
            System.err.println("Invoked method: %s".formatted(method.getName()));
    
            if (method.isDefault())
            {
                // if it's a default method, invoke it
                return InvocationHandler.invokeDefault(proxy, method, args);
            }
    
            return method.invoke(target, args);
        }
    }
}
