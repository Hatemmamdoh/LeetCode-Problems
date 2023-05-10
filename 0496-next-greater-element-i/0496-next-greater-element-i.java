class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] answer = new int[n];
        Stack<Integer> s = new Stack<>();
        HashMap <Integer,Integer> sol = new HashMap<>() ;

        for (int i = nums2.length-1 ; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums2[i]){
                s.pop();
            }
            if (s.isEmpty()) {
                sol.put(nums2[i], -1);
            } else {
                sol.put(nums2[i], s.peek());
            }
            s.push(nums2[i]) ;
        }
        for (int i = 0 ; i < nums1.length ; i++) {
            answer[i] = sol.get(nums1[i]);
        }
        return answer;
    }
}