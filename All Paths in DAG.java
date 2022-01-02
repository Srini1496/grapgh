/*
BFS APPROACH
*/
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result= new ArrayList<>();
       // if(graph.length)
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(0));
        int finalNode =graph.length-1;
        
        while(!queue.isEmpty()){
            List<Integer> path=queue.poll();
            
            int currNode = path.get(path.size()-1);
            if(currNode == finalNode){
                result.add(new ArrayList<>(path));
            }else{
                for(int i : graph[currNode]){
                    List<Integer> temp = new ArrayList<>(path);
                    temp.add(i);
                    queue.add(temp);
                }
            }
        }
        
        return result;
    }
}

/*
DFS and BACK TRACKIGN
*/
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path= new ArrayList<>();
        path.add(0);
        dfs(graph,0,path,res);
        return res;
    }
    public void dfs(int[][] graph, int node,List<Integer> path,List<List<Integer>> res){
        if(node==graph.length-1){
            res.add(new ArrayList<>(path));
            return;
        }
       
        for(int i:graph[node]){
            path.add(i);
            dfs(graph,i,path,res);
            path.remove(path.size()-1);
        }
            
    }
}
