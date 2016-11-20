/*
198. House Robber
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/
class Solution {

    HashMap<Integer, Integer> s = new HashMap<>();

    public int solve(int idx, int[] nums) {
        if (idx < 0) return 0;
        if (s.get(idx - 2) == null) s.put(idx - 2, solve(idx - 2, nums));
        if (s.get(idx - 1) == null) s.put(idx - 1, solve(idx - 1, nums));
        return Math.max(nums[idx] + s.get(idx - 2), s.get(idx - 1));
    }

    public int rob(int[] nums) {
        return solve(nums.length - 1, nums);
    }
}