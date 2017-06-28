import java.util.*;

/**
 * Created by yizhiw on 6/26/2017.
 */
public class FirstAppearingChar {
    public static int getAppearingCharPos(String str1, String str2) {
        if ((str1 == null) || (str2 == null) || (str1.length() == 0) || (str2.length() == 0)) {
            return -1;
        }

        String src = null;
        String str = null;
        if (str1.length() < str2.length()) {
            src = str1;
            str = str2;
        } else {
            src = str2;
            str = str1;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        //scan the character one by one and save the position
        for (int i = 0; i < src.length(); i++) {
            char ch = src.charAt(i);
            Integer pos = map.get(Character.valueOf(ch));
            // only add the early positions
            if (pos == null) {
                map.put(Character.valueOf(ch), i);
            }
        }

        int minPos = Integer.MAX_VALUE;
        // scan the second string to get the first appearing character position
        for (int i = 0; i < str.length(); i++) {
            Character ch = Character.valueOf(str.charAt(i));
            Integer pos = map.get(ch);

            if (pos != null) {
                int min = Math.min(pos, i);

                minPos = Math.min(min, minPos);
            }
        }

        return (minPos == Integer.MAX_VALUE) ? -1 : minPos;
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "edf";

        System.out.println("first appearing char position is: " + getAppearingCharPos(str1, str2));
    }
}
