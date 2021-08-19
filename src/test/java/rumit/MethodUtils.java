package rumit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MethodUtils {

    /*
    int[] myIntArray = new int[3];
    int[] myIntArray = {1, 2, 3};
    int[] myIntArray = new int[]{1, 2, 3};
    Since Java 8. Doc of IntStream: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.htm
    int [] myIntArray = IntStream.range(0, 100).toArray(); // -> From 0 to 99
    int [] myIntArray = IntStream.rangeClosed(0, 100).toArray(); // -> From 0 to 100
    int [] myIntArray = IntStream.of(12,25,36,85,28,96,47).toArray(); // -> The order is preserved
    int [] myIntArray = IntStream.of(12,25,36,85,28,96,47).sorted().toArray(); // -> Sort
     */

    public static void reverseStrWithBufferedReader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int N = Integer.parseInt(input);

        for (int i = 0; i < N; i++) {
            input = reader.readLine();
            String[] inputArray = input.split(" ");
            String[] reverseInputArray = new String[inputArray.length];
            StringBuffer strSB;
            String reverseStr = "";

            for (int g = 0; g < inputArray.length; g++) {
                strSB = new StringBuffer(inputArray[g]);
                reverseInputArray[g] = String.valueOf(strSB.reverse());
            }
            for (int q = 0; q < reverseInputArray.length; q++) {
                reverseStr = reverseStr + " " + reverseInputArray[q];
            }
            System.out.println(reverseStr.trim());
        }
    }


    public static int palindromeCount(int number1, int number2){
        int count=0;
        for(int i=number1;i<=number2;i++) {
            int reversed = 0;
            int nums = i; // make this i
            if (nums < 0) {
                nums = nums * (-1);
            }
            while (nums > 0) {
                reversed = reversed * 10 + nums % 10;
                nums /= 10;
            }
            if (i < 0) { // make it i
                reversed = reversed * (-1);
            }
            if(i==reversed){ // make it i
                count++;
            }
        }
        return count;
    }



    public static String addMinutes(String timeWithString, int time) {
        // For example, AddMinutes("9:10 AM", 200) would return"12:30 PM".
        String aMPm = timeWithString.substring(timeWithString.length() - 2);
        String hoursAndMinStr[] = timeWithString.split(":");
        String hourStr = hoursAndMinStr[0];

        String minutesAndAmPmStr = hoursAndMinStr[1];
        String minutesStr = minutesAndAmPmStr.substring(0, minutesAndAmPmStr.length() - 2).trim();

        int parsedHours = Integer.parseInt(hourStr);
        int parsedMin = Integer.parseInt(minutesStr);
        int totalMin = (parsedHours * 60) + parsedMin + time;

        int finalMin = totalMin % 60;
        int finalHour = (totalMin - finalMin) / 60;

        if (finalHour >= 12) {
            if (aMPm.equalsIgnoreCase("AM")) {
                aMPm = "PM";
            } else if (aMPm.equalsIgnoreCase("PM")) {
                aMPm = "AM";
            }
        }
        if (finalHour > 12) finalHour = finalHour - 12;
        String finalStr = finalHour + ":" + finalMin + " " + aMPm;
        return finalStr;
    }


