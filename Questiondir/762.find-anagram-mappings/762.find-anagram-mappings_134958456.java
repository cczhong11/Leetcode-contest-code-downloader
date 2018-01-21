class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int n = A.length;
        int[] P = new int[n];
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
        for(int i=0;i<n;i++) {
            LinkedList<Integer> list = map.get(B[i]);
            if(list==null) {
                list = new LinkedList<Integer>();
                map.put(B[i], list);
            }
            list.add(i);
        }
        for(int i=0;i<n;i++) {
            LinkedList<Integer> list = map.get(A[i]);
            try {
                P[i] = list.removeFirst();
            } catch (Exception e) {
                throw new RuntimeException("Not anagram " + e.getMessage());
            }
        }
        return P;
    }
}