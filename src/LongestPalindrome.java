// https://leetcode.com/problems/longest-palindrome

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int max = 0;
        int[] letters = new int[125];

        for (char l : s.toCharArray()) {
            letters[l]++;
            if (letters[l] == 2) {
                max += letters[l];
                letters[l] = 0;
            }
        }
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == 1) {
                max++;
                break;
            }
        }
        return max;
    }
}
