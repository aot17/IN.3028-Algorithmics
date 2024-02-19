package ch.unifr.algo2023.teacher.calculator;

import ch.unifr.algo2023.teacher.fundamentals.IQueue;

public interface IShuntingYardAlgorithm {
    IQueue<Token> convertToRPN(IQueue<Token> input);
}
