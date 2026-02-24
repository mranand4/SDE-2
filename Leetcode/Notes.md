# Backtracking

1. [Bible of backtracking] Common generic template which applies to many problems - https://leetcode.com/problems/subsets/solutions/27281/a-general-approach-to-backtracking-quest-0ea5/

2. Reference link for stack and queue based solutions - https://leetcode.com/problems/binary-tree-paths/solutions/68272/python-solutions-dfsstack-bfsqueue-dfs-r-k9fg/

3. Handling duplicate permutations type of questions -  https://leetcode.com/problems/permutations-ii/solutions/18594/really-easy-java-solution-much-easier-th-lpev/

4. Nikhil Lohia subset 2 - https://www.youtube.com/watch?v=qGyyzpNlMDU , uses list contains.

5. In Java, List.contains() uses the .equals() method to compare elements.

- For a List<List<Integer>>:
- List.equals() compares element-by-element
- If another list has same size and hasthe same values in the same order, then it is considered equal.

6. Subset, combinations are "look forward solution" or "forward seeking solution", permutation is a "look forward and backwards solution". In look forward sols, prev. elements are automatically ignored. Identifying forward seeking or forward-backward seeking is also key to solving many of these problems. This is my own discovery.

6.1 Use once pattern involves a boolean array. e.g. Permutations 2, Combination Sum 3.

7. Using array list instead of linked list increased a lot of performance (contrary to what I thought ...)

8. Once you solve enough questions of a given type (say 10-12 or more) than you get a hang of it automatically. Imp thing is to solve a lot of questions of each type.

# How to stop forgetting own solutions?

https://medium.com/@therubeprotocol/stop-forgetting-your-leetcode-solutions-a-retention-system-that-works-26acc13e83e0