class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int indegree[]=new int[numCourses];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0; i< numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0; i<prerequisites.length; i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];

            adj.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] ==0) q.add(i);                      
        }
        int ans[] =new int[numCourses];
        int k=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            ans[k]=curr;
            k++;
            for(int conn: adj.get(curr)){
                indegree[conn]--;
                if(indegree[conn]==0) q.add(conn);
            }
        }
        if(k==numCourses) return ans;
        else return new int[0];
    }
}