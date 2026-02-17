# Longest Substring Without Repeating Characters

https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

# Answer using sliding window

import java.util.Set;
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int sp=0; // start pointer
        int ep=0; // end pointer
        int ml=0; //max length
        Set<Character> set = new HashSet<>();

        for(; ep<s.length(); ep++) {
            char c = s.charAt(ep);
            if(set.contains(c)) {
                int len = ep - sp;
                ml = len > ml ? len : ml;
                for(int j=sp; j<ep; j++) {
                    set.remove(s.charAt(j));
                    if(s.charAt(j) == c) {
                        sp = j + 1;
                        break;
                    }
                }
            }
            set.add(c);
        }

        ml = ep - sp > ml ? ep - sp : ml;
        return ml;
    }
}

# Notes

- I solved this question using the two pointer technique myself.
- Main thing to do was remove characters from set too.