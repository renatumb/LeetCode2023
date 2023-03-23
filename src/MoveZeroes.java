// https://leetcode.com/problems/move-zeroes

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String args[]) {

        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }


    public static void moveZeroes(int[] nums) {

        int end = nums.length - 1;

        for (int i = 0; i <= end; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                for (int j = i; j < end; j++)
                    nums[j] = nums[j + 1];

                nums[end] = tmp;
                end--;
            }
            if (nums[i] == 0) i--;
        }
        System.out.println(Arrays.toString(nums));
    }
}
