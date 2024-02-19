package students;

import ch.unifr.algo2023.students.calculator.ShuntingYardAlgorithm;
import ch.unifr.algo2023.students.calculator.Token;
import ch.unifr.algo2023.students.fundamentals.ArrayQueue;
import ch.unifr.algo2023.students.fundamentals.IQueue;
import org.junit.Test;

public class ShuntingYardAlgorithmTest {

    @Test
    public void convertToRPN() {
        ArrayQueue<Token> inQ = new ArrayQueue<>();
        Token three = new Token(3), plus = new Token(Token.OperatorType.Plus), four = new Token(4);

        inQ.enqueue(three);
        inQ.enqueue(plus);
        inQ.enqueue(four);

        IQueue<Token> outQ = new ShuntingYardAlgorithm().convertToRPN(inQ);

        assert outQ.dequeue() == three;
        assert outQ.dequeue() == four;
        assert outQ.dequeue() == plus;
    }
}