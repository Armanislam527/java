import java.awt.*;        // Using AWT container and component classes
// import java.awt.event.*;  // Using AWT event classes and listener interfaces
import java.awt.*;

// An AWT program inherits from the top-level container java.awt.Frame
public class AWTCounter extends Frame {
   /** 
   /**
    * This is a placeholder comment for the AWTCounter class.
    * 
    * Note: The actual class implementation is not provided in the selection.
    * 
    * Author: Arman Islam
    * Filepath: /home/arman/arman/github/java/GUI/AWTCounter.java
    *
      * @version 1.0 2021-09-01  // 1.0 is the version number
      *  
   import java.awt.*;
import java.awt.event.*;  // Added missing import for ActionListener

public class AWTCounter extends Frame {
   private Label lblCount;    
   private TextField tfCount;
   private Button btnCount;   
   private int count = 0;     

   public AWTCounter () {
      setLayout(new FlowLayout());

      lblCount = new Label("Counter");
      add(lblCount);                    

      tfCount = new TextField(count + "", 10);
      tfCount.setEditable(true);      
      add(tfCount);                     
      
      try {
         count = Integer.parseInt(tfCount.getText());
      } catch (NumberFormatException e) {
         count = 0; // Set default if parsing fails
         tfCount.setText("0");
      }

      btnCount = new Button("Count");   
      add(btnCount);                    

      btnCount.addActionListener(new BtnCountListener());

      setTitle("AWT Counter");
      setSize(300, 100);        

      // Add window closing handler
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

   private class BtnCountListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent evt) {
         try {
            count = Integer.parseInt(tfCount.getText());
            ++count;
            tfCount.setText(String.valueOf(count));
         } catch (NumberFormatException e) {
            count = 0;
            tfCount.setText("0");
         }
      }
   }
}   and i am the author of this source code
   cant you blelieve this
   run the code
   ha ha ha;
   '''*/
   private Label lblCount;    // Declare a Label component
   private TextField tfCount; // Declare a TextField component
   private Button btnCount;   // Declare a Button component
   private int count = 0;     // Counter's value

   // Constructor to setup GUI components and event handlers
   public AWTCounter () {
      setLayout(new FlowLayout());
         // "super" Frame, which is a Container, sets its layout to FlowLayout to arrange
         // the components from left-to-right, and flow to next row from top-to-bottom.

      lblCount = new Label("Counter");  // construct the Label component
      add(lblCount);                    // "super" Frame container adds Label component

      tfCount = new TextField(count + "", 10); // construct the TextField component with initial text
      tfCount.setEditable(true);       // set to read-only
      add(tfCount);                     // "super" Frame container adds TextField component
      count = Integer.parseInt(tfCount.getText()); //, the number of   
      btnCount  = new Button("Count");   // construct the Button component
      add(btnCount);                    // "super" Frame container adds Button component

      btnCount.addActionListener(new BtnCountListener());  // anonymous instance
      // same as
      //BtnCountListener listener = new BtnCountListener();
      //btnCount.addActionListener(listener);
         // "btnCount" is the source object that fires an ActionEvent when clicked.
         // The source object adds an instance of BtnCountListener as an ActionEvent listener,
         //   which provides an ActionEvent handler called actionPerformed().
         // Clicking "Count" button calls back actionPerformed().

      setTitle("AWT Counter");  // "super" Frame sets its title
      setSize(300, 100);        // "super" Frame sets its initial window size

      // For inspecting the Container/Components objects
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
      setVisible(true);         // "super" Frame shows
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
   }

   // The entry main() method
   public static void main(String[] args) {
      // Invoke the constructor to setup the GUI, by allocating an instance
      AWTCounter app = new AWTCounter();
         // or simply "new AWTCounter();" for an anonymous instance
   }

   // Define an inner class to handle the "Count" button-click
   private class BtnCountListener implements ActionListener {
      // ActionEvent handler - Called back upon button-click.
      @Override
      public void actionPerformed(ActionEvent evt) {
         count=Integer.parseInt(tfCount.getText()); // Increment the counter value
         ++count; // Increase the counter value
         // Display the counter value on the TextField tfCount
         tfCount.setText(count + ""); // Convert int to String
      }
   }
}
