class Node implements Comparable<Node> {
      int row, col, effort;

    Node(int row, int col, int effort) {
        this.row = row;
        this.col = col;
        this.effort = effort;
    }

    @Override
    public int compareTo(Node other) {
        return this.effort - other.effort;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
         int row = heights.length;
        int col = heights[0].length;
        boolean[][] vis = new boolean[row][col];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int sr = node.row, sc = node.col, effort = node.effort;

            if (vis[sr][sc]) continue;
            vis[sr][sc] = true;

            if (sr == row - 1 && sc == col - 1)
                return effort;

            for (int idx = 0; idx < 4; idx++) {
                int nr = sr + dr[idx];
                int nc = sc + dc[idx];

                if (nr < 0 || nc < 0 || nr >= row || nc >= col || vis[nr][nc])
                    continue;

                int diff = Math.abs(heights[nr][nc] - heights[sr][sc]);
                q.add(new Node(nr, nc, Math.max(effort, diff)));
            }
        }

        return 0;
    
    }
}