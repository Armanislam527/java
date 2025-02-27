
import java.awt.*;
import java.awt.event.*;  // ✅ Import missing event classes

// An AWT program inherits from the top-level container java.awt.Frame
public class AWTCounter extends Frame {

    private Label lblCount;
    private TextField tfCount;
    private Button btnCount;
    private int count = 0;
    private Button btnreset;

    public AWTCounter() {
        setLayout(new FlowLayout());

        lblCount = new Label("Counter");
        add(lblCount);

        tfCount = new TextField(count + "", 10);
        tfCount.setEditable(true);
        add(tfCount);
        count = Integer.parseInt(tfCount.getText());

        btnCount = new Button("Count");
        add(btnCount);
        Button btnreset = new Button("Reset");
        btnCount.addActionListener(new BtnCountListener());  // ✅ Works now!
        btnreset.addActionListener(l -> {

            tfCount.setText("0");
            count = 0;
            lblCount.setText("Counter: " + count);
        });

        setTitle("AWT Counter");
        setSize(300, 100);

        // Handle window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new AWTCounter();
    }

    // ✅ Fix: Import and implement ActionListener properly
    private class BtnCountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            count = Integer.parseInt(tfCount.getText());
            ++count;
            tfCount.setText(count + "");
        }
    }
}
