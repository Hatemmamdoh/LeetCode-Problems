class Solution {
    public boolean primeSubOperation(int[] nums) {
        int max = Integer.MIN_VALUE ;
        for (int i = 0 ; i < nums.length ; i++){
            if (nums[i] > max){
                max = nums[i] ;
            }
        }
        if (sorted(nums,0)){
            return true ;
        }
        ArrayList<Integer> primes = new ArrayList<>() ;
        for (int i = 2 ; i < max ; i++){
            if(isPrime(i)){
                primes.add(i) ;
            }
        }

        for (int i = 0 ; i < nums.length;i++){
            int prime= 0;

            if (i == 0 ){
                for (int j : primes ){
                    if (j>=nums[i]){
                        break;
                    }
                    prime = j ;
                }
                nums[i] = nums[i] - prime ;
            }
            else {
                for (int j : primes ){
                    if (j>=nums[i]){
                        break;
                    }
                    if (nums[i-1] < nums[i]-j){
                        prime = j ;
                    }
                }
                nums[i] = nums[i] - prime ;
            }

            if (sorted(nums,0)){
                return true ;
            }

        }
        return false ;
    }
    public  boolean isPrime(int num)
    {
        if(num<=1)
        {
            return false;
        }
        for(int i=2;i<=num/2;i++)
        {
            if((num%i)==0)
                return  false;
        }
        return true;
    }
    public static boolean sorted (int [] nums,int start){
        for (int i = start ; i < nums.length-1 ; i++){
            if (nums[i] >= nums[i+1]){
                return false ;
            }
        }
        return true ;
    }
}