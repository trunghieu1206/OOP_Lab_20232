package package1;

import javax.swing.JOptionPane;
public class Number_calculator {
	public static void main(String[] args){
		String strNum1, strNum2;
        
		String strNotification = "You've just entered: ";
		
		strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
		double num1 = Double.parseDouble(strNum1);
        
		strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
		double num2 = Double.parseDouble(strNum2);
		
        //Sum
        double sum = num1 + num2;
        JOptionPane.showMessageDialog(null, "The sum of the two numbers is: " + sum);

        //Difference
        double diff = num1 - num2;
        JOptionPane.showMessageDialog(null, "The diff of num1 - num2 is: " + diff);

        //Product
        double prod = num1 * num2;
        JOptionPane.showMessageDialog(null, "The product of the two numbers is: " + prod);

        //division
        if(num2 == 0){
            JOptionPane.showMessageDialog(null, "Cannot divide by 0");
        } else{
            double div = num1 / num2;
            JOptionPane.showMessageDialog(null, "The quotient of the two numbers is: " + div);
        }

		System.exit(0);
	}
}

