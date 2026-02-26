# Palindrome Partitioning

Given a string s, partition s such that every of the partition is a palindrome. Return all possible palindrome partitioning of s.

https://leetcode.com/problems/palindrome-partitioning/description/

# Backtracking sol

```java
class Solution {

    private boolean isPalindrome(String str) {
        int len = str.length();
        for(int i=0; i<len/2; i++) {
            if(str.charAt(i) != str.charAt(len - i - 1)) return false;
        }
        return true;
    }

    private void backtrack(List<List<String>> result, List<String> curr, String s) {
        if(s == null || s.length() == 0) {
            result.add(new ArrayList<String>(curr));
            return;
        }

        for(int i=1; i<=s.length(); i++) {
            String temp = s.substring(0, i);

            // we only have to partition palindromes
            // so we can skip non-palindromic strings
            if(!isPalindrome(temp)) continue;

            curr.add(temp);
            // if string is of single character than s.substring(1, 1) will give empty
            // string which will terminate the next recursive call
            backtrack(result, curr, s.substring(i, s.length()));
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<String>(), s);
        return result;
    }
}
```

# Solution and explanation link

https://leetcode.com/problems/palindrome-partitioning/solutions/182307/java-backtracking-template-general-appro-qseh/

- I worked it out myself to understand it, if I forget it again in future then I'll work it out again.