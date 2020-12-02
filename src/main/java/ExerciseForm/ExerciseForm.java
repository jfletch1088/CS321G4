package ExerciseForm;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ExerciseForm extends JPanel implements ActionListener {
    public ExerciseForm()
    {
        super(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel exTypeLabel = new JLabel("Enter your exercise type: ");
        JTextField exTypeField = new JTextField(20);
        add(exTypeLabel, c);
        add(exTypeField, c);
        JLabel exLengthLabel = new JLabel("Enter your exercise length: ");
        JTextField exLengthHrsField = new JTextField(5);
        JTextField exLengthMinsField = new JTextField(5);
        JLabel exLengthHrsLabel = new JLabel("Hours: ");
        JLabel exLengthMinsLabel = new JLabel("Minutes: ");
        add(exLengthLabel, c);
        add(exLengthHrsLabel, c);
        add(exLengthHrsField, c);
        add(exLengthMinsLabel, c);
        add(exLengthMinsField, c);
       
    }
    
    private static void createFrame()
    {
        JFrame frame = new JFrame("TextDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new ExerciseForm());

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createFrame();
            }
        });
    }
}
