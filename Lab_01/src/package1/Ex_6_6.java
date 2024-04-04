package package1;

import java.util.Scanner;
public class Ex_6_6{
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter number of rows of 2 matrices: ");
        int m = keyboard.nextInt();
        System.out.println("Enter number of columns of 2 matrices: ");
        int n = keyboard.nextInt();

        int A[][] = new int[m][n];
        int B[][] = new int[m][n];
        int C[][] = new int[m][n];

        System.out.println("Enter the first matrix");
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                A[i][j] = keyboard.nextInt();
            }
        }
        System.out.println("Enter the second matrix");
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                B[i][j] = keyboard.nextInt();
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        System.out.println("Result matrix:");
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
        keyboard.close();
        System.exit(0);
    }
}
