package com.group4.cs321g4;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu implements ActionListener {
	
	int count = 0;
	// Frames
	private JFrame progressFrame;
	private JFrame menuFrame;
	private JFrame calendarFrame;
	private JFrame exerciseEntryFrame;
	private JFrame calorieCalcFrame;
	
	// Panels
	private JPanel mainPanel;
	private JPanel progressLogPanel;
	private JPanel calendarPanel;
	private JPanel exerciseEntryPanel;
	private JPanel calorieCalcPanel;
	
	// Labels
	private JLabel progressLogLabel;
	private JLabel mainLabel;
	private JLabel calendarLabel;
	private JLabel exerciseEntryLabel;
	private JLabel calorieCalcLabel;
	
	// Buttons
	private JButton calendarButton;
	private JButton calorieCalcButton;
	private JButton progressLogButton;
	private JButton exerciseEntryButton;
	
	
	
	

	public MainMenu()
	{
		// Frames----------------------------------------------------------
		menuFrame = new JFrame(); 											// Frame for the main menu
		progressFrame = new JFrame();										// Frame for progress log menu
		calendarFrame = new JFrame();										// Frame for calendar menu
		exerciseEntryFrame = new JFrame();
		calorieCalcFrame = new JFrame();
		
		// Panels----------------------------------------------------------	
		progressLogPanel = new JPanel();									// Panel for progress log frame
		mainPanel = new JPanel();											// Panel for main menu frame
		calendarPanel = new JPanel();										// Panel for calendar frame
		exerciseEntryPanel = new JPanel();
		calorieCalcPanel = new JPanel();
		
		// Labels----------------------------------------------------------
		mainLabel = new JLabel("Please select an option.");					// Label for main menu frame
		progressLogLabel = new JLabel("This is the progress log");			// Label for progress log frame
		calendarLabel = new JLabel("This is the Calendar");
		exerciseEntryLabel = new JLabel("This is the Exercise Entry menu");
		calorieCalcLabel = new JLabel("This is the Calorie Calculator");
		
		// Buttons---------------------------------------------------------
		progressLogButton = new JButton("Progress Log");					// Button that takes user to progress log frame
		calendarButton = new JButton("Calendar");							// Button that takes user to calendar frame
		calorieCalcButton = new JButton("Calorie Calculator");				// Button that takes user to calorie calculator
		exerciseEntryButton = new JButton("Exercise Log");					// Button that takes user to exercise log
		
		//-----------------------------------------------------------------
		
		
		
		
		// This section controls the main menu
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		mainPanel.setPreferredSize(new Dimension(1000, 500));
	
		mainPanel.add(progressLogButton);
		mainPanel.add(calendarButton);
		mainPanel.add(exerciseEntryButton);
		mainPanel.add(calorieCalcButton);
		mainPanel.add(mainLabel);
		
		menuFrame.add(mainPanel, BorderLayout.CENTER);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setTitle("Exercise Tracking System");
		menuFrame.pack();
		menuFrame.setSize(800, 300);
		menuFrame.setVisible(true);
		
		// This section controls the secondary menu for Progress Log
		
		progressLogPanel.add(progressLogLabel);
		
		progressFrame.add(progressLogPanel, BorderLayout.CENTER);
		progressFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		progressFrame.setTitle("Progress Log Menu");
		progressFrame.pack();
		progressFrame.setSize(800, 300);
		progressFrame.setVisible(false);
		
		progressLogButton.addActionListener(this);
		
		// This section controls the secondary menu for the Calendar
		
		calendarPanel = new CalendarPanel(calendarFrame);
		
		calendarFrame.add(calendarPanel, BorderLayout.CENTER);
		calendarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calendarFrame.setTitle("Progress Log Menu");
		calendarFrame.pack();
		calendarFrame.setSize(800, 300);
		calendarFrame.setVisible(false);
		
		calendarButton.addActionListener(this);
		
		// This section controls the secondary menu for Exercise Entry 
		
		exerciseEntryPanel = new ExerciseForm();
		
		exerciseEntryFrame.add(exerciseEntryPanel, BorderLayout.CENTER);
		exerciseEntryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		exerciseEntryFrame.setTitle("Progress Log Menu");
		exerciseEntryFrame.pack();
		exerciseEntryFrame.setSize(800, 300);
		exerciseEntryFrame.setVisible(false);
		
		exerciseEntryButton.addActionListener(this);
		
		// This section controls the secondary menu for the Calorie Calculator
		
		calorieCalcPanel = new Calculator();
		
		calorieCalcFrame.add(calorieCalcPanel, BorderLayout.CENTER);
		calorieCalcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calorieCalcFrame.setTitle("Progress Log Menu");
		calorieCalcFrame.pack();
		calorieCalcFrame.setSize(800, 300);
		calorieCalcFrame.setVisible(false);
		
		calorieCalcButton.addActionListener(this);
		
		
		
	}
	
	public static void main(String[] args) {
		
		new MainMenu();

	}

	
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == progressLogButton)
		{
			menuFrame.setVisible(false);
			
			progressFrame.setVisible(true);
		}
		else if(event.getSource() == calendarButton)
		{
			menuFrame.setVisible(false);
			calendarFrame.setVisible(true);
		}
		else if(event.getSource() == exerciseEntryButton)
		{
			menuFrame.setVisible(false);
			exerciseEntryFrame.setVisible(true);
		}
		else if(event.getSource() == calorieCalcButton)
		{
			menuFrame.setVisible(false);
			
			calorieCalcFrame.setVisible(true);
		}
		
		
	}

}

