# Split a String Into the Max Number of Unique Substrings

Given a string s, return the maximum number of unique substrings that the given string can be split into.

You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.

A substring is a contiguous sequence of characters within a string.

https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/description/

# My own solution #1 inspired from palindrome partioning sol

```java
import java.util.List;
import java.util.ArrayList;

class Solution {

    private int backtrack(List<String> result, List<String> temp, String str) {
        if(str == null || str.length() == 0) {
            if(temp.size() > result.size()) {
                return temp.size();
            }
            return 0;
        }

        int max = 0;
        for(int i=1; i<=str.length(); i++) {
            String part = str.substring(0, i);

            if(temp.contains(part)) continue;

            temp.add(part);
            int cm = backtrack(result, temp, str.substring(i, str.length()));
            temp.remove(temp.size() - 1);
            if(cm > max) max = cm;
        }

        return max;
    }


    public int maxUniqueSplit(String s) {
        int max = backtrack(new ArrayList<>(), new ArrayList<>(), s);
        return max;
    }
}
```

# We don't really need result set in this ques so removed it, also hashset will work just fine here as we just want unique substrings

```java
import java.util.Set;
import java.util.HashSet;

class Solution {

    private int backtrack(Set<String> temp, String str, int max) {
        if(str == null || str.length() == 0) {
            if(temp.size() > max) {
                return temp.size();
            }
            return max;
        }

        for(int i=1; i<=str.length(); i++) {
            String part = str.substring(0, i);

            if(temp.contains(part)) continue;

            temp.add(part);
            int cm = backtrack(temp, str.substring(i, str.length()), max);
            temp.remove(part);
            if(cm > max) max = cm;
        }

        return max;
    }


    public int maxUniqueSplit(String s) {
        int max = backtrack(new HashSet<String>(), s, 0);
        return max;
    }
}
```

