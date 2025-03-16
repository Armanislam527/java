
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class CGPACalculator extends JFrame {

    private JTextField nameField, rollField;
    private JSpinner semesterSpinner;
    private JButton calculateBtn, closeBtn;
    private JTextArea resultArea;
    private ArrayList<JDialog> semesterDialogs = new ArrayList<>();
    private ArrayList<ArrayList<JTextField>> marksFields = new ArrayList<>();
    private ArrayList<ArrayList<JComboBox<Double>>> creditBoxes = new ArrayList<>();
    private final Double[] creditOptions = {0.75, 1.0, 1.25, 1.5, 2.0, 3.0};

    public CGPACalculator() {
        setTitle("CGPA Calculator");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Roll Number:"));
        rollField = new JTextField();
        add(rollField);

        add(new JLabel("Number of Semesters:"));
        semesterSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 8, 1));
        add(semesterSpinner);

        calculateBtn = new JButton("Enter Subjects");
        calculateBtn.addActionListener(e -> openSemesterDialogs());
        add(calculateBtn);

        closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> System.exit(0));
        add(closeBtn);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea));
    }

    private void openSemesterDialogs() {
        int numSemesters = (int) semesterSpinner.getValue();
        marksFields.clear();
        creditBoxes.clear();

        for (int i = 0; i < numSemesters; i++) {
            JDialog semDialog = new JDialog(this, "Semester " + (i + 1), true);
            semDialog.setLayout(new GridLayout(0, 2));

            int numSubjects = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter number of subjects for Semester " + (i + 1)));

            ArrayList<JTextField> subjectMarks = new ArrayList<>();
            ArrayList<JComboBox<Double>> subjectCredits = new ArrayList<>();

            for (int j = 0; j < numSubjects; j++) {
                semDialog.add(new JLabel("Subject " + (j + 1) + " Marks:"));
                JTextField markField = new JTextField();
                semDialog.add(markField);
                subjectMarks.add(markField);

                semDialog.add(new JLabel("Credit:"));
                JComboBox<Double> creditBox = new JComboBox<>(creditOptions);
                semDialog.add(creditBox);
                subjectCredits.add(creditBox);
            }

            JButton saveBtn = new JButton("Save");
            int finalI = i;
            saveBtn.addActionListener(e -> {
                marksFields.add(subjectMarks);
                creditBoxes.add(subjectCredits);
                semDialog.dispose();
                if (finalI == numSemesters - 1) {
                    calculateCGPA();
                }
            });
            semDialog.add(saveBtn);

            semDialog.pack();
            semDialog.setVisible(true);
        }
    }

    private void calculateCGPA() {
        double totalMarks = 0, totalWeightedGPA = 0, totalCredits = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < marksFields.size(); i++) {
            double semesterMarks = 0, semesterWeightedGPA = 0, semesterCredits = 0;
            for (int j = 0; j < marksFields.get(i).size(); j++) {
                double marks = Double.parseDouble(marksFields.get(i).get(j).getText());
                double credit = (double) creditBoxes.get(i).get(j).getSelectedItem();
                double gpa = marksToGPA(marks);

                semesterMarks += marks;
                semesterWeightedGPA += gpa * credit;
                semesterCredits += credit;
            }
            totalMarks += semesterMarks;
            totalWeightedGPA += semesterWeightedGPA;
            totalCredits += semesterCredits;

            double semesterGPA = semesterWeightedGPA / semesterCredits;
            result.append("Semester ").append(i + 1).append(" GPA: ").append(String.format("%.2f", semesterGPA)).append("\n");
        }

        double cgpa = totalWeightedGPA / totalCredits;
        result.append("Total Marks: ").append(totalMarks).append("\n");
        result.append("CGPA: ").append(String.format("%.2f", cgpa)).append("\n\n");
        result.append("Author: Arman, Dept of ICE, PUST\nRoll: 230623, Reg: 1065512, Session: 2022-23");

        resultArea.setText(result.toString());
        saveResult(result.toString());
    }

    private double marksToGPA(double marks) {
        if (marks >= 80) {
            return 4.0;
        } else if (marks >= 70) {
            return 3.5;
        } else if (marks >= 60) {
            return 3.0;
        } else if (marks >= 50) {
            return 2.5;
        } else if (marks >= 40) {
            return 2.0;
        } else {
            return 0.0;
        }
    }

    private void saveResult(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("CGPA_Result.txt"))) {
            writer.write(data);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving result.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CGPACalculator().setVisible(true));
    }
}
