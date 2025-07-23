package org.calculator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

  @Test
  public void testAddition() {
    Calculate calculate = new Calculate.Values().firstNumber(123.45).secondNumber(23.4).build();
    Assert.assertEquals(calculate.addition(),146.85);
  }

  @Test
  public void testSubstractionPositiveValue(){
    Calculate calculate = new Calculate.Values().firstNumber(123.45).secondNumber(23.4).build();
    Assert.assertEquals(calculate.substraction(),100.05);
  }

  @Test
  public void testSubstractionNegativeValue(){
    Calculate calculate = new Calculate.Values().firstNumber(123.45).secondNumber(223.45).build();
    Assert.assertEquals(calculate.substraction(),-100.00);
  }

  @Test
  public void testMultiplication(){
    Calculate calculate = new Calculate.Values().firstNumber(6).secondNumber(4).build();
    Assert.assertEquals(calculate.multiplication(),24);
  }

  @Test
  public void testDividePositive(){
    Calculate calculate = new Calculate.Values().firstNumber(6).secondNumber(2).build();
    Assert.assertEquals(calculate.divide(),3);
  }

  @Test
  public void testDivideNegative(){
    Calculate calculate = new Calculate.Values().firstNumber(6).secondNumber(0).build();
    Assert.assertEquals(calculate.divide(),3);
  }
}