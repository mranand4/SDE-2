# Combination Sum

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the of at least one of the chosen numbers is different.

https://leetcode.com/problems/combination-sum/description/

# My own naive

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {

    private void backtrack(List<List<Integer>> resultSet, List<Integer> tempSet, int[] nums, int tempSum, int target)  {
        if(tempSum > target) return;
        if(tempSum == target) {
            List<Integer> arr = new ArrayList<Integer>(tempSet);
            Collections.sort(arr);

            if(!resultSet.contains(arr)) resultSet.add(arr);
            return;
        }

        for(int i=0; i<nums.length; i++) {
            tempSet.add(nums[i]);
            backtrack(resultSet, tempSet, nums, tempSum + nums[i], target);
            tempSet.remove(tempSet.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultSet = new ArrayList<>();
        backtrack(resultSet, new ArrayList<Integer>(), candidates, 0, target);
        return resultSet;
    }
}
```

# Optimized solution without the need of sorting and contains check

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {

    private void backtrack(List<List<Integer>> resultSet, List<Integer> tempSet, int[] nums, int tempSum, int target, int s)  {
        if(tempSum > target) return;
        if(tempSum == target) {
            resultSet.add(new ArrayList<Integer>(tempSet));
            return;
        }

        for(int i=s; i<nums.length; i++) {
            tempSet.add(nums[i]);
            backtrack(resultSet, tempSet, nums, tempSum + nums[i], target, i);
            tempSet.remove(tempSet.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultSet = new ArrayList<>();
        backtrack(resultSet, new ArrayList<Integer>(), candidates, 0, target, 0);
        return resultSet;
    }
}
```

# Notes

- Same element can be used twice.
- Inspired sol. is taken from generic backtracking pattern - https://leetcode.com/problems/combination-sum/solutions/16502/a-general-approach-to-backtracking-quest-dexx/


