package com.aggregate.client;

interface A{
  int f();
}

interface B{
  int f();
}

class Test implements A, B{
  public static void main(String... args) throws Exception{

    A a = new Test();
    B b = new Test();

    System.out.println("sss"+a.f());



  }

  @Override
  public int f() {  // from which interface A or B
    return 0;
  }
}
