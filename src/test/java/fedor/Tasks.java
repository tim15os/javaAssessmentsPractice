package fedor;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public static void main(String[] args) {

        String word = "voooweeel";
        printLetterThatAppearsMaxTime(word);

    }
}
