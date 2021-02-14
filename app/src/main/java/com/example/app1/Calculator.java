package com.example.app1;

public class Calculator {

  public int Count(int x, int y, String condition) {
      if (condition == "sum") {return x+y;}
      else if (condition == "prod") {return x*y;}
      else if (condition == "diff") {return x-y;}
      else if (condition == "quot") {return x/y;}
      else {return -01010101;}
  }
  }





