# Permutations II

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

https://leetcode.com/problems/permutations-ii/description/

# Topics

- Array
- Backtracking
- Sorting

# My own naive solution using contains

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    private void backtrack(List<List<Integer>> resultSet, List<Integer> tempSet, int[] nums, int s) {
        if(tempSet.size() == nums.length) {
            List<Integer> numList = new ArrayList<>(tempSet);
            for(int i=0; i<numList.size(); i++) {
                numList.set(i, nums[numList.get(i)]);
            }

            if(!resultSet.contains(numList)) resultSet.add(numList);
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(tempSet.contains(i)) continue;

            tempSet.add(i);
            backtrack(resultSet, tempSet, nums, i + 1);
            tempSet.remove(tempSet.size() - 1);
        }

    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> idxResultSet = new ArrayList<>();
        backtrack(idxResultSet, new ArrayList<Integer>(), nums, 0);
        return idxResultSet;
    }
}
```

# Notes

- Core logic is similar to subset 2 and permutations question.
- Instead of checking contains on element, we can check it on index. If we check it on index then we'll stop the permutation before completing.
- We instead maintain list of indexes.
- When we see we have traversed full array, then we convert the index array to element array and add it to result if not already seen.

# Todo

- See this sol: https://leetcode.com/problems/permutations-ii/solutions/18594/really-easy-java-solution-much-easier-th-lpev/