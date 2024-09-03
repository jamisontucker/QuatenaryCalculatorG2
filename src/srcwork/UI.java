import javax.swing.*;
import java.awt.*;

public class UI {

    public UI(){
        JFrame frame = new JFrame();

        JButton button = new JButton("Click");
        JLabel label = new JLabel("1");



        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(label);

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
