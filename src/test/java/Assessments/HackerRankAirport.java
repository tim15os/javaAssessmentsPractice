package Assessments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class HackerRankAirport {


    public static int getMinGates(List<Integer> landingTimes, List<Integer> takeOffTimes, int maxWaitTime, int initialPlanes) {
        int gatesNeeded = initialPlanes; //1
        int max = initialPlanes;
        if(landingTimes.size() == 0){
            return gatesNeeded;
        }
        if(takeOffTimes.size() == 0){
            return gatesNeeded+landingTimes.size();
        }
        for(int i = 0; i < landingTimes.size(); i++){
            for (int j = 0; j < takeOffTimes.size(); j++){
                if(landingTimes.get(i)+maxWaitTime<takeOffTimes.get(j)){
                    gatesNeeded++;
                    max = gatesNeeded;
                    break;
                }else if(landingTimes.get(i)+maxWaitTime>= takeOffTimes.get(j)){
                    gatesNeeded--;
                    break;
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        List<Integer> landingTimes = new ArrayList<>(Arrays.asList(630,645,650,730,1100));
        List<Integer> takeOffTimes = new ArrayList<>(Arrays.asList(700,715,845,1015,1130,1500,1600,1700));
        int maxWaitTime = 20;
        int initialPlanes = 1;

        System.out.println(getMinGates(landingTimes, takeOffTimes, maxWaitTime, initialPlanes));


    }








}



