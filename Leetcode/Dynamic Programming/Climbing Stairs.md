# Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

# My own answer using recursion with dp

class Solution {

    // Solution 1 - top down
    public int distinctWays(int limit, int[] mem) {
        if(limit == 0) return 1;
        if(limit < 0) return 0;
        if(mem[limit - 1] != -1) return mem[limit - 1];

        int withOne = distinctWays(limit - 1, mem);
        int withTwo = distinctWays(limit - 2, mem);
        mem[limit - 1] = withOne + withTwo;
        return withOne + withTwo;
    }

    //Solution 2 -  bottom up
    public int distinctWays(int curr, int limit, int[] mem) {
        if(limit == curr) return 1;
        if(limit < curr) return 0;
        if(curr != 0 && mem[curr - 1] != -1) return mem[curr - 1];

        int withOne = distinctWays(curr + 1, limit, mem);
        int withTwo = distinctWays(curr + 2, limit, mem);

        if(curr != 0) mem[curr - 1] = withOne + withTwo;
        return withOne + withTwo;
    }

    public int climbStairs(int n) {
        int[] mem = new int[n + 1];
        for(int i=0; i<n; i++) mem[i] = -1;
        return distinctWays(0, n, mem);
    }
}

# Notes

- This involves recursion and dynamic programming