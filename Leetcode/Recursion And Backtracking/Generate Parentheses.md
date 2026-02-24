# Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

https://leetcode.com/problems/generate-parentheses/description/

# Topics

- String
- Dynamic Programming
- Backtracking

# My own sol (kind of optimized)

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class Solution {
    private void backtrack(List<String> resultSet, StringBuilder temp, int availableOpening, int availableClosing) {
        if(availableOpening > availableClosing) return;
        if(availableOpening == 0 && availableClosing == 0) {
            Stack<Character> st = new Stack<>();
            for(int i=0; i<temp.length(); i++) {
                char ch = temp.charAt(i);
                if(ch == '(') st.push(ch);
                if(ch == ')' && !st.isEmpty()) st.pop();
            }
            if(st.isEmpty()) resultSet.add(temp.toString());
            return;
        }

        if(availableOpening > 0) {
            temp.append('(');
            backtrack(resultSet, temp, availableOpening - 1, availableClosing);
            temp.setLength(temp.length() - 1);
        }

        if(availableClosing > 0) {
            temp.append(')');
            backtrack(resultSet, temp, availableOpening, availableClosing - 1);
            temp.setLength(temp.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> resultSet = new ArrayList<String>();
        backtrack(resultSet, new StringBuilder(), n, n);
        return resultSet;
    }
}
```

# Notes

- Key realisation was that if at any point, num opening brackets > num closing brackets then that recursive branch is already unbalanced and we can avoid travelling it.

# Todo

- See an optimized dp solution.