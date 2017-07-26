/**
 * Created by yizhiw on 7/26/2017.
 */
import java.util.*;

public class MeanMedianMode {
    public double mean(int[] nums) {
        // valid the passing in array, throw exception if it's empty or null
        if ((nums == null) || (nums.length == 0)) {
            System.err.println("Input number array is null or empty!");
            throw (new RuntimeException());
        }

        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return (sum / nums.length);
    }

    public double median(int[] nums){
        // valid the passing in array, throw exception if it's empty or null
        if ((nums == null) || (nums.length == 0)) {
            System.err.println("Input number array is null or empty!");
            throw (new RuntimeException());
        }
        // sort the array first
        Arrays.sort(nums);

        int size = nums.length;
        // check the array size and return the median accordingly
        if( size % 2 == 1) {
            return nums[size/2];
        } else {
            return (nums[size/2 - 1] + nums[size/2])/ 2.0;
        }
    }

    // mode function will return the most frequent number in the number array
    // i.e, {1,2,2} --> {2}; {1,1,2,2}  --> {1, 2}
    public List<Integer> mode(int[] nums) {
        // valid the passing in array, throw exception if it's empty or null
        if ((nums == null) || (nums.length == 0)) {
            System.err.println("Input number array is null or empty!");
            throw (new RuntimeException());
        }
        // use a hashmap to store <number, frequency>
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // use max to keep tracking of the max
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            Integer cnt = map.get(nums[i]);
            if (cnt == null) {
                map.put(nums[i], 1);
                max = Math.max(max, 1);
            } else {
                cnt++;
                map.put(nums[i], cnt);
                max = Math.max(max, cnt);
            }
        }
        List<Integer> result = new LinkedList<Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {5,3,4,2,1,2,1};

        MeanMedianMode obj = new MeanMedianMode();

        System.out.println(obj.mean(array));
        System.out.println(obj.median(array));
        System.out.println(obj.mode(array));
    }
}
