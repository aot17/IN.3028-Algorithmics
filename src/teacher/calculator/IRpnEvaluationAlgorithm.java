package ch.unifr.algo2023.teacher.calculator;

import ch.unifr.algo2023.teacher.fundamentals.IQueue;

public interface IRpnEvaluationAlgorithm {
    double evaluateExpression(IQueue<Token> inputQueue);
}
