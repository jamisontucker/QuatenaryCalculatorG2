import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {

    private JTextField textField;
    private String currentOp;
    private String firstOperand;
    private boolean isQuaternary = true;

    public UI() {

        JFrame frame = new JFrame();
        textField = new JTextField();
        currentOp = "";
        firstOperand = "";

        JButton button0 = new JButton("0");
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton buttonPlus = new JButton("+");
        JButton buttonSub = new JButton("-");
        JButton buttonMul = new JButton("x");
        JButton buttonDiv = new JButton("/");
        JButton buttonSquare = new JButton("²");
        JButton buttonSquareRoot = new JButton("√");
        JButton buttonClear = new JButton("C");
        JButton buttonEqu = new JButton("=");

        JButton buttonQuaternary = new JButton("Quaternary");
        JButton buttonDecimal = new JButton("Decimal");

        JPanel panelT = new JPanel();
        panelT.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 30));
        panelT.setLayout(new GridLayout(0, 1));
        panelT.add(textField);

        JPanel panelQ = new JPanel();
        panelQ.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
        panelQ.setLayout(new GridLayout(0, 2));
        panelQ.add(buttonQuaternary);
        panelQ.add(buttonDecimal);

        JPanel panelB = new JPanel();
        panelB.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));
        panelB.setLayout(new GridLayout(0, 4));
        panelB.add(button0);
        panelB.add(button1);
        panelB.add(button2);
        panelB.add(button3);
        panelB.add(buttonPlus);
        panelB.add(buttonSub);
        panelB.add(buttonMul);
        panelB.add(buttonDiv);
        panelB.add(buttonSquare);
        panelB.add(buttonSquareRoot);
        panelB.add(buttonClear);
        panelB.add(buttonEqu);

        // Add action listeners to buttons
        button0.addActionListener(e -> appendDigit("0"));
        button1.addActionListener(e -> appendDigit("1"));
        button2.addActionListener(e -> appendDigit("2"));
        button3.addActionListener(e -> appendDigit("3"));
        buttonPlus.addActionListener(e -> setOperation("+"));
        buttonSub.addActionListener(e -> setOperation("-"));
        buttonMul.addActionListener(e -> setOperation("x"));
        buttonDiv.addActionListener(e -> setOperation("/"));
        buttonClear.addActionListener(e -> clear());
        buttonEqu.addActionListener(e -> calculate());

        buttonQuaternary.addActionListener(e -> isQuaternary = true);
        buttonDecimal.addActionListener(e -> isQuaternary = false);

        frame.add(panelT, BorderLayout.PAGE_START);
        frame.add(panelQ, BorderLayout.CENTER);
        frame.add(panelB, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quaternary Calculator");
        frame.pack();
        frame.setVisible(true);
    }

    private void appendDigit(String digit) {
        textField.setText(textField.getText() + digit);
    }

    private void setOperation(String operation) {
        firstOperand = textField.getText();
        currentOp = operation;
        textField.setText("");
    }

    private void calculate() {
        String secondOperand = textField.getText();
        String result = "";

        switch (currentOp) {
            case "+":
                result = Calculator.add(firstOperand, secondOperand);
                break;
            case "-":
                result = Calculator.subtract(firstOperand, secondOperand);
                break;
            case "x":
                result = Calculator.multiply(firstOperand, secondOperand);
                break;
            case "/":
                result = Calculator.divide(firstOperand, secondOperand);
                break;
        }

        textField.setText(result);
    }

    private void clear() {
        textField.setText("");
        firstOperand = "";
        currentOp = "";
    }



    public static void main(String[] args) {
        new UI();
    }
}


