# Longest Palindromic Substring

Given a string s, return the longest in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

# Naive answer but my own

class Solution {

    public String isPalindrome(String str) {
        int len = str.length();
        for(int i=0; i<=len/2; i++) {
            char s = str.charAt(i);
            char e = str.charAt(len - i - 1);
            if(s != e) return null;
        }
        return str;
    }

    public String longestPalindrome(String str) {        
        int lp = 0;
        int len = str.length();
        String ans = str;

        for(int sp=0; sp < len && len - sp > lp; sp++) {

            int ep = len - 1;
            while(ep >= sp) {
                char s = str.charAt(sp);
                char e = str.charAt(ep);

                if(s == e) {
                    String t = isPalindrome(str.substring(sp, ep + 1));
                    if(t != null && 1 + ep - sp > lp) {
                        ans = t;
                        lp = 1 + ep - sp;
                        break;
                    }                
                }

                ep = ep - 1;
            }
        }

        return ans;
    }
}

# Notes

- Have to find optimized answer.
- This uses dp too.
- Came up with naive answer myself.

# Todo

- See how to do it using dp.
