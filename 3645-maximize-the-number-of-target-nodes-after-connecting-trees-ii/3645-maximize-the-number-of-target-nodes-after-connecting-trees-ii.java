class Solution {       
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> adjA = buildList(n, edges1);
        List<List<Integer>> adjB = buildList(m, edges2);

        int[] colorA = new int[n];
        int[] colorB = new int[m];

        int[] countA = new int[2]; // [even, odd]
        int[] countB = new int[2];

        colorA[0] = 0;
        dfsColor(adjA, 0, -1, colorA, countA);

        colorB[0] = 0;
        dfsColor(adjB, 0, -1, colorB, countB);

        int maxB = Math.max(countB[0], countB[1]);

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = (colorA[i] == 0 ? countA[0] : countA[1]) + maxB;
        }

        return res;
    }

    public List<List<Integer>> buildList(int nodes, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return adj;
    }

    void dfsColor(List<List<Integer>> adj, int u, int parent, int[] color, int[] count) {
        count[color[u]]++;
        for (int v : adj.get(u)) {
            if (v != parent) {
                color[v] = color[u] ^ 1;
                dfsColor(adj, v, u, color, count);
            }
        }
    }
    
}