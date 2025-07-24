package org.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculate {

  private static final Logger LOGGER = LogManager.getLogger(Calculate.class);
  private double firstNumber;
  private double secondNumber;

  public Calculate(Values value) {
    this.firstNumber = value.firstNumber;
    this.secondNumber = value.secondNumber;
    LOGGER.info("Values entered {},{}", value.firstNumber, value.secondNumber);
  }

  public static class Values {

    private double firstNumber;
    private double secondNumber;

    public Values firstNumber(double firstNumber) {
      this.firstNumber = firstNumber;
      return this;
    }

    public Values secondNumber(double secondNumber) {
      this.secondNumber = secondNumber;
      return this;
    }

    public Calculate build() {
      return new Calculate(this);
    }
  }

  public double addition() {
    double result = this.firstNumber + this.secondNumber;
    LOGGER.info("Addition result :: {}", result);
    return result;
  }

  public double substraction() {
    double result = this.firstNumber - this.secondNumber;
    LOGGER.info("Substraction result :: {}", result);
    return result;
  }

  public double multiplication() {
    double result = this.firstNumber * this.secondNumber;
    LOGGER.info("Multiplication result :: {}", result);
    return result;
  }

  public double divide() {
    double result = 0;
    if (this.secondNumber > 0.0 || this.secondNumber < 0) {
      result = this.firstNumber / this.secondNumber;
      LOGGER.info("Division result :: {}", result);
      return result;
    }else{
      LOGGER.error("Divide by zero is not possible!");
      throw new ArithmeticException();
    }
  }
}
