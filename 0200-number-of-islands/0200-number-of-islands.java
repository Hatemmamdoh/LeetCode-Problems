class Solution {
   
      int[] root;
     char[] charRoot;
     int[] rank;
     HashSet <Integer> unique = new HashSet<>() ;

    public int numIslands(char[][] grid) {
        
        int [] lrud = {-1,1,-1,1} ;
        root = new int [grid.length*grid[0].length] ;
        rank = new int [grid.length*grid[0].length] ;
        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j < grid[0].length;j++){
                if (grid[i][j] == '1'){
                    root[i*grid[0].length+j] = i*grid[0].length+j ;
                    rank[i*grid[0].length+j] = 1 ;
                }
                else {
                    root[i*grid[0].length+j] = -1 ;
                }
            }
        }
        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j < grid[0].length;j++){
                if (grid[i][j] == '1'){
                    if (j+lrud[0] >= 0 && grid[i][j-1] == '1'){
                        union(i*grid[0].length+j,i*grid[0].length+(j-1));
                    }
                    if (j+lrud[1] <= grid[0].length-1 && grid[i][j+1] == '1'){
                        union(i*grid[0].length+j,i*grid[0].length+(j+1));
                    }
                    if (i+lrud[2] >= 0 && grid[i-1][j] == '1'){
                        union(i*grid[0].length+j,(i-1)*grid[0].length+(j));
                    }
                    if (i+lrud[3] <= grid.length-1 && grid[i+1][j] == '1'){
                        union(i*grid[0].length+j,(i+1)*grid[0].length+(j));
                    }
                }
            }
        }
        for (int i = 0 ; i < root.length ; i++ ){
            if (root[i] != -1)
                root[i] = find(root[i]) ;
        }
        for (int i = 0 ; i < root.length ; i++){
            if (root[i] != -1 ){
                if (!unique.contains(root[i])){
                    unique.add(root[i]) ;
                }
            }
        }
        return unique.size() ;
    }
    public int find(int z) {
        while (z != root[z]) {
            z = root[z];
        }
        return z;
    }
    public  void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
                rank[rootX] += rank[rootY];
            } else if (rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
                rank[rootY] += rank[rootX];
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }

    }
}