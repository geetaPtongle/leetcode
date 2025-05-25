class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n]; // number of roads connected to each city
        boolean[][] connected = new boolean[n][n]; // direct connection matrix

        // Step 1: Fill degree and connection info
        for (int[] road : roads) {
            int a = road[0], b = road[1];
            degree[a]++;
            degree[b]++;
            connected[a][b] = true;
            connected[b][a] = true;
        }

        // Step 2: Calculate max network rank
        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = degree[i] + degree[j];
                if (connected[i][j]) {
                    rank--; // avoid double-counting the same road
                }
                maxRank = Math.max(maxRank, rank);
            }
        }
        return maxRank;
    }
}