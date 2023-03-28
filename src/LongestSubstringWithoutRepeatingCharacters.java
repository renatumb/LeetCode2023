// https://leetcode.com/problems/longest-substring-without-repeating-characters

import java.util.Arrays;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String... args) {

        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("bbbbb"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
        System.out.println("---");
        System.out.println(lengthOfLongestSubstring3("abcabcbb"));
        System.out.println(lengthOfLongestSubstring3("bbbbb"));
        System.out.println(lengthOfLongestSubstring3("pwwkew"));
    }

    public static int lengthOfLongestSubstring1(String s) {
        int max = 0;
        HashSet set = new HashSet<Character>();

        char[] as = s.toCharArray();
        for (int i = 0; i < as.length; i++) {
            set.clear();
            for (int j = i; j < as.length; j++) {
                if (set.contains(as[j])) break;
                else {
                    set.add(as[j]);
                    max = set.size() > max ? set.size() : max;
                }
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int max = 0;
        HashSet set = new HashSet<Character>();

        char[] as = s.toCharArray();
        for (int ini = 0, end = 0; end < as.length; end++) {
            if (set.contains(as[end])) {
                set.clear();
                end = ++ini;
            }
            set.add(as[end]);
            max = set.size() > max ? set.size() : max;
        }
        return max;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int max = 0;
        boolean[] allChars = new boolean[255];
        char[] as = s.toCharArray();
        for (int ini = 0, end = 0; end < as.length; end++) {
            if (allChars[as[end]]) {
                allChars = new boolean[255];
                end = ++ini;
            }
            allChars[as[ini]] = true;
            allChars[as[end]] = true;
            max = (end - ini) + 1 > max ? (end - ini) + 1 : max;
        }
        return max;
    }
}
