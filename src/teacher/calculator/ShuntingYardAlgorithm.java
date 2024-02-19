package ch.unifr.algo2023.teacher.calculator;

import ch.unifr.algo2023.teacher.fundamentals.ArrayQueue;
import ch.unifr.algo2023.teacher.fundamentals.ArrayStack;
import ch.unifr.algo2023.teacher.fundamentals.IQueue;
import ch.unifr.algo2023.teacher.fundamentals.IStack;

public class ShuntingYardAlgorithm implements IShuntingYardAlgorithm {
    @Override
    public IQueue<Token> convertToRPN(IQueue<Token> input) {
        IQueue<Token> output = new ArrayQueue<Token>();
        IStack<Token> operatorStack = new ArrayStack<Token>();

        while (!input.isEmpty()) {
            Token current = input.dequeue();

            switch (current.type) {
                case Numeric:
                    output.enqueue(current);
                    break;
                case Operator:
                    while (!operatorStack.isEmpty() && operatorStack.peek().asBracket != Token.Bracket.Open
                            && (operatorStack.peek().type == Token.TokenType.Function || operatorStack.peek().getOperatorPrecedence() > current.getOperatorPrecedence()
                            || (operatorStack.peek().getOperatorPrecedence() == current.getOperatorPrecedence() && operatorStack.peek().asOperator != Token.OperatorType.Power))) {
                        output.enqueue(operatorStack.pop());
                    }

                case Function:
                    operatorStack.push(current);
                    break;

                case Bracket:
                    switch (current.asBracket) {
                        case Open:
                            operatorStack.push(current);
                            break;
                        case Close:
                            while (operatorStack.peek().asBracket != Token.Bracket.Open) {
                                output.enqueue(operatorStack.pop());
                            }
                            if (operatorStack.peek().asBracket == Token.Bracket.Open)
                                operatorStack.pop();
                    }
            }
        }

        while (!operatorStack.isEmpty()) {
            output.enqueue(operatorStack.pop());
        }

        return output;
    }
}
