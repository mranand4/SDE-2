# Min Cost to Connect All Points

You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

https://leetcode.com/problems/min-cost-to-connect-all-points/description/

# Topics

- Array
- Union-Find
- Graph Theory
- Minimum Spanning Tree

```java
import java.util.PriorityQueue;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;

        // forming up weights array
        int[][] weights = new int[len][len];
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                weights[i][j] = (int)(Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
            }
        }

        // edges are represented as following array [endNodeIdx, weight]
        PriorityQueue<int []> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        // node in mst(for this case we index of node in array will work well for node id)
        // starting with node at index 0, adding it to visited list and adding all it's vertices
        // to pq.
        boolean[] inMst = new boolean[len];
        int startNode = 0;
        inMst[startNode] = true;

        // adding all connected nodes accept itself
        for(int i=0; i<weights[startNode].length; i++) {
            if(i != startNode) {
                pq.add(new int[]{i, weights[startNode][i]});
            }
        }

        int minCost = 0;

        while(!pq.isEmpty()) {
            int[] edge = pq.poll();
            int dest = edge[0];

            // destination node is already visited so don't visit it
            if(inMst[dest]) continue;

            // adding the min cost
            minCost = minCost + edge[1];

            inMst[dest] = true;

            // adding all connected nodes accept itself
            for(int i=0; i<weights[dest].length; i++) {
                if(i != dest) {
                    pq.add(new int[]{i, weights[dest][i]});
                }
            }
        }

        return minCost;
    }
}
```

# Notes

- This solution uses a straightforward mst implementation. Studied mst from [here](https://www.youtube.com/watch?v=y40TOm0Hnys&list=PLFdAYMIVJQHNFJQt2eWA9Sx3R5eF32WPn&index=10) and implemented it with this question.
- Another important thing was to determine a data structure to store connected nodes and weights, adjacency matrix did the job for this ques as it's a dense graph(every node is connected to each other).