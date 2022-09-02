class Solution {
     int [][] graph ;
     int [] sol ;
    
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        sol = new int [n] ;
        int min = Integer.MAX_VALUE ;
        int minIndex = -1 ;
        initializeGraph (n,edges) ;
        for (int i = 0 ; i < n ; i++){
            dijkstra (graph,i,distanceThreshold) ;
        }
        for (int i = 0 ; i < sol.length ; i++){
            if (sol[i] <= min){
                min = sol[i] ;
                minIndex = i ;
            }
        }
        return minIndex ;
    }
      public void initializeGraph (int n , int[][] edges){
        graph = new int[n][n] ;
         for (int i = 0 ; i < edges.length ; i++){
             graph[edges[i][0]][edges[i][1]] = edges[i][2] ;
             graph[edges[i][1]][edges[i][0]] = edges[i][2] ;

         }
    }
    
    public void dijkstra( int [][] graph , int source,int distanceThreshold) {
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
                break;
            visitedVertex[u] = true;
            if (distance[u] > distanceThreshold )
                continue;
            if (distance[u] == distanceThreshold){
                sol[source] = sol[source]+1 ;
                continue;
            }
            if (distance[u] != 0)
                sol[source] = sol[source]+1 ;

            // Update all the neighbouring vertex distances
            for (int v = 0; v < count; v++) {
                if (!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

    }
    public  int findMinDistance(int[] distance, boolean[] visitedVertex) {
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