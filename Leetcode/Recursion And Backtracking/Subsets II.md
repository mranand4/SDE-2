# Subsets II

Given an integer array nums that may contain duplicates, return all possible (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

https://leetcode.com/problems/subsets-ii/description/

# Naive answer from Nikhil Lohia

https://www.youtube.com/watch?v=qGyyzpNlMDU

```java
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {

    private void backtrack(List<List<Integer>> resultSet, List<Integer> tempSet, int[] nums, int s) {
        if(resultSet.contains(tempSet)) return;

        resultSet.add(new LinkedList<Integer>(tempSet));

        for(int i=s; i<nums.length; i++) {
            tempSet.add(nums[i]);
            backtrack(resultSet, tempSet, nums, i + 1);
            tempSet.removeLast();
        }
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultSet = new LinkedList<>();
        backtrack(resultSet, new LinkedList<Integer>(), nums, 0);
        return resultSet;
    }
}
```

# More efficient solution without using contains and checking duplicates in result set

Taken from - https://leetcode.com/problems/subsets/solutions/27281/a-general-approach-to-backtracking-quest-0ea5/

```java
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {

    private void backtrack(List<List<Integer>> resultSet, List<Integer> tempSet, int[] nums, int s) {
        resultSet.add(new LinkedList<Integer>(tempSet));

        for(int i=s; i<nums.length; i++) {
            if(i > s && nums[i] == nums[i-1]) continue;
            tempSet.add(nums[i]);
            backtrack(resultSet, tempSet, nums, i + 1);
            tempSet.removeLast();
        }
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultSet = new LinkedList<>();
        backtrack(resultSet, new LinkedList<Integer>(), nums, 0);
        return resultSet;
    }
}
```