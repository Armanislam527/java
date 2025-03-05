
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GreetingApp {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Greeting App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // Set up a panel to organize the layout
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Label
        JLabel userLabel = new JLabel("Enter your name:");
        userLabel.setBounds(10, 20, 150, 25);
        panel.add(userLabel);

        // Text field for user input
        JTextField userText = new JTextField(20);
        userText.setBounds(150, 20, 130, 25);
        panel.add(userText);

        // Button to display greeting
        JButton greetButton = new JButton("Greet");
        greetButton.setBounds(100, 60, 100, 30);
        panel.add(greetButton);

        // Label to display the greeting message
        JLabel greetingLabel = new JLabel("");
        greetingLabel.setBounds(10, 100, 250, 25);
        panel.add(greetingLabel);

        // Button click event to display the greeting
        greetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = userText.getText();
                greetingLabel.setText("Hello, " + name + "!");
            }
        });
    }
}
