class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n-1 ; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i]){
                s.pop();
            }
            answer[i] = s.isEmpty() ? -1 : s.peek() ;
            s.push(nums[i]  ) ;
        }
        for (int i = n-1 ; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i]){
                s.pop();
            }
            answer[i] = s.isEmpty() ? -1 : s.peek() ;
            s.push(nums[i]  ) ;
        }
        return answer;
    }
}