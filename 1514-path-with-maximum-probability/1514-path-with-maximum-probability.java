class Solution {
     public static class Node {
         int to ;
         double cost ;
         Node(int to,double cost){
             this.to = to ;
             this.cost = cost ;
         }
  }

    static ArrayList<ArrayList<Node>> adj  ;
    public static  double maxProbability(int n, int[][] edges, double[] succProb, int start, int end){

        initializeGraph (n,edges,succProb) ;
        return dijkstra (start,end) ;

    }
    public static void initializeGraph (int n , int[][] edges,double[] succProb){
        adj = new ArrayList<>(n) ;
        for (int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<Node>()) ;
        }
         for (int i = 0 ; i < edges.length ; i++){
             int x = edges[i][0]  ;
             int y = edges[i][1]  ;
             Node z = new Node(y,succProb[i]) ;
             Node b = new Node(x,succProb[i]) ;

             adj.get(x).add(z) ;
             adj.get(y).add(b) ;


         }
    }

    public static double dijkstra(  int source, int dist) {
        int count = adj.size();
        boolean[] visitedVertex = new boolean[count];
        double[] distance = new double[count];
        for (int i = 0; i < count; i++) {
            visitedVertex[i] = false;
            distance[i] = Integer.MIN_VALUE;
        }

        // Distance of self loop is zero
        distance[source] = 1;
        for (int i = 0; i < count; i++) {

            // Update the distance between neighbouring vertex and source vertex
            int u = findMinDistance(distance, visitedVertex);
            if (u == -1)
                break; 
            visitedVertex[u] = true;

            // Update all the neighbouring vertex distances
            ArrayList<Node> nodes = adj.get(u) ;
            for (int v = 0; v < nodes.size(); v++) {
                if (!visitedVertex[nodes.get(v).to] && (distance[u] * nodes.get(v).cost > distance[nodes.get(v).to])) {
                    distance[nodes.get(v).to] = distance[u] * nodes.get(v).cost;
                }
            }
        }
        if (distance[dist] == Integer.MIN_VALUE)
            return 0 ;

        return distance[dist] ;

    }
    public static int findMinDistance(double[] distance, boolean[] visitedVertex) {
        double maxDistance = Double.MIN_VALUE;
        int maxDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visitedVertex[i] && distance[i] > maxDistance) {
                maxDistance = distance[i];
                maxDistanceVertex = i;
            }
        }
        return maxDistanceVertex;
    }
}