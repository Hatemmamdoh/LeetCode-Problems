class Solution {
    

    int[] root;
    int[] rank;
    HashSet<Integer> unique = new HashSet<>() ;
    int count = 0 ;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length ;

        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i,j);
                }
            }
        }
         for (int i = 0 ; i < root.length ; i++){
            if (root[i] != i){
                root[i] = find (root[i]) ;
            }
            if (!unique.contains(root[i])){
                unique.add(root[i]) ;
                count ++ ;
            }
        }

        return count ;
    }
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rank[rootX] > rank[rootY]){
            root[rootY] = rootX ;
        }
        else if (rank[rootX] < rank[rootY]){
            root[rootX] = rootY;
        }
        else {
            root[rootY] = root[rootX] ;
            rank[rootX] += 1 ;
        }
    }
}