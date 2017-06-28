/*
 * Given an array S of n integers, 
 * are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * Example
 * For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * */
import java.util.*;

public class ThreeSum {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        if (numbers == null || numbers.length == 0) {
            return result;
        }
        
        //sort the array first, O(nlogn)
        Arrays.sort(numbers);
        
        int a = 0;
        int head = 0; 
        int tail = 0;
        for (int i = 0; i < numbers.length; i++) {
        	a = numbers[i]; 
        	
        	//find b+c = -a in the rest of numbers
        	head = i + 1;
        	tail = numbers.length - 1;
        	
        	while (head < tail) {
        		if (numbers[head] + numbers[tail] < -a) {
        			head++;
        		} else if (numbers[head] + numbers[tail] > -a) {
        			tail--;
        		} else {
        			ArrayList<Integer> temp = new ArrayList<>();
        			
        			temp.add(a);
        			temp.add(numbers[head]);
        			temp.add(numbers[tail]);
        			
        			if (result.contains(temp) != true) {
            			result.add(temp);
        			}
        			
        			head++;
        			tail--;       			
        		}
        	}
        }
 
        return result;
    }
}
