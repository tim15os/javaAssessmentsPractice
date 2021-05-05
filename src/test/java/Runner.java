import java.io.IOException;
import java.util.*;

public class Runner {


    public static void main(String[] args) throws IOException {

// === <Data> ===

        int[] arrNum = {0, 6, 0, 0, 2, 1, 0, 5};
        int lengthOfArray = arrNum.length;
        int countData = 0;
        String[] logs = {"A:1", "A:1", "A:2", "A:3", "A:1", "B:1", "B:1", "B:2", "B:3", "B:3", "A:3", "C:3", "C:2", "C:1", "B:1", "C:1"};
        for (int i = 0; i < lengthOfArray; i++) {
            if (arrNum[i] != 0)

                arrNum[countData++] = arrNum[i];
        }
        while (countData < lengthOfArray) {
            arrNum[countData++] = 0;
        }
        System.out.println(Arrays.toString(arrNum));
        String newStringInput = "Techtorial Students";
        char[] newStringInputArray = newStringInput.replace(" ", "").trim().toLowerCase().toCharArray();
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : newStringInputArray) {
            if (charCountMap.containsKey(c)) charCountMap.put(c, charCountMap.get(c) + 1);
            else charCountMap.put(c, 1);
        }
        System.out.println("==========");
        System.out.println(charCountMap);
        System.out.println("==========");
        System.out.println(MethodUtils.fizzBuzz3(475));
        System.out.println("==========");
        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();
            fibonacciNum(1000);
            long stopTime = System.nanoTime();
            System.out.println(stopTime - startTime);
        }
        System.out.println("==========");
        System.out.println("==========");
        System.out.println("==========");
        System.out.println(errorLogs(logs));
        System.out.println(errorLogs2(logs));


        HashMap<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("a", 5);
        unsortedMap.put("b", 4);
        unsortedMap.put("c", 3);
        unsortedMap.put("d", 1);
        System.out.println(unsortedMap);
        //int[]testArray={1,3,5,9,10,15,8};
        //System.out.println(subOfTheSumArray(testArray,13));


    }


// === <\Data> ===


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
            if (count.get(user).contains("ABC")) mapa.put(user, false);
            else mapa.put(user, true);
        }
        return mapa;
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


    public static String convertToUpperCase(String str) {
        str = str.trim().substring(0, 1).toLowerCase().concat(str.substring(1));
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals(" ")) {
                str = str.substring(i + 1, i + 2).toUpperCase().concat(str.substring(2));
            }
        }
        return str;
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
        long[] arrayN = new long[n + 1];
        arrayN[0] = 0;
        arrayN[1] = 1;
        for (int i = 2; i <= n; i++) {
            arrayN[i] = arrayN[i - 1] + arrayN[i - 2];
        }
        return arrayN[n];
    }


    public static int testFunc(int x) {
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


    public static boolean testTempo(String s) {
        boolean isContains = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == 'a') isContains = true;
            else if (c == 'b' && isContains) return false;
        }
        return true;
    }


}
