package com.academy2024.task1;

public class Calculator {

    public int addNumber(int numberOne, int numberTwo) {

        return numberOne + numberTwo;
    }

    public int subtractNumber(int numberOne, int numberTwo) {

        return numberOne - numberTwo;
    }

    public int multiplyNumber(int numberOne, int numberTwo) {

        return numberOne * numberTwo;
    }

    //bonus to implement it with exception
    public int divideNumber(int numberOne, int numberTwo) throws ArithmeticException {

        if (numberTwo == 0) {
            throw new ArithmeticException("Cannot divide by 0");
        }
        return numberOne / numberTwo;
    }

    public int findRemainder(int numberOne, int numberTwo) {

        if (numberTwo == 0) {
            throw new ArithmeticException("Cannot divide by 0");
        }
        return numberOne % numberTwo;
    }
}
