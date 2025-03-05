
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SimpleCalculator extends JFrame {

    private JTextField num1Field, num2Field, resultField;
    private JButton addButton, subButton, mulButton, divButton;

    public SimpleCalculator() {
        // Set up the window
        setTitle("Simple Calculator");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        // Create components
        JLabel label1 = new JLabel("Number 1:");
        num1Field = new JTextField();
        JLabel label2 = new JLabel("Number 2:");
        num2Field = new JTextField();
        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false); // Read-only result field

        // Buttons for operations
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");

        // Action listeners for buttons
        addButton.addActionListener(new OperationListener());
        subButton.addActionListener(new OperationListener());
        mulButton.addActionListener(new OperationListener());
        divButton.addActionListener(new OperationListener());

        // Add components to the window
        add(label1);
        add(num1Field);
        add(label2);
        add(num2Field);
        add(resultLabel);
        add(resultField);
        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);

        // Center the window
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Event handling for button clicks
    private class OperationListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                double result = 0;

                if (e.getSource() == addButton) {
                    result = num1 + num2;
                } else if (e.getSource() == subButton) {
                    result = num1 - num2;
                } else if (e.getSource() == mulButton) {
                    result = num1 * num2;
                } else if (e.getSource() == divButton) {
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(null, "Cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    result = num1 / num2;
                }

                resultField.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
