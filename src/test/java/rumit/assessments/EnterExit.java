package rumit.assessments;

import java.util.*;

public class EnterExit {
    /*
    We are working on a security system for a badged-access room in our company's building.
    Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:
    1. All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit. (All employees are required to leave the room before the log ends.)
    2. All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter. (The room is empty when the log begins.)
    Each collection should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.

    badge_records_1 = [
      ["Martha",   "exit"],
      ["Paul",     "enter"],
      ["Martha",   "enter"],
      ["Martha",   "exit"],
      ["Jennifer", "enter"],
      ["Paul",     "enter"],
      ["Curtis",   "exit"],
      ["Curtis",   "enter"],
      ["Paul",     "exit"],
      ["Martha",   "enter"],
      ["Martha",   "exit"],
      ["Jennifer", "exit"],
      ["Paul",     "enter"],
      ["Paul",     "enter"],
      ["Martha",   "exit"],
    ]

    Expected output: ["Curtis", "Paul"], ["Martha", "Curtis"]
    Additional test cases:
    badge_records_2 = [
      ["Paul", "enter"],
      ["Paul", "enter"],
      ["Paul", "exit"],
]

    Expected output: ["Paul"], []
    badge_records_3 = [
      ["Paul", "enter"],
      ["Paul", "exit"],
      ["Paul", "exit"],
    ]

    Expected output: [], ["Paul"]
    badge_records_4 = [
      ["Paul", "enter"],
      ["Paul", "exit"],
      ["Paul", "exit"],
      ["Paul", "enter"],
      ["Martha", "enter"],
      ["Martha", "exit"],
    ]

    Expected output: ["Paul"], ["Paul"]
    badge_records_5 = [
      ["Paul", "enter"],
      ["Paul", "exit"],
    ]

    Expected output: [], []
    badge_records_6 = [
      ["Paul", "enter"],
      ["Paul", "enter"],
      ["Paul", "exit"],
      ["Paul", "exit"],
    ]

    Expected output: ["Paul"], ["Paul"]
    n: length of the badge records array

*/


    public static List<String> stupidWorkers(String [][] record) {
        List<String> result = new ArrayList<>();
        Map<String, Boolean> shift = new HashMap<>();

        for(int i=0; i<record.length; i++){
            String name = record[i][0];
            String action = record[i][1];

            if(!shift.containsKey(name)) {
                shift.put(name,false);
            }

            boolean onWork = action.equals("enter");

            if(! shift.get(name) != onWork) {
                result.add(name);
            }

            shift.put(name,onWork);
        }
        return  result;
    }
















    public static void main(String[] argv) {

        String badgeRecords1[][] = new String[][]{
                {"Martha", "exit"}, // -
                {"Paul", "enter"}, // -
                {"Martha", "enter"}, // +
                {"Martha", "exit"}, // +
                {"Jennifer", "enter"}, // +
                {"Paul", "enter"}, // +
                {"Curtis", "exit"}, // -
                {"Curtis", "enter"}, //+
                {"Paul", "exit"}, //+
                {"Martha", "enter"}, //+
                {"Martha", "exit"}, //+
                {"Jennifer", "exit"}, //+
                {"Paul", "enter"}, // -
                {"Paul", "enter"},// +
                {"Martha", "exit"}, //+
        };


        String[][] arrayNamesCountries = {
                {"John", "Russia"},
                {"Peter", "Brazil"},
                {"Peter", "England"},
                {"John", "Spain"},
                {"Peter", "Ukraine"},
                {"John", "France"}
        };

        Map<String, List<String>> map = new HashMap<>();

        for(int i=0; i <arrayNamesCountries.length; i++){
            if (!map.containsKey(arrayNamesCountries[i][0])){
                map.put(arrayNamesCountries[i][0], new ArrayList<>());
            }
            map.get(arrayNamesCountries[i][0]).add(arrayNamesCountries[i][1]);
        }
        System.out.println(map);



        /*
        Second approach
        List<String> countriesList = new ArrayList<>();
        for (int i = 0; i < arrayNamesCountries.length; i++) {
            String countryStr = arrayNamesCountries[i][1];
            for (int j = 1; j < arrayNamesCountries.length; j++) {
                if (arrayNamesCountries[i][0].equals(arrayNamesCountries[j][0])) {
                    if (map.containsKey(arrayNamesCountries[i][0])) {
                    } else {
                        countriesList.add(countryStr);
                    }
                }
            }
            if (map.containsKey(arrayNamesCountries[i][0])) {
            } else {
                map.put(arrayNamesCountries[i][0], countriesList);
            }
        }
         */




        System.out.println(stupidWorkers(badgeRecords1));



        }



    }










