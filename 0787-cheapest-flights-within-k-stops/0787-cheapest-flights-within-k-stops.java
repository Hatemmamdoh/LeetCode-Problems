class Solution {
    
  public class pair {
        int source ;
        int cost ;
        int stops ;

        pair(int x , int y , int stops){
            this.source = x ;
            this.cost  = y;
            this.stops = stops;
        }
    }
   public class Node {
        public int to;
        public int cost;

        public Node(int _to, int _cost) {
            to = _to ;
            cost = _cost ;
        }
    }
   ArrayList<ArrayList<Node>> adj  ;

    
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        initializeGraph(flights,n);
        return dijkstra(src,dst,n,k) ;
    }
        public void initializeGraph (int [][] edges ,int n){

        adj = new ArrayList<>() ;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0 ; i < edges.length ; i++){
            Node x = new Node(edges[i][1],edges[i][2]);
            adj.get(edges[i][0]).add(x) ;
        }
    }
    
        public int dijkstra(int source,int dist , int n,int k) {

        Queue<pair> all = new LinkedList<>() ;
//        boolean[] visitedVertex = new boolean[n];
//        int[] stops = new int[n];
        int [] distance = new int[n];
        for (int i = 0; i < n; i++) {
//            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
//            stops[i] = 0;
        }

//        distance[source] = 0;
        all.add(new pair(source,0,0));
        while (!all.isEmpty()){
            int st = all.peek().stops ;
            int cost = all.peek().cost ;
            int src = all.peek().source ;

            all.poll() ;
            if (st > k)
                break;

            ArrayList<Node> nodes = adj.get(src) ;
            for (int v = 0; v < nodes.size(); v++) {
                if (nodes.get(v).cost+ cost < distance[nodes.get(v).to] ){
                    distance[nodes.get(v).to] = nodes.get(v).cost+ cost ;
                    all.add(new pair(nodes.get(v).to,distance[nodes.get(v).to],st+1)) ;
                }
            }
        }

        return distance[dist] == Integer.MAX_VALUE ? -1 : distance[dist] ;
        }
    


}