# Target Sum

You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

    For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".

Return the number of different expressions that you can build, which evaluates to target.

# My naive answer

class Solution {

    public int rec(int[] nums, int ci, int ts, int t) {

        if(nums.length == ci) {
            if(ts == t) return 1;
            return 0;          
        }

        int neg = rec(nums, ci + 1, ts - nums[ci], t);
        int pos = rec(nums, ci + 1, ts  + nums[ci], t);

        return neg + pos;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return rec(nums, 0, 0, target);
    }
}

# Notes

- It's optimized solution uses dp.

# Todo

- Learn dp solution.