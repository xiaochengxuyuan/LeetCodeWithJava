/*
442. Find All Duplicates in an Array

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
*/
public class Solution {

    /**
     * 这个方法很巧妙的运用了题目中 1 ≤ a[i] ≤ n ，和元素要么出现一次要么出现两次的特点，很优雅，肯定不是我想出来的...
     */
    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null) return null;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int location = Math.abs(nums[i]) - 1;
            if (nums[location] < 0) {
                result.add(Math.abs(nums[i]));
            }
            nums[location] = -nums[location];
        }
        return result;
    }
}