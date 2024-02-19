package ch.unifr.algo2023.teacher.calculator;

import ch.unifr.algo2023.teacher.fundamentals.ArrayStack;
import ch.unifr.algo2023.teacher.fundamentals.IQueue;
import ch.unifr.algo2023.teacher.fundamentals.IStack;

public class RpnEvaluationAlgorithm implements IRpnEvaluationAlgorithm {
    @Override
    public double evaluateExpression(IQueue<Token> inputQueue) {
        IStack<Token> operandStack = new ArrayStack<>();

        while (!inputQueue.isEmpty()) {

            Token current = inputQueue.dequeue();

            switch (current.type) {
                case Numeric:
                    operandStack.push(current);
                    break;

                case Operator:
                    Token op2 = operandStack.pop();
                    Token op1 = operandStack.pop();

                    switch (current.asOperator) {
                        case Plus:
                            operandStack.push(new Token(op1.asNumber + op2.asNumber));
                            break;
                        case Minus:
                            operandStack.push(new Token(op1.asNumber - op2.asNumber));
                            break;
                        case Multiply:
                            operandStack.push(new Token(op1.asNumber * op2.asNumber));
                            break;
                        case Divide:
                            operandStack.push(new Token(op1.asNumber / op2.asNumber));
                            break;
                        case Power:
                            operandStack.push(new Token(Math.pow(op1.asNumber, op2.asNumber)));
                            break;
                    }
                    break;

                case Function:
                    Token arg = operandStack.pop(); //unary fct

                    switch (current.asFunction) {
                        case Sin:
                            operandStack.push(new Token(Math.sin(arg.asNumber)));
                            break;
                        case Cos:
                            operandStack.push(new Token(Math.cos(arg.asNumber)));
                            break;
                        case Exp:
                            operandStack.push(new Token(Math.exp(arg.asNumber)));
                            break;
                    }
                    break;
            }
        }

        return operandStack.pop().asNumber;
    }
}
