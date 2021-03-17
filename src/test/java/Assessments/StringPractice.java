package Assessments;

import java.util.Scanner;

public class StringPractice {

    public static void main(String[] args) {


        /*
        Task %1
        Write the program to get the string value from the specified position. First, ask the user to enter
        one String value. Then ask the user the enter starting number and ending number. After that, print
        the value between the given starting and ending numbers. (Note: since the user does not know the java,
        the user starts counting from 1 and ending number will be included) Example:
        Please enter the String value: Definition of Science
        Please enter the starting number: 2
        Please enter the ending number: 5
        The output is: efin
         */

//        Scanner sc1  = new Scanner(System.in);
//        System.out.println("Please enter the String value: ");
//        String userInput1 = sc1.nextLine();
//        System.out.println("Please enter the starting number: ");
//        int starStrPoint1 = sc1.nextInt();
//        System.out.println("Please enter the ending number: ");
//        int endStrPoint1 = sc1.nextInt();
//        String userOutput1 = userInput1.substring(starStrPoint1, endStrPoint1);
//        System.out.println(userOutput1);





        /*
        Task %2
        Please use method chaining for the following Strings. Methods are provided next to the String.
        String “ Snicker “; —> trim, toUpperCase, substring and charAt methods
        String “Cookie” —> toLowerCase, replace ‘o’ with ‘u’, concat with ’s’, starts with ‘C’
         */

//        String stringTask2_1 = " Snicker ";
//        String newStringTask2_1 = stringTask2_1.trim();
//        String stringTask2_2 = "Cookie";
//        String newStringTask2_2 = stringTask2_2.toLowerCase().replace('o','u').concat("s");



        /*
        Task %3
        Using a scanner enter three different ingredients for the product on the same line. Then ask the user to enter any int number.
        Change the first letter of the ingredients starting from the entered number. (Ingredients should start with different letters.
        Please read the example carefully ) Example 1:
        Please enter three ingredients with spaces: Milk Peanuts Butter
        Please enter the int number: 5
        The output is: 5ilk 6eanuts 7utter
        Example 2:
        Please enter three ingredients with spaces: Sugar Cocoa Oil
        Please enter the int number: 3
        The output is: 3ugar 4ocoa 5il
         */


//        Scanner sc3  = new Scanner(System.in);
//        System.out.println("Please enter the String value: ");
//        String userStrInput3 = sc3.nextLine().trim().trim();
//        System.out.println("Please enter the int number: ");
//        int userIntInput3 = sc3.nextInt();
//        int indexOfSpace = userStrInput3.indexOf(' ');
//
//        String firstString = userIntInput3 + userStrInput3.substring(1,indexOfSpace);
//
//        String temperString = userStrInput3.substring(indexOfSpace).trim();
//        indexOfSpace = temperString.indexOf(' ');
//
//
//        String secondString = ++userIntInput3 + temperString.substring(1,indexOfSpace);
//        temperString = temperString.substring(indexOfSpace).trim();
//
//        String thirdString = ++userIntInput3 + temperString.substring(1);
//        String resultString = firstString+" "+secondString+" "+thirdString;
//        System.out.println(resultString);






        /*
        Task %4
        Using scanner enter String (two words) value with spaces in the beginning and at the end. In this input
        the second word is not starting with upper case, using string methods change the letter with upper case and print it
        Example 1:
        Please enter the String with following format “ word “ Natural black
        The output is:
        Natural Black
         */

//        Scanner sc4  = new Scanner(System.in);
//        System.out.println("Please enter the String value: ");
//        String userInput4 = sc4.nextLine().trim();
//        int indexOfSpace = userInput4.indexOf(' ');
//        String newUserInput4 = userInput4.substring(0, indexOfSpace)+" "+ Character.toUpperCase(userInput4.charAt(indexOfSpace+1))
//                + userInput4.substring(indexOfSpace+2);
//        System.out.println(newUserInput4);







        /*
        Task %5
        Using scanner ask user to enter one String value. If string length is bigger than or equals to 3 print
        the string without first and last char. If the length is not bigger than 3 print print as it is. (for this
        task you need to use if statement).
        Example 1:
        Please enter the String value: test
        The output is: es
        Example 2:
        Please enter the String value: Hello
        The output is: ell
         */

//        Scanner sc5  = new Scanner(System.in);
//        System.out.println("Please enter the String value: ");
//        String userInput5 = sc5.nextLine();
//        int userInput5Length = userInput5.length();
//        int userInput5MidLength = userInput5.length()/2;
//        if (userInput5Length <= 3) System.out.println(userInput5);
//        else System.out.println(userInput5.substring(userInput5MidLength-1, userInput5MidLength+1));







        /*
        Task %6
        Using scanner ask user to enter one String value. If this String length is odd number print middle 3
        string from given value. (You need to use if statement for this task)
        Example 1:
        Please enter the String value: test
        The output is:
        (Since "test" length is not odd number output should be nothing) Example 2:
        Please enter the String value: Chicago
        The output is: ica
         */

//        Scanner sc6  = new Scanner(System.in);
//        System.out.println("Please enter the String value: ");
//        String userInput6 = sc6.nextLine();
//        int userInput6MidLength = userInput6.length()/2;
//        if (userInput6.length()%2 != 0)
//            System.out.println(userInput6.substring(userInput6MidLength-1, userInput6MidLength+2));
//        else System.out.println("Input String length is not odd number");







        /*
            Task %7
            Write a Java program to get a number from the user and print whether it is positive or negative.
            Input number: 35
            Output :Number is positive
         */

//        Scanner sc7  = new Scanner(System.in);
//        System.out.println("Input number: ");
//        int userInput7 = sc7.nextInt();
//        if (userInput7>=0)
//            System.out.println(userInput7+" -> Number is positive!");
//        else if(userInput7<0)
//            System.out.println(userInput7 + " -> Number is negative!");



    }





}
