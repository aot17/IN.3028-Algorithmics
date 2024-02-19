package students;

import ch.unifr.algo2023.students.calculator.RpnEvaluationAlgorithm;
import ch.unifr.algo2023.students.calculator.Token;
import ch.unifr.algo2023.students.fundamentals.ArrayQueue;
import org.junit.Test;

public class RpnEvaluationAlgorithmTest
{

    @Test
    public void evaluateExpression()
    {
        ArrayQueue<Token> tokenQueue = new ArrayQueue<>();

        tokenQueue.enqueue(new Token(5));
        tokenQueue.enqueue(new Token(4));
        tokenQueue.enqueue(new Token(Token.OperatorType.Plus));

        assert new RpnEvaluationAlgorithm().evaluateExpression(tokenQueue) == 9;
    }
}