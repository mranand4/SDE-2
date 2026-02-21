# LC 78. Subsets

Given an integer array nums of unique elements, return all possible (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

# Topics

- Array
- Backtracking
- Bit Manipulation

# My own naive solution

```java
import java.util.List;
import java.util.LinkedList;

class Solution {

    private List<Integer> copy(List<Integer> arr) {
        List<Integer> lst = new LinkedList<>();
        for(Integer i : arr) lst.add(i);
        return lst;
    }

    private void rec(List<List<Integer>> ans, List<Integer> curr, int[] nums, int idx) {
        if(idx < nums.length) {
            curr.add(nums[idx]);
            ans.add(copy(curr));

            for(int i=idx + 1; i< nums.length; i++) {
                rec(ans, curr, nums, i);
                curr.removeLast();
            }

        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        ans.add(new LinkedList<>());
        for(int i=0; i<nums.length; i++) {
            LinkedList<Integer> curr = new LinkedList<>();
            rec(ans, curr, nums, i);
        }
        return ans;
    }
}
```

# Notes

- I took a lot of time(~1hr) to find the solution myself. My sol beats some 87% sols but it doesn't looks very good(both aethetic and logic wise).
- Key on arriving at the solution was looking at the problem and working out test cases. e.g. work out this input [1,2,3,4].
- We see an empty list will always be there so we've added it before hand. Then we traverse the list sequentially.
- We are only calculating permutations of number@index i with numbers after it.
- With this logic we cover everything.
- In for loop, we have to remove the last added number so as to get proper permutations, e.g. with 1 we have [1], [1,2], [1,2,3,4], [1,3], [1,3,4], [1,4]
- This is the template for all of these sol: https://leetcode.com/problems/subsets/solutions/27281/a-general-approach-to-backtracking-quest-0ea5/

# Todo

- See the cleaner solution with backtracking patterns here - https://leetcode.com/problems/subsets/solutions/27281/a-general-approach-to-backtracking-quest-0ea5/.
