/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int maximum = Integer.MIN_VALUE ;
    public int maxDepth(Node root) {
        if (root == null){
            return 0 ;
        }
        recursion(root,1) ;
        return maximum ;
        
    }
    public void recursion (Node root , int depth){
        if (root == null){
            return ;
        }
        maximum = Math.max(maximum,depth) ;
        for (Node child : root.children){
            recursion(child,depth+1) ;
        }
    }
}