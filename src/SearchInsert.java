// https://leetcode.com/problems/search-insert-position/

public class SearchInsert {
    public static void main(String args[]) {

        System.out.println(searchInsert(new int[]{1, 3, 5, 7}, 2)); // 1
        System.out.println(searchInsert(new int[]{1, 3, 5, 7}, 6)); //3
        System.out.println(searchInsert(new int[]{1, 3, 5, 7}, 5)); // 2

        System.out.println(searchInsert(new int[]{1, 3, 5, 7, 9}, 2)); // 1
        System.out.println(searchInsert(new int[]{1, 3, 5, 7, 9}, 8)); //4
        System.out.println(searchInsert(new int[]{1, 3, 5, 7, 9}, 5)); // 2

    }

    public static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int middle;

        if (target > nums[right]) return ++right;
        if (target < nums[left]) return 0;

        for (; ; ) {
            middle = (left + right) / 2;
            if (target == nums[middle])
                return middle;

            if (target > nums[middle]) {
                if (left == middle) return ++left;
                left = middle;
            } else {
                right = middle;
            }
        }

    }
}
