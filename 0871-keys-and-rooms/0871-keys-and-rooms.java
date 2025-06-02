class Solution {
    int count =0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        int visited[] =new int[n];

        dfs(0, rooms, visited);

        if(count ==n) return true;
        else return false;
    }

    void dfs(int curr, List<List<Integer>> rooms, int[] visited){
        visited[curr] =1;
        count++;
        for(int room: rooms.get(curr)){
            if(visited[room] == 0){
                visited[room] =1;
                dfs(room, rooms ,visited );
            }
        }
    }
}