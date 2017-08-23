/**
 * Created by yizhiw on 8/10/2017.
 */
import java.util.*;

public class FindDuplicate {
    public int findTheFirstDup (int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return -1;
        }

        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

        //for (int num : nums) {
        //    map.put(num, map.getOrDefault(num, 0) + 1);
        //}

        for (Integer num : map.keySet()) {
            System.out.println(num);
        }

        for (Integer num : map.keySet()) {
            Integer cnt = map.get(num);
            if (cnt >= 2) {
                return num.intValue();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 5, 1, 3, 7};
        FindDuplicate obj = new FindDuplicate();

        System.out.println(obj.findTheFirstDup(nums));
    }
}
