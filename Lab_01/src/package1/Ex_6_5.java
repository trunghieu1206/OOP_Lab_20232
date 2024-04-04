package package1;

import java.util.Scanner;
public class Ex_6_5{
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = keyboard.nextInt();
        int A[] = new int[n];
        int sum = 0;

        System.out.println("Enter each element in the array : ");
        for(int i = 0; i < n; i++){
            System.out.println("Enter the " + (i + 1) + "th element");
            A[i] = keyboard.nextInt();
            sum += A[i];
        }
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(A[i] > A[j]){
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
        System.out.print("Array after sorted: ");
        for(int i = 0; i < n; i++){
            System.out.print(A[i] + " ");
        }
        System.out.print("\nAverage value of elements: " + sum/n);
        keyboard.close();
        System.exit(0);
    }
}
