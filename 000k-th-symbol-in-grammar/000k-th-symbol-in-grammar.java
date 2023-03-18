class Solution {
   public int kthGrammar(int n, int k) {

        return recursion(n,k);


    }
    public int recursion (int n,int k ){
         if(n == 1 || k == 1) return 0;

        int mid =  (int)Math.pow(2, n-1)/2;
        if (k <= mid){
            return recursion(n-1,k) ;

        }
        else {
            return recursion(n-1, k-mid)^1 ;
        }

        

    }
    public String flip(String x){
       String x1 =  x.replace('0','2') ;
       String x2 = x1.replace('1','0') ;
       String x3 = x2.replace('2','1') ;
        return x3 ;

    }
}