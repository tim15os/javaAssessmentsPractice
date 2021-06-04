package fedor;

import java.util.*;
import java.util.stream.Collectors;

public class Tasks {

    public static void printLetterThatAppearsMaxTime(String word){

        Map<Character,Integer> map = new HashMap<>();

        word.chars().forEach(a->{
            if(a=='a' || a=='e' || a=='i' || a=='o' || a=='u'){
                map.put((char)a,map.containsKey((char)a)?map.get((char)a)+1:1);
            }
        });

        int maxValue= Collections.max(map.values());

        List<Character> listOfMaxRepeatedLetters=map.keySet()
                .stream()
                .filter(k->map.get(k)==maxValue)
                .collect(Collectors.toList());

        listOfMaxRepeatedLetters.forEach(a->
                System.out.println(maxValue<2 ? a+" appears "+maxValue+" time" : a+" appears "+maxValue+" times"));

    }

    public static Map<String,List<Integer>> findFibonacciNumbersFormGivenMap(Map<String,List<Integer>> mapOfNumbers,List<Integer> listOfFibonacciNumbers){

        return mapOfNumbers.entrySet().stream()
                .filter(a->a.getValue().retainAll(listOfFibonacciNumbers))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

    }

    public static List<Integer> listOfTripleNumbers(){
        List<Integer> list = new ArrayList<>();
        int i=100;
        while (i<1000){
            list.add(i);
            i++;
        }
        return list;
    }

    public static List<Integer> listOfDoubleNumbers(){
        List<Integer> list = new ArrayList<>();
        int i=10;
        while (i<100){
            list.add(i);
            i++;
        }
        return list;
    }

    public static List<Integer> listOfSingleNumbers(){
        List<Integer> list = new ArrayList<>();
        int i=0;
        while (i<10){
            list.add(i);
            i++;
        }
        return list;
    }

    public static List<Integer> getListOfFibonacciNumbers(int maxLimit){

        List<Integer> listOfFibonacciNum  = new ArrayList<>();
        int nunOne = 0;
        int numTwo = 1;
        for(int i=0;i<maxLimit;i++){
            if(nunOne<maxLimit){
                listOfFibonacciNum.add(nunOne);
                int numThree = nunOne+numTwo;
                nunOne = numTwo;
                numTwo = numThree;
            }else {
                break;
            }
        }
        return listOfFibonacciNum;
    }


    public static String makeWordUpperCase(String word){
        return Arrays.stream(word.split(" ")).map(a->a.substring(0,1).toUpperCase()+a.substring(1))
                .collect(Collectors.joining(" "));
    }


    public static void main(String[] args) {

        Map<String,List<Integer>> map = new HashMap<>();
        map.put("SingleNumber",listOfSingleNumbers());
        map.put("DoubleNumbers",listOfDoubleNumbers());
        map.put("TripleNumbers",listOfTripleNumbers());

        System.out.println(makeWordUpperCase("i love java"));

        System.out.println(findFibonacciNumbersFormGivenMap(map,getListOfFibonacciNumbers(1000)));

        String word = "voooweeel";






    }
}
