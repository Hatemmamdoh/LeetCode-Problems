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
    public List<List<Integer>> levelOrder(Node root) {
            

        List<List<Integer>> levels = new ArrayList<>() ;

        if (root == null)
            return levels;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> toAdd = new ArrayList<>() ;
            int len = queue.size() ;
            for (int i = 0 ; i < len;i++){
                Node cur = queue.poll() ;
                if (cur != null) {
                    toAdd.add(cur.val) ;
                    List <Node> child = cur.children ;
                    for (int j = 0 ; j < child.size();j++){
                        queue.add(child.get(j)) ;
                    }
                    
                }
            }
            if (toAdd.size() != 0){
                levels.add(toAdd) ;
            }
        }
        return levels ;
    }
}