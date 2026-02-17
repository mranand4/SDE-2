# Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

# Answer my own

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int fi = 0; // first num index
        int si = 0; // second num index
        int sn = 0; // second num
        for(int i=0; i<nums.length; i++) {
            int on = target - nums[i]; // other number
            if(on == nums[i] && map.get(on) == 1) continue;
            if(map.containsKey(on)) {
                sn = on;
                fi = i;
                break;
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == sn && i != fi) {
                si = i;
                break;
            }
        }

        return new int[]{fi, si};   
    }
}

# Answer optimized

https://leetcode.com/problems/two-sum/solutions/127810/two-sum-by-leetcode-kwuq/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        // In case there is no solution, return an empty array
        return new int[] {};
    }
}