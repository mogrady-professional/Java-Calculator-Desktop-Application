
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
//Initialize instance variables
//	JFrame
	JFrame frame;
//	TextField
	JTextField textfield;
//	Buttons
	JButton[] numberButtons = new JButton[10]; // 10 number buttons
	JButton[] functionButtons = new JButton[9]; // 9 function buttons
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
//	JPanel
	JPanel panel;
//	Reusable font
	Font myFont = new Font("Tahoma",Font.BOLD,30);
	
	double num1=0,num2=0,result=0; // Initialize number/result
	char operator; // Hold Operator
	
	Calculator(){
//		Frame config
		frame = new JFrame("Java Calculator Desktop Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
//		Textfield 
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false); // Prevent editing textfield
//		Define operator Buttons and labels
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");
		negButton = new JButton("(-)");
//		Define function buttons and labels
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
/**
 * For loop to iterate through loop of buttons -> add action listener -> set font -> remove focusability
 */
		for(int i =0;i<9;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		/**
		 * For loop to iterate through loop of buttons -> add text to buttons -> add action listener -> set font -> remove focusability
		 */		
		for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
//		X, Y, WIDTH, HEIGHT
		negButton.setBounds(50,430,100,50);
		delButton.setBounds(150,430,100,50);
		clrButton.setBounds(250,430,100,50);
		
//		JPANEL
		panel = new JPanel();
//		X, Y, WIDTH, HEIGHT
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10)); // Grid layout -> specify rows, cols, 10px of space around X, Y
//		Add panel to JFrame
		panel.add(numberButtons[1]); // #1
		panel.add(numberButtons[2]); // #2
		panel.add(numberButtons[3]); // #3
		panel.add(addButton); // Row 2
		panel.add(numberButtons[4]); // #4
		panel.add(numberButtons[5]); // #5
		panel.add(numberButtons[6]); // #6
		panel.add(subButton); // Row 3
		panel.add(numberButtons[7]); // #7
		panel.add(numberButtons[8]); // #8
		panel.add(numberButtons[9]); // #9
		panel.add(mulButton); // Multiplication Button
		panel.add(decButton); // Decimal Button
		panel.add(numberButtons[0]); // #0
		panel.add(equButton); // Equals Button
		panel.add(divButton); // Divide Button
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		 new Calculator();
	}
	
	/**
	 * Main functionality
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
//		Assign number to button text fields
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
//		Decimal button
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
//		Add button
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+'; // assign operator
			textfield.setText(""); // clear text field
		}
//		Subtract button
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
//		Multiplication button
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
//		Division button
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
//		Equal button
		if(e.getSource()==equButton) {
			num2=Double.parseDouble(textfield.getText());
			
//			Determine math operation
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
//		Clear button
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
//		Delete button -> delete last character
		if(e.getSource()==delButton) {
			String string = textfield.getText(); // Store textfield as string
			textfield.setText("");
//			iterate loop through string
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
//		Negative button
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
	}
}