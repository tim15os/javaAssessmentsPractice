package Assessments;

import java.util.ArrayList;
import java.util.List;

public class ArrayGame {

    /***
     ! ARRAY GAME !
     Given an array of integers, determine the number of moves to make all elements equal.
     Each move consists of choosing all but 1 element and incrementing their values by 1.
     Example numbers = [3, 4, 6, 6, 3]
     Choose 4 of the 5 elements during each move and increment each of their values by one. Indexing begins at 1. It takes 7 moves as follows:
     ​
     Iteration			Array   	            Unchanged element's index
     0		        [ 3,  4,  6,  6,  3]
     1		        [ 4,  5,  7,  6,  4]		4
     2		        [ 5,  6,  7,  7,  5]		3
     3		        [ 6,  7,  8,  7,  6]		4
     4 		        [ 7,  8,  8,  8,  7]		3
     5		        [ 8,  9,  9,  8,  8]		4
     6		        [ 9,  9, 10,  9,  9]		2
     7		        [10, 10, 10, 10, 10]		3
     ​
     Function Description
     Complete the function countMoves in the editor below. CountMoves has the following parameter(s):
     int numbers[n]:  an array of integers
     Returns:
     long:  the minimum number of moves required
     Constraints
     1 ≤ n ≤ 105
     1 ≤ numbers[i] ≤ 106
     Sample Input 0
     ​
     STDIN    Function
     -----    --------
     5    →   numbers[] size n = 5
     5    →   numbers = [5, 6, 8, 8, 5]
     6
     8
     8
     5
     ​
     Sample Output 7
     ​
     ----------------------------------------------------------------------------------------------------------------
     Explanation 0
     Make the following moves:
     Increment the values corresponding to all indices except numbers[3], so the array becomes [6, 7, 9, 8, 6].
     Increment the values corresponding to all indices except numbers[2], so the array becomes [7, 8, 9, 9, 7].
     Increment the values corresponding to all indices except numbers[3], so the array becomes [8, 9, 10, 9, 8].
     Increment the values corresponding to all indices except numbers[2], so the array becomes [9, 10, 10, 10, 9].
     Increment the values corresponding to all indices except numbers[3], so the array becomes [10, 11, 11, 10, 10].
     Increment the values corresponding to all indices except numbers[1], so the array becomes [11, 11, 12, 11, 11].
     Increment the values corresponding to all indices except numbers[2], so the array becomes [12, 12, 12, 12, 12].
     ​
     Recall that the set of indices updated during each move must be of size n − 1.
     It took a minimal 7 moves to make all elements in the array equal.
     */

    /*
     *  A. 1) Find Max number
     *     2) Find second Max number
     *     3) Max number equal to second max number
     *  B. Finding when we finish counting
     *  C. Counting how many steps we well do until conditional b is true
     */

    public static long pilesOfBoxes(List<Integer> boxesInPiles) {
        long result = 0;
        while(operationNotDone(boxesInPiles)) {
            result++;
            step(boxesInPiles);
        }
        return result;
    }


    static int maxInList(List<Integer> list) {
        /*
        int max = list.get(0);
		for(int i=1; i<list.size(); i++) {
			if(max<list.get(i)) {
				max = list.get(i);
			}
		}
		return max;
         */
        return list.stream().max(Integer::compare).get();
//      return list.stream().filter(num -> num<max).max(Integer::compare).get();
    }


    static int secondMaxInList(List<Integer> list) {
        int max = maxInList(list);
        int result = 0;
        for(int i=0; i<list.size(); i++) {
            if(result<list.get(i) && list.get(i) != max) {
                result = list.get(i);
            }
        }
        return result;
    }


    static void step(List<Integer> list) {
        int max = maxInList(list);
        int secondMax = secondMaxInList(list);
        int index = list.indexOf(max);
        list.remove(index);
        list.add(index,secondMax);
    }


    static boolean operationNotDone(List<Integer> list) {
        int num = list.get(0);
        for(int i=1; i<list.size(); i++) {
            if(list.get(i) != num) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        numbers.add(4);
        numbers.add(6);
        System.out.println(pilesOfBoxes(numbers));
    }



}
