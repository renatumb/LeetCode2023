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
            if ((mapping.containsKey(ss) && (char) mapping.get(ss) != tt) ||
                    (alreadyMapped.containsKey(tt) && (char) alreadyMapped.get(tt) != ss)) {
                return false;
            }
        }
        return true;
    }

    //
    public static boolean isIsomorphic2(String s, String t) {
        //final int ascii = 65;
        char ss[] = new char[256];
        char tt[] = new char[256];

        for (int i = 0; i < s.length(); i++) {
            if (ss[s.charAt(i) ] == '\u0000' && tt[t.charAt(i) ] == '\u0000') {
                ss[s.charAt(i) ] = t.charAt(i);
                tt[t.charAt(i) ] = s.charAt(i);
                continue;
            }
            if( ss[s.charAt(i) ] != t.charAt(i) || tt[t.charAt(i) ] != s.charAt(i) ){
                return false;
            }
        }
        return true;
    }

}
