class Solution {
    int [][] graph ;
    int [][] found ;

    
    public int networkDelayTime(int[][] times, int n, int k) {
        initializeGraph (n,times) ;
        return dijkstra (graph,k-1) ;
    }
        public  void initializeGraph (int n , int[][] edges){
                graph = new int[n][n] ;
        found = new int[n][n] ;
         for (int i = 0 ; i < edges.length ; i++){
             int x = edges[i][0] -1 ;
             int y = edges[i][1] -1 ;
             graph[x][y] = edges[i][2] ;
             found[x][y] = 1 ;
         }
    }
       public  int dijkstra( int [][] graph , int source) {
          int count = graph.length;
        boolean[] visitedVertex = new boolean[count];
        int[] distance = new int[count];
        for (int i = 0; i < count; i++) {
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }

        // Distance of self loop is zero
        distance[source] = 0;
        for (int i = 0; i < count; i++) {

            // Update the distance between neighbouring vertex and source vertex
            int u = findMinDistance(distance, visitedVertex);
            if (u == -1)
                return -1 ;
            visitedVertex[u] = true;

            // Update all the neighbouring vertex distances
            for (int v = 0; v < count; v++) {
                if (v == u)
                    continue;
                if (!visitedVertex[v] && found[u][v] == 1 && (distance[u] + graph[u][v] < distance[v])) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
        for ( int j = 0 ; j < visitedVertex.length ; j++){
            if (!visitedVertex[j]){
                return -1 ;
            }
        }
        int max = Integer.MIN_VALUE ;
        for (int j = 0 ; j < distance.length ; j++){
            if (distance[j] > max)
                max = distance[j] ;
        }
        return max ;
    }
        public int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visitedVertex[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }
}