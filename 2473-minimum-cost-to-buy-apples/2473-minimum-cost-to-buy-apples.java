class Solution {
    
    
    
   ArrayList<ArrayList<Node>> adj  ;
    
     public class Node {
        public int to;
        public int cost;

        public Node(int _to, int _cost) {
            to = _to ;
            cost = _cost ;
        }
    }
    
   public class pair {
        int x ;
        long cost ;

        pair(int x , long cost){
            this.x = x ;
            this.cost = cost ;
        }
    }
    
    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        initializeGraph(roads, n);
        long [] sol = new long[n] ;
        for (int i = 0 ; i < n ; i++){
            sol[i] = dijkstra(roads,n,i,k,appleCost) ;
        }
        return sol ;
    }
    
    public void initializeGraph (int [][] roads,int n){

        adj = new ArrayList<>() ;
        for (int i = 0; i < n ; i++) {
            adj.add(new ArrayList<>());
        }
        for (int [] road :roads  ){
            adj.get(road[0]-1).add(new Node(road[1]-1,road[2])) ;
            adj.get(road[1]-1).add(new Node(road[0]-1,road[2])) ;
        }
    }
    public long dijkstra(int [][] roads, int n,int source,int k,int [] appleCost) {

        boolean[] visitedVertex = new boolean[n];
        long [] distance = new long[n];
        for (int i = 0; i < n; i++) {
            visitedVertex[i] = false;
            distance[i] = Long.MAX_VALUE;
        }
        distance[source] = 0 ;
        Queue<pair> all = new LinkedList<>() ;
        all.add(new pair(source,0)) ;
        while (!all.isEmpty()){
            pair cur = all.poll() ;
            ArrayList<Node> nodes = adj.get(cur.x) ;
            for (int i = 0 ; i < nodes.size();i++){
                long calc = nodes.get(i).cost + nodes.get(i).cost*k  ;
                if (calc + cur.cost + appleCost[nodes.get(i).to] < distance[nodes.get(i).to] ){
                    distance[nodes.get(i).to] = calc+cur.cost + appleCost[nodes.get(i).to] ;
                    all.add(new pair(nodes.get(i).to,calc + cur.cost)) ;
                }
            }

        }
        long min = Long.MAX_VALUE ;
        for (int i = 0 ; i < distance.length ; i++){
            if (i==source)
                continue;
            min = Math.min(min,distance[i]) ;
        }

        return Math.min(min,appleCost[source]) ;
    }
    
    
}