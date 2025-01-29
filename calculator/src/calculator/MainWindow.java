package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainWindow implements ActionListener{
	//Distance between buttons 
	private final int DISTANCE = 5;
	
	//buttons width and height for main buttons, width for side buttons
	private final int WIDTH = 75;
	private final int HEIGHT = 50;
	
	//buttons height for the side bar buttons 
	private final int SIDEHEIGHT = 40;
	
	//screen width and height 
	private final int SCREENWIDTH = 375; 
	private final int SCREENHEIGHT = 400; 
	
	//buttons x and y coordinates for main buttons  
	private final int X1 = 25; 
	private final int X2 = X1 + WIDTH + DISTANCE;//105 
	private final int X3 = X2 + WIDTH + DISTANCE; 
	private final int Y1 = SCREENHEIGHT - 125; //275
	private final int Y2 = Y1 - HEIGHT - DISTANCE;//220
	private final int Y3 = Y2 - HEIGHT - DISTANCE;//165
	private final int Y4 = Y3 - HEIGHT - DISTANCE;//110
	private int xPos[] = {X1,X2,X3};
	private int yPos[] = {Y1,Y2,Y3,Y4};
	
	//buttons x and y for the side bar 
	private final int sY1 = SCREENHEIGHT - 110; 
	private final int sY2 = sY1 - SIDEHEIGHT - DISTANCE;
	private final int sY3 = sY2 - SIDEHEIGHT - DISTANCE;
	private final int sY4 = sY3 - SIDEHEIGHT - DISTANCE;
	private final int sY5 = sY4 - SIDEHEIGHT - DISTANCE;
	private final int X4 = X3 + WIDTH + 2*DISTANCE;
	
	
	
	private JFrame frame; 
	private JPanel panel;
	private JTextField text;
	
	private JButton[] buttons = new JButton[10];
 
	private JButton button0;
	private JButton buttonPlus;
	private JButton buttonMin; 
	private JButton buttonDiv; 
	private JButton buttonMul; 
	private JButton buttonClr; 
	private JButton buttonEq;
	private JButton buttonDec; 
	
	Double num1 = 0.0; 
	Double num2 = 0.0;
	
	Double result = 0.0;
	char operator;
	
	public MainWindow() {
		run();
	}
	public void show() { 
		this.frame.setVisible(true);
		
	}
	

	private void run() {
		// TODO Auto-generated method stub
		this.frame = new JFrame();
		this.frame.setLayout(null);
		
		this.panel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
		this.panel.setBackground(Color.GRAY);
		
		this.text = createJTextField();
		
		this.setButtons();
		this.addFrame();
		this.addButtonsToPanel();
		//this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,50));
	
		this.frame.add(this.text);
		this.frame.add(this.panel);
		
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 10 ; i++) {
			if (e.getSource() == this.buttons[i]) {
				System.out.println("hi");
				this.text.setText(text.getText().concat(String.valueOf(i)));
			}
		}
		
		if (e.getSource() == this.button0) {
			this.text.setText(text.getText().concat(String.valueOf(0)));
		}
		if (e.getSource() == this.buttonDec) {
			this.text.setText(text.getText().concat("."));
		}
		if (e.getSource() == this.buttonPlus) {
	
			num1 = Double.parseDouble(text.getText());
			char operator = '+';
			this.text.setText("");
			
		}
		if (e.getSource() == this.buttonMin) {
			
			num1 = Double.parseDouble(text.getText());
			operator = '-';
			this.text.setText("");
		}
		if (e.getSource() == this.buttonDiv) {
			
			num1 = Double.parseDouble(text.getText());
			operator = '/';
			this.text.setText("");
		}
		if (e.getSource() == this.buttonMul) {
			
			num1 = Double.parseDouble(text.getText());
			operator = 'x';
			this.text.setText("");
		}
		
		if (e.getSource() == this.buttonClr) {
			this.text.setText("");
			
		}
		if (e.getSource() == this.buttonEq) {
			num2 = Double.parseDouble(text.getText());
			
			switch(operator) {
			case '+':
				result = num1 + num2;
				break;
			
			case '-':
				result = num1 - num2;
				break;
			
			case 'x':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			
			this.text.setText(String.valueOf(result));
			num1 = result;
			
			
		}
		
		
	}




	private JTextField createJTextField() {
		// TODO Auto-generated method stub
		JTextField textField = new JTextField(); 
		textField.setFont(new Font("Arial",Font.BOLD,24));
		textField.setMargin(new Insets(5,10,5,10));
		textField.setBounds(X1,25,320,50);
		textField.setEditable(false);
		
		return textField;
	}


	
	private void addFrame() {
		// TODO Auto-generated method stub
		this.frame.setLayout(new BorderLayout());
		this.frame.setTitle("Calculator");
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		this.frame.setSize(SCREENWIDTH,SCREENHEIGHT); 
		this.frame.setLocationRelativeTo(null);
		this.frame.setResizable(false);
		
	}
	/*
	 * Helper method to set all of the buttons
	 * takes no parameters 
	 * return null 
	 */
	private void setButtons() {

		int index = 1; // Index for button numbers

	    for (int row = 3; row >= 0; row--) { // Loop for rows (bottom to top)
	        for (int col = 0; col < 3; col++) { // Loop for columns
	            if (index > 9) break; // Stop after creating button "9"

	            buttons[index] = new JButton(String.valueOf(index)); // Create button with number
	            buttons[index].setBounds(xPos[col], yPos[row], WIDTH, HEIGHT);
	            buttons[index].setFocusable(false);
	            buttons[index].addActionListener(this); // Assuming MainWindow implements ActionListener

	            this.frame.add(buttons[index]); // Add button to the frame or panel
	            index++; // Move to the next button number
	        }
	    }
	    this.button0 = new JButton("0"); 
	    this.button0.setBounds(xPos[1],yPos[0],WIDTH,HEIGHT);
	    this.button0.setFocusable(false);
	    this.button0.addActionListener((ActionListener) this);
		
		this.buttonPlus = new JButton("+");
		this.buttonPlus.setBounds(X4,sY4,WIDTH,SIDEHEIGHT);
		this.buttonPlus.setFocusable(false);
		this.buttonPlus.addActionListener((ActionListener) this);
		
		this.buttonMin = new JButton("-");
		this.buttonMin.setBounds(X4,sY3,WIDTH,SIDEHEIGHT);
		this.buttonMin.setFocusable(false);
		this.buttonMin.addActionListener((ActionListener) this);
		
		this.buttonClr = new JButton("CLR"); 
		this.buttonClr.setBounds(X4,sY5,WIDTH,SIDEHEIGHT);
		this.buttonClr.setFocusable(false);
		this.buttonClr.addActionListener((ActionListener) this);
		
		this.buttonMul = new JButton("x"); 
		this.buttonMul.setBounds(X4,sY2,WIDTH,SIDEHEIGHT);
		this.buttonMul.setFocusable(false);
		this.buttonMul.addActionListener((ActionListener) this);
		
		this.buttonDiv = new JButton("/");
		this.buttonDiv.setBounds(X4,sY1,WIDTH,SIDEHEIGHT);
		this.buttonDiv.setFocusable(false);
		this.buttonDiv.addActionListener((ActionListener) this);
		
		this.buttonDec = new JButton(".");
		this.buttonDec.setBounds(X1,Y1,WIDTH,HEIGHT);
		this.buttonDec.setFocusable(false);
		this.buttonDec.addActionListener((ActionListener) this);
		
		this.buttonEq = new JButton("=");
		this.buttonEq.setBounds(X3,Y1,WIDTH,HEIGHT);
		this.buttonEq.setFocusable(false);
		this.buttonEq.addActionListener((ActionListener) this);
		
	}
	/*
	 * private helper method to add all of the 
	 * button to the panel 
	 * no parameters 
	 * returns null 
	 */
	private void addButtonsToPanel() {
		// TODO Auto-generated method stub
		this.frame.add(button0);
		this.frame.add(this.buttonPlus);
		this.frame.add(this.buttonMin);
		this.frame.add(this.buttonMul);
		this.frame.add(this.buttonDiv);
		this.frame.add(this.buttonDec);
		this.frame.add(this.buttonClr);
		this.frame.add(this.buttonEq);
		
	}
	
}
