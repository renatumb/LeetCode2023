// https://leetcode.com/problems/reverse-string

import java.util.Arrays;

public class ReverseString {

    public static void main(String args[]) {

        reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
        reverseString(new char[]{'c', 'a', 's', 'a'});
    }

    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        int middle = s.length / 2;

        while (i < middle) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(s));
    }
}
