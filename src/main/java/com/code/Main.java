package com.code;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
  public static void main(String[] args) {
    Apple apple = new Apple();
    apple.setPrice(4);

    try {
      Class clazz = Class.forName("com.code.Apple");
      Method method = clazz.getMethod("setPrice", int.class);
      Constructor constructor = clazz.getConstructor();
      Object object = constructor.newInstance();
      method.invoke(object, 5);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}

class Apple {

  int price = 0;

  public Apple() {

  }

  public void setPrice(int... prices) {
    this.price = prices[0];
    System.out.println("setPrice = " + price);
  }
}