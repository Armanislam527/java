
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class CGPACalculators extends JFrame {

    private JTextField nameField, rollField;
    private JSpinner semesterSpinner;
    private List<List<Subject>> allSemesters = new ArrayList<>();

    public CGPACalculators() {
        setTitle("CGPA Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Student Information
        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Roll Number:"));
        rollField = new JTextField();
        add(rollField);

        // Semester Selection
        add(new JLabel("Number of Semesters:"));
        SpinnerModel model = new SpinnerNumberModel(1, 1, 8, 1);
        semesterSpinner = new JSpinner(model);
        add(semesterSpinner);

        // Calculate Button
        JButton calculateButton = new JButton("Calculate CGPA");
        calculateButton.addActionListener(e -> collectSemesterData());
        add(calculateButton);

        setVisible(true);
    }

    private void collectSemesterData() {
        int totalSemesters = (Integer) semesterSpinner.getValue();
        allSemesters.clear();

        for (int i = 0; i < totalSemesters; i++) {
            String input = JOptionPane.showInputDialog(this,
                    "Enter number of subjects for Semester " + (i + 1) + ":");
            if (input == null) {
                return;
            }

            int subjects = Integer.parseInt(input);
            List<Subject> semesterSubjects = new ArrayList<>();

            for (int j = 0; j < subjects; j++) {
                JPanel panel = new JPanel(new GridLayout(2, 2));
                JTextField marksField = new JTextField(5);
                JComboBox<Double> creditCombo = new JComboBox<>(
                        new Double[]{0.75, 1.0, 1.25, 1.5, 2.0, 3.0});

                panel.add(new JLabel("Marks for Subject " + (j + 1) + ":"));
                panel.add(marksField);
                panel.add(new JLabel("Credit:"));
                panel.add(creditCombo);

                int result = JOptionPane.showConfirmDialog(null, panel,
                        "Semester " + (i + 1) + " Subject " + (j + 1),
                        JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    double marks = Double.parseDouble(marksField.getText());
                    double credit = (Double) creditCombo.getSelectedItem();
                    semesterSubjects.add(new Subject(marks, credit));
                }
            }
            allSemesters.add(semesterSubjects);
        }
        calculateAndDisplay();
    }

    private void calculateAndDisplay() {
        double totalCreditPoints = 0;
        double totalCredits = 0;
        StringBuilder resultText = new StringBuilder();

        for (int i = 0; i < allSemesters.size(); i++) {
            double semesterCreditPoints = 0;
            double semesterCredits = 0;

            for (Subject subject : allSemesters.get(i)) {
                double gradePoint = calculateGradePoint(subject.marks);
                semesterCreditPoints += gradePoint * subject.credit;
                semesterCredits += subject.credit;
            }

            double sgpa = semesterCreditPoints / semesterCredits;
            totalCreditPoints += semesterCreditPoints;
            totalCredits += semesterCredits;

            resultText.append(String.format("Semester %d SGPA: %.2f\n", i + 1, sgpa));
        }

        double cgpa = totalCreditPoints / totalCredits;
        resultText.append(String.format("\nOverall CGPA: %.2f", cgpa));

        saveToFile(resultText.toString());
        new ResultWindow(resultText.toString());
    }

    private double calculateGradePoint(double marks) {
        if (marks >= 80) {
            return 4.00;
        }
        if (marks >= 75) {
            return 3.75;
        }
        if (marks >= 70) {
            return 3.50;
        }
        if (marks >= 65) {
            return 3.25;
        }
        if (marks >= 60) {
            return 3.00;
        }
        if (marks >= 55) {
            return 2.75;
        }
        if (marks >= 50) {
            return 2.50;
        }
        if (marks >= 45) {
            return 2.25;
        }
        if (marks >= 40) {
            return 2.00;
        }
        return 0.00;
    }

    private void saveToFile(String result) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("results.txt", true))) {
            writer.println("Student Name: " + nameField.getText());
            writer.println("Roll Number: " + rollField.getText());
            writer.println(result);
            writer.println("----------------------------------");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving results!");
        }
    }

    class ResultWindow extends JFrame {

        public ResultWindow(String result) {
            setTitle("Results");
            setSize(400, 300);
            setLayout(new BorderLayout());

            JTextArea resultArea = new JTextArea(result);
            add(new JScrollPane(resultArea), BorderLayout.CENTER);

            // Author Information
            JPanel authorPanel = new JPanel(new GridLayout(5, 1));
            authorPanel.add(new JLabel("Author: Anamul"));
            authorPanel.add(new JLabel("Dept: Information and Communication Engineering, PUST"));
            authorPanel.add(new JLabel("Roll: 230614"));
            authorPanel.add(new JLabel("Reg: 1065503"));
            authorPanel.add(new JLabel("Session: 2022-23"));
            add(authorPanel, BorderLayout.NORTH);

            // Buttons
            JPanel buttonPanel = new JPanel();
            JButton againButton = new JButton("Calculate Again");
            againButton.addActionListener(e -> {
                new CGPACalculator();
                dispose();
            });

            JButton closeButton = new JButton("Close");
            closeButton.addActionListener(e -> System.exit(0));

            buttonPanel.add(againButton);
            buttonPanel.add(closeButton);
            add(buttonPanel, BorderLayout.SOUTH);

            setVisible(true);
        }
    }

    class Subject {

        double marks;
        double credit;

        public Subject(double marks, double credit) {
            this.marks = marks;
            this.credit = credit;
        }
    }

    public static void main(String[] args) {
        new CGPACalculators();
    }
}
