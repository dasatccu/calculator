package org.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller exposing basic calculator operations.
 */
@RestController
@RequestMapping("/calculate")
public class CalculatorController {

  private static final Logger LOGGER = LogManager.getLogger(CalculatorController.class);

  /**
   * Adds two numbers.
   * @param a First number
   * @param b Second number
   * @return Sum of a and b
   */
  @GetMapping("/add")
  public Double add(@RequestParam double a, @RequestParam double b) {
    LOGGER.info("Received add request: {} + {}", a, b);
    double result = new Calculate.Values().firstNumber(a).secondNumber(b).build().addition();
    LOGGER.info("Addition result: {}", result);
    return result;
  }

  /**
   * Subtracts b from a.
   * @param a First number
   * @param b Second number
   * @return Difference of a and b
   */
  @GetMapping("/sub")
  public double subtract(@RequestParam double a, @RequestParam double b) {
    LOGGER.info("Received subtract request: {} - {}", a, b);
    double result = new Calculate.Values().firstNumber(a).secondNumber(b).build().substraction();
    LOGGER.info("Subtraction result: {}", result);
    return result;
  }

  /**
   * Multiplies two numbers.
   * @param a First number
   * @param b Second number
   * @return Product of a and b
   */
  @GetMapping("/mul")
  public double multiply(@RequestParam double a, @RequestParam double b) {
    LOGGER.info("Received multiply request: {} * {}", a, b);
    double result = new Calculate.Values().firstNumber(a).secondNumber(b).build().multiplication();
    LOGGER.info("Multiplication result: {}", result);
    return result;
  }

  /**
   * Divides a by b.
   * @param a Dividend
   * @param b Divisor
   * @return Quotient of a and b
   * @throws IllegalArgumentException when b is 0
   */
  @GetMapping("/div")
  public double divide(@RequestParam double a, @RequestParam double b) {
    LOGGER.info("Received divide request: {} / {}", a, b);
    try {
      double result = new Calculate.Values().firstNumber(a).secondNumber(b).build().divide();
      LOGGER.info("Division result: {}", result);
      return result;
    } catch (ArithmeticException e) {
      LOGGER.error("Division by zero error with input a={}, b={}", a, b);
      throw new IllegalArgumentException("Division by zero is not allowed.");
    }
  }
}
