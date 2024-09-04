import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UI {

    public UI(){

        JFrame frame = new JFrame();
        JTextField textField = new JTextField();
        JButton button0 = new JButton("0");
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton buttonPlus = new JButton("+");
        JButton buttonSub = new JButton("-");
        JButton buttonMul = new JButton("x");
        JButton buttonDiv = new JButton("/");
        JButton buttonEqu = new JButton("=");
        JButton buttonQuaternary = new JButton("Quaternary");
        JButton buttonDecimal = new JButton("Decimal");

        JPanel panelT = new JPanel();
        panelT.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 30));
        panelT.setLayout(new GridLayout(0,1));
        panelT.add(textField);

        JPanel panelQ = new JPanel();
        panelQ.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
        panelQ.setLayout(new GridLayout(0,2));
        panelQ.add(buttonQuaternary);
        panelQ.add(buttonDecimal);

        JPanel panelB = new JPanel();
        panelB.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));
        panelB.setLayout(new GridLayout(0,4));
        panelB.add(button0);
        panelB.add(button1);
        panelB.add(button2);
        panelB.add(button3);
        panelB.add(buttonPlus);
        panelB.add(buttonSub);
        panelB.add(buttonMul);
        panelB.add(buttonDiv);
        panelB.add(buttonEqu);

        frame.add(panelT, BorderLayout.PAGE_START);
        frame.add(panelQ, BorderLayout.CENTER);
        frame.add(panelB, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quaternary Calculator");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new UI();
    }
}
