import java.util.HashMap;
import java.util.TreeSet;

// https://leetcode.com/problems/isomorphic-strings/
public class IsIsomorphic {
    public static boolean isIsomorphic(String s, String t) {

        HashMap mapping = new HashMap<Character, Character>();
        HashMap alreadyMapped = new HashMap<Character, Character>();

        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if (!mapping.containsKey(ss) && !mapping.containsValue(tt)) {
                mapping.put(ss, tt);
                alreadyMapped.put(tt, ss);
                continue;
            }
            if ( (      mapping.containsKey(ss) && (char)       mapping.get(ss) != tt) ||
                 (alreadyMapped.containsKey(tt) && (char) alreadyMapped.get(tt) != ss) ) {
                return false;
            }
        }
        return true;
    }
}
