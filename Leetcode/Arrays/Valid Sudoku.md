# Valid Sudoku

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

- Each row must contain the digits 1-9 without repetition.
- Each column must contain the digits 1-9 without repetition.
- Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

https://leetcode.com/problems/valid-sudoku/description/

# Topic

- Array
- Hash Table
- Matrix

# My own solution

```java
import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        int r = board.length;
        int c = board[0].length;

        Set<Character> seen = new HashSet<>();

        // row validation
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                char ch = board[i][j];
                if(ch == '.') continue;
                if(seen.contains(ch)) return false;
                seen.add(ch);
            }
            seen.clear();
        }

        // column validation
        for(int i=0; i<c; i++) {
            for(int j=0; j<r; j++) {
                char ch = board[j][i];
                if(ch == '.') continue;
                if(seen.contains(ch)) return false;
                seen.add(ch);
            }
            seen.clear();
        }

        // block validation
        for(int i=0; i<r; i=i+3) {
            for(int j=0; j<c; j=j+3) {

                for(int m=i; m<i + 3; m++) {
                    for(int n=j; n<j+3; n++) {
                        char ch = board[m][n];
                        if(ch == '.') continue;
                        if(seen.contains(ch)) return false;
                        seen.add(ch);
                    }
                }
                seen.clear();
            }
        }

        return true;
    }
}
```

# Notes

- It's a straightfroward solution with Set and array traversal wherein we just translated the rules to code.
- A more clever solution where each row, column and block is considered an individual array and we only check for uniqueness - https://leetcode.com/problems/valid-sudoku/solutions/15634/sharing-my-easy-understand-java-solution-ti8f/.