package hu.progmatic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CodingBat {


    public static String startOz(String str) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char inspected = str.charAt(i);
            if (i == 0 && inspected == 'o') {
                sb.append(inspected);
            }
            if (i == 1 && inspected == 'z') {
                sb.append(inspected);
            }
        }
        return String.valueOf(sb);
    }

    public static String[] swap(String[] strings) {
        Map<String, Integer> map = new HashMap();
        for (int i=0; i<strings.length; i++) {
            String key = strings[i].substring(0, 1);
            if (map.containsKey(key)) {
                int match = map.get(key);
                String temp = strings[match];  // swap strings at match/i
                strings[match] = strings[i];
                strings[i] = temp;
                map.remove(key);  // so this old one won't match anything
            }
            else {
                map.put(key, i);
            }
        }
        return strings;
    }

    public static int createChocalateBar(int small, int big, int goal) {
        return big * 5 < goal ? (small < goal - big * 5 ? -1 : goal - big * 5) : (big * 5 == 0 ? 0 : (small < goal % 5 ? -1 : goal % 5));
    }

    public int intMax(int a, int b, int c) {
        int[] numberMax = {a, b, c};
        return Arrays.stream(numberMax).max().getAsInt();
    }

    public static String frontTimes(String str, int n) {
        return str.substring(0, 3).repeat(n);

    }

    public Map<String, String> mapBully(Map<String, String> map) {
        if (map.get("a") != null) {
            map.put("b", map.get("a"));
            map.replace("a", "");
        }
        return map;
    }

    public Map<String, String> mapAB4(Map<String, String> map) {
        int aLength = map.get("a").length();
        int bLength = map.get("b").length();

        if (aLength != bLength) {
            map.put("c", map.get(aLength > bLength ? map.get("a") : map.get("b")));
            return map;
        }

        if (map.containsKey("a") && map.containsKey("b")) {
            map.replace("a", "");
            map.replace("b", "");
        }

        return map;
    }

    public static String mirrorEnds(String string) {
        StringBuilder sb = new StringBuilder();
        for
        (int i = 0; i < string.length() &&
                string.charAt(i) == (string.charAt(string.length() - 1 - i)); i++) {
            sb.append(string.charAt(i));
        }
        return String.valueOf(sb);
    }

}
