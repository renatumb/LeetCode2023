// https://leetcode.com/problems/is-subsequence/
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int indexS = 0;
        String copyS = "";
        if (s.length() == 0) return true;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(indexS)) {
                copyS += t.charAt(i);
                indexS++;
                if (copyS.length() == s.length() && copyS.equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSubsequence2(String s, String t) {
        int indexS = 0;
        if (s.length() == 0) return true;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(indexS)) {
                indexS++;
                if (indexS > s.length() - 1) return true;
            }
        }
        return false;
    }
}
