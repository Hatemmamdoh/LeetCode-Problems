class Solution {
       public class Node {
        public Integer to;
        public double cost;

        public Node(Integer _to, double _cost) {
            to = _to ;
            cost = _cost ;
        }
    }
    
    public class pair {
        int x ;
        double cost ;
        pair(int x , double y){
            this.x = x ;
            this.cost  = y ;
        }
    }
    
     HashMap<Integer,List<Node>> symbols = new HashMap<>() ;
     HashMap<String,Integer> index = new HashMap<>() ;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        initializeGraph(equations,values);
        double[] solution  = new double[queries.size()] ;
        for (int i = 0 ; i < queries.size() ; i++){
            solution[i] = path(queries.get(i).get(0),queries.get(i).get(1)) ;
        }
        return solution ;
    }
    
    public void initializeGraph (List<List<String>> equations,double [] values){

          int c = 0 ;
         for (int i = 0 ; i < equations.size() ; i++){
             List <String> equation = equations.get(i) ;
             String from = equation.get(0) ;
             String to = equation.get(1) ;



             if (!index.containsKey(from)){
                 index.put(from,c++) ;
             }
             if (!index.containsKey(to)){
                 index.put(to,c++) ;
             }

             double cost = values[i] ;
             Node n = new Node(index.get(to),cost);
             if (!symbols.containsKey(index.get(from))) {
                 symbols.put(index.get(from), new ArrayList<>());
             }
             symbols.get(index.get(from)).add(n) ;

             Node x = new Node(index.get(from),(1/cost));
             if (!symbols.containsKey(index.get(to))) {
                 symbols.put(index.get(to), new ArrayList<>());
             }
             symbols.get(index.get(to)).add(x) ;
         }
    }

    public double path(String s, String d) {

        if (!index.containsKey(s) || !index.containsKey(d))
            return -1 ;
        int source = index.get(s);
        int destination = index.get(d) ;

        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(source,1));
        boolean[] seen = new boolean[index.size()];
        Arrays.fill(seen, false);
        seen[source] = true;

        while (!queue.isEmpty()){

            pair vertex = queue.poll() ;
            if (vertex.x == destination)
                return vertex.cost ;

            for (int i = 0 ; i<symbols.get(vertex.x).size() ;i++ ) {
                List <Node> cur  = symbols.get(vertex.x) ;
                for (Node neighbor : cur)
                if (!seen[neighbor.to]) {
                    seen[neighbor.to] = true;
                    queue.add(new pair(neighbor.to,neighbor.cost*vertex.cost));
                }
            }
        }
        return -1 ;
    }
}