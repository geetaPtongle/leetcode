class Solution {
    public int minTrioDegree(int n, int[][] edges) {
         int[] degree = new int[n +1];
         int[][] connected = new int[n+1][n+1]; 
        for (int[] adj : edges) {
            int a = adj[0], b = adj[1];
            degree[a]++;
            degree[b]++;
            connected[a][b] = 1;
            connected[b][a] = 1;
        }
        int res=Integer.MAX_VALUE;
        for(int i=1; i<=n ; i++){
            for(int j=i+1; j<=n; j++){
                if (connected[i][j] == 0) continue;
                for(int k=j+1; k<=n; k++){
                     if (connected[i][k] == 1 && connected[j][k] == 1) {
                        int trioDegree = degree[i] + degree[j] + degree[k] - 6;
                        res = Math.min(res, trioDegree);
                    }
                }
            }
        }
         return res == Integer.MAX_VALUE ? -1 : res;
    }
}