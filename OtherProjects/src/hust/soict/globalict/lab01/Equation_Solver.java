package hust.soict.globalict.lab01;

import javax.swing.JOptionPane;
import java.lang.Math;

public class Equation_Solver{

    private static void linear_equation(){
        JOptionPane.showMessageDialog(null, "Linear equation format:\n" + "ax + b = 0");
        double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a: "));
        double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter b: "));
        if(a == 0){
            if(b == 0){
                JOptionPane.showMessageDialog(null, "Infinitely many solutions");
            } else{
                JOptionPane.showMessageDialog(null, "No solution");
            }
        } else{
            double sol = -b / a;
            JOptionPane.showMessageDialog(null, "Solution is: " + sol);
        }
    }
    
    public static void system_equations(){
        JOptionPane.showMessageDialog(null, "System of 2 linear equations format:\na11.x1 + a12.x2 = b1\na21.x1 + a22.x2 = b2");
        double a11 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a11: "));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a12: "));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter b1: "));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a21: "));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a22: "));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter b2: "));
        double D = a11*a22 - a21*a12;
        double Dx = b1*a22 - b2*a12;
        double Dy = a11*b2 - a21*b1;
        JOptionPane.showMessageDialog(null, "Solutions are:\n" + "x1 = " + Dx/D + "\nx2 = " + Dy/D);
    }
    
    public static void second_degree(){
        JOptionPane.showMessageDialog(null, "Quadratic equation format:\n" + "ax^2 + bx + c = 0");
        double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a: "));
        double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter b: "));
        double c = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter c: "));
        if(a == 0){
            if(b == 0){
                if(c == 0){
                    JOptionPane.showMessageDialog(null, "Infinitely many solutions");
                } else{
                    JOptionPane.showMessageDialog(null, "No solution");
                }
            } else{
                JOptionPane.showMessageDialog(null, "Solution is: x = " + (-c / b) );
            }
        } else{
            double delta = b*b - 4*a*c;
            if(delta < 0){
                JOptionPane.showMessageDialog(null, "No solution");
            } else if(delta == 0){
                JOptionPane.showMessageDialog(null, "Solution is: x = " + (-b /(2*a)) );
            } else{
                double x1 = (-b + Math.sqrt(delta))/(2*a);
                double x2 = (-b - Math.sqrt(delta))/(2*a);
                JOptionPane.showMessageDialog(null, "Solutions are:\nx1 = " + x1 + "\nx2 = " + x2);
            }
        }
    }

    public static void main(String[] args){
        String user_choice;
        user_choice = JOptionPane.showInputDialog(null, "Choose which kind of option: \n" + "1: Linear equation\n" + "2: System of 2 linear equations\n" + "3: Second-degree equation");
        
        switch(user_choice){
            case "1":
                linear_equation();
                break;
            case "2":
                system_equations();
                break;
            case "3":
                second_degree();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice");
        }

        System.exit(0);
    }
}

    
