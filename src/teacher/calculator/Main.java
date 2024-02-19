package ch.unifr.algo2023.teacher.calculator;

//This is the main class for the calculator to be executed

public class Main {
    public static void main(String[] args) {
        new Calculator(new RpnEvaluationAlgorithm(), new ShuntingYardAlgorithm());
    }
}
