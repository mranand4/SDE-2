class Solution {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;

        // forming up weights array
        // int[][] weights = new int[len][len];
        // for(int i=0; i<len; i++) {
        //     for(int j=0; j<len; j++) {
        //         weights[i][j] = (int)(Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
        //     }
        // }
        //
        // Actually, storing weights as list of list will better serve our purpose
        int[][] weights = new int[len * len][3];
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                int idx = (i*len) + (j%len);
                int dist = (int)(Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
                weights[idx][0] = i; // source
                weights[idx][1] = j; // destination
                weights[idx][2] = dist; // weight or distance
            }
        }

        // node in mst(for this case we index of node in array will work well for node id)
        boolean[] inMst = new boolean[len];

        // edges are represented as following array [startNodeIdx, endNodeIdx, weight]


    }
}