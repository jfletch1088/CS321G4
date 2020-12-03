package com.group4.cs321g4;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JFrame implements ActionListener {
	
	int count = 0;
	// Frames
	private JFrame progressFrame;
	private JFrame menuFrame;
	private JFrame calendarFrame;
	private JFrame exerciseEntryFrame;
	private JFrame calorieCalcFrame;
	private JFrame currentFrame;
        
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
                removeAll();
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

		progressLogButton.addActionListener(this);
		calendarButton.addActionListener(this);
		exerciseEntryButton.addActionListener(this);
		calorieCalcButton.addActionListener(this);
		
		
		
	}
	
	public static void main(String[] args) {
		
		new MainMenu();

	}

	
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == progressLogButton)
		{
			menuFrame.remove(mainPanel);
                        progressLogPanel = new JPanel();
                        menuFrame.add(progressLogPanel, BorderLayout.CENTER);
                        JButton mainMenuBtn = new JButton("Back");
                        menuFrame.add(mainMenuBtn, BorderLayout.SOUTH);
                        mainMenuBtn.addActionListener(e -> {
                            menuFrame.remove(progressLogPanel);
                            menuFrame.add(mainPanel);
                            menuFrame.remove(mainMenuBtn);
                            menuFrame.pack();
                            menuFrame.setSize(800, 300);
                        });

                        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        menuFrame.setTitle("Exercise Tracking System");
                        menuFrame.pack();    
                        menuFrame.setSize(800, 300);
		}
		else if(event.getSource() == calendarButton)
		{
			menuFrame.remove(mainPanel);
                        calendarPanel = new CalendarPanel(menuFrame);
                        menuFrame.add(calendarPanel, BorderLayout.CENTER);
                        JButton mainMenuBtn = new JButton("Back");
                        menuFrame.add(mainMenuBtn, BorderLayout.SOUTH);
                        mainMenuBtn.addActionListener(e -> {
                            menuFrame.remove(calendarPanel);
                            menuFrame.add(mainPanel);
                            menuFrame.remove(mainMenuBtn);
                            menuFrame.pack();
                            menuFrame.setSize(800, 300);
                        });

                        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        menuFrame.setTitle("Exercise Tracking System");
                        menuFrame.pack();    
                        menuFrame.setSize(800, 300);
		}
		else if(event.getSource() == exerciseEntryButton)
		{
                        menuFrame.remove(mainPanel);
                        exerciseEntryPanel = new ExerciseForm();
                        menuFrame.add(exerciseEntryPanel, BorderLayout.CENTER);
                        JButton mainMenuBtn = new JButton("Back");
                        menuFrame.add(mainMenuBtn, BorderLayout.SOUTH);
                        mainMenuBtn.addActionListener(e -> {
                            menuFrame.remove(exerciseEntryPanel);
                            menuFrame.add(mainPanel);
                            menuFrame.remove(mainMenuBtn);
                            menuFrame.pack();
                            menuFrame.setSize(800, 300);
                        });

                        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        menuFrame.setTitle("Exercise Tracking System");
                        menuFrame.pack();    
                        menuFrame.setSize(800, 300);
		}
		else if(event.getSource() == calorieCalcButton)
		{
			menuFrame.remove(mainPanel);
                        calorieCalcPanel = new Calculator();
                        menuFrame.add(calorieCalcPanel, BorderLayout.CENTER);
                        JButton mainMenuBtn = new JButton("Back");
                        menuFrame.add(mainMenuBtn, BorderLayout.SOUTH);
                        mainMenuBtn.addActionListener(e -> {
                            menuFrame.remove(calorieCalcPanel);
                            menuFrame.add(mainPanel);
                            menuFrame.remove(mainMenuBtn);
                            menuFrame.pack();
                            menuFrame.setSize(800, 300);
                        });

                        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        menuFrame.setTitle("Exercise Tracking System");
                        menuFrame.pack();    
                        menuFrame.setSize(800, 300);                 
		}
		
		
	}
}

