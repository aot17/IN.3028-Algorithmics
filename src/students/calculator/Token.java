package ch.unifr.algo2023.students.calculator;

import ch.unifr.algo2023.students.fundamentals.ArrayQueue;

public final class Token {

    public enum TokenType {
        Numeric, Operator, Bracket, Function
    }

    public enum OperatorType {
        None, Plus, Minus, Multiply, Divide, Power
    }

    public enum Bracket {
        None, Open, Close
    }

    public enum Function {
        None, Sin, Cos, Exp
    }

    public final TokenType type;
    public final double asNumber;
    public final OperatorType asOperator;
    public final Bracket asBracket;
    public final Function asFunction;

    public Token(double number) {
        type = TokenType.Numeric;
        asNumber = number;
        asOperator = OperatorType.None;
        asBracket = Bracket.None;
        asFunction = Function.None;
    }

    public Token(OperatorType operator) {
        assert operator != OperatorType.None;
        type = TokenType.Operator;
        asOperator = operator;
        asNumber = 0;
        asBracket = Bracket.None;
        asFunction = Function.None;
    }

    public Token(Bracket bracket) {
        assert bracket != Bracket.None;
        type = TokenType.Bracket;
        asBracket = bracket;
        asNumber = 0;
        asOperator = OperatorType.None;
        asFunction = Function.None;
    }

    public Token(Function function) {
        assert function != Function.None;
        type = TokenType.Function;
        asFunction = function;
        asBracket = Bracket.None;
        asNumber = 0;
        asOperator = OperatorType.None;
    }

    public int getOperatorPrecedence() {
        assert this.type == TokenType.Operator;
        switch (asOperator) {
            case Power:
                return 3;
            case Divide:
            case Multiply:
                return 2;
            case Plus:
            case Minus:
                return 1;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static ArrayQueue<Token> tokenize(String input) {
        ArrayQueue<Token> tokenQueue = new ArrayQueue<>();
        for (String s : new String[]{"*", "+", "-", "/", "(", ")", "pi", "sin", "cos", "exp", "^", "e"})
            input = input.replace(s, " " + s + " ");

        for (String s : input.split(" ")) {
            if (s.isEmpty())
                continue;
            switch (s) {
                case "+":
                    tokenQueue.enqueue(new Token(OperatorType.Plus));
                    break;
                case "-":
                    tokenQueue.enqueue(new Token(OperatorType.Minus));
                    break;
                case "*":
                    tokenQueue.enqueue(new Token(OperatorType.Multiply));
                    break;
                case "/":
                    tokenQueue.enqueue(new Token(OperatorType.Divide));
                    break;
                case "^":
                    tokenQueue.enqueue(new Token(OperatorType.Power));
                    break;
                case "(":
                    tokenQueue.enqueue(new Token(Bracket.Open));
                    break;
                case ")":
                    tokenQueue.enqueue(new Token(Bracket.Close));
                    break;
                case "pi":
                    tokenQueue.enqueue(new Token(Math.PI));
                    break;
                case "exp":
                    tokenQueue.enqueue(new Token(Function.Exp));
                    break;
                case "e":
                    tokenQueue.enqueue(new Token(Math.E));
                    break;
                case "sin":
                    tokenQueue.enqueue(new Token(Function.Sin));
                    break;
                case "cos":
                    tokenQueue.enqueue(new Token(Function.Cos));
                    break;
                default:
                    tokenQueue.enqueue(new Token(Double.parseDouble(s)));
                    break;
            }
        }
        return tokenQueue;
    }

    @Override
    public String toString() {
        switch (this.type) {
            case Bracket:
                if (this.asBracket == Bracket.Open)
                    return "( ";
                else
                    return ") ";
            case Operator:
                switch (this.asOperator) {
                    case Plus:
                        return "+ ";
                    case Minus:
                        return "- ";
                    case Multiply:
                        return "* ";
                    case Divide:
                        return "/ ";
                    case Power:
                        return "^ ";
                }
            case Function:
                switch (this.asFunction) {
                    case Sin:
                        return "sin ";
                    case Cos:
                        return "cos ";
                    case Exp:
                        return "exp ";
                }
            case Numeric:
                if (this.asNumber - Math.round(this.asNumber) == 0.0) {
                    return Long.toString(Math.round(this.asNumber)) + " ";
                }
                return Double.toString(this.asNumber) + " ";
        }
        throw new IllegalArgumentException();
    }

}
