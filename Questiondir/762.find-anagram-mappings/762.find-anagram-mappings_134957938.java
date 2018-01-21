class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Integer[] ai = argsort(A);
        Integer[] bi = argsort(B);
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; ++ i) {
            result[ai[i]] = bi[i];
        }
        return result;
    }

    Integer[] argsort(int[] A) {
        Integer[] ai = new Integer[A.length];
        for (int i = 0; i < ai.length; ++ i) {
            ai[i] = i;
        }
        Arrays.sort(ai, Comparator.comparingInt(i -> A[i]));
        return ai;
    }
}