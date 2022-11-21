class Solution {
    
    
        public class pair {
        int x ;
        int y ;
        pair(int x , int y){
            this.x = x ;
            this.y  = y ;
        }
    }
    public int orangesRotting(int[][] grid){
           
                   int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int numOfFresh = 0 ;
        int indexOfFirstRotten = -1 ;
        Queue<pair> queue = new LinkedList<>() ;

        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j < grid[0].length ; j++){
                if (grid[i][j] == 1)
                    numOfFresh++ ;

                if (grid[i][j] == 2 ){
                    pair p = new pair(i,j) ;
                    queue.add(p) ;
                }

            }
        }
        
        if (numOfFresh == 0)
            return 0 ;
        if (queue.size() == 0 )
            return -1 ;
        

        


        int time = -1 ;
        while (!queue.isEmpty()){
            int len = queue.size() ;
            time++ ;
            for (int j = 0 ; j < len ; j++){
                pair cur = queue.poll() ;
                if (cur != null){
                    for (int i = 0 ; i < 4 ; i++){
                        if (ok(cur.x + directions[i][0], cur.y + directions[i][1],grid)){

                            pair p = new pair(cur.x+directions[i][0],cur.y+directions[i][1]) ;
                            queue.add(p) ;
                            grid[cur.x+directions[i][0]][cur.y+directions[i][1]] = 2 ;
                            numOfFresh-- ;
                            if (numOfFresh == 0)
                                return time+1 ;

                        }
                    }
                }

            }


        }
        return -1 ;
           
       }

    public  Boolean ok(int i, int j,int [][] grid){
        return (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1);
    }

}