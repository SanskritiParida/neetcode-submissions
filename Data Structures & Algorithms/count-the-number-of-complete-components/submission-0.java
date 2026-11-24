class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
         boolean[] vis = new boolean[n];
         int cnt = 0;
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
         }
         for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
         }
         for(int i = 0; i < n; i++){
            if(!vis[i]){
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i,vis,adj,component);
                int size = component.size();
                boolean complete = true;
                for(int node : component){
                    if(adj.get(node).size() != size - 1){
                        complete = false;
                        break;
                    }
                }
                if(complete == true){
                    cnt++;
                }
            }
         }
         return cnt;
         
    }
    public void dfs(int node,boolean[] vis,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> component){
        vis[node] = true;
        component.add(node);
        for(int a : adj.get(node)){
            if(!vis[a]){
                dfs(a,vis,adj,component);
            }
        }
    }
}
