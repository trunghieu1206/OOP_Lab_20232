package hust.soict.globalict.test.cart;

import java.util.ArrayList;

public class TestClass {

	public static void main(String[] args) {
		// Creating an Empty Integer ArrayList 
        ArrayList<Integer> arr = new ArrayList<Integer>(4); 
  
        // Using add() to initialize values 
        // [10, 20, 30, 40] 
        arr.add(10); 
        arr.add(20); 
        arr.add(30); 
        arr.add(40); 
  
        // Printing elements of list 
        System.out.println("List: " + arr); 
  
        // Getting element at index 2 
        int element = arr.get(0); 
  
        // Displaying element at specified index 
        // on console inside list 
        System.out.println("the element at index 2 is " + element); 
	}

}
