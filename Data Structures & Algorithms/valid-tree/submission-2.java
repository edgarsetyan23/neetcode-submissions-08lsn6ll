public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // adjacent list
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        if(!checkhelper(n,edges,0,-1,visited,adj)) return false;
        
        for(boolean v: visited){//check lonely islands
            if(!v) return false;
        }
        return true;
    }
    public boolean checkhelper(int n, int[][] edges,int nodeid, int parentid, boolean[] visited,List<List<Integer>> adj ){
        if(visited[nodeid]) return false;
        visited[nodeid] = true;
        List<Integer> neighbors = adj.get(nodeid);
        for(Integer neighbor : neighbors){
            if(neighbor!= parentid && !checkhelper(n,edges,neighbor,nodeid,visited,adj)) return false;
        }
        return true;
    }
}