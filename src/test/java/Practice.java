import com.sun.tools.javac.code.Scope;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {

    public static Map<String, Integer> hashMap;

    static
    {
        hashMap = new HashMap<>();
        hashMap.put("A", 100);
        hashMap.put("B", 200);
    }

    public static void main(String[] args) {
        // 1: Remove duplicates from ArrayList with LinkedHashSet
        System.out.println("=======================");
        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(6, 3, 6, 7, 8, 9, 1, 2, 2, 3, 3, 4, 5, 6, 5));
        System.out.println(l1);
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(l1);
        ArrayList<Integer> l1WithoutDuplicates = new ArrayList<>(linkedHashSet);
        System.out.println(l1WithoutDuplicates);
        // 2: Remove duplicates from ArrayList with JDK 8 - Stream:
        System.out.println("=======================");
        ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(6, 3, 6, 7, 8, 9, 1, 2, 2, 3, 3, 4, 5, 6, 5));
        List<Integer> l3 = l2.stream().distinct().collect(Collectors.toList());
        System.out.println(l3);
        // 3: Removing (specific condition) from ArrayList with lambda
        System.out.println("=======================");
        List<Integer> l4 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        l4.removeIf(number -> number % 2 == 0);
        System.out.println(l4);
        // 4: Removing all Strings with specific values
        System.out.println("=======================");
        List<String> l5 = new ArrayList<>(Arrays.asList("Gogi", "Hraklis", "Adil", "Haji", "Nepe", "Dion"));
        l5.retainAll(Collections.singleton("Nepe"));
        System.out.println(l5);
        // 5: Convert ArrayList to Array
        System.out.println("=======================");
        List<String> l6 = new ArrayList<>(Arrays.asList("Gogi", "Hraklis", "Adil", "Haji", "Nepe", "Dion"));
        Object arrayFroml6[] = l6.toArray();
        System.out.println(Arrays.toString(arrayFroml6));
        // 6: Find the common elements it the two ArrayLists
        System.out.println("=======================");
        List<String> l7 = new ArrayList<>(Arrays.asList("Java", "JS", "Python", "Ruby", "C#", "C"));
        List<String> l8 = new ArrayList<>(Arrays.asList("Java", "JS", "Python", "Ruby", "C#", "C++"));
        System.out.println(l7.equals(l8));
        l7.retainAll(l8);
        System.out.println(l7);
        // 7: Remove that elements whats are not matching
        System.out.println("=======================");
        l8.removeAll(l7);
        System.out.println(l8);
        // Maps
        // 8.1: Iterator: over the keys: by using keySet()
        System.out.println("=======================");
        HashMap<String, String> m1 = new HashMap<>();
        m1.put("Ossetia", "Vladicavkaz"); m1.put("Greece", "Athens");
        m1.put("Russia", "Moscow"); m1.put("Norway", "Oslo");
        m1.put("USA", "Washington DC"); m1.put(null, "Grozniy");
        Iterator<String> it1 = m1.keySet().iterator();
        while (it1.hasNext()){
            String key = it1.next();
            String value = m1.get(key);
            System.out.println("Key: "+key+" Value: "+value);
        }
        // 8.2: Iterator: over the set (pair): by using entrySet();
        System.out.println("=======================");
        Iterator<Map.Entry<String,String>> it2 = m1.entrySet().iterator();
        while (it2.hasNext()){
            Map.Entry<String, String> entry = it2.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: "+key+" Value: "+value);
        }
        // 8.3: Iterator HashMap using Lambda
        System.out.println("=======================");
        m1.forEach((key, value) -> System.out.println("Key: "+key+" Value: "+value));
        // 9: Comparing HashMap
        System.out.println("=======================");
        HashMap<Integer, String> m2 = new HashMap<>();
        m2.put(1,"A"); m2.put(2,"B"); m2.put(3,"C");
        HashMap<Integer, String> m3 = new HashMap<>();
        m3.put(1,"A"); m3.put(2,"B"); m3.put(3,"C");
        HashMap<Integer, String> m4 = new HashMap<>();
        m4.put(1,"A"); m4.put(2,"B"); m4.put(3,"C"); m4.put(3,"D");
        // 9.1 Compare base on the basis of Key-Value: By using method equals();
        System.out.println(m2.equals(m3)); // true
        System.out.println(m2.equals(m4)); // false
        // 9.2 Compare hashmaps for the same keys: keySet();
        System.out.println(m2.keySet().equals(m2.keySet())); // true
        System.out.println(m2.keySet().equals(m3.keySet())); // true -> we override the 3 with the new value, but the key is reminding the same
        // 9.3 Find out extra key: -> Combine the keys from both maps: by using HashSet
        HashMap<Integer, String> m5 = new HashMap<>();
        m5.put(1,"A"); m5.put(2,"B"); m5.put(3,"C"); m5.put(4,"D");
        // 9.3 add(); the keySet from m4, HashSet will remove the duplicates and after we remove all keySet from m2 and will understand the differences between m2 && m4
        HashSet<Integer> combineKeysFromM2 = new HashSet<>(m2.keySet());
        combineKeysFromM2.addAll(m5.keySet());
        combineKeysFromM2.removeAll(m2.keySet());
        System.out.println(combineKeysFromM2);
        // 9.4 Combine HashMap by Values
        System.out.println("=======================");
        HashMap<Integer, String> m6 = new HashMap<>();
        m6.put(1,"A"); m6.put(2,"B"); m6.put(3,"C");
        HashMap<Integer, String> m7 = new HashMap<>();
        m7.put(4,"A"); m7.put(5,"B"); m7.put(6,"C");
        HashMap<Integer, String> m8 = new HashMap<>();
        m8.put(1,"A"); m8.put(2,"B"); m8.put(3,"C"); m8.put(4,"C");
        // 9.5 Duplicates are not allowed: using ArrayList
        System.out.println(new ArrayList<>(m6.values()).equals(new ArrayList<>(m7.values()))); // true
        System.out.println(new ArrayList<>(m6.values()).equals(new ArrayList<>(m8.values()))); // false
        // 9.6 Duplicates are allowed: using HashSet
        System.out.println(new HashSet<>(m6.values()).equals(new HashSet<>(m7.values()))); // true
        System.out.println(new HashSet<>(m6.values()).equals(new HashSet<>(m8.values()))); // true
        // 10 HashMap:
        System.out.println("=======================");
        HashMap<String, Integer> m9 = new HashMap<>();
        m9.put("Sarah", 100); m9.put("Tom", 200); m9.put("Lisa", 300); m9.put("Peter", 400); m9.put("Robby", 500); m9.put(null, 600);
        // 10.1: Using HashMap class
        HashMap<String, Integer> m10 = new HashMap<>();
        Map<String, String> m11 = new HashMap<>();
        // 10.2: Static way: Static HashMap
        System.out.println(Practice.hashMap.get("A"));
        // 10.3: immutableMap with only one single Entry:
        Map<String, Integer> immutableMap = Collections.singletonMap("Test", 100);
        System.out.println(immutableMap.get("Test")); // immutableMap.put("ABC", 200); // UnsupportedOperationException
        // 10.4: JDK 8: Creating one 2D Array of Strings using Stream and collecting in the form Map
        Map<String, String> m12 = Stream.of(new String [][] {
                {"Sarah", "A"},
                {"Lisa", "B"}
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        m12.put(null, "C");
        System.out.println(m12);
        // 10.5: Using SimpleEntry
        Map<String, String> m13 = Stream.of(new AbstractMap.SimpleEntry<>("Sarah", "Java"),
                new AbstractMap.SimpleEntry<>("Lisa", "Python"))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        m13.put("Steve", "C#");
        System.out.println(m13.get("Sarah")+" better than: "+m13.get("Steve"));
        // 10.6: JDC 1.9 SingletonMap (Map.of(); Available only in JDK 1.9)
        // Map<String, String> mapa = Map.of("key", "value", "key", "value", "key", "value"); (maximum 10 keyValues pairs)
        // Map.ofEntries();

        // 11: Synchronization in Map:
        System.out.println("=======================");
        Map<String, Integer> m14 = new HashMap<>();
        m14.put("Sarah", 100); m14.put("Tom", 200); m14.put("Lisa", 300); m14.put("Peter", 400); m14.put("Robby", 500); m14.put(null, 600);
        Map<String, Integer> syncMap = Collections.synchronizedMap(m14);
        System.out.println(syncMap);
        // 11.1: ConcurrentHashMap
        ConcurrentHashMap<String, String> cHM = new ConcurrentHashMap<>();
        cHM.put("A", "Java"); cHM.put("B", "Python"); cHM.put("C", "C#");
        // 12: Convert HashMap in to ArrayList
        System.out.println("=======================");
        Map<String, Integer> copmMap = new HashMap<>();
        copmMap.put("Google", 10000); copmMap.put("Walmart", 20000); copmMap.put("Amazon", 30000); copmMap.put("Facebook", 5000); copmMap.put("Cisco", 15000);
        System.out.println("Copm map size: "+ copmMap.size());
        Iterator it = copmMap.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry pairs = (Map.Entry)it.next();
            System.out.println("Me thn Iterator: "+pairs.getKey()+" = "+pairs.getValue());
        }
        copmMap.forEach((k,v) -> System.out.println("Me thn Lambda: "+k+" = "+v));
        // 12.1: Convert HashMap Keys into ArrayList:
        List<String> compNamesList = new ArrayList<>(copmMap.keySet());
        System.out.println(compNamesList);
        // 12.2: Convert HashMap Values into ArrayList:
        List<Integer> empValuesList = new ArrayList<>(copmMap.values());
        System.out.println(empValuesList);















    }









}
