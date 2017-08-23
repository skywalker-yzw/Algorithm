/**
 * Created by yizhiw on 8/6/2017.
 */
import java.util.*;

public class TopKNumbersInString {
    public List<Integer> getTopKLargestNumber (String input, int k) {
        List<Integer>  result = new LinkedList<Integer>();

        if((input == null) || (input.length() == 0) || (k < 0)) {
            return result;
        }

        // maintain a min heap with K size to hold the largest K number
        Queue<Integer> pQueue = new PriorityQueue<>(k);

        char sign = '+';
        int num = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if ((ch >= '0') && (ch <= '9')) {
                num = num * 10 + ch - '0';

                // the last number
                if (i == input.length() - 1) {
                    num = (sign == '+') ? num : (-num);

                    if (pQueue.size() < k) {
                        pQueue.offer(Integer.valueOf(num));
                    } else {
                        int top = pQueue.peek().intValue();
                        if (num > top) {
                            pQueue.poll();
                            pQueue.offer(Integer.valueOf(num));
                        }
                    }
                }
            } else if (ch == '-'){
                sign = '-';
            } else {
                if (num != 0) {
                    num = (sign == '+') ? num : (-num);

                    if (pQueue.size() < k) {
                        pQueue.offer(Integer.valueOf(num));
                    } else {
                        int top = pQueue.peek().intValue();
                        if (num > top) {
                            pQueue.poll();
                            pQueue.offer(Integer.valueOf(num));
                        }
                    }

                    num = 0;
                    sign = '+';
                } else {
                    continue;
                }
            }
        }


        while(pQueue.isEmpty() == false) {
            result.add(0,pQueue.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        // rft567.908kih000000hh890jug678gtff567
        String input = "dfsfs980sdf123poier110poipoikkj-10asdfasfa200sadfadf330";

        TopKNumbersInString obj = new TopKNumbersInString();
        int k = 3;
        List<Integer> result = obj.getTopKLargestNumber(input, k);
        System.out.println(result);
    }

}
