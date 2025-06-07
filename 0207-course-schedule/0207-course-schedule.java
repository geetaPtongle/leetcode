class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegree[]=new int[numCourses];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(int i=0; i<numCourses; i++){
        adj.add(new ArrayList<Integer>());
        
    }
    for(int i=0;i<prerequisites.length; i++){
        int a=prerequisites[i][0];
        int b=prerequisites[i][1];
        adj.get(b).add(a);
        indegree[a]++;
    }
    ArrayList<Integer> ans=new ArrayList<>();
    Queue<Integer> q=new LinkedList();
    for(int i=0; i<numCourses; i++){
        if(indegree[i] ==0){
            q.add(i);
        }
    }
    while(!q.isEmpty()){
        int curr=q.poll();
        ans.add(curr);
        for(int con: adj.get(curr)){
            indegree[con]--;
            if(indegree[con] ==0){
                q.add(con);
            }
        }
    }
    if(ans.size() ==numCourses)
        return true;
    else 
        return false;
    }
}