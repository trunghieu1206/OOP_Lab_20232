package package1;

import java.util.Scanner;
public class Ex_6_4{
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter month: ");
        String month = keyboard.nextLine();
        
        System.out.println("Enter year: (Only number allowed)");
        int year = keyboard.nextInt();

        if(month.equals("Jan") || month.equals("January") || month.equals("Jan.")) month = "1";
        if(month.equals("Feb") || month.equals("February") || month.equals("Feb.")) month = "2";
        if(month.equals("March") || month.equals("Mar") || month.equals("Mar.")) month = "3";
        if(month.equals("April") || month.equals("Apr") || month.equals("Apr.")) month = "4";
        if(month.equals("May")) month = "5";
        if(month.equals("June") || month.equals("Jun")) month = "6";
        if(month.equals("July") || month.equals("Jul")) month = "7";
        if(month.equals("August") || month.equals("Aug.") || month.equals("Aug")) month = "8";
        if(month.equals("September") || month.equals("Sep.") || month.equals("Sep")) month = "9";
        if(month.equals("October") || month.equals("Oct.") || month.equals("Oct")) month = "10";
        if(month.equals("November") || month.equals("Nov.") || month.equals("Nov")) month = "11";
        if(month.equals("December") || month.equals("Dec.") || month.equals("Dec")) month = "12";

        switch(month){
            case "1":
                System.out.println("31 days"); 
                break;
            case "2":
                if(year % 100 == 0){
                    if(year % 400 == 0){
                        System.out.println("29 days");
                    } else System.out.println("28 days");
                } else{
                    if(year % 4 == 0){
                        System.out.println("29 days");
                    } else System.out.println("28 days");
                }
                break;
            case "3":
                System.out.println("31 days");
                break;
            case "4":
                System.out.println("30 days");
                break;
            case "5":
                System.out.println("31 days");
                break;
            case "6":
                System.out.println("30 days");
                break;
            case "7":
                System.out.println("31 days");
                break;
            case "8":
                System.out.println("31 days");
                break;
            case "9":
                System.out.println("30 days");
                break;
            case "10":
                System.out.println("31 days");
                break;
            case "11":
                System.out.println("30 days");
                break;
            case "12":
                System.out.println("31 days");
                break;
            default:
                System.out.println("Invalid month");
        }
        keyboard.close();
        System.exit(0);
    }
}