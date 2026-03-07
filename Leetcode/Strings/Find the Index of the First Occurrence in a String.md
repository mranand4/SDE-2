# Find the Index of the First Occurrence in a String

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

# Topics

- Two Pointers
- String
- String Matching

**Note doing a simple indexOf works well and beats 100% sol but that won't get us anywhere in interviews, will it now?**

## KMP Based sol

```java
class Solution {
    public int[] lps(String str) {
        int k, i, x, m;
        m = str.length();

        int[] f = new int[m];
        f[0] = 0;

        for(k=1; k<m; k++) {

            i = k-1;
            x = f[i];

            while(str.charAt(k) != str.charAt(x)) {
                i = x - 1;
                if(i < 0) break;
                x = f[i];
            }

            if(i < 0) f[k] = 0;
            else f[k] = f[i] + 1;
        }
        
        return f;
    }

    public int strStr(String haystack, String needle) {
        int[] f = lps(needle);
        int i0 = 0;
        int i = 0;
        int j = 0;

        int n = haystack.length();
        int m = needle.length();

        while(i < n) {

            if(needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;

                if(j == m) return i0;
            } else {
                if(j == 0) {
                    i0++;
                    i = i0;
                    j = 0;
                    System.out.println(i);
                } else {
                    int k = f[j - 1];
                    j = k;
                    i0 = i - j;
                }
            }
        }

        return -1;
    }
}
```