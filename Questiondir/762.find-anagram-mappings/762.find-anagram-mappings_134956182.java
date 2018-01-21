class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer,Queue<Integer>> map=new HashMap<Integer,Queue<Integer>>();
        for(int i=0;i<B.length;i++){
            if(!map.containsKey(B[i])){
                map.put(B[i],new LinkedList<Integer>());
            }
            map.get(B[i]).offer(i);
        }
        int[] res=new int[A.length];
        for(int i=0;i<A.length;i++){
            res[i]=map.get(A[i]).poll();
        }
        return res;
    }
}