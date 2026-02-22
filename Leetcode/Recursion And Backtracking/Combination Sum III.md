# Combination Sum III

Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

- Only numbers 1 through 9 are used.
- Each number is used at most once.

Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

https://leetcode.com/problems/combination-sum-iii/description/

# My own sol (beats 100%)

```java
import java.util.List;
import java.util.ArrayList;

class Solution {

    private void backtrack(List<List<Integer>> resultSet, List<Integer> tempSet, int sum, int n, int s, boolean[] used, int k) {
        if(tempSet.size() > k) return;
        if(sum > n) return;
        if(sum == n && tempSet.size() == k) {
            resultSet.add(new ArrayList<Integer>(tempSet));
            return;
        }

        for(int i=s; i<=9; i++) {
            if(used[i - 1]) continue;
            tempSet.add(i);
            used[i-1] = true;
            backtrack(resultSet, tempSet, sum + i, n, i + 1, used, k);
            used[i-1] = false;
            tempSet.remove(tempSet.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> resultSet = new ArrayList<>();
        backtrack(resultSet, new ArrayList<Integer>(), 0, n, 1, new boolean[9], k);
        return resultSet;
    }
}
```

# Notes

- Builds upon boolean array used pattern.