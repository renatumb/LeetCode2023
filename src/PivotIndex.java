// https://leetcode.com/problems/find-pivot-index/
public class PivotIndex {
    public static int pivotIndex(int[] nums) {
        int right = 0;
        int left = 0;

        for (int el : nums) {
            right += el;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((right - nums[i]) == left) return i;

            right -= nums[i];
            left += nums[i];
        }
        return -1;
    }
}
