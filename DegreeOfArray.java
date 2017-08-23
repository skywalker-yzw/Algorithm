/**
 * Created by yizhiw on 8/5/2017.
 */
import  java.util.*;

public class DegreeOfArray {
    public int helper(int[] array, int start, int end) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            int num = array[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }

        //System.out.println("Start: "+ start + ", end:" + end + ", degree :" + max);
        return max;
    }

    // return the min length of subarray which has the same degree as array
    public int degreeOfArray(int[] array) {
        if ((array == null) || (array.length == 0)) {
            return 0;
        }

        int degree = helper(array, 0, array.length-1);

        int len = Integer.MAX_VALUE;
/*
        // lame way to do in two loops
        for (int i = 0 ; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (helper(array, i, j) == degree) {
                    len = Math.min(len, j - i + 1);
                }
            }
        }
*/

        int i = 0;
        while(i < array.length) {
            int j = i;

            while(j < array.length) {
                if (helper(array, i, j ) < degree) {
                    j++;
                } else {
                    len = Math.min(len, j - i + 1);
                    break;
                }
            }

            i++;
        }

        return len;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,1};
        DegreeOfArray obj = new DegreeOfArray();
        System.out.println(obj.degreeOfArray(array));
    }
}
