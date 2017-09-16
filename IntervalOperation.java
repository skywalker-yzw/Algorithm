/**
 * Created by yizhiw on 9/15/2017.
 */
import java.util.*;

public class IntervalOperation {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // just simply merge a list of intervals
    public List<Interval> merge(List<Interval> input) {
        List<Interval> result = new LinkedList<Interval>();
        if ((input == null) || (input.size() == 0)) {
            return result;
        }

        Collections.sort(input, (o1, o2) -> o1.start - o2.start);

        result.add(input.get(0));
        for (int i = 1; i < input.size(); i++) {
            Interval node = input.get(i);
            Interval cur = result.get(result.size() - 1);

            if (cur.end >= node.start) { // overlap
                cur.end = Math.max(cur.end, node.end);
            } else {
                result.add(node);
            }
        }

        return result;
    }

    // Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
    // You may assume that the input intervals were initially sorted according to their start times.
    public List<Interval> insertInterval(List<Interval> input, Interval it) {
        List<Interval> result = new LinkedList<Interval>();

        if ((input == null) || (input.size() == 0)) {
            result.add(it);
            return result;
        }

        // one scan to insert the interval and merge
        result.add(input.get(0));
        boolean flag = false;
        for(int i = 1; i < input.size(); i++) {
            Interval node = input.get(i);
            Interval cur = result.get(result.size() - 1);

            if (flag == false) { // haven't insert the interval yet
                if (cur.start >= it.start) {
                    if (it.end < cur.start) { // an non-overlap interval need to insert before current interval
                        if (result.size() > 1) {
                            result.add(result.size() - 2, it);
                        } else {
                            result.add(0, it);
                        }
                    } else {
                        cur.start = it.start;
                        cur.end = Math.max(cur.end, it.end);
                    }

                    flag = true;
                } else if (cur.end >= it.start) { // overlap
                    cur.end = Math.max(cur.end, it.end);
                    flag = true;
                }
            }

            cur = result.get(result.size() - 1);
            // check with the interval from the input
            if (cur.end >= node.start) {
                cur.end = Math.max(cur.end, node.end);
            } else {
                result.add(node);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Interval> input = new LinkedList<Interval>();
        input.add(new Interval(3,4));
        input.add(new Interval(6,9));

        IntervalOperation obj = new IntervalOperation();
        List<Interval> result = obj.insertInterval(input, new Interval(1,2));
        for (Interval it : result) {
            System.out.println(it.start + "," + it.end);
        }

        result.add(new Interval(5,7));

        List<Interval> mergeRes = obj.merge(result);
        for (Interval it : mergeRes) {
            System.out.println(it.start + "," + it.end);
        }
    }
}