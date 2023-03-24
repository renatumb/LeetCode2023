// https://leetcode.com/problems/reverse-words-in-a-string-iii

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordsStringIII {
    public static void main(String... args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords("God Ding"));
    }

    public static String reverseWords(String s) {
        return Arrays.stream(s.split(" "))
                .map(x -> new StringBuffer(x).reverse())
                .collect(Collectors.joining(" "));
    }
}
