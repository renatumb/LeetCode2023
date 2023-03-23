// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

import java.util.Arrays;

public class TwoSumII_InputArrayIsSorted {

    public static void main(String... args) {


        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if ((numbers[i] + numbers[j]) == target) return new int[]{++i, ++j};
            else if ((numbers[i] + numbers[j]) > target) j--;
            else i++;
        }
        return new int[]{++i, ++j};
    }
}
