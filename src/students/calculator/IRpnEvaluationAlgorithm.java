package ch.unifr.algo2023.students.calculator;

import ch.unifr.algo2023.students.fundamentals.IQueue;

public interface IRpnEvaluationAlgorithm {
    double evaluateExpression(IQueue<Token> inputQueue);
}
