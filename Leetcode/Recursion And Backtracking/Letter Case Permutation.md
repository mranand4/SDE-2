# Letter Case Permutation

Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.

https://leetcode.com/problems/letter-case-permutation/description/

# Topics

- Senior
- String
- Backtracking
- Bit Manipulation
- Weekly Contest 

# My own answer - optimized

```java
import java.util.List;
import java.util.LinkedList;

class Solution {

    private void backtrack(int idx, char[] arr, List<String> ans) {
        if(idx == arr.length) {
            ans.add(new String(arr));
        } else {
            char c = arr[idx];
            if(Character.isDigit(c)) {
                // digits can't be converted to upper or lower case
                // so we process them as is
                backtrack(idx + 1, arr, ans);
            } else {
                // we have to convert each char into
                // lower and upper case
                arr[idx] = Character.toLowerCase(c);
                backtrack(idx + 1, arr, ans);
                arr[idx] = Character.toUpperCase(c);
                backtrack(idx + 1, arr, ans);
                // backtracking
                arr[idx] = c;
            }
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> ans = new LinkedList<>();
        backtrack(0, s.toCharArray(), ans);
        return ans;
    }
}
```

# Notes

- We can't have logic like permute only upper case if char is lower case and vice versa as it'll skip permutations.
- Was able to find optimized solution and code it up in less than 20 mins.

# With backtrack returning ans directly

```java
import java.util.List;
import java.util.LinkedList;

class Solution {

    private List<String> backtrack(int idx, char[] arr, List<String> ans) {
        if(idx == arr.length) {
            ans.add(new String(arr));
        } else {
            char c = arr[idx];
            if(Character.isDigit(c)) {
                // digits can't be converted to upper or lower case
                // so we process them as is
                backtrack(idx + 1, arr, ans);
            } else {
                // we have to convert each char into
                // lower and upper case
                arr[idx] = Character.toLowerCase(c);
                backtrack(idx + 1, arr, ans);
                arr[idx] = Character.toUpperCase(c);
                backtrack(idx + 1, arr, ans);
                // backtracking
                arr[idx] = c;
            }
        }
        return ans;
    }

    public List<String> letterCasePermutation(String s) {
        return backtrack(0, s.toCharArray(), new LinkedList<>());
    }
}
```