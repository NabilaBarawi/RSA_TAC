import javax.swing.*;
import java.awt.*;

class gui {

    public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("RSA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(20); // accepts upto 20 characters

        JButton encrypt = new JButton("Encrypt");
        JButton decrypt = new JButton("Decrypt");       

        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(encrypt);
        panel.add(decrypt);

        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, ta);
        frame.setVisible(true);
    }

} 