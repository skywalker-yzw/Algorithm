/**
 * Created by yizhiw on 7/31/2017.
 */
public class FindInBisect {
    public int findFirstBad(String[] bisect) {
        if ((bisect == null) || (bisect.length == 0)) {
            return -1;
        }

        int start = 0;
        int end = bisect.length - 1;

        while(start + 1 < end) {
            int mid = start + (end - start) / 2 ;

            if (bisect[mid].equals("bad")) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (bisect[start].equals("bad")) {
            return start;
        } else if (bisect[end].equals("bad")){
            return end;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String[] bisect = {"good", "good", "good", "good", "bad", "bad"};

        FindInBisect obj = new FindInBisect();

        System.out.println(obj.findFirstBad(bisect));
    }
}
