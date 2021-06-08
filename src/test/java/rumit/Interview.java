package rumit;

import java.util.Scanner;

public class Interview {

    public static String questionsMarks2(String str) {
        int questionsMarksCount = 0;
        int start = 0;
        int end = 0;
        boolean started = false;
        int firstNum = 0;
        int lastNumb = 0;

        for(int i = 0; i < str.length(); i++){
            if(!started && Character.isDigit(str.charAt(i))){
                start = i;
                firstNum = Integer.parseInt(""+ str.charAt(i));
                started = true;
            } else if(started && Character.isDigit(str.charAt(i))){
                end = i;
                lastNumb = Integer.parseInt(""+ str.charAt(i));
                String temp = str.substring(start, end+1);
                for(int j = 0; j < temp.length(); j++){
                    if(temp.charAt(j)=='?'){
                        questionsMarksCount++;
                    }
                }
                int sum = firstNum + lastNumb;
                if(questionsMarksCount == 3 && sum == 10) {
                    return "true";
                }
                questionsMarksCount=0;
                started = false;
            }
        }
        return "false";
    }


    public static String camelCase2(String str) {
        /*
        Input: "BOB loves-coding" Output: "bobLovesCoding"
        Input: "cats AND*Dogs-are Awesome" Output: "catsAndDogsAreAwesome"
        Input: "a b c d-e-f%g" Output: "aBCDEFG"
         */
        String result = "";
        String[] strArr = str.split("[^\\w]+");
        for(int i = 0; i<strArr.length; i++){
            String temp = strArr[i];
            if(i>0) {
                if(temp.length()>1)
                    result+=String.valueOf(temp.charAt(0)).toUpperCase()+temp.substring(1).toLowerCase();
                else
                    result+=temp.toUpperCase();
            }else{
                result+=temp.toLowerCase();
            }
        }
        return result;
    }



    public static int getIndex(int[] arr){
        for (int i = 0; i<arr.length; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = i-1; j>=0; j--) {
                sum1 += arr[j];
            }
            for (int k = i+1; k <= arr.length-1; k++) {
                sum2 += arr[k];
            }
            if (sum1 == sum2) {
                return i;
            }
        }
        return -1;
    }




    public static String longestWord(String sen) {
        String[] strArray = sen.trim().split(" ");
        String longestStr = "";
        for(int i=0; i<strArray.length; i++){
            String tempStr = strArray[i].replace("[^\\w]+","");
            if(tempStr.length() >= longestStr.length()){
                longestStr = tempStr;
            }
        }
        return longestStr;
    }


    public static void main(String[] args) {
        String input1 = "aa6?9"; // false
        String input2 = "acc?7??sss?3r1??????5"; // true
        String input3 = "BOB loves-coding";
        String input4 = "cats AND*Dogs-are Awesome";
        String input5 = "I love dogs";
        System.out.println(questionsMarks2(input1));
        System.out.println(questionsMarks2(input2));
        System.out.println(camelCase2(input3));
        System.out.println(camelCase2(input4));
        System.out.println(longestWord(input5));



        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a month number: ");
        int month = userInput.nextInt();
        System.out.println("Enter a year number: ");
        int year = userInput.nextInt();

        if(month == 1 && year>0){
            System.out.println("January " + year + " has" + " 31 days!");
        } else if(month == 2 && year > 0){
            System.out.println("February " + year + " has" + " 28 days!");
        } else if(month == 3 && year > 0){
            System.out.println("March " + year + " has" + " 31 days!");
        } else if(month == 4 && year > 0){
            System.out.println("April " + year + " has" + " 30 days!");
        } else if(month == 5 && year > 0){
            System.out.println("May " + year + " has" + " 31 days!");
        } else if(month == 6 && year > 0){
            System.out.println("June " + year + " has" + " 30 days!");
        } else if(month == 7 && year > 0){
            System.out.println("July " + year + " has" + " 31 days!");
        } else if(month == 8 && year > 0){
            System.out.println("August " + year + " has" + " 31 days!");
        } else if(month == 9 && year > 0){
            System.out.println("September " + year + " has" + " 30 days!");
        } else if(month == 10 && year > 0){
            System.out.println("October " + year + " has" + " 31 days!");
        } else if(month == 11 && year > 0){
            System.out.println("November " + year + " has" + " 30 days!");
        } else if(month == 12 && year > 0){
            System.out.println("December  " + year + " has" + " 31 days!");
        } else
            System.err.println("NoSuchMonthException! There is no such a month re mlk!");





    }








}
