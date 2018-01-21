public class Solution {
    List<Integer>[] graph;
    int[] longestChainFrom;
    boolean[] visited;
    int maxLength;
    
    public int findLongestChain(int[][] pairs) {
        maxLength=0;
        graph = new List[pairs.length];
        for(int i=0; i<pairs.length; ++i)
            graph[i]=new ArrayList<Integer>();
        for(int i=0; i<pairs.length; ++i) {
            for(int j=0; j<pairs.length; ++j) {
                if(i==j)
                    continue;
                if(pairs[i][1]<pairs[j][0])
                    graph[i].add(j);
            }
        }
        longestChainFrom = new int[pairs.length];
        visited = new boolean[pairs.length];
        for(int i=0; i<pairs.length; ++i)
            if(!visited[i])
                dfs(i);
        return maxLength;
    }
    
    void dfs(int node) {
        longestChainFrom[node]=1;
        visited[node]=true;
        for(int neighbor:graph[node]) {
            if(!visited[neighbor])
                dfs(neighbor);
            longestChainFrom[node]=Math.max(longestChainFrom[node], longestChainFrom[neighbor]+1);
        }
        maxLength=Math.max(maxLength, longestChainFrom[node]);
    }
}