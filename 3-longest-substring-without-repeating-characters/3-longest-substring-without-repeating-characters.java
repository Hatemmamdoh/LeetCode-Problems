class Solution {
    public int lengthOfLongestSubstring(String s) {
                      HashSet <Character> occur = new HashSet<>() ;
         int max = 0 ;
         int i = 0 ;
         int j = 0 ;
        if (s == null || s.length () == 0) return 0 ;
         while (i < s.length()){
             char c = s.charAt(i) ;
             while (occur.contains(c)){
                 occur.remove(s.charAt(j)) ;
                 ++j ;
             }
             occur.add(c) ;
             max = Math.max(max,(i-j+1));
             ++i ;
         }
         return max ;
    }
}