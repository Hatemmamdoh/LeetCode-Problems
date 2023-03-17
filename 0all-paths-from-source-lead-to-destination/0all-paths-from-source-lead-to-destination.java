class Solution {
    int [] seen = new int [10000] ;
    
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {

         ArrayList<ArrayList<Integer>> graph = buildDigraph(n, edges);
         Arrays.fill(seen,0) ;
         return recursion(graph,source,destination) ;
        
    }
    public Boolean recursion (ArrayList<ArrayList<Integer>> graph ,int node,int dest){

        if (seen[node] != 0){
            return seen[node] == 2  ;
        }
        if (graph.get(node).isEmpty()){
            return node == dest ;
        }
        seen[node] = 1 ;
        for (int next:graph.get(node)){
            if (!recursion(graph,next,dest)){
                return false ;
            }
        }
        seen[node] = 2 ;
        return true ;

    }

    public ArrayList<ArrayList<Integer>> buildDigraph(int n, int[][] edges) {
        ArrayList <ArrayList<Integer>> graph = new ArrayList <> () ;

        for (int i = 0; i < n; i++) {
            graph.add (new ArrayList<>()) ;  
        }
        
        for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
            
        }
        
        return graph;
    }
}