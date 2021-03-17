import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

public class CodingBat {


    public boolean hasBad1(String str) {
        String targetStr = "bad";
        if(str.length()<=2){
            return false;
        }else if(str.substring(0,3).equals(targetStr)){
            return true;
        }else if(str.length()>=4 && str.substring(1,4).equals(targetStr)){
            return true;
        }else return false;
    }

    public boolean hasBad2(String str) {
        if (str.length() >= 3 && str.substring(0, 3).equals("bad")) {
            return true;
        }
        if (str.length() >= 4 && str.substring(1, 4).equals("bad")) {
            return true;
        }
        return false;
    }

    public static List<String> testFunctionalStr(List<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            String updatedString = "y" + strings.get(i).concat("y");
            strings.set(i, updatedString);
        }
        return strings;
    }

    public static List<Integer> testFunctionalInteger(List<Integer> nums) {
        for(int i=0; i<nums.size(); i++){
            Integer number = (nums.get(i)+1)*10;
            nums.set(i,number);
        }
        return nums;
    }

    public static int[] telephoneBill (int[] input1, int input2){
        double first = input1[0]*1;
        double second = input1[1]*0.25;
        double third = input1[2]*10;
        int [] result =new int[2];

        if((first+second+third)>1200){
            result [0]=1;
            result[1] = (int)((first+second+third)-input2);
        } else {
            result[0] = 0;
            result[1]=(int)(first+second+third);
        }
        return result;
    }

    public static int missingNumberInArray(int[] numbers) {
        int result = 0;
        for (int i = 0; i < numbers.length-1; i++) {
            if (numbers[i]!=i+1)
                result = i;
        }
        return result;
    }

    public static int missingNumberInArray2(int[] numbers) {
        // int[] numbers = {1,2,3,4,5,7,8,9};
        int actualResult = 0;
        int expResult = 0;
        int lastNumInArray = numbers[numbers.length-1];
        int result = 0;
        for (int j = 1; j <= lastNumInArray; j++) {
            expResult += j;
        }

        for (int i = 0; i < numbers.length; i++) {
            actualResult+= numbers[i];
        }
        result = expResult-actualResult;
        return result;
    }

    public static String seeColor(String str) {
        String red = "red";
        String blue = "blue";
        String result = "";
        result = "";
        if(str.length()==0) return str;
        if(str.startsWith(red)) result = red;
        else if (str.startsWith(blue)) result = blue;
        else result = "";
        return result;
    }

    public static boolean frontAgain(String str) {
        String firstTwoChars = str.substring(0,2);
        String lastTwoChars = str.substring(str.length()-2);
        boolean isContains = false;

        if(str.length()<=1)
            isContains = false;
        else if (str.equals(firstTwoChars) && str.equals(lastTwoChars))
            isContains = true;

        return isContains;
    }


    /**
     Given a string, return a string length 2 made of its first 2 chars.
     If the string length is less than 2, use '@' for the missing chars.
     */
    public String atFirst(String str) {
        if(str.length()<=2){
            str = str.substring(0,2);
        }else if(str.length()==1){
            str = str.substring(1).concat("@");
        }else if(str.length()==0){
            str = str.concat("@");
        }
        return str;
    }


    /**
    Modify and return the given map as follows: if the keys "a" and "b" are both in the map and have equal values, remove them both.
    mapAB2({"a": "aaa", "b": "aaa", "c": "cake"}) → {"c": "cake"}
    mapAB2({"a": "aaa", "b": "bbb"}) → {"a": "aaa", "b": "bbb"}
    mapAB2({"a": "aaa", "b": "bbb", "c": "aaa"}) → {"a": "aaa", "b": "bbb", "c": "aaa"}
     */

    public static Map<String, String> mapAB2(Map<String, String> map) {
        if ((map.containsKey("a") && map.containsKey("b")) && (map.get("a").equals(map.get("b")))) {
            map.remove("a");
            map.remove("b");
        }
        return map;
    }

    public static String reverseString(String string){
        String[] strArray = string.trim().split(" ");
        String reversedStr = "";
        for(String s:strArray){
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            reversedStr+= sb.toString()+" ";
        }
        return reversedStr;
    }

    public static Map<String, String> mapShare(Map<String, String> map) {
        // mapShare({"a": "aaa", "b": "bbb", "c": "ccc"}) → {"a": "aaa", "b": "aaa"}
        map.remove("c");
        if (map.get("a") != null)
            map.put("b", map.get("a"));
        return map;
    }

    public static Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Integer> strCountMapa = new HashMap<>();
        Map<String, Boolean> strBoolMapa = new HashMap<>();
        for(String str:strings){
            if(strCountMapa.containsKey(str)){
                int count = strCountMapa.get(str);
                count++;
                strCountMapa.put(str, count);
            }else strCountMapa.put(str, 1);
            strBoolMapa.put(str, strCountMapa.get(str)>=2);
        }
        return strBoolMapa;
    }

    public static String[] allSwap1(String[] strings) {
        // {"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"} will be -> {ay, by, cy, cx, bx, ax, azz, aaa}
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < strings.length; i++){
            String key = strings[i].charAt(0) + "";
            if (map.containsKey(key)){
                String string = strings[i];
                strings[i] = strings[map.get(key)];
                strings[map.get(key)] = string;
                map.remove(key);
            } else map.put(key, i);
        }
        return strings;
    }

    public static String[] allSwap2(String[] strings) {
        // {"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"} will be -> {ay, by, cy, cx, bx, ax, azz, aaa}
        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<strings.length; i++){
            String key = strings[i].substring(0,1);
            if(map.containsKey(key)){
                String tempStr = strings[i];
                strings[i] = strings[map.get(key)];
                strings[map.get(key)] = tempStr;
                map.remove(key);
            } else map.put(key,i);
        }
        return strings;
    }

    public static String[] firstSwap(String[] strings) {
        Map<String, Integer> mapa = new HashMap<>();
        for(int i=0; i<strings.length; i++){
            String key = strings[i].substring(0,1);
            if(mapa.containsKey(key)){
                if(mapa.get(key) == -1) continue;
                String tempoString = strings[i];
                strings[i] = strings[mapa.get(key)];
                strings[mapa.get(key)] = tempoString;
                mapa.put(key, -1);
            } else mapa.put(key,i);
        }
        return strings;
    }

    public static String altPairs(String str) {
        String result = "";
        // Run i by 4 to hit 0, 4, 8, ...
        // CodingHorror
        for (int i=0; i<str.length(); i += 4) {
            // Append the chars between i and i+2
            int end = i + 2; //
            if (end > str.length()) {
                end = str.length();
            }
            result = result + str.substring(i, end); // Congrr
        }
        return result;
    }



    public static String stringYak(String str){
        String result = "";
        for(int i=0; i<str.length(); i++){
            if(i+2 < str.length() && str.charAt(i) == 'y' && str.charAt(i+2) == 'k') i = i+2;
            else result = result + str.charAt(i);
        }
        return result;
    }


    public static int array667(int[] nums) {
        int count = 0;
        if(nums.length<=1) return 0;
        for(int i=0; i<nums.length-1; i++){
            if((nums[i]==6) && (nums[i+1]==6)) count ++;
            else if((nums[i]==6) && (nums[i+1]==7)) count ++;
        }
        return count;
    }

    public static boolean noTriples(int[] nums) {
        if(nums.length<=2) return true;
        for(int i=0; i<nums.length-2; i++){
            if(nums[i+1] == nums[i] && nums[i+2] == nums[i]) return false;
        }
        return true;
    }



    public static void main(String[] args) {
        int[] array = {6,6,2,6,7};
        System.out.println(array667(array));
    }







}