// ============================================================ //


    public static boolean checkStringIfCapLowNum(String str) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;

        for(int i=0;i < str.length();i++) {
            ch = str.charAt(i);
            if( Character.isDigit(ch)) numberFlag = true;
            else if (Character.isUpperCase(ch)) capitalFlag = true;
            else if (Character.isLowerCase(ch)) lowerCaseFlag = true;
            if(numberFlag && capitalFlag && lowerCaseFlag) return true;
        }
        return false;
    }



    public static int palindromeNum(int num) {
        int origin = num;
        int reversed = 0;

        while (num > 0) {
            int singleNum = num % 10;
            num = num / 10;
            reversed = reversed * 10 + singleNum;
        }
        if (origin == reversed) return reversed;
         else return -1;
    }

    public static List<String> palindromeStringWithStreamFilter1(List<String> list) {
        List<String> res = new ArrayList<>();
        list.forEach(a->{
            if(a.equals(new StringBuilder(a).reverse().toString())){
                res.add(a);
            }
        });
        return res;
    }


    public static List<String> palindromeStringWithStreamFilter2(List<String> list) {
        return list.stream().filter(a->a.equals(new StringBuilder(a).reverse().toString())).collect(Collectors.toList());
    }


    static boolean tellPalindrome ( int[] arrayNum){ // So we return boolean and accept array of int
        // I create new Array with the same length of my 'arrayNum'
        int newArrayNum[] = new int[arrayNum.length];
        // int primitive 'starting' = 0;
        int starting=0;
        // We loop through array of 'arrayNum' from the back
        for (int i = arrayNum.length-1; i >=0; i--) {
            // and store in to the newArray
            newArrayNum[starting] = arrayNum[i];
            starting++; // increasing the starting int with ++
        }
        // Just compare two Array, by that I will understand if they are equal or no
        if (Arrays.equals(arrayNum,newArrayNum)) return true;
        else return false;
    }

    static int[] reverseIntArray ( int[] arrayNum){
        int reverseArray[] = new int[arrayNum.length];
        if(arrayNum.length==0 || arrayNum.length==1) return arrayNum;
        for (int i = arrayNum.length-1, k=0; i >=0; i--,k++) {
            arrayNum[i] = reverseArray[k];
        }
        return reverseArray;
    }

    public static int reverseNum(int num) {
        int reversed = 0;

        while (num > 0) {
            int singleNum = num % 10;
            num = num / 10;
            reversed = reversed * 10 + singleNum;
        }
        return reversed;
    }


    public int reverseNum2(int num) {
        int reverseNum = 0;
        boolean isNegative = false;

        if (num < 0) {
            num = -num;
            isNegative = true;
        }

        while (num != 0) {
            int singleNum = num % 10;
            num = num / 10;
            reverseNum = reverseNum * 10 + singleNum;
        }

        if (isNegative) reverseNum = -reverseNum;
        return reverseNum;
    }





    public static boolean isAnagram(String str1, String str2) {
        //     1. Checking if both String have same length
        if (str1.length() != str2.length()) return false;
        //     2. Create two char Array, and store the String as Char Arrays
        char[] str1arr = str1.toCharArray(); // march -> m,a,r,c,h
        char[] str2arr = str2.toCharArray(); // charm -> c,h,a,r,m
        //     3. Sort that Array
        Arrays.sort(str1arr);
        Arrays.sort(str2arr);
        //     4. Check if the two char arrays equals, and return true/false
        return Arrays.equals(str1arr, str2arr);
    }

    public static void sumOfNumbers(String str) {
        int sum = 0;
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                String empty = "" + str.charAt(i);
                num = Integer.parseInt(empty);
                sum += num;
            }
        }
        System.out.println(sum);
    }

    public static long fibonacciNum(int n) {
        long startNum = 0;
        long nextNum = 1;
        long sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = startNum + nextNum;
            startNum = nextNum;
            nextNum = sum;
        }
        return nextNum;
    }


    public static long fibonacciNum2(int n) {
        long[] arrayN = new long[n+1];
        arrayN[0] = 0;
        arrayN[1] = 1;
        for (int i=2; i <= n; i++){
            arrayN[i] = arrayN[i-1] + arrayN[i-2];
        }
        return arrayN[n];
    }


    public void fizzBuzz(int n) {
        for (int i = 0; i <= n; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }


    public static void fizzBuzz2(int n){
        for (int i = 0; i <= n; i++) {
            String result = (i%15 == 0) ? "FizzBuzz" : (i%5 == 0) ? "Fizz" : (i%3 == 0) ? "Buzz" : ""+i;
            System.out.println(result);
        }
    }


    public static int fizzBuzz3(int n){
        if(n<=0) return n;
        if(n==1) return n;
        String result = (n%15 == 0) ? "FizzBuzz" : (n%5 == 0) ? "Fizz" : (n%3 == 0) ? "Buzz" : ""+n;
        System.out.println(result);
        return fizzBuzz3(n -1);
    }


    public static boolean isMissingNum(int[] numbers) {
        Arrays.sort(numbers);
        boolean found = true;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] + 1 != numbers[i + 1])
                found = false;
        }
        return found;
    }


    public static int largeNumberInArray(int[] num) {
        int firstNumberOfArray = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] > firstNumberOfArray) {
                firstNumberOfArray = num[i];
            }
        }
        return firstNumberOfArray;
    }



