// https://leetcode.com/problems/binary-search

public class BinarySearch {
    public int search(int[] nums, int target) {
        int result = -1;
        int left = 0;
        int right = nums.length;
        int middle;

        for (; ; ) {
            middle = (left + right) / 2;
            if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle;
            } else {
                result = middle;
                break;
            }
            if (left >= right) return result;
        }
        return result;
    }
}
