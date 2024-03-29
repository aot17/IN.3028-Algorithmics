package ch.unifr.algo2023.teacher.calculator;

import ch.unifr.algo2023.teacher.fundamentals.IQueue;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public final class Calculator {
    private final JTextField textField;
    private final JLabel modeLabel;

    private enum Mode {
        RPN, IN // reverse polish notation or infix notation
    }

    private Mode mode = Mode.RPN;

    private final IRpnEvaluationAlgorithm evaluationAlgorithm;
    private final IShuntingYardAlgorithm shuntingYardAlgorithm;

    public Calculator(IRpnEvaluationAlgorithm evaluationAlgorithm, IShuntingYardAlgorithm shuntingYardAlgorithm) {
        this.evaluationAlgorithm = evaluationAlgorithm;
        this.shuntingYardAlgorithm = shuntingYardAlgorithm;

        JFrame f = new JFrame("Calculator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField("", 30);
        textField.addActionListener(actionEvent -> evaluate()); // evaluate on enter Key press
        JPanel textPanel = new JPanel();
        modeLabel = new JLabel("RPN:");
        textPanel.add(modeLabel);
        textPanel.add(textField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 5));

        String[] texts = new String[]{"MODE", "(", ")", "⌫", "DEL", "7", "8", "9", "/", "^", "4", "5", "6", "*", "sin", "1", "2", "3", "-", "cos", "0", ".", "␣", "+", "exp",};

        Arrays.stream(texts).map(JButton::new).forEach(button -> {
            button.addActionListener(actionEvent -> onButtonClick(button.getText()));
            buttonPanel.add(button);
        });

        JPanel evalPanel = new JPanel();
        JButton evalButton = new JButton("Evaluate");
        evalButton.addActionListener(actionEvent -> evaluate());
        evalPanel.add(evalButton);

        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));
        masterPanel.add(textPanel);
        masterPanel.add(buttonPanel);
        masterPanel.add(evalPanel);

        f.getContentPane().add(masterPanel);
        f.pack();
        f.setVisible(true);
    }

    private void switchMode() {
        if (mode == Mode.IN) {
            modeLabel.setText("RPN:");
            mode = Mode.RPN;
            if (shuntingYardAlgorithm != null && !textField.getText().equals("")) {
                IQueue<Token> q = shuntingYardAlgorithm.convertToRPN(Token.tokenize(textField.getText()));
                StringBuilder str = new StringBuilder();
                while (!q.isEmpty())
                    str.append(q.dequeue());
                textField.setText(str.toString());
            } else {
                textField.setText("");
            }
        } else {
            modeLabel.setText("IN:");
            mode = Mode.IN;
        }
    }

    private void evaluate() {
        IQueue<Token> input = Token.tokenize(textField.getText());
        if (mode == Mode.IN) {
            input = shuntingYardAlgorithm.convertToRPN(input);
        }

        double result = evaluationAlgorithm.evaluateExpression(input);
        if (result - Math.round(result) == 0.0) {
            textField.setText(Long.toString(Math.round(result)) + " ");
        } else {
            textField.setText(Double.toString(result) + " ");
        }
        textField.requestFocus();
    }

    private void onButtonClick(String button) {
        switch (button) {
            case "MODE":
                switchMode();
                break;
            case "DEL":
                textField.setText("");
                break;
            case "␣":
                textField.setText(textField.getText() + " ");
                break;
            case "⌫":
                if (textField.getText().length() > 0) {
                    textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
                }
                break;
            default:
                textField.setText(textField.getText() + button + (Character.isDigit(button.charAt(0)) || mode == Mode.IN ? "" : " "));
        }
        textField.requestFocus(); // allow continued keyboard input
    }

}
