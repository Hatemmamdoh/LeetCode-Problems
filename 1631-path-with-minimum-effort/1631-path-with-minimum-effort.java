class Solution {
    
    public class Node {
        public int to;
        public int cost;

        public Node(int _to, int _cost) {
            to = _to ;
            cost = _cost ;
        }
    }

     ArrayList<ArrayList<Node>> adj  ;
    public int minimumEffortPath(int[][] heights){
        
        initializeGraph (heights) ;
        return (dijkstra(heights,heights.length)) ;
    }
    
    public void initializeGraph (int [][] heights){

       adj = new ArrayList<>() ;
        int cols = heights[0].length ;
        int [][] directions = {{-1,0} , {1,0} , {0,1}, {0,-1}} ;
        int n = heights.length ;
        for (int i = 0; i < n*cols ; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0 ; i < heights.length ; i++){
            for (int j = 0 ; j < heights[0].length ; j++){
                for(int k = 0 ; k < 4 ; k++){
                    int dx = i+directions[k][0] ;
                    int dy = j+directions[k][1] ;

                    if (dx >= 0 && dx < heights.length && dy >= 0 && dy < heights[0].length ){
                        adj.get(i*cols+j).add(new Node(dx*cols+dy,Math.abs(heights[i][j]-heights[dx][dy]))) ;
                    }
                }
            }
        }
    }
   public int dijkstra(int [][] heights, int n) {
      

        int cols = heights[0].length ;

        boolean[] visitedVertex = new boolean[n*cols];
        int [] distance = new int[n*cols];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0 ; j < cols ; j++ ){
                visitedVertex[i*cols+j] = false;
                distance[i*cols+j] = Integer.MAX_VALUE;
            }
        }
        distance[0] = 0 ;
        for (int i = 0 ; i < heights.length*cols ; i++){
            int u = findMinDistance(distance, visitedVertex);
            if (u == -1)
                return -1 ;
            visitedVertex[u] = true;

            for (int v = 0; v < adj.get(u).size(); v++) {
                if (!visitedVertex[adj.get(u).get(v).to] ) {
                    int mx = Math.max(distance[u] , adj.get(u).get(v).cost);
                    if (distance[adj.get(u).get(v).to] > mx ){
                        distance[adj.get(u).get(v).to] = mx ;

                    }
                }
            }
        }

        return distance[(heights.length-1) * cols + heights[0].length-1] ;
    }
    public static int findMinDistance(int[] distance, boolean[] visitedVertex) {
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