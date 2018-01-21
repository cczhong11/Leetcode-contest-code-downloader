class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        int n = A.length;
        
        for (int i = 0; i < n; ++i) {
            
            if (!map.containsKey(B[i])) map.put(B[i], new LinkedList<Integer>());
            map.get(B[i]).add(i);
            
        }
        
        int[] res = new int[n];
        
        for (int i = 0; i < n; ++i) {
            
            int ind = map.get(A[i]).remove(0);
            res[i] = ind;
            
        }
        
        return res;
        
        
    }
}