// ============================================================ //


    public int mostFrequentNumberInTheArray(int arr [], int n){
        if(arr.length == 0) return -1;
        Arrays.sort(arr);
        int max_count = 1;
        int result = arr[0];
        int curr_count = 1;
        for (int i = 1; i < n; i++){
            if (arr[i] == arr[i - 1]) curr_count++;
            else{
                if (curr_count>max_count){
                    max_count = curr_count;
                    result= arr[i-1];
                }
                curr_count=1;
            }
        }
        if (curr_count>max_count){
            max_count=curr_count;
            result= arr[n-1];
        }
        return result;
    }


    public static  String firstRepeatedWord(String sentence){
        sentence = sentence.replaceAll("\\s+", " ");
        String [] arr = sentence.split(" ");
        Set<String> set = new LinkedHashSet<>();
        return Arrays.stream(arr).filter(a->!set.add(a)).findFirst().orElse(null);
        // OR --->
        // String result =  Arrays.stream(arr).filter(a->!set.add(a)).findFirst().orElse(null);
        // if (result==null) return arr[0];
        // else return result;
    }

    public static List<Integer> isSelfDividingNumbers(int left, int right){
        /*
            A self-dividing number is a number that is divisible by every digit it contains.
            For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
            Also, A self-dividing number is NOT allowed to contain the digit ZERO:
            Input: left = 1, right = 22;
            Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
            Input: left = 47, right = 85;
            Output: [48,55,66,77]
         */
        List<Integer> list = new ArrayList<>();
        boolean isModule = false;
        for (int i=left; i<=right; i++) {
            String str = String.valueOf(i);
            for (int j=0; j<str.length(); j++) {
                int temp = Integer.parseInt(str.charAt(j)+"");
                if(temp == 0){
                    isModule = false;
                    break;
                }else if (i%temp==0){
                    isModule = true;
                }else {
                    isModule = false;
                    break;
                }
            }
            if (isModule) list.add(i);
        }
        return list;
    }


    public static long multiNumbers(long n){
        if(n <= 0) return -1;
        if(n == 1) return 1;
        return n * multiNumbers(n - 1);
    }

    public static int sumNumbers(int n){
        if(n <= 0) return -1;
        if(n == 1) return 1;
        return n+sumNumbers(n - 1);
    }

    public static String reverseStr1(String str) {
        if (str == null || str.length() <= 1) return str;
        else return reverseStr1(str.substring(1)) + str.charAt(0);
    }

    public static String reverseStr2(String str) {
        if (str == null || str.length() == 1) return str;
        char last = str.charAt(str.length()-1);
        str = str.substring(0, str.length()-1);
        return last + reverseStr2(str);
    }

    public static String reverseStr3(String str){
        if (str == null || str.equals("")) return str;
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseStr4(String str){
        String reverseStr = "";
        if (str == null || str.isEmpty()) return str;
        for (int i=str.length()-1; i>=0; i--) {
            reverseStr += str.charAt(i);
        }
        return reverseStr;
    }

    public static boolean stringRotation(String str1, String str2){
        return (str1.length() == str2.length()) && ((str1 + str1).contains(str2));
    }


    public static String questionsMarks(String str) {
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



    public static String camelCase(String str) {
        /*
        Input: "BOB loves-coding" Output: "bobLovesCoding"
        Input: "cats AND*Dogs-are Awesome" Output: "catsAndDogsAreAwesome"
        Input: "a b c d-e-f%g" Output: "aBCDEFG"
         */
        String result = "";
        String[] strArr = str.split("[^\\w]+");
        for(int i = 0; i<strArr.length; i++){
            String temp = strArr[i];
            if(i>0){
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



    public static String camelCase2(String str) {
        String temp = "";
        str=str.toLowerCase();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='a' && str.charAt(i)<='z'){
                temp+=str.charAt(i);
            }else{
                str=str.substring(0,i)+str.substring(i+1);
                temp =temp+ str.substring(i,i+1).toUpperCase();
            }
        }
        return temp;
    }

    public static Set<Integer> findUniqueDuplicatesInTheList(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        return list.stream().filter(a->!set.add(a)).collect(Collectors.toSet());
    }


    public static List<Integer> findAllDuplicatesInTheList(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        return list.stream().filter(a->!set.add(a)).collect(Collectors.toList());
    }





    public static int priceCheckHackerRank(List<String> products, List<Float> productPrices,
                                           List<String> productSold, List<Float> soldPrice){
        int count = 0;
        List<Float> listOfOriginalPricesSold = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            for (int q = 0; q < productSold.size(); q++) {
                if (products.get(i).equalsIgnoreCase(productSold.get(q))) {
                    listOfOriginalPricesSold.add(productPrices.get(i));
                }
            }
        }
        Collections.sort(listOfOriginalPricesSold);
        Collections.sort(soldPrice);

        for (int i = 0; i < soldPrice.size(); i++) {
            if (!listOfOriginalPricesSold.get(i).equals(soldPrice.get(i)))
                count++;
        }
        return count;
    }



    public static int secondLargestNumber(int[] arr){
        if(arr.length==0) return -1;
        if(arr.length==1) return arr[0];
        for(int i=0;i<arr.length;i++){
            boolean switched = false;
            for(int b=0;b<arr.length-1;b++){
                if(arr[b]>arr[b+1]){
                    int temp=arr[b];
                    arr[b]=arr[b+1];
                    arr[b+1]=temp;
                    switched=true;
                }
            }
            if(switched==false){
                break;
            }
        }
        int secondMax=0;
        int max=arr[arr.length-1];
        for(int k=arr.length-1;k>=0;k--){
            if(arr[k]!=max && arr[k]<max){
                secondMax=arr[k];
                break;
            }
        }
        return secondMax;
    }

    public static int secondLargestNumber2(int array[]) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        // Loop over the array
        for (int i = 0; i < array.length; i++) {
            // If we've found a new highest number...
            if (array[i] > highest) {
                // ...shift the current highest number to second highestisSelfDividingNumbers(int left, int right){
                secondHighest = highest;
                // ...and set the new highest.
                highest = array[i];
            } else if (array[i] > secondHighest && array[i] != highest)
                // Just replace the second highest
                secondHighest = array[i];
        }
        return secondHighest;
    }


    public static List<Integer> uniqueIntegersInTheListOfIntegers(List<Integer> inputList) {
        /*
            Write a Java code to get list of unique items in a given list,
            skip if there are any strings and handle them.
            list1 = [10,20,10,30,40,40] -> [10,20,30,40]
        */
        return inputList.stream().distinct().collect(Collectors.toList());
    }


    public static List<Integer> uniqueIntegersInTheListOfObjects(List<Object> inputList) {
        /*
            Write a Java code to get list of unique items in a given list,
            skip if there are any strings and handle them.
             list1 = ["4",8,8,8,"Java","Java",1,10,10,null,"",-1,-1] -> [8,1,10,-1]
        */
        List<Integer> listInteger = new ArrayList<>();
        for (Object obj : inputList ) {
            if (obj instanceof Integer) listInteger.add((Integer)obj);
        }
        return listInteger.stream().distinct().collect(Collectors.toList());
    }


    public static List<Integer> uniqueIntegersInTheListOfObjects2(List<Object> inputList) {
        /*
            Write a Java code to get list of unique items in a given list,
            skip if there are any strings and handle them.
             list1 = ["4",8,8,8,"Java","Java",1,10,10,null,"",-1,-1] -> [8,1,10,-1]
        */
        return inputList.stream().filter(a->a instanceof Integer).distinct().map(e-> (Integer) e).collect(Collectors.toList());
    }

    public static List<Integer> increaseEachElementWithAddNumber(List<Integer> inputList, int addNumber) {
        /*
             list1 = [1,8,2,3,10], 3 -> [3,11,5,6,13]
        */
        return inputList.stream().map(a->a+addNumber).collect(Collectors.toList());
    }

    public static List<Integer> increaseEachElementWithAddNumber2(List<Integer> inputList, int addNumber) {
        /*
             list1 = [1,8,2,3,10], 3 -> [3,11,5,6,13]
        */
        inputList.replaceAll(a->a+addNumber);
        return inputList;
    }


    public static List<Integer> findIndexesOfMatchingValuesInTheFirstList(List<Integer> firstList, List<Integer> secondList) {
        /*
            Find the indices of matching elements in 2 arrays
            test_list1 = [5, 7, 8, 9, 10, 11]
            test_list2 = [8, 10, 11]
        */
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < secondList.size(); i++) {
            for (int j = 0; j < firstList.size(); j++) {
                if (secondList.get(i).equals(firstList.get(j))){
                    resultList.add(j);
                    break;
                }
            }
        }
        return resultList;
    }





    public static int priceCheck(List<String> products, List<Float> productPrice, List<String> productSold, List<Float> soldPrice) {
        HashMap<String, Float> priceList = new HashMap<>();
        for(int i=0; i<products.size(); i++) {
            priceList.put(products.get(i),productPrice.get(i));
        }
        int result =0;
        for(int i=0; i<productSold.size(); i++) {
            float current = priceList.get(productSold.get(i));
            float compare = soldPrice.get(i);
            result = (current == compare) ? result : result+1;
        }
        return result;
    }






    public static boolean matrixMethod(char[][] matrix, String firstWord, String secondWord) {
        String horizontal = "";
        String vertical = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                horizontal += "" + matrix[i][j];
                vertical += "" + matrix[j][i];
            }
            horizontal = horizontal + " ";
            vertical = vertical + " ";
        }
        if ((horizontal.contains(firstWord) || vertical.contains(firstWord)) ||
                (horizontal.contains(secondWord) || vertical.contains(secondWord))) {
            return true;
        }
        return false;
    }


    public static void evenAndLessFifty(int[] arr){
        if (arr.length==0) System.out.println("Array is empty");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2==0 && arr[i]<50) System.out.println(arr[i]);
        }
    }

    public static void evenAndLessFifty2(int [] arr){
        Arrays.stream(arr).filter(a->a%2==0 && a<50).forEach(e->System.out.println(arr[e]));
    }

    public static int factorialNumber(int num){
        if(num==1) return 1;
        return factorialNumber(num-1)*num;
    }


    public static String convertPhoneNumberToDigits(String str){
        // 1-800-XFINITY-->1800578394
        str=str.replaceAll("[^\\w\\s]","").toLowerCase();
        Map<String,String> map = new HashMap<>();
        map.put("abc", "2");
        map.put("def", "3");
        map.put("ghi", "4");
        map.put("jkl", "5");
        map.put("mno", "6");
        map.put("pqrs", "7");
        map.put("tuv", "8");
        map.put("wxyz", "9");
        String result="";
        for(int i=0;i<str.length();i++){
            boolean isAdded = false;
            String digit = str.substring(i,i+1);//1
            for(String m:map.keySet()){
                if(m.contains(digit)){
                    result+=map.get(m);
                    isAdded=true;
                    break;
                }
            }
            if(!isAdded){
                result+=digit;
            }
        }
        return result;
    }

    public static int[] twoSumWithMap(int[] numArray, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numArray.length; i++) {
            int difference = target - numArray[i];
            if (map.containsKey(difference)) {
                result[0] = i;
                result[1] = map.get(difference);
                return result;
            }
            map.put(numArray[i], i);
        }
        return result;
    }


    public static int findTheIndexOfNumInTheArray(int[] arr, int target){
        int index = 0;
        if (arr.length == 0) return -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static String firstUniqueCharacterInTheString(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1){
                return ""+s.charAt(i);
            }
        }
        return "";
    }

    public static Character firstUniqueCharacterInTheString2(String input) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            hashMap.put(input.charAt(i), hashMap.getOrDefault(input.charAt(i), 0) + 1);
        }
        for (int z = 0; z < input.length(); z++) {
            if (hashMap.get(input.charAt(z)) == 1){
                return input.charAt(z);
            }
        }
        return null;
    }

    public static boolean isPrimeTraditional(int number) {
        if(number < 2) return false;
        for(int i=2; i<number; i++){
            if(number % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrimeWithLambdaStreamApi(int number) {
        return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
    }

    public static boolean subInTheNumber(int firstNumber, int target) {
        // === First approach with the Loop ===
        String stringHelper = Integer.toString(firstNumber);
        int[] arrayOfFirstNumbers = new int[stringHelper.length()];
        for (int i = 0; i < stringHelper.length(); i++) {
            arrayOfFirstNumbers[i] = stringHelper.charAt(i) - '0';
        } // === *** ===
        // === First approach with the Stream ===
         int[] arrayOfFirstNumbers2 = Integer.toString(firstNumber).chars().map(c -> c - '0').toArray();
        // === *** ===
        for (int i = 0; i < arrayOfFirstNumbers.length; i++) {
            if (arrayOfFirstNumbers[i] == target) return true;
        }
        return false;
    }

    public static boolean subInTheNumber2(int wholeNum, int target){
        String[] arrOfStrings = String.valueOf(wholeNum).split("");
        String temperString = String.valueOf(target);
        return Arrays.asList(arrOfStrings).contains(temperString);
    }

    public static String convertToUpperCase(String str) {
        str = str.trim().substring(0, 1).toLowerCase().concat(str.substring(1));
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals(" ")) {
                str = str.substring(i + 1, i + 2).toUpperCase().concat(str.substring(2));
            }
        }
        return str;
    }

    public static String firstUniqueChar(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1){
                return  ""+s.charAt(i);
            }
        }
        return "";
    }


    public static boolean compareTwoArrays(Integer[] a, Integer[] b) {
        if(a.length == 0 || b.length == 0) return false;
        if(a.length == 0 && b.length == 0) return false;
        return Arrays.asList(a).containsAll(Arrays.asList(b));
    }



    public static int[] twoSumWithList(int[] numArray, int target) {
        int[] result = new int[2];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numArray.length; i++) {
            int difference = target - numArray[i];
            if (list.contains(difference)) {
                result[0] = difference;
                result[1] = numArray[i];
                return result;
            }
            list.add(numArray[i]);
        }
        return result;
    }



    public static int subArrayOfTheSumArray(int[] arr, int target){ // 1,3,5,9,10,15,8  13
        if(arr.length == 0) return 0;
        int a = 0;
        int b = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            int diff = target - arr[i];
            if(!map.containsKey(diff)){
                map.put(arr[i],i);
            } else {
                a = map.get(diff);
                b = i;
                break;
            }
        }
        int res = 0;
        for(int i = a; i <= b; i++){
            res = res + arr[i];
        }
        return res;
    }





    public static int[] combineTwoArraysAndSort(int [] firstIntArray, int [] secondIntArray) {
        // int [] firstIntArray = {3,1,5,0,7};
        // int [] secondIntArray = {10,0,-1,10};
        int [] combinedIntArray = new int[firstIntArray.length+secondIntArray.length];

        int count = 0;
        for(int i =0; i<firstIntArray.length; i++){
            combinedIntArray[i] = firstIntArray[i];
            count++;
        }
        for(int i =0; i<secondIntArray.length; i++){
            combinedIntArray[count] = secondIntArray[i];
            count++;
        }

        int length = combinedIntArray.length;
        for(int i=0; i<length-1; i++){
            for(int j=0; j<length-i-1; j++){
                if(combinedIntArray[j] > combinedIntArray[j+1]){
                    int tempo = combinedIntArray[j];
                    combinedIntArray[j] = combinedIntArray[j+1];
                    combinedIntArray[j+1] = tempo;
                }
            }
        }
        return combinedIntArray;
    }


    public static List<String> errorLogs(String[] logs) {
        /*
            Create a function that outputs all the users who experienced the error.
            Logs are in chronological order from when they occurred don't place package name!
                A => B => C => ERROR / A => C => B => no error / C => B => A => no error / A => B => B => C => no error
                BBCCAA -no error / AABCAAA - error / CCCAAABBBABC - error / ABCAAAAA - error
            String[] logs = { "A:1","A:1","A:2","A:3","A:1","B:1","B:1","B:2","B:3","B:3","A:3","C:3","C:2","C:1","B:1","C:1"};
         */

        Map<Integer, String> count = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            int user = Integer.parseInt("" + logs[i].charAt(logs[i].indexOf(":") + 1));
            if (count.containsKey(user)) {
                String current = "" + logs[i].charAt(0);
                String log = count.get(user) + current;
                count.put(user, log);
            } else {
                String current = "" + logs[i].charAt(0);
                count.put(user, current);
            }
        }
        List<String> result = new ArrayList<>();
        for (Integer user : count.keySet()) {
            if (count.get(user).contains("ABC")) {
                result.add("Error");
            } else {
                result.add("Success");
            }
        }
        return result;
    }

    public static String weirdOrNot(int n) {
        /*
        if given number is odd print out weird
        if given number is even and in a range between 2 and 5 inclusive print out  - not weird
        if given number is even and in range between 6 and 20 inclusive print out  - weird
        if number is even and larger then 20 print out weird (Even == Chetnie)
        */
        String weird = "";

        if (n % 2 != 0) weird = "weird";
        else if (n >= 2 && n <= 5) weird = "not weird";
        else if (n >= 6 && n <= 20) weird = "weird";
        else if (n == 0) weird = "weird";
        else if (n > 20) weird = "weird";
        return weird;
    }


    public static int yerkenazTask(int x) {
        /*
        A: What inputs would you use to test this function? : -10 -> -10, 0 -> 0, 5 -> 6, 10 -> 11, 20 -> 21, 21 -> 210, 25 -> 50
        B: When would the “Return x*10” case be reached, if at all? -> x*10 will be executed only in case if x=21;
        C: What can break this function? Any number within int range <-2147483648 && >2147483648
          -> This function will work as expected from range -2147483648 <= x => 1073741823. Any number bigger
               than 1073741823 (2147483648/2-1) or smaller than -2147483648 will break the function.
         */
        if (x < 5) return x;
        if (x <= 20) return x + 1;
        if (x > 21) return x * 2;
        return x * 10;
    }


    public static Map<Integer, Boolean> errorLogs2(String[] logs) {
        Map<Integer, String> count = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            int user = Integer.parseInt("" + logs[i].charAt(logs[i].indexOf(":") + 1));
            if (count.containsKey(user)) {
                String current = "" + logs[i].charAt(0);
                String log = count.get(user) + current;
                count.put(user, log);
            } else {
                String current = "" + logs[i].charAt(0);
                count.put(user, current);
            }
        }
        Map<Integer, Boolean> mapa = new HashMap<>();
        for (Integer user : count.keySet()) {
            if (count.get(user).contains("ABC")) mapa.put(user,false);
            else mapa.put(user,true);
        }
        return mapa;
    }





    public static int maximizingTheFinalElement(int[] numbers) {
        // arr {3,2,3,5,5,6,7,3,2} -> {2,2,3,3,3,5,5,6,7} -> {1,2,3,3,3,4,5,6,7} -> 7
        Arrays.sort(numbers);
        int firstNumberOfArray = numbers[0];
        int lastNumberOfArray = 0;
        if (firstNumberOfArray != 1) numbers[0] = 1;

        for (int i = 0; i < numbers.length - 1; i++) {
            if ((numbers[i] + 1 != numbers[i + 1]) && (numbers[i] != numbers[i + 1])) {
                numbers[i + 1] = numbers[i] + 1;
            }
        }
        lastNumberOfArray = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > lastNumberOfArray) {
                lastNumberOfArray = numbers[i];
            }
        }
        return lastNumberOfArray;
    }







    public static Map<Integer, Integer> countIntegerInList(List<Integer> list) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>(Collections.<Integer>reverseOrder());
        //Map<Integer, Integer> map2 = new TreeMap<Integer, Integer>();
        //Map<Integer, Integer> map3 = new HashMap<Integer, Integer>();

        for (int i = 0; i < list.size(); i++) {
            if (map.keySet().contains(list.get(i))) {
                map.put(list.get(i), map.get(list.get(i)) + 1);
            } else {
                map.put(list.get(i), 1);
            }
        }
        return map;
    }






    // method used to count characters in a String
    public static void countCharsWithMap(String message) {
        Map<Character, Integer> numCharMap = new HashMap<>();
        for (int i = 0; i < message.length(); i++) {
            // Take one character
            char c = message.charAt(i);
            // We don't need to count spaces
            if (c == ' ')
                continue;
            // If that character is already there in the map
            // then increase the value by 1
            if (numCharMap.containsKey(c)) {
                numCharMap.put(c, numCharMap.get(c) + 1);
            } else {
                // otherwise put that character in the map
                // with the value as 1
                numCharMap.put(c, 1);
            }
        }
        // Displaying the map values
        Set<Map.Entry<Character, Integer>> numSet = numCharMap.entrySet();
        for (Map.Entry<Character, Integer> m : numSet) {
            System.out.println("Char- " + m.getKey() + " Count " + m.getValue());
        }
    }


    static boolean areBracketsBalanced(String expr) {
        // Using ArrayDeque is faster than using Stack class
        Stack<Character> stack = new Stack<>();
        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++){
            char x = expr.charAt(i);
            if (x == '(' || x == '[' || x == '{'){
                // Push the element in the stack
                stack.push(x);
                continue;
            }
            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        // Check Empty Stack
        return (stack.isEmpty());
    }






    public static Map<Character, Integer> countCharsWithMap2(String message){
        char[] newStringInputArray = message.replace(" ", "").trim().toLowerCase().toCharArray();
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : newStringInputArray){
            if (charCountMap.containsKey(c)) charCountMap.put(c,charCountMap.get(c)+1);
            else charCountMap.put(c,1);
        }
        return charCountMap;
    }


    public static int countSocks(List<Integer> list){
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(list.get(i))) map.put(list.get(i),map.get(list.get(i))+1);
            else map.put(list.get(i),1);
            if (map.get(list.get(i))%2==0) count++;
        }
        System.out.println(map.entrySet());
        return count;
    }




    public static Map<String, Integer> countWordsInString(String string){
        // String inputString = "he is a boy she is a the girl";
        Map<String, Integer> map = new HashMap<>();
        String[] stringArray = string.split(" ");

        for (int i = 0; i < stringArray.length; i++) {
            Integer count = 1;
            if (!map.containsKey(stringArray[i])) {
                for (int j = i + 1; j < stringArray.length; j++) {
                    if (stringArray[i].equalsIgnoreCase(stringArray[j])) {
                        count++;
                    }
                }
            } else {
                continue;
            }
            map.put(stringArray[i], count);
        }
        return map;
    }
    // regex to replace all non alphanumeric characters java -> value.replaceAll("[^A-Za-z0-9]", "");
    public static Map<String, Integer> countWordsInList(List<String> list){
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Integer count = 1;
            if (!map.containsKey(list.get(i))) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i).equalsIgnoreCase(list.get(j))) {
                        count++;
                    }
                }
            } else {
                continue;
            }
            map.put(list.get(i), count);
        }
        return map;
    }

    public static Map<String, Integer>countWordsInList2(List<String> list){
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Integer count = 1;
            String tempI = list.get(i).toLowerCase().replaceAll("\\s","").replaceAll("[^A-Za-z0-9]", "").trim();
            if (!map.containsKey(tempI)) {
                for (int j = i + 1; j < list.size(); j++) {
                    String tempJ = list.get(j).toLowerCase().replaceAll("\\s","").replaceAll("[^A-Za-z0-9]", "").trim();
                    if (tempI.equals(tempJ)) {
                        count++;
                    }
                }
            } else {
                continue;
            }
            map.put(tempI, count);
        }
        return map;
    }

    public static Map<String, Integer> countWordsInList3 (List<String> list){
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String tempI = list.get(i).toLowerCase().replaceAll("\\s","").replaceAll("[^A-Za-z0-9]", "").trim();
            if (!map.containsKey(tempI)) map.put(tempI, map.getOrDefault(tempI, 1));
            else map.put(tempI, map.get(tempI)+1);
        }
        return map;
    }



    public static String countLettersInStringAEIOU(String string){
        int maxNumber=0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<string.length();i++){ // vowel
            if(string.charAt(i)=='a' || string.charAt(i)=='e'||
                    string.charAt(i)=='o' || string.charAt(i)=='i'||
                    string.charAt(i)=='u'){
                if(map.containsKey(string.charAt(i))){
                    map.put(string.charAt(i),map.get(string.charAt(i))+1);
                }else{
                    map.put(string.charAt(i),1);
                }
            }
        }
        for(Character c:map.keySet()){
            if(map.get(c)>maxNumber) maxNumber=map.get(c);
        }
        int finalMaxNumber = maxNumber;
        List<Character> list = map.keySet().stream().sorted().filter(a->map.get(a)==finalMaxNumber).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if(maxNumber>1){
                sb.append(list.get(i)).append(" appears ").append(maxNumber).append(" times"+"\n");
            }else{
                sb.append(list.get(i)).append(" appears ").append(maxNumber).append(" time"+"\n");
            }
        }
        return sb.toString().trim();
    }







    public void countCharsWithArray(String str) {
        char[] strArr;
        do {
            strArr = str.toCharArray();
            char ch = strArr[0];
            int count = 1;
            for (int i = 1; i < strArr.length; i++) {
                if (ch == strArr[i]) {
                    count++;
                }
            }
            // We don't need to count spaces
            if (((ch != ' ') && (ch != '\t'))) {
                System.out.println(ch + " - " + count);
            }
            // replace all occurrence of the character
            // which is already iterated and counted
            str = str.replace("" + ch, "");
        } while (strArr.length > 1);
    }

    public static int getUniqueCharacter1(String s){
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            char key = s.charAt(i);
            map.put(key, map.containsKey(key)?-1:i);
        }
        for (Map.Entry<Character, Integer> m : map.entrySet()){
            if(m.getValue()!=-1){
                return m.getValue()+1;
            }
        }
        return -1;
    }

    public static int getUniqueCharacter2(String s){
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),-1);
            }else{
                map.put(s.charAt(i),i);
            }
        }
        System.out.println(map);
        return map.entrySet().stream().filter(a->a.getValue()!=-1).findFirst().get().getValue();
    }


    public static Map<Character, Integer> letterCountWithStreams(String string) {
        Map<Character, Integer> result = new HashMap<>();
        string.chars().mapToObj(ch -> (char) ch).
                forEach(ch -> result.put(ch, (result.containsKey(ch) ? result.get(ch) + 1 : 1)));
        return result;
    }


    public static Map<Character, Integer> letterCountWithStreams2(String string) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            result.put(ch, (result.containsKey(ch) ? result.get(ch) + 1 : 1));
        }
        return result;
    }


    public static int[] pushZeroesEnd(int[] array, int lengthOfTheArray){
        // Function which pushes all zeros to end of an array.
        int count = 0;
        /*
            Traverse the array. If element encountered is
            non-zero, then replace the element at index 'count'
            with this element
         */
        for (int i = 0; i <lengthOfTheArray; i++) {
            if(array[i]!=0)
                array[count++] = array[i]; // here count is incremented
        }
        /*
            Now all non-zero elements have been shifted to
            front and 'count' is set as index of first 0.
            Make all elements 0 from count to end.
         */
        while (count < lengthOfTheArray)
            array[count++] = 0;
        return array;
    }



    public static String longestSubstring(String inputString) {
        //String inputString = "javaisgreat0reapdy"; output -> [t, 0, r, e, a, p, d, y];
        int maxLength = 0;
        String lorgestSubstring = "";
        char[] strArray = inputString.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        if(inputString.length()<1) return inputString;
        for(int i=0; i < strArray.length; i++ ) {
            char ch = strArray[i];
            if(!map.containsKey(ch)) {
                map.put(ch,i);
            } else {
                i = map.get(ch);
                map.clear();
            }
            if(map.size()>=maxLength){
                maxLength = map.size();
                lorgestSubstring = map.keySet().toString();
            }
        }
        return lorgestSubstring.replace("[","").replace("]","")
                .replace(" ","").replace(",","");
    }


    public static String longestSubstringWithoutRepeatingCharacters(String input){
        HashSet<Character> set = new HashSet<>();
        String longestOverAll = "";
        String longestTillNow = "";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (set.contains(c)) {
                longestTillNow = "";
                set.clear();
            }
            longestTillNow += c;
            set.add(c);
            if (longestTillNow.length() > longestOverAll.length()) {
                longestOverAll = longestTillNow;
            }
        }
        return longestOverAll;
    }



    public static String wordAppendInTheArray(String[] strings) {
        // wordAppend(["a", "b", "a", "c", "a", "d", "a"]) → "aa"
        Map<String, Integer> mapa = new HashMap();
        String resultStr = "";
        for (String key : strings) {
            if (mapa.containsKey(key)) {
                int value = mapa.get(key);
                value++;
                if (value % 2 == 0) resultStr += key;
                mapa.put(key, value);
            } else mapa.put(key, 1);
        }
        return resultStr;
    }

    public static int findTheLargestSubstringOfOne(String str) {
        // Find the largest substring of ones if can delete one zero in any index of the string 01100101100
        List<Integer> list = new ArrayList<>();
        int countOfOnes = 0;
        int innerCount = 0;
        String strHelper;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0'){
                strHelper = str.substring(i+1);
                for (int j = 0; j < strHelper.length(); j++) {
                    if (strHelper.charAt(j) == '1'){
                        innerCount++;
                    } else {
                        list.add(innerCount);
                        innerCount = 0;
                        break;
                    }
                }
                countOfOnes = 0;
            } else {
                countOfOnes ++;
            }
        }
        list.add(countOfOnes);
        return list.stream().max(Integer::compare).get();
    }

    public static Map<String, Integer> startsWithA(List<String> list){
        Map<String, Integer> map = list.stream()
                .filter(a->a.toLowerCase().startsWith("a"))
                .collect(Collectors.toMap(Function.identity(), String::length));
        return map;
    }




    public static int searchLetterAndGetMaxDifferentIndex(String input1, String input2) {
        if ((input1 == null) || (input2 == null) || input2.isEmpty()
                || input1.isEmpty() || (!input1.contains(input2))) return -1;

        List<Integer> list = new ArrayList<>();
        int temperInt = 0;
        int result;
        input1  = input1.replace(" ", "").trim();
        for (int i = 0; i < input1.length(); i++) {
            if (input1.charAt(i) == input2.charAt(0)) {
                list.add(i - temperInt);
                temperInt = i;
            } else if (input1.charAt(i) != input2.charAt(0)) result = -1;
        }
        if (list.size()==1) result = -1;
        else if (list.size()>=2)
        Collections.sort(list);
        result = (list.get(list.size()-1) - list.get(0));
        return result;
    }

    public static int searchLetterAndGetMaxDifferentIndex2(String input1, String input2) {
        if ((input1 == null || input2 == null) || (!input1.contains(input2))) {
            return -1;
        }
        int result = 0;
        int count;
        int temp = 0;
        input1  = input1.replace(" ", "").trim();

        for (int i = 0; i < input1.length(); i++){
            if(input1.substring(i,i+1).equals(input2)){
                count = (i-temp)-1;
                temp=i;
                result=count>=result?count:result;
                result = (result==1) ? -1 : result;
            }
        }
        return result;
    }

    public static int searchLetterAndGetMaxDifferentIndex3(String input1, String input2) {
        if ((input1 == null) || (input2 == null) || input2.isEmpty()
                || input1.isEmpty() || (!input1.contains(input2))) return -1;
        List<Integer> list = new ArrayList<>();
        int result = 0;
        input1  = input1.replace(" ", "").trim();

        for (int i = 0; i < input1.length(); i++) {
            if (input1.charAt(i) == input2.charAt(0)) {
                list.add(i);
            } else if (input1.charAt(i) != input2.charAt(0)) result = -1;
        }
        if (list.size()==1) result = -1;
        else if (list.size()==2) result = ((list.get(list.size()-1) - list.get(0))-1);
        else result = (((list.get(list.size()-1) - list.get(0)) - (list.size()-2))-1);
        return result;
    }

    public static int searchLetterAndGetMaxDifferentIndex4(String input1, String input2) {
        if ((input1 == null) || (input2 == null) || input2.isEmpty()
                || input1.isEmpty() || (!input1.contains(input2))) return -1;
//        int max = input1.substring(input1.indexOf(input2),input1.lastIndexOf(input2))
//                .replaceAll("[ "+input2+"]","").length();
//        return max;
        int result = 0;
        int count;
        int temp = 0;
        for (int i = 0; i < input1.length(); i++){
            if(input1.substring(i,i+1).equals(input2)){
                count = (i-temp)-2;
                temp=i;
                result=count>=result?count:result;
            }
        }
        return result;
    }




    public static int sumInt(String value){
    /*Given a String value, calculate the sum of all numbers
      in the String. If the number has minus before, do subtraction.
      Take the numbers as a group if they are coming after each other.
      add-3455cc4df567 -> -3455+4+567 = answer
    */
        int sum=0;
        for(int i=0;i<value.length();i++){
            int counter=0;
            if((Character.isDigit(value.charAt(i)) )&& !(value.charAt(i-1)=='-')){
                String number=value.substring(i,i+1);
                counter++;
                for(int b=i+1;b<value.length();b++) {
                    if(Character.isAlphabetic(value.charAt(b))){
                        break;
                    }
                    if(Character.isDigit(value.charAt(b))) {
                        number = number + value.substring(b,b+1);
                        counter++;
                    }
                }
                sum=sum+Integer.parseInt(number);
            }else if((Character.isDigit(value.charAt(i))) && (value.charAt(i-1)=='-')){
                String number=value.substring(i,i+1);
                counter++;
                for(int b=i+1;b<value.length();b++) {
                    if(Character.isAlphabetic(value.charAt(b))){
                        break;
                    }
                    if(Character.isDigit(value.charAt(b))) {
                        number = number + value.substring(b,b+1);
                        counter++;
                    }
                }
                sum=sum-Integer.parseInt(number);
            }
            i=i+counter;
        }
        return sum;
    }





    public static int sequenceSum(int a, int b, int c){
        int s = 0;
        int incrementTo = b-a;
        int decrementTo = b-c;
        for(int i =0;i<incrementTo+decrementTo;i++){
            s = (i<=incrementTo) ? (s+a++) : (s+(--b));
        }
        return s+c;
    }


    public static long greatestProduct(String str){
        long result =0;
        for(int i=0;i<str.length()-12;i++){
            long product = Arrays.stream(str.substring(i,i+13).split(""))
                    .mapToLong(Long::parseLong).reduce((x,y)->x*y).getAsLong();
            result = (product>result)?product:result;
        }
        return result;
    }



    public static String getNonDuplicateChar (String str){
        Map<String, Integer> letterCount = new LinkedHashMap();
        String result = "";

        for(int i =0; i<str.length(); i++){
            String temp = String.valueOf(str.charAt(i)).toLowerCase();
            if(letterCount.containsKey(temp)) letterCount.put(temp, letterCount.get(temp)+1);
            else letterCount.put(temp, 1);
        }

        for(String ch: letterCount.keySet()){
            if(letterCount.get(ch)==1) result = result + ch;
        }
        return result;
    }


    public int sumDigits(int n) {
        if(n==0){
            return 0;
        }
        return (n%10)+sumDigits(n/10);
    }


    static boolean isSubset(int arr1[],int arr2[],int m, int n){
        int i = 0;
        int j = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++)
                if (arr2[i] == arr1[j])
                    break;
            /* If the above inner loop
            was not broken at all then
            arr2[i] is not present in
            arr1[] */
            if (j == m)
                return false;
        }
        /* If we reach here then all
        elements of arr2[] are present
        in arr1[] */
        return true;
    }

    public static int maximumSumSubArrayAndIndexes(int [] array){
        int totalSumNumber = 0;
        int maxPossibleNumber = 0;
        int endIndex  = 0;
        int startIndex  = 0;
        int helper  = 0;

        for(int i = 0; i<array.length; i++){
            totalSumNumber = totalSumNumber+array[i];

            if(maxPossibleNumber < totalSumNumber){
                maxPossibleNumber = totalSumNumber;
                startIndex = helper;
                endIndex = i;
            }

            if(totalSumNumber < 0){
                totalSumNumber = 0;
                helper = i+1;
            }
        }
        return maxPossibleNumber;
    }

    public static int minNumberInTheArray(int[] array){
        if (array.length==0) return 0;
        if (array.length==1) return array[0];
        return IntStream.of(array).min().getAsInt();
    }

    public static int maxNumberInTheArray(int[] array){
        if (array.length==0) return 0;
        if (array.length==1) return array[0];
        return IntStream.of(array).max().getAsInt();
    }

    public static int maxIntList(List<Integer> list) {
        return list.stream().max(Integer::compare).get();
    }

    public static int minIntList(List<Integer> list) {
        return list.stream().min(Integer::compare).get();
    }

    private static int sumIntLestThanTenWithStream(List<Integer> list) { return list.stream().filter(i -> i > 10).mapToInt(i -> i).sum(); }







































}
