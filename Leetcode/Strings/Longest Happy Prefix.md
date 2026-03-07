# Longest Happy Prefix

A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).

Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.

https://leetcode.com/problems/longest-happy-prefix/description/

# Topics

- String
- Rolling Hash
- String Matching
- Hash Function

# My sol using LPS Table (longest prefix search)

```java
class Solution {

    // using lps algo here - https://www.cs.emory.edu/~cheung/Courses/253/Syllabus/Text/Matching-KMP2.html
    public String longestPrefix(String s) {
        int k, x, i, m;

        m = s.length();
        int f[] = new int[m];
        f[0] = 0;

        for(k=1; k<m; k++) {

            i = k - 1;
            x = f[i];

            while(s.charAt(k) != s.charAt(x)) {
                i = x - 1;
                if(i < 0) break;
                x = f[i];
            }

            if(i < 0) f[k] = 0;
            else f[k] = f[i] + 1;
        }

        if(f[m - 1] == 0) return "";
        return s.substring(m - f[m-1]);
    }
}
```

# Source of algo

- https://www.cs.emory.edu/~cheung/Courses/253/Syllabus/Text/Matching-KMP2.html