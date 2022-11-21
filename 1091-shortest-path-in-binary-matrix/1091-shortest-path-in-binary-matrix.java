class Solution {
    
        public class pair {
        int x ;
        int y ;
        int distance ;
        pair(int x , int y,int d){
            this.x = x ;
            this.y  = y ;
            this.distance = d ;
        }
    }
    
    
    public int shortestPathBinaryMatrix(int[][] grid) {
                int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        
        if (grid[0][0] != 0)
            return -1 ;
        
        Queue<pair> queue = new LinkedList<>() ;
        pair root = new pair(0,0,1) ;
        queue.add(root) ;
        grid[0][0] = 1 ;
        while (!queue.isEmpty()){
            for (int j = 0 ; j < queue.size() ; j++){
                pair cur = queue.poll() ;
                if (cur.x == grid.length-1 && cur.y == grid[0].length-1)
                    return cur.distance ;
                for (int i = 0 ; i < 8 ; i++){
                    if (ok(cur.x + directions[i][0], cur.y + directions[i][1],grid)){

                        pair p = new pair(cur.x+directions[i][0],cur.y+directions[i][1],cur.distance+1) ;
                        queue.add(p) ;
                        grid[cur.x+directions[i][0]][cur.y+directions[i][1]] = 1 ;

                    }
                }
            }


        }
        return -1 ;
    }
        public  Boolean ok(int i, int j,int [][] grid){
        return (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 0);
    }
}