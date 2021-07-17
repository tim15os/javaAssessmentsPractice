package rumit;

import javax.lang.model.type.NullType;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Runner{


    public static void main(String[] args) throws IOException {
        Runner r = new Runner();

// === <Data> ===
        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();
            // fibonacciNum(1000);
            long stopTime = System.nanoTime();
            System.out.println(stopTime - startTime);
        }
        HashMap<String, Integer> mapa = new HashMap<>();
        List<Integer> list11 = Arrays.asList(3,4,3,5,5,3,4,5,1);
        List<String> List22 = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        int[]testArray = {1,3,5,9,10,15,15,8};
        int n = testArray.length;
        int[]testArray2 = {-1,0,6,25,50,51,52};
        int[]testArray3 = {34,52,6,1,53,45,53,8,15};
        int[]testArray4 = {34,52,6,1,109,566,45,53,8,15};


        List<Integer> list1 = new ArrayList<>(Arrays.asList(5, 7, 8, 9, 10, 11));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(8, 10, 11));

        List<Object> list3 = new ArrayList<>(Arrays.asList("4",8, 8, 8,"Java","Java", 1, 10, 10, null, "", -1, -1));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(5, 10, 8, 8, 10, 8));


        System.out.println(testArray4.length);
        System.out.println("==============");
        System.out.println(r.subInTheNumber3(123,3));
        System.out.println(r.subInTheNumber3(123,2));
        System.out.println(r.subInTheNumber3(123,1));
        System.out.println(r.subInTheNumber3(122,0));
        System.out.println("==============");
        System.out.println(r.getUniqueCharacter11("hackthegame"));
        System.out.println(r.getUniqueCharacter22("hackthegame"));
        System.out.println("==============");
        r.fizzBuzz2(25);
        System.out.println("==============");
        System.out.println(factorialNumber(5));
        r.evenAndLessFifty(testArray2);
        r.evenAndLessFifty2(testArray2);
        System.out.println("==============");
        System.out.println(r.mostFrequentNumberInTheArray(testArray, n));
        System.out.println("==============");
        System.out.println(r.isSelfDividingNumbers(1, 22));
        System.out.println(r.isSelfDividingNumbers(47, 85));
        System.out.println(r.secondLargestNumber(testArray4));
        System.out.println(r.secondLargestNumber(testArray3));
        System.out.println(r.secondLargestNumber2(testArray3));
        System.out.println("==============");
        System.out.println(r.findIndexesOfMatchingValuesInTheFirstList(list1, list2));
        System.out.println(r.uniqueIntegersInTheListOfIntegers(list4));
        System.out.println(r.uniqueIntegersInTheListOfObjects(list3));
        System.out.println("==============");

    } // ===================================================== *** ===================================================== //


    public List<Integer> uniqueIntegersInTheListOfIntegers(List<Integer> inputList) {
        /*
            Write a Java code to get list of unique items in a given list,
            skip if there are any strings and handle them.
            list1 = [10,20,10,30,40,40] -> [10,20,30,40]
        */
        return inputList.stream().distinct().collect(Collectors.toList());
    }


    public List<Integer> uniqueIntegersInTheListOfObjects(List<Object> inputList) {
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



    public List<Integer> findIndexesOfMatchingValuesInTheFirstList(List<Integer> firstList, List<Integer> secondList) {
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

    public static int secondLargestNumber(int array[]) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        // Loop over the array
        for (int i = 0; i < array.length; i++) {
            // If we've found a new highest number...
            if (array[i] > highest) {
                // ...shift the current highest number to second highest
                secondHighest = highest;
                // ...and set the new highest.
                highest = array[i];
            } else if (array[i] > secondHighest && array[i] != highest)
                // Just replace the second highest
                secondHighest = array[i];
        }
        return secondHighest;
    }



    public int secondLargestNumber2(int[] arr){
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


    public List<Integer> isSelfDividingNumbers(int left, int right){
        /*
            A self-dividing number is NOT allowed to contain the digit ZERO:
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



    public void fizzBuzz2(int n){
        for (int i = 0; i <= n; i++) {
            String result = (i%15 == 0) ? "FizzBuzz" : (i%5 == 0) ? "Fizz" : (i%3 == 0) ? "Buzz" : ""+i;
            System.out.println(result);
        }
    }


    public void evenAndLessFifty(int[] arr){
        if (arr.length==0) System.out.println("Array is empty");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2==0 && arr[i]<50) System.out.println(arr[i]);
        }
    }

    public void evenAndLessFifty2(int [] arr){
        Arrays.stream(arr).filter(a->a%2==0 && a<50).forEach(e->System.out.println(arr[e]));
    }

    public static int factorialNumber(int num){
        if(num==1) return 1;
        return factorialNumber(num-1)*num;
    }


    public int getUniqueCharacter11(String s){
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

    public int getUniqueCharacter22(String s){
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

    public String countLettersInStringAEIOU1(String string){
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

    public boolean subInTheNumber1(int firstNumber, int secondNumber) {
        // Creating the stringHelper to convert integer to to intArray
        String stringHelper = Integer.toString(firstNumber);
        // Creating intArray with the length of the String
        int[] arrayOfFirstNumbers = new int[stringHelper.length()];
        for (int i = 0; i < stringHelper.length(); i++) {
            // Looping and storing numbers in to our intArray
            arrayOfFirstNumbers[i] = stringHelper.charAt(i) - '0';
        }
        // Looping and checking if we have secondNumber in our intArray
        for (int i = 0; i < arrayOfFirstNumbers.length; i++) {
            // returning true if 'if' condition if true
            if (arrayOfFirstNumbers[i] == secondNumber) return true;
        }
        return false; // otherwise false
    }


    public boolean subInTheNumber22(int wholeNum, int target){
        String[] arrOfStrings = String.valueOf(wholeNum).split("");
        String temperString = String.valueOf(target);
        return Arrays.asList(arrOfStrings).contains(temperString);
    }


    public boolean subInTheNumber3(int num1, int num2){
        //first i am going to convert my whole num to string and split it.
        String [] arr = String.valueOf(num1).split("");
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length-1;j++){
                if(Integer.parseInt(arr[i])+Integer.parseInt(arr[j])==num2){
                    return true;
                }
            }
        }
        return false;
    }









}
