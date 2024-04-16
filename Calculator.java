import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Class declaration
public class Calculator implements ActionListener{

    // Instance variables
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, eqButton, delButton, clrButton, negButton;
    JPanel panel; 

    // Font for text field and buttons
    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    // Variables to store numbers and result of operations
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    // Constructor
    Calculator(){
        // Frame setup
        frame = new JFrame("My Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        // Text field setup
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        // Button setup
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        // Assigning buttons to functionButtons array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = eqButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // Adding ActionListener, setting font, and making buttons not focusable
        for(int i = 0; i < 9; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        // Adding ActionListener, setting font, and making buttons not focusable
        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // Setting bounds for functional buttons
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 130, 50); 
        clrButton.setBounds(275, 430, 120, 50); 

        // Panel setup
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));

        // Adding buttons to panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);

        // Adding components to frame
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    // Main method
    public static void main(String[] args) {
        // Creating instance of Calculator
        Calculator calc = new Calculator();
    }

    // ActionListener implementation
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handling number buttons
        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        // Handling decimal button
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }

        // Handling arithmetic operation buttons
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        // Handling equals button
        if(e.getSource() == eqButton){
            num2 = Double.parseDouble(textField.getText());
            switch(operator){
                case'+':
                    result = num1 + num2;
                    break;
                case'-':
                    result = num1 - num2;
                    break;
                case'*':
                    result = num1 * num2;
                    break;
                case'/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        // Handling clear button
        if(e.getSource() == clrButton){
            textField.setText("");
        }

        // Handling delete button
        if(e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i < string.length()-1; i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }

        // Handling negative button
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
