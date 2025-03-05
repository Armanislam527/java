import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI extends JFrame {
    private JTextField nameField;
    private JButton greetButton;
    private JLabel resultLabel;

    public SimpleGUI() {
        // Set up the window
        setTitle("Simple GUI Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create components
        JLabel nameLabel = new JLabel("Enter your name:");
        nameField = new JTextField(15);
        greetButton = new JButton("Greet");
        resultLabel = new JLabel(" ");

        // Add action listener to the button
        greetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                if (!name.isEmpty()) {
                    resultLabel.setText("Hello, " + name + "!");
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a name.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add components to the window
        add(nameLabel);
        add(nameField);
        add(greetButton);
        add(resultLabel);

        // Center the window
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI();
    }
}
