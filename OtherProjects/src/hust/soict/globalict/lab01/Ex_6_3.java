package hust.soict.globalict.lab01;

import java.util.Scanner;
public class Ex_6_3{
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter number of lines to print: ");
        int n = keyboard.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = n; j > i; j--){
                System.out.print(" ");
            }
            for(int k = 0; k < 2*i + 1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        keyboard.close();
        System.exit(0);
    }
}
