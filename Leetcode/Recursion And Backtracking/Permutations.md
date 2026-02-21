# Permutations

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

https://leetcode.com/problems/permutations/description/

# Topics

- Array
- Backtracking

# Solution my own optimized

```java
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {

    private void backtrack(List<List<Integer>> resultSet, List<Integer> tempSet, int[] nums, int start) {
        if(tempSet.size() == nums.length) {
            resultSet.add(new ArrayList<Integer>(tempSet));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(tempSet.contains(nums[i])) continue;

            tempSet.add(nums[i]);
            backtrack(resultSet, tempSet, nums, i + 1);
            tempSet.remove(tempSet.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // Arrays.sort(nums);
        List<List<Integer>> resultSet = new ArrayList<>();
        backtrack(resultSet, new ArrayList<Integer>(), nums, 0);
        return resultSet;
    }
}
```

# Notes

- Sorting arrays isn't really required.
- Key thing to note is that we have to consider before and after the current element.
- We don't have to consider already considered elements again.
- Using array list instead of linked list increased performance by 30%.
- We'll get answer at the end i.e. when temp set's length == nums length not before that as we have to consider all the elements.
- Draw permutation/backtrack tree on paper to understand better.