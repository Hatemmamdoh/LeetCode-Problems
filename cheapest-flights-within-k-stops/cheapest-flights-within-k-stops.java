class Solution {
     int [][] dp ;

    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return belmanFordUsingDp(flights,src,dst,n,k) ;

    }
    public int belmanFordUsingDp(int [][] flights,int source,int dist , int n,int k) {
        
       if (source == dist) {
            return 0;
        }

        dp = new int[k+2][n] ;
        for (int i = 0 ; i < k+2 ; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[0][source] = 0 ;
        for (int i = 1 ; i <= k+1 ;i++){
            dp[i][source] = 0 ;
            for (int [] flight : flights){
                if (dp[i-1][flight[0]] < Integer.MAX_VALUE)
                    dp[i][flight[1]] = Math.min(dp[i][flight[1]], dp[i-1][flight[0]] + flight[2]) ;
            }
        }
        return dp[k+1 ][dist] == Integer.MAX_VALUE ? -1 : dp[k + 1][dist];
    }
    

    


}