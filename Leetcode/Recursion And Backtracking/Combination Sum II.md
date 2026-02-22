# Combination Sum II

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

https://leetcode.com/problems/combination-sum-ii/description/

# My sol which got TLEd

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    private void backtrack(
        List<List<Integer>> resultSet,
        List<Integer> tempSet,
        int[] nums,
        int s,
        int sum,
        int target
    ) {
        if(sum > target) return;

        if(sum == target) {
            List<Integer> arr = new ArrayList<>(tempSet);
            if(!resultSet.contains(arr)) resultSet.add(arr);
            return;
        }

        for(int i=s; i<nums.length; i++) {
            tempSet.add(nums[i]);
            backtrack(resultSet, tempSet, nums, i + 1, sum + nums[i], target);
            tempSet.remove(tempSet.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(ans, new ArrayList<Integer>(), candidates, 0, 0, target);
        return ans;
    }
}
```

# My own sol which got accepted

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    private void backtrack(
        List<List<Integer>> resultSet,
        List<Integer> tempSet,
        int[] nums,
        int s,
        int sum,
        int target
    ) {
        if(sum > target) return;

        if(sum == target) {
            List<Integer> arr = new ArrayList<>(tempSet);
            if(!resultSet.contains(arr)) resultSet.add(arr);
            return;
        }

        for(int i=s; i<nums.length; i++) {
            if(i != s && nums[i] == nums[i-1]) continue;
            tempSet.add(nums[i]);
            backtrack(resultSet, tempSet, nums, i + 1, sum + nums[i], target);
            tempSet.remove(tempSet.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(ans, new ArrayList<Integer>(), candidates, 0, 0, target);
        return ans;
    }
}
```

# Notes

- Above written sol is my own, key thing is to sort the array first so that all duplicate elements are in subsequent order and we can place a simple duplicate check(nums[i] == nums[i-1]) in the for loop itself to avoid duplicate calculations.