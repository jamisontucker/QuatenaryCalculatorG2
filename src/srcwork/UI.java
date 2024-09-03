import javax.swing.*;
import java.awt.*;

public class UI {

    public UI(){
        JFrame frame = new JFrame();


        JButton button0 = new JButton("0");
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");



        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,4));
        panel.add(button0);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quaternary Calculator");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new UI();
    }
}
