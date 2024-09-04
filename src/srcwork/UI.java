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

        JPanel panelT = new JPanel();
        panelT.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 30));
        panelT.setLayout(new GridLayout(0,1));
        panelT.add(textField);


        JPanel panelB = new JPanel();
        panelB.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        panelB.setLayout(new GridLayout(0,4));
        panelB.add(button0);
        panelB.add(button1);
        panelB.add(button2);
        panelB.add(button3);
        panelB.add(buttonPlus);
        panelB.add(buttonSub);
        panelB.add(buttonMul);
        panelB.add(buttonDiv);


        frame.add(panelT, BorderLayout.PAGE_START);
        frame.add(panelB, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quaternary Calculator");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new UI();
    }
}
