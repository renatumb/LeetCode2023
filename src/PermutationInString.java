// https://leetcode.com/problems/permutation-in-string

import java.util.Arrays;

public class PermutationInString {
    public static void main(String... args) {

        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
        System.out.println(checkInclusion("adc", "dcda"));
    }

    public static boolean checkInclusion(String s1, String s2) {

        char[] s1a = s1.toCharArray();
        Arrays.sort(s1a);

        int size = s1.length();

        for (int i = 0; i + size <= s2.length(); i++) {

            String aux = s2.substring(i, i + size);
            char[] auxa = aux.toCharArray();
            Arrays.sort(auxa);

            if (Arrays.compare(s1a, auxa) == 0)
                return true;
        }
        return false;
    }

}
