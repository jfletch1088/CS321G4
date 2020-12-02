package ExerciseForm;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ExerciseForm extends JPanel implements ActionListener {
    protected JTextField exDateField;
    protected JTextField exTypeField;
    protected JTextField exLengthHrsField;
    protected JTextField exLengthMinsField;
    public ExerciseForm()
    {
        super(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel exDateLabel = new JLabel("Enter the date of workout (mm/dd/yyyy): ");
        exDateField = new JTextField(20);
        add(exDateLabel, c);
        add(exDateField, c);
        
        JLabel exTypeLabel = new JLabel("Enter your exercise type: ");
        exTypeField = new JTextField(20);
        add(exTypeLabel, c);
        add(exTypeField, c);
        
        JLabel exLengthLabel = new JLabel("Enter your exercise length: ");
        exLengthHrsField = new JTextField(5);
        exLengthMinsField = new JTextField(5);
        JLabel exLengthHrsLabel = new JLabel("Hours: ");
        JLabel exLengthMinsLabel = new JLabel("Minutes: ");
        add(exLengthLabel, c);
        add(exLengthHrsLabel, c);
        add(exLengthHrsField, c);
        add(exLengthMinsLabel, c);
        add(exLengthMinsField, c);
        
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton,c);
    }
    
    private static void createFrame()
    {
        JFrame frame = new JFrame("Exercise Entry");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new ExerciseForm());

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String date = exDateField.getText();
        String[] formatDate = date.split("/");
        int exerMonth = Integer.parseInt(formatDate[0]);
        int exerDay = Integer.parseInt(formatDate[1]);
        int exerYear = Integer.parseInt(formatDate[2]);
        
        String exerType = exTypeField.getText();
        int exerLengthHrs = Integer.parseInt(exLengthHrsField.getText());
        int exerLengthMins = Integer.parseInt(exLengthMinsField.getText());
        
        //Test all data collection from submit button
        System.out.println("Date of exercise: " + exerMonth + "/" + exerDay + "/" + 
                exerYear + "\nType of exercise: " + exerType + "\nLength of exercise: " +
                exerLengthHrs + " hours and " + exerLengthMins + " minutes.");
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createFrame(); 
            }
        });
    }
}
