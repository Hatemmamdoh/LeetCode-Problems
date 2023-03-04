class Solution {
    
    public class index {
        int x ;
        int y ;
        int cost ;
        index(int x , int y,int cost){
            this.x = x ;
            this.y  = y ;
            this.cost = cost ;
        }
     }
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0 ; i < rooms.length ; i++){
            for (int j = 0 ; j < rooms[0].length ;j++){
                if (rooms[i][j] == 2147483647){
                    rooms [i][j] = bfs (i,j,rooms) ;
                }
            }
        }
    }
    public int bfs (int i , int j , int [][] rooms){

        int [] lrud = {-1,1,-1,1} ;
        int [][] seen = new int [rooms.length][rooms[0].length];
        Queue<index> q = new LinkedList <> () ;
        q.add(new index(i,j,0)) ;
        while(!q.isEmpty()){
            index cur = q.poll() ;
            seen [cur.x][cur.y] = -2 ;

            if (cur.y +lrud[0] >= 0 ){
                if (rooms [cur.x][cur.y+lrud[0]] == 0){
                    return cur.cost+1 ;
                }
                else if (rooms [cur.x][cur.y+lrud[0]] != 0 && rooms [cur.x][cur.y+lrud[0]] != -1 && seen [cur.x][cur.y+lrud[0]] != -2 ){
                    q.add(new index(cur.x,cur.y+lrud[0],cur.cost+1)) ;
                }
            }
            if (cur.y +lrud[1] <= rooms[0].length-1 ){
                if (rooms [cur.x][cur.y+lrud[1]] == 0){
                    return cur.cost+1 ;
                }
                else if ( rooms [cur.x][cur.y+lrud[1]] != 0 && rooms [cur.x][cur.y+lrud[1]] != -1 && seen [cur.x][cur.y+lrud[1]] != -2 ){
                    q.add(new index(cur.x,cur.y+lrud[1],cur.cost+1)) ;
                }
            }
            if (cur.x +lrud[2] >= 0 ){
                if (rooms [cur.x+lrud[2]][cur.y] == 0){
                    return cur.cost+1 ;
                }
                else if (rooms [cur.x+lrud[2]][cur.y] != 0 && rooms [cur.x+lrud[2]][cur.y] != -1 && seen [cur.x+lrud[2]][cur.y] != -2){
                    q.add(new index(cur.x+lrud[2],cur.y,cur.cost+1)) ;
                }
            }

            if (cur.x +lrud[3] <= rooms.length-1 ){
                if (rooms [cur.x +lrud[3]][cur.y] == 0){
                    return cur.cost+1 ;
                }
                else if (rooms [cur.x +lrud[3]][cur.y] != 0 && rooms [cur.x +lrud[3]][cur.y] != -1 &&  seen [cur.x +lrud[3]][cur.y] != -2){
                    q.add(new index(cur.x +lrud[3],cur.y,cur.cost+1)) ;
                }
            }
        }
        return 2147483647 ;
    }
}