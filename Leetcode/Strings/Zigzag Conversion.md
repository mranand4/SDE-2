# Zigzag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

# My own answer naive

class Solution {
    public String convert(String s, int rows) {
        int len = s.length();
        int cols = len; // rows == 1 ? len : len/2;

        char[][] zz = new char[rows][cols];
        for(int i=0; i<rows; i++)
        for(int j=0; j<cols; j++)
        zz[i][j] = ' ';

        boolean ceil = true;
        int r = 0;
        int c = 0;
        for(char ch : s.toCharArray()) {
            zz[r][c] = ch;

            if(ceil) {
                r = r + 1;
            } else {
                r = r - 1;
                c = c + 1;
            }

            if(r == rows) {
                ceil = false;
                r = r - 2;
                c = c + 1;
            }

            if(r <= 0) {
                ceil = true;
                r = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<rows; i++)
        for(int j=0; j<cols; j++)
        if(zz[i][j] != ' ') sb.append(zz[i][j]);

        return sb.toString();
    }
}

# Notes

- I solved this question myself.
- My solution isn't optimized.

# Todo

- See optimized approach.
