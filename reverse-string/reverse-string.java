class Solution {
    public void reverseString(char[] s){

        helper(s,0,s.length-1);
    }
    public void helper (char[] s , int i , int j){
        if (i >= j){
            return  ;
        }
        char t = s[i] ;
        s[i] = s[j] ;
        s[j] = t ;
        helper(s,i+1,j-1);
    }
}