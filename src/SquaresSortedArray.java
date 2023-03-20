// https://leetcode.com/problems/squares-of-a-sorted-array

import java.util.Arrays;

public class SquaresSortedArray {

    public static void main(String args[]) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }

    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) nums[i] = nums[i] * nums[i];
        Arrays.sort(nums);
        return nums;
    }
}
