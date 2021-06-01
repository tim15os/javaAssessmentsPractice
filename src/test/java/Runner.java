import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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
        int[]testArray={1,3,5,9,10,15,15,8};
        System.out.println(subArrayOfTheSumArray(testArray,13));
        System.out.println(palindromeStringWithStreamFilter1(Arrays.asList("madam","red","civic","war","sos")));
        System.out.println(palindromeStringWithStreamFilter2(Arrays.asList("madam","red","civic","war","sos")));
        System.out.println(findUniqueDuplicatesInTheList(list));
        System.out.println(findAllDuplicatesInTheList(list));
        System.out.println("======= Streams =======");

        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
        System.out.println("======= Streams =======");
        String worddddd="vowel";
        System.out.println(countLettersInStringAEIOU(worddddd));

    }

// === <\Data> ===



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












}
