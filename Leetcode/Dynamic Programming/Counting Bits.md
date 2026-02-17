# Counting Bits

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

https://leetcode.com/problems/counting-bits/description/

# My own answer naive

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int countSetBits(int n) {
        int count = 0;
        while(n != 0) {
            count = count + n%2;
            n = n/2;

        }
        return count;
    }

    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        ans[0] = 0;
        int lpow = 1;
        int tc = 0;

        for(int i=1; i<ans.length; i++) {
            if((i & (i - 1)) == 0) {
                ans[i] = 1;
                map.put(i, 1);
                lpow = i;
            } else {
                int rem = i - lpow;
                if(map.containsKey(rem)) {
                    int cnt = 1 + map.get(rem);
                    ans[i] = cnt;
                    map.put(i, cnt);
                } else {
                    int cnt = Integer.bitCount(i);
                    ans[i] = cnt;
                    map.put(i, cnt);
                }
            }
        }

        System.out.println(tc);
        return ans;
    }
}

# Notes

- This also involves bit manip.

# Todo

- Find efficient answer.