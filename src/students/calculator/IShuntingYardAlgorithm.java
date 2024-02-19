package ch.unifr.algo2023.students.calculator;

import ch.unifr.algo2023.students.fundamentals.IQueue;

public interface IShuntingYardAlgorithm {
    IQueue<Token> convertToRPN(IQueue<Token> input);
}
