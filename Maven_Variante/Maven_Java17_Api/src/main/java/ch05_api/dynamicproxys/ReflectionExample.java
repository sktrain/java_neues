package ch05_api.dynamicproxys;

import static java.lang.ClassLoader.getSystemClassLoader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Beispielprogramm für den Workshop "Java 9 Hands On" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class ReflectionExample
{
    public static void main(final String[] args)
                    throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
    {
        Object proxy = Proxy.newProxyInstance(getSystemClassLoader(), new Class<?>[] { HelloWorld.class },
                                              (prox, method, _args) -> {
                                                  if (method.isDefault())
                                                  {
                                                      return InvocationHandler.invokeDefault(prox, method, _args);
                                                  }
                                                  // ...
                                                  return "ORIGINAL CODE";
                                              });
        Method method = proxy.getClass().getMethod("hello");
        System.out.println(method.invoke(proxy));
    }
}
