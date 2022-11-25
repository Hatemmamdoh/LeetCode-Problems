class Solution {
    
    public class Node {
        public int to;
        public int cost;

        public Node(int _to, int _cost) {
            to = _to ;
            cost = _cost ;
        }
    }
public  class pair {
        int x ;
        int y ;
        Integer diff ;

        pair(int x , int y , Integer diff){
            this.x = x ;
            this.y  = y;
            this.diff = diff;
        }
    }

     ArrayList<ArrayList<Node>> adj  ;
    public int minimumEffortPath(int[][] heights){
        int [][] directions = {{-1,0} , {1,0} , {0,1}, {0,-1}} ;
        int row = heights.length ;
        int cols = heights[0].length ;

        int [][] d = new int[row][cols];

        for (int[] each : d){
            Arrays.fill(each,Integer.MAX_VALUE);
        }
        d[0][0] = 0;
        PriorityQueue<pair> queue = new PriorityQueue<pair>((a, b) -> (a.diff.compareTo(b.diff)));
        boolean[][] visited = new boolean[row][cols];
        queue.add(new pair(0, 0, d[0][0]));
        while (!queue.isEmpty()){
            pair cur = queue.poll() ;
            int x = cur.x ;
            int y = cur.y ;
            int diff = cur.diff ;
            visited[x][y] = true ;
            for (int i = 0 ; i < 4 ; i++){
                int dx = directions[i][0] + x ;
                int dy = directions[i][1] + y ;
                if (ok(dx,dy,heights) && !visited[dx][dy]){
                   int curDiff = Math.abs(heights[dx][dy] - heights[cur.x][cur.y]);
                   int maxDiff  = Math.max(curDiff,d[x][y]) ;
                    if (d[dx][dy] > maxDiff) {
                        d[dx][dy] = maxDiff;
                        queue.add(new pair(dx, dy, maxDiff));
                    }
                }

            }
        }
        return d[row - 1][cols - 1];
    }
 public Boolean ok(int i, int j,int [][] grid){
        return (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length );
    }

    
    
}