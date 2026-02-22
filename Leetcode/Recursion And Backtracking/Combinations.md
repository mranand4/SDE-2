# Combinations

Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

https://leetcode.com/problems/combinations/description/

# Topics

- Backtracking

# My own optimized "forward seeking backtracking" sol

```java
import java.util.List;
import java.util.ArrayList;

class Solution {

    private void backtrack(List<List<Integer>> resultSet, List<Integer> tempSet, int s, int k, int n) {
        if(tempSet.size() == k) {
            resultSet.add(new ArrayList<Integer>(tempSet));
            return;
        }

        for(int i=s; i<=n; i++) {
            tempSet.add(i);
            backtrack(resultSet, tempSet, i + 1, k, n);
            tempSet.remove(tempSet.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultSet = new ArrayList<>();
        backtrack(resultSet, new ArrayList<Integer>(), 1, k, n);
        return resultSet;
    }
}
```
# Notes

- It's solved easily with forward seeking backtracking approach.
- I was tempted to initialize an array from 1..n but it's not required and I didn't did it. Looping in a for loop from 1..n works just fine.