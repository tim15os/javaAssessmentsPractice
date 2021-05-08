import java.io.IOException;
import java.util.*;

public class Runner extends MethodUtils{


    public static void main(String[] args) throws IOException {

// === <Data> ===

        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();
            // fibonacciNum(1000);
            long stopTime = System.nanoTime();
            System.out.println(stopTime - startTime);
        }

        HashMap<String, Integer> mapa = new HashMap<>();
        List<Integer> list = Arrays.asList(3,4,3,5,5,3,4,5,1);
        int[]testArray={1,3,5,9,10,15,8};
        System.out.println(subArrayOfTheSumArray(testArray,13));
        System.out.println(palindromeStringWithStreamFilter1(Arrays.asList("madam","red","civic","war","sos")));
        System.out.println(palindromeStringWithStreamFilter2(Arrays.asList("madam","red","civic","war","sos")));
        System.out.println(findUniqueDuplicatesInTheList(list));
        System.out.println(findAllDuplicatesInTheList(list));


    }

// === <\Data> ===
























}
