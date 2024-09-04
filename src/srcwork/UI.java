import javax.swing.*;
import java.awt.*;

public class UI {
    private JTextField textField;
    private String currentInput = "";
    private String operator = "";
    private int firstNumber = 0;

    private boolean isQuaternary = true;


    public UI() {

        JFrame frame = new JFrame();
        textField = new JTextField();

        JButton button0 = new JButton("0");
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton buttonPlus = new JButton("+");
        JButton buttonSub = new JButton("-");
        JButton buttonMul = new JButton("x");
        JButton buttonDiv = new JButton("/");
        JButton buttonSquare = new JButton("²\n");
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

        //button0.addActionListener();
        //button1.addActionListener();
        //button2.addActionListener();
        //button3.addActionListener();
        //buttonPlus.addActionListener();
        //buttonSub.addActionListener();
        //buttonMul.addActionListener();
        //buttonDiv.addActionListener();
        //buttonSquare.addActionListener();
        //buttonSquareRoot.addActionListener();
        //buttonClear.addActionListener();
        //buttonEqu.addActionListener();
        //buttonQuaternary.addActionListener();
        //buttonDecimal.addActionListener();


        button0.addActionListener(e -> appendToInput("0"));
        button1.addActionListener(e -> appendToInput("1"));
        button2.addActionListener(e -> appendToInput("2"));
        button3.addActionListener(e -> appendToInput("3"));
        buttonPlus.addActionListener(e -> setOperator("+"));
        buttonSub.addActionListener(e -> setOperator("-"));
        buttonMul.addActionListener(e -> setOperator("x"));
        buttonDiv.addActionListener(e -> setOperator("/"));
        buttonSquare.addActionListener(e -> performUnaryOperation("square"));
        buttonSquareRoot.addActionListener(e -> performUnaryOperation("sqrt"));
        buttonClear.addActionListener(e -> clearInput());
        buttonEqu.addActionListener(e -> Calculator.calculate());
        buttonQuaternary.addActionListener(e -> setDisplayMode(true));
        buttonDecimal.addActionListener(e -> setDisplayMode(false));

        frame.add(panelT, BorderLayout.PAGE_START);
        frame.add(panelQ, BorderLayout.CENTER);
        frame.add(panelB, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quaternary Calculator");
        frame.pack();
        frame.setVisible(true);


    }

    private void appendToInput(String value) {
        currentInput += value;
        updateTextField();
    }

    private void setOperator(String op) {
        if (!currentInput.isEmpty()) {
            firstNumber = Calculator.quaternaryToDecimal(currentInput);
            operator = op;
            currentInput = "";
        }
    }

    private void clearInput() {
        currentInput = "";
        operator = "";
        textField.setText("");
    }

    private void setDisplayMode(boolean isQuaternary) {
        this.isQuaternary = isQuaternary;
        updateTextField();
    }

    private void calculate() {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            int secondNumber = Calculator.quaternaryToDecimal(currentInput);
            String result = Calculator.calculate(firstNumber, secondNumber, operator);
            textField.setText(result);
            currentInput = "";
            operator = "";
        }
    }

    private void performUnaryOperation(String op) {
        if (!currentInput.isEmpty()) {
            int number = Calculator.quaternaryToDecimal(currentInput);
            String result = Calculator.performUnaryOperation(op, number);
            textField.setText(result);
            currentInput = "";
        }
    }

    private void updateTextField() {
        if (isQuaternary) {
            textField.setText(currentInput);
        } else {
            try {
                int decimalValue = Calculator.quaternaryToDecimal(currentInput);
                textField.setText(decimalValue + " (Decimal)");
            } catch (NumberFormatException e) {
                textField.setText("Invalid Input");
            }
        }
    }

    public static void main(String[] args) {
        new UI();

    }

}

