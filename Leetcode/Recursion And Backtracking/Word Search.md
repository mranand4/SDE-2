# Word Search

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

https://leetcode.com/problems/word-search/description/

# Topics

- Array
- String
- Backtracking
- Depth-First Search
- Matrix

# My own solution

class Solution {

    private boolean backtrack(int r, int c, char[][] board, int idx, String word) {
        int tr = board.length;
        int tc = board[0].length;

        // if we reach this point then all prev. characters were same as char of string.
        if(idx == word.length()) return true;

        // matrix edges
        if(r >= tr || r < 0 || c >= tc || c < 0) return false;

        // char already visited
        if(board[r][c] == '-') return false;

        // do not move forward if char at curr index in word is not found at the current matrix cell
        if(word.charAt(idx) != board[r][c]) return false;

        int nr = r;
        int nc = c;

        // set curr cell as visited
        char og = board[r][c];
        board[r][c] = '-';

        // left
        nc = c - 1;
        boolean foundLeft = backtrack(r, nc, board, idx + 1, word);

        // right
        nc = c + 1;
        boolean foundRight = backtrack(r, nc, board, idx + 1, word);

        // up
        nr = r - 1;
        boolean foundUp = backtrack(nr, c, board, idx + 1, word);

        // down
        nr = r + 1;
        boolean foundDown = backtrack(nr, c, board, idx + 1, word);

        // resetting the og char value in board;
        board[r][c] = og;
        return foundLeft || foundRight || foundUp || foundDown;
    }

    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(backtrack(i, j, board, 0, word)) return true;
                }
            }
        }
        return false;
    }
}

# Notes

I think my own solution is pretty optimized.

Key points:
- I'm only calling the backtrack function iff character of the matrix is the start character of the word, no use in calling it otherwise.
- Do not go to the next character(i.e. call further backtrack) if the char in the current cell doesn't matches the char at the required index.
- Note that we are only proceeding to the next cell if the current cell matches the char at the required index.
- We are also not visiting the visited cell again, backtracking helps us in revering our changes in matrix.
- We are backtracking in sequence of words in strings. We are not going to branches wherein sequence doesn't matches.
- Above techniques allow us to "short-circuit" the solution instead of searching the whole matrix for all the characters and all possible solutions.

# Code can be further shortened to just this ...

class Solution {

    private boolean backtrack(int r, int c, char[][] board, int idx, String word) {
        int tr = board.length;
        int tc = board[0].length;

        // if we reach this point then all prev. characters were same as char of string.
        if(idx == word.length()) return true;

        // matrix edges
        if(r >= tr || r < 0 || c >= tc || c < 0) return false;

        // char already visited
        if(board[r][c] == '-') return false;

        // do not move forward if char at curr index in word is not found at the current matrix cell
        if(word.charAt(idx) != board[r][c]) return false;

        // set curr cell as visited
        char og = board[r][c];
        board[r][c] = '-';
        boolean found = backtrack(r - 1, c, board, idx + 1, word) ||
        backtrack(r + 1, c, board, idx + 1, word) ||
        backtrack(r, c + 1, board, idx + 1, word) ||
        backtrack(r, c - 1, board, idx + 1, word); 

        // resetting the og char value in board;
        board[r][c] = og;
        return found;
    }

    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(backtrack(i, j, board, 0, word)) return true;
                }
            }
        }
        return false;
    }
